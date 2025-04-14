package budget.mypersonalbudget.budget.Components;

import java.util.HashMap;

public class Budget {
    public static final HashMap<Integer, BudgetRecord> recordHashMap = new HashMap<Integer, BudgetRecord>();


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
