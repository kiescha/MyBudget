package budget.mypersonalbudget.service;

import budget.mypersonalbudget.core.domain.Transaction;
import budget.mypersonalbudget.core.domain.TransactionTypeEnum;
import budget.mypersonalbudget.mapper.TransactionEntityMapper;
import budget.mypersonalbudget.repository.BudgetRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BudgetServiceTest {

    @Mock
    private BudgetRepository budgetRepository;

    @Mock
    private TransactionEntityMapper transactionEntityMapper;

    @InjectMocks
    private BudgetService budgetService;

    private Transaction incomeTransaction;
    private Transaction expenseTransaction;
    private UUID testId;

    @BeforeEach
    void setUp() {
        testId = UUID.randomUUID();
        incomeTransaction = Transaction.builder()
                .id(testId)
                .amount(new BigDecimal("100.00"))
                .description("Salary")
                .category("Work")
                .date(LocalDateTime.now())
                .type(TransactionTypeEnum.INCOME)
                .build();

        expenseTransaction = Transaction.builder()
                .id(UUID.randomUUID())
                .amount(new BigDecimal("50.00"))
                .description("Groceries")
                .category("Food")
                .date(LocalDateTime.now())
                .type(TransactionTypeEnum.EXPENSE)
                .build();
    }

    @Test
    void save_ShouldSaveTransaction() {
        // Arrange
        doNothing().when(budgetRepository).save(any(Transaction.class));

        // Act
        budgetService.save(incomeTransaction);

        // Assert
        verify(budgetRepository, times(1)).save(incomeTransaction);
    }

    @Test
    void getAllTransactions_ShouldReturnAllTransactions() {
        // Arrange
        List<Transaction> expectedTransactions = Arrays.asList(incomeTransaction, expenseTransaction);
        when(budgetRepository.findAll()).thenReturn(expectedTransactions);

        // Act
        List<Transaction> actualTransactions = budgetService.getAllTransactions();

        // Assert
        assertEquals(expectedTransactions.size(), actualTransactions.size());
        assertEquals(expectedTransactions, actualTransactions);
        verify(budgetRepository, times(1)).findAll();
    }

    @Test
    void getTransactionById_WhenTransactionExists_ShouldReturnTransaction() {
        // Arrange
        when(budgetRepository.findById(testId)).thenReturn(java.util.Optional.of(incomeTransaction));

        // Act
        Transaction result = budgetService.getTransactionById(testId);

        // Assert
        assertNotNull(result);
        assertEquals(incomeTransaction, result);
        verify(budgetRepository, times(1)).findById(testId);
    }

    @Test
    void getTransactionById_WhenTransactionDoesNotExist_ShouldReturnNull() {
        // Arrange
        when(budgetRepository.findById(testId)).thenReturn(java.util.Optional.empty());

        // Act
        Transaction result = budgetService.getTransactionById(testId);

        // Assert
        assertNull(result);
        verify(budgetRepository, times(1)).findById(testId);
    }

    @Test
    void updateTransaction_ShouldUpdateTransaction() {
        // Arrange
        doNothing().when(budgetRepository).update(any(Transaction.class));

        // Act
        budgetService.updateTransaction(incomeTransaction);

        // Assert
        verify(budgetRepository, times(1)).update(incomeTransaction);
    }

    @Test
    void deleteTransactionById_ShouldDeleteTransaction() {
        // Arrange
        doNothing().when(budgetRepository).deleteTransactionById(testId);

        // Act
        budgetService.deleteTransactionById(testId);

        // Assert
        verify(budgetRepository, times(1)).deleteTransactionById(testId);
    }

    @Test
    void calculateBalance_WithIncomeAndExpenses_ShouldReturnCorrectBalance() {
        // Arrange
        List<Transaction> transactions = Arrays.asList(incomeTransaction, expenseTransaction);
        when(budgetRepository.findAll()).thenReturn(transactions);

        // Act
        BigDecimal balance = budgetService.calculateBalance();

        // Assert
        assertEquals(new BigDecimal("50.00"), balance);
        verify(budgetRepository, times(1)).findAll();
    }

    @Test
    void calculateBalance_WithNoTransactions_ShouldReturnZero() {
        // Arrange
        when(budgetRepository.findAll()).thenReturn(List.of());

        // Act
        BigDecimal balance = budgetService.calculateBalance();

        // Assert
        assertEquals(BigDecimal.ZERO, balance);
        verify(budgetRepository, times(1)).findAll();
    }
} 