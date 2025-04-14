package budget.mypersonalbudget.budget.Components;

import budget.mypersonalbudget.budget.Components.BudgetDto.BudgetDto;

import java.util.HashMap;

public class Budget {
    public static final HashMap<Integer, BudgetDto> recordHashMap = new HashMap<Integer, BudgetDto>();


    private int getNextId() {
        int highestId = 0;
        for (Integer key : recordHashMap.keySet()) {
            if (key > highestId) {
                highestId = key;
            }
        }
        return highestId + 1;
    }
}
