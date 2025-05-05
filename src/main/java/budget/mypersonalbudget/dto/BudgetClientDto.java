package budget.mypersonalbudget.dto;

import budget.mypersonalbudget.model.BudgetEntity;
import budget.mypersonalbudget.model.ClientEntity;
import budget.mypersonalbudget.model.ClientRoleEnum;

public record BudgetClientDto(
        long budgetClientId,
        ClientEntity client,
        BudgetEntity budget,
        ClientRoleEnum role) {

}
