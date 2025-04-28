package budget.mypersonalbudget.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class BudgetUserEntity {
    @Id
    private long budgetUserId;

    public void setBudgetUserId(Long budgetUserId) {
        this.budgetUserId = budgetUserId;
    }

    public Long getBudgetUserId() {
        return budgetUserId;
    }
    //something for user_id
    //something for budget_id
}
