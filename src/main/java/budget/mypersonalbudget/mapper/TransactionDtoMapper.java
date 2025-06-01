package budget.mypersonalbudget.mapper;

import budget.mypersonalbudget.core.domain.Transaction;
import budget.mypersonalbudget.dto.TransactionDto;
import org.springframework.stereotype.Component;

@Component
public class TransactionDtoMapper {

    public Transaction toTransaction(final TransactionDto transactionDto) {
        return Transaction.builder()
                .amount(transactionDto.getAmount())
                .category(transactionDto.getCategory())
                .description(transactionDto.getDescription())
                .date(transactionDto.getDate())
                .type(transactionDto.isIncome())
                .build();
    }
    
    public TransactionDto toTransactionDto(final Transaction transaction) {
        TransactionDto dto = TransactionDto.builder()
                .amount(transaction.getAmount())
                .category(transaction.getCategory())
                .description(transaction.getDescription())
                .date(transaction.getDate())
                .build();
                
        dto.setIncome(transaction.getType() != null ? transaction.getType() : false);
        
        return dto;
    }
}
