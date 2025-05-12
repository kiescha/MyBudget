package budget.mypersonalbudget.service;


import budget.mypersonalbudget.dto.TransactionDto;
import budget.mypersonalbudget.mapper.TransactionMapper;
import budget.mypersonalbudget.repository.BudgetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class BudgetService {

    private final BudgetRepository budgetRepository;
    private final TransactionMapper transactionMapper;

    public void save(final TransactionDto transactionDto) {
        budgetRepository.save(transactionMapper.toTransactionEntity(transactionDto));
    }

    public List<TransactionDto> getAllTransactions() {
        return budgetRepository.getAllTransactions()
                .stream()
                .map(transactionMapper::toTransactionDto)
                .toList();
    }
}
