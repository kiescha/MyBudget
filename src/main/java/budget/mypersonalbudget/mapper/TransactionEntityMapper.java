package budget.mypersonalbudget.mapper;

import budget.mypersonalbudget.core.domain.Transaction;

import budget.mypersonalbudget.model.TransactionEntity;
import org.springframework.stereotype.Component;

@Component
public class TransactionEntityMapper {
    public Transaction toTransaction(final TransactionEntity transactionEntity) {
        return Transaction.builder()
                .id(transactionEntity.getId())
                .amount(transactionEntity.getAmount())
                .category(transactionEntity.getCategory())
                .description(transactionEntity.getDescription())
                .type(transactionEntity.getType())
                .date(transactionEntity.getDate())
                .build();
    }


    public TransactionEntity toTransactionEntity(final Transaction transaction) {
        return TransactionEntity.builder()
                .id(transaction.getId())
                .amount(transaction.getAmount())
                .description(transaction.getDescription())
                .category(transaction.getCategory())
                .type(transaction.getType())
                .date(transaction.getDate())
                .build();
    }
}
