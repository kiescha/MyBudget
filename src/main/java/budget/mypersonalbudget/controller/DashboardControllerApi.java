package budget.mypersonalbudget.controller;
import budget.mypersonalbudget.core.domain.BudgetRole;
import budget.mypersonalbudget.core.domain.Transaction;
import budget.mypersonalbudget.model.BudgetEntity;
import budget.mypersonalbudget.model.BudgetMemberEntity;
import budget.mypersonalbudget.repository.JpaBudgetMemberRepository;
import budget.mypersonalbudget.repository.JpaBudgetRepository;
import budget.mypersonalbudget.service.BudgetService;
import budget.mypersonalbudget.user.services.CurrentUserName;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/api/dashboard")
@RequiredArgsConstructor
public class DashboardControllerApi {

    private final BudgetService budgetService;
    private final JpaBudgetRepository jpaBudgetRepository;
    private final JpaBudgetMemberRepository jpaBudgetMemberRepository;
    private final CurrentUserName currentUserName;



    private Long resolveBudgetIdOrThrow(UUID budgetUuid) {
        return jpaBudgetRepository.findByBudgetUuid(budgetUuid)
                .map(BudgetEntity::getId)
                .orElseThrow(() -> new RuntimeException("Budget not found"));
    }

    private void requireRole(Long budgetId, Long userId, Set<BudgetRole> allowed) {
        BudgetRole role = jpaBudgetMemberRepository.findByBudgetIdAndUserId(budgetId, userId)
                .map(BudgetMemberEntity::getRole)
                .orElseThrow(() -> new RuntimeException("Forbidden"));
        if (!allowed.contains(role)) throw new RuntimeException("Forbidden");
    }

    @GetMapping("/all")
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        return ResponseEntity.ok(budgetService.getAllTransactions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransaction(@PathVariable UUID id) {
        return ResponseEntity.of(budgetService.getTransactionOptionalById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable UUID id) {
        if (budgetService.getTransactionOptionalById(id).isPresent()) {
            budgetService.deleteTransactionById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Transaction> updateTransaction(
            @PathVariable UUID id,
            @RequestBody Transaction transaction) {

        if (budgetService.getTransactionOptionalById(id).isPresent()) {
            transaction.setId(id);
            budgetService.updateTransaction(transaction);
            return ResponseEntity.of(budgetService.getTransactionOptionalById(id));
        }
        return ResponseEntity.notFound().build();
    }


    @PostMapping("/create")
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
        Transaction created = budgetService.createTransaction(transaction);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/budgets/{budgetUuid}/transactions")
    public ResponseEntity<List<Transaction>> getAll(@PathVariable UUID budgetUuid) {
        Long userId = currentUserName.getCurrentUserIdOrThrow();
        Long budgetId = resolveBudgetIdOrThrow(budgetUuid);
        requireRole(budgetId, userId, Set.of(BudgetRole.VIEWER, BudgetRole.EDITOR, BudgetRole.OWNER));
        return ResponseEntity.ok(budgetService.getAllTransactionsByBudget(budgetId));
    }

    @PostMapping("/budgets/{budgetUuid}/transactions")
    public ResponseEntity<Transaction> create(@PathVariable UUID budgetUuid, @RequestBody Transaction tx) {
        Long userId = currentUserName.getCurrentUserIdOrThrow();
        Long budgetId = resolveBudgetIdOrThrow(budgetUuid);
        requireRole(budgetId, userId, Set.of(BudgetRole.EDITOR, BudgetRole.OWNER));
        return ResponseEntity.ok(budgetService.createTransactionInBudget(tx, budgetId));
    }

}
