package budget.mypersonalbudget.repository;

import budget.mypersonalbudget.model.BudgetMemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JpaBudgetMemberRepository extends JpaRepository<BudgetMemberEntity, Long> {
    Optional<BudgetMemberEntity> findByBudgetIdAndUserId(Long budgetId, Long userId);

    List<BudgetMemberEntity> findAllByUserId(Long userId);
}


