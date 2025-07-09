package budget.mypersonalbudget.repository;

import budget.mypersonalbudget.model.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {

    Optional<TransactionEntity> findByTransactionId(UUID transactionId);

    void deleteByTransactionId(UUID transactionId);
} 