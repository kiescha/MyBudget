package budget.mypersonalbudget.repository;

import budget.mypersonalbudget.core.domain.Transaction;
import budget.mypersonalbudget.mapper.TransactionEntityMapper;
import budget.mypersonalbudget.model.TransactionEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


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
}
