package budget.mypersonalbudget.service;


import budget.mypersonalbudget.core.domain.Transaction;
import budget.mypersonalbudget.core.domain.TransactionTypeEnum;
import budget.mypersonalbudget.mapper.TransactionEntityMapper;
import budget.mypersonalbudget.repository.BudgetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;


@Service
@RequiredArgsConstructor
public class BudgetService {

    private final BudgetRepository budgetRepository;
    private final TransactionEntityMapper transactionEntityMapper;

    public void save(final Transaction transaction) {
        budgetRepository.save(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return budgetRepository.findAll();
    }
    
    public BigDecimal calculateBalance() {
        List<Transaction> transactions = getAllTransactions();
        
        return transactions.stream()
                .map(transaction -> {
                    if (transaction.getType() == TransactionTypeEnum.INCOME) {
                        return transaction.getAmount();
                    } else {
                        return transaction.getAmount().negate();
                    }
                })
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
