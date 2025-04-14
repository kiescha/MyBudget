package budget.mypersonalbudget.budget.Components.Balance;

import budget.mypersonalbudget.budget.Components.BudgetDto.BudgetDto;

import static budget.mypersonalbudget.budget.Components.Budget.recordHashMap;

public class Balance {
    public void balance() {
        double balance = 0;
        for (BudgetDto budgetRecord : recordHashMap.values()){
            balance += budgetRecord.changeInBalance();
        }
    }
}
