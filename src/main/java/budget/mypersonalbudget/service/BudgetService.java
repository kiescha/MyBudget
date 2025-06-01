package budget.mypersonalbudget.service;


import budget.mypersonalbudget.core.domain.Transaction;
import budget.mypersonalbudget.dto.TransactionDto;
import budget.mypersonalbudget.mapper.TransactionEntityMapper;
import budget.mypersonalbudget.repository.BudgetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@RequiredArgsConstructor
public class BudgetService {

    private final BudgetRepository budgetRepository;
    private final TransactionEntityMapper transactionMapper;

    public void save(final Transaction transaction) {
        budgetRepository.save(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return budgetRepository.findAll();
    }
}
