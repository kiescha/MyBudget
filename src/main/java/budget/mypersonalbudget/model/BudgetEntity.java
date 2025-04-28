package budget.mypersonalbudget.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class BudgetEntity {
    @Id
    private long budgetId;
    private String budgetName;
    private int startDate;
    private int endDate;

    @OneToMany(mappedBy = "budget")
    private List<BudgetUserEntity> users;

    public void setBudgetId(Long budgetId) {
        this.budgetId = budgetId;
    }

    public Long getBudgetId() {
        return budgetId;
    }
}
