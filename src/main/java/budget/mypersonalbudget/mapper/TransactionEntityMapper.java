package budget.mypersonalbudget.mapper;

import budget.mypersonalbudget.core.domain.Transaction;

import budget.mypersonalbudget.model.TransactionEntity;
import org.springframework.stereotype.Component;

@Component
public class TransactionEntityMapper {
    public Transaction toTransaction(final TransactionEntity transactionEntity) {
        return Transaction.builder()
                .amount(transactionEntity.getAmount())
                .category(transactionEntity.getCategory())
                .description(transactionEntity.getDescription())
                .date(transactionEntity.getDate())
                .build();
    }


    public TransactionEntity toTransactionEntity(final Transaction transaction) {
        return TransactionEntity.builder()
                .amount(transaction.getAmount())
                .description(transaction.getDescription())
                .category(transaction.getCategory())
                .date(transaction.getDate())
                .build();
    }
}
