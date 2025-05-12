package budget.mypersonalbudget.repository;
import budget.mypersonalbudget.dto.TransactionDto;
import budget.mypersonalbudget.model.TransactionEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BudgetRepository {

    private final List<TransactionEntity> transactions = new ArrayList<>();

    public void save(final TransactionEntity transactionDto) {
        transactions.add(transactionDto);
    }

    public List<TransactionEntity> getAllTransactions() {
        return transactions;
    }

}
