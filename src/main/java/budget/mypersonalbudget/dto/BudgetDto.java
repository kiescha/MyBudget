package budget.mypersonalbudget.dto;

import java.time.LocalDate;

public record BudgetDto(
        long budgetId,
        String name,
        LocalDate startDate,
        LocalDate endDate) {
}
