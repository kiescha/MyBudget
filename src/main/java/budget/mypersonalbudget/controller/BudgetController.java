package budget.mypersonalbudget.controller;
import budget.mypersonalbudget.core.domain.BudgetRole;
import budget.mypersonalbudget.model.BudgetEntity;
import budget.mypersonalbudget.model.BudgetMemberEntity;
import budget.mypersonalbudget.repository.JpaBudgetMemberRepository;
import budget.mypersonalbudget.repository.JpaBudgetRepository;
import budget.mypersonalbudget.user.services.CurrentUserName;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/budgets")
@RequiredArgsConstructor
public class BudgetController {

    private final JpaBudgetRepository budgetRepository;
    private final JpaBudgetMemberRepository budgetMemberRepository;
    private final CurrentUserName currentUserName;



    @PostMapping
    public ResponseEntity<?> createBudget(@RequestBody Map<String, String> req) {
        String name = req.get("name");
        if (name == null || name.isBlank()) {
            return ResponseEntity.badRequest().body("name is required");
        }

        Long currentUserId = currentUserName.getCurrentUserIdOrThrow();

        BudgetEntity budget = BudgetEntity.builder()
                .budgetUuid(UUID.randomUUID())
                .name(name)
                .ownerUserId(currentUserId)
                .createdAt(LocalDateTime.now())
                .build();
        budget = budgetRepository.save(budget);

        BudgetMemberEntity owner = BudgetMemberEntity.builder()
                .budgetId(budget.getId())
                .userId(currentUserId)
                .role(BudgetRole.OWNER)
                .build();
        budgetMemberRepository.save(owner);

        return ResponseEntity.ok(Map.of(
                "budgetUuid", budget.getBudgetUuid(),
                "name", budget.getName(),
                "createdAt", budget.getCreatedAt()
        ));
    }

    @GetMapping("/mine")
    public ResponseEntity<List<BudgetEntity>> myBudgets() {
        Long userId = currentUserName.getCurrentUserIdOrThrow();
        var memberships = budgetMemberRepository.findAllByUserId(userId);
        var budgetIds = memberships.stream().map(BudgetMemberEntity::getBudgetId).toList();
        return ResponseEntity.ok(budgetRepository.findAllById(budgetIds));
    }
}


