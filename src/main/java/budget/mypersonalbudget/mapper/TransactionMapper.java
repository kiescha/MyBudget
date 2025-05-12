package budget.mypersonalbudget.mapper;

import budget.mypersonalbudget.dto.TransactionDto;
import budget.mypersonalbudget.model.TransactionEntity;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {
    public TransactionEntity toTransactionEntity(final TransactionDto transactionDto) {
        return TransactionEntity.builder()
                .income(transactionDto.getIncome())
                .expense(transactionDto.getExpense())
                .amount(transactionDto.getAmount())
                .description(transactionDto.getDescription())
                .build();
    }
    public TransactionDto toTransactionDto(final TransactionEntity transactionEntity) {
        return TransactionDto.builder()
                .income(transactionEntity.getIncome())
                .expense(transactionEntity.getExpense())
                .amount(transactionEntity.getAmount())
                .description(transactionEntity.getDescription())
                .build();
    }

}
