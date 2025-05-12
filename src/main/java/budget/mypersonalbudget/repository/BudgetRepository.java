package budget.mypersonalbudget.repository;
import budget.mypersonalbudget.dto.TransactionDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BudgetRepository {

    private final List<TransactionDto> transactions = new ArrayList<>();

    public void save(final TransactionDto transactionDto) {
        transactions.add(transactionDto);
    }

    public List<TransactionDto> getAllTransactions() {
        return transactions;
    }

}
