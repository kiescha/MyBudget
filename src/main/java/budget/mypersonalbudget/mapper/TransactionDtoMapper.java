package budget.mypersonalbudget.mapper;

import budget.mypersonalbudget.core.domain.Transaction;
import budget.mypersonalbudget.core.domain.TransactionTypeEnum;
import budget.mypersonalbudget.dto.TransactionDto;
import org.springframework.stereotype.Component;

@Component
public class TransactionDtoMapper {

    public Transaction toTransaction(final TransactionDto transactionDto) {
        return Transaction.builder()
                .id(transactionDto.getId())
                .amount(transactionDto.getAmount())
                .category(transactionDto.getCategory())
                .description(transactionDto.getDescription())
                .date(transactionDto.getDate())
                .type(transactionDto.getType())
                .build();
    }
    
    public TransactionDto toTransactionDto(final Transaction transaction) {
        TransactionDto transactionDto = TransactionDto.builder()
                .id(transaction.getId())
                .amount(transaction.getAmount())
                .category(transaction.getCategory())
                .description(transaction.getDescription())
                .type(transaction.getType())
                .date(transaction.getDate())
                .build();
        return transactionDto;
    }
}
