package budget.mypersonalbudget.dto;

import budget.mypersonalbudget.model.CardEntity;

public record BankDto(
        long id,
        String name,
        CardEntity card) {

}
