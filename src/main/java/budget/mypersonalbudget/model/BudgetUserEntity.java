package budget.mypersonalbudget.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class BudgetUserEntity {
    @Id
    private long budgetUserId;

    @ManyToOne
    @JoinColumn(name = "user_user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "budget_budget_id")
    private BudgetEntity budget;

    public void setBudgetUserId(Long budgetUserId) {
        this.budgetUserId = budgetUserId;
    }

    public Long getBudgetUserId() {
        return budgetUserId;
    }
}
