package budget.mypersonalbudget.repository;

import budget.mypersonalbudget.model.BudgetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface JpaBudgetRepository extends JpaRepository<BudgetEntity, Long> {
    Optional<BudgetEntity> findByBudgetUuid(UUID budgetUuid);
}


