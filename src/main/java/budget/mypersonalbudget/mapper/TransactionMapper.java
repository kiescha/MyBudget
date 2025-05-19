package budget.mypersonalbudget.mapper;

import budget.mypersonalbudget.dto.TransactionDto;
import budget.mypersonalbudget.dto.TransactionFormDto;
import budget.mypersonalbudget.model.TransactionEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TransactionMapper {
    public TransactionEntity toTransactionEntity(final TransactionDto transactionDto) {
        return TransactionEntity.builder()
                .id(transactionDto.getId())
                .income(transactionDto.isIncome())
                .amount(transactionDto.getAmount())
                .description(transactionDto.getDescription())
                .category(transactionDto.getCategory())
                .date(transactionDto.getDate())
                .build();
    }

    public TransactionDto toTransactionDto(final TransactionEntity transactionEntity) {
        return TransactionDto.builder()
                .id(transactionEntity.getId())
                .income(transactionEntity.isIncome())
                .amount(transactionEntity.getAmount())
                .description(transactionEntity.getDescription())
                .category(transactionEntity.getCategory())
                .date(transactionEntity.getDate())
                .build();
    }
    public TransactionDto fromTransactionFormDto(final TransactionFormDto transactionFormDto) {
        return TransactionDto.builder()
                .income(transactionFormDto.isIncome())
                .amount(transactionFormDto.getAmount())
                .description(transactionFormDto.getDescription())
                .category(transactionFormDto.getCategory())
                .date(LocalDateTime.parse(transactionFormDto.getDate()))
                .build();
    }

}
