package budget.mypersonalbudget.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class BudgetEntity {
    @Id
    private long budgetId;
    private String budgetName;
    private int startDate;
    private int endDate;

    public void setBudgetId(Long budgetId) {
        this.budgetId = budgetId;
    }

    public Long getBudgetId() {
        return budgetId;
    }
}
