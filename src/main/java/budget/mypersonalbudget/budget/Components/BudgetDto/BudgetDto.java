package budget.mypersonalbudget.budget.Components.BudgetDto;

import lombok.Getter;
import lombok.Setter;

public class BudgetDto {
    private int id;
    @Getter
    double sum;
    @Getter
    @Setter
    String data;
    @Getter
    final String info;
    @Getter
    final String category;

    public BudgetDto(double sum, String data, String info, String category) {
        this.sum = sum;
        this.data = data;
        this.info = info;
        this.category = category;
    }

    public double changeInBalance() {
        return getSum();
    }
}
