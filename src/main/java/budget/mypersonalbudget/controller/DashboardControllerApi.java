package budget.mypersonalbudget.controller;

import budget.mypersonalbudget.core.domain.Transaction;
import budget.mypersonalbudget.dto.TransactionDto;
import budget.mypersonalbudget.service.BudgetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/dashboard")
@RequiredArgsConstructor
public class DashboardControllerApi {

    private final BudgetService budgetService;

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
        }
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Transaction> updateTransaction(
            @PathVariable UUID id,
            @RequestBody Transaction transaction) {

        if (budgetService.getTransactionOptionalById(id).isPresent()) {
            budgetService.updateTransaction(transaction);
            return ResponseEntity.of(budgetService.getTransactionOptionalById(id));
        }
        return ResponseEntity.notFound().build();
    }


    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
        Transaction created = budgetService.createTransaction(transaction);
        return ResponseEntity.ok(created);
    }

}
