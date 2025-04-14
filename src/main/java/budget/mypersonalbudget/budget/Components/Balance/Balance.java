package budget.mypersonalbudget.budget.Components.Balance;

import budget.mypersonalbudget.budget.Components.BudgetRecord;

import static budget.mypersonalbudget.budget.Components.Budget.recordHashMap;

public class Balance {
    public void balance() {
        double balance = 0;
        for (BudgetRecord budgetRecord : recordHashMap.values()){
            balance += budgetRecord.changeInBalance();
        }
    }
}
