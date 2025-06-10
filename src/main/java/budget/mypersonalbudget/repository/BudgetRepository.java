package budget.mypersonalbudget.repository;

import budget.mypersonalbudget.core.domain.Transaction;
import budget.mypersonalbudget.mapper.TransactionEntityMapper;
import budget.mypersonalbudget.model.TransactionEntity;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository
@RequiredArgsConstructor
public class BudgetRepository {

    private final TransactionEntityMapper transactionEntityMapper;
    private final TransactionRepository transactionRepository;

    public void save(final Transaction transaction) {
        TransactionEntity transactionEntity = transactionEntityMapper.toTransactionEntity(transaction);
        transactionRepository.save(transactionEntity);
    }

    public List<Transaction> findAll() {
        return transactionRepository.findAll()
                .stream()
                .map(transactionEntityMapper::toTransaction)
                .toList();
    }

    public void update(final Transaction transaction) {
        transactionRepository.findByTransactionId(transaction.getId())
                .ifPresent(entity -> {
                    entity.setAmount(transaction.getAmount());
                    entity.setCategory(transaction.getCategory());
                    entity.setDescription(transaction.getDescription());
                    entity.setDate(transaction.getDate());
                    entity.setType(transaction.getType());
                    transactionRepository.save(entity);
                });
    }
    
    @Transactional
    public void deleteTransactionById(final UUID id) {
        transactionRepository.deleteByTransactionId(id);
    }

    public Optional<Transaction> findById(final UUID id) {
        return transactionRepository.findByTransactionId(id)
                .map(transactionEntityMapper::toTransaction);
    }
}
