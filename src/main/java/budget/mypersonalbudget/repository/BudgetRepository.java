package budget.mypersonalbudget.repository;

import budget.mypersonalbudget.core.domain.Transaction;
import budget.mypersonalbudget.mapper.TransactionEntityMapper;
import budget.mypersonalbudget.model.TransactionEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository
@RequiredArgsConstructor
public class BudgetRepository {

    private final TransactionEntityMapper transactionEntityMapper;
    private final List<TransactionEntity> transactionEntities = new ArrayList<>();


    public void save(final Transaction transaction) {
        transactionEntities.add(transactionEntityMapper.toTransactionEntity(transaction));
    }

    public List<Transaction> findAll() {
        return transactionEntities.stream().map(transactionEntityMapper::toTransaction).toList();
    }

    public void update(final Transaction transaction) {
        transactionEntities.stream().filter(transactionEntity -> transactionEntity.getId() == transaction.getId())
                .findFirst()
                .ifPresent(transactionEntity -> {
                    transactionEntity.setAmount(transaction.getAmount());
                    transactionEntity.setCategory(transaction.getCategory());
                    transactionEntity.setDescription(transaction.getDescription());
                    transactionEntity.setDate(transaction.getDate());
                });
    }

    public Optional<Transaction> findById(final UUID id) {
        return transactionEntities.stream()
                .filter(transactionEntity -> transactionEntity.getId() == id)
                .map(transactionEntityMapper::toTransaction)
                .findFirst();
    }

}
