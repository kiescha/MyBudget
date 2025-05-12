package budget.mypersonalbudget.service;


import budget.mypersonalbudget.dto.TransactionDto;
import budget.mypersonalbudget.repository.BudgetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BudgetService {

    private final BudgetRepository budgetRepository;

    public void save(final TransactionDto transactionDto) {
        budgetRepository.save(transactionDto);
    }

    public List<TransactionDto> getAllTransactions() {
        return budgetRepository.getAllTransactions();
    }
}
