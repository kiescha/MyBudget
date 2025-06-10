package budget.mypersonalbudget.controller;


import budget.mypersonalbudget.core.domain.Transaction;
import budget.mypersonalbudget.dto.DashboardDto;
import budget.mypersonalbudget.dto.TransactionDto;
import budget.mypersonalbudget.mapper.TransactionDtoMapper;
import budget.mypersonalbudget.service.BudgetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class DashboardController {

    private final BudgetService budgetService;
    private final TransactionDtoMapper transactionDtoMapper;

    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        if (!model.containsAttribute("transaction")) {
            TransactionDto transactionDto = new TransactionDto();
            transactionDto.setDate(LocalDateTime.now()); // Set default date to now
            model.addAttribute("transaction", transactionDto);
        }
        
        model.addAttribute("dashboard", DashboardDto.builder()
                .transactionDtoList(budgetService.getAllTransactions())
                .balance(budgetService.calculateBalance())
                .build());
        return "dashboard";
    }
    
    @GetMapping("/dashboard/edit")
    public String showEditForm(@RequestParam UUID id, Model model) {
        Transaction transaction = budgetService.getTransactionById(id);
        TransactionDto transactionDto = transactionDtoMapper.toTransactionDto(transaction);
        
        model.addAttribute("transaction", transactionDto);
        model.addAttribute("dashboard", DashboardDto.builder()
                .transactionDtoList(budgetService.getAllTransactions())
                .balance(budgetService.calculateBalance())
                .build());
        return "dashboard";
    }

    @PostMapping("/transaction/{id}/update")
    public String updateTransaction(@PathVariable UUID id, 
                                    @Valid @ModelAttribute TransactionDto transactionDto,
                                    BindingResult bindingResult,
                                    Model model,
                                    RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            // If validation fails, return to dashboard with errors
            model.addAttribute("dashboard", DashboardDto.builder()
                    .transactionDtoList(budgetService.getAllTransactions())
                    .balance(budgetService.calculateBalance())
                    .build());
            return "dashboard";
        }
        
        transactionDto.setId(id);
        budgetService.updateTransaction(transactionDtoMapper.toTransaction(transactionDto));
        
        redirectAttributes.addFlashAttribute("message", "Transaction updated successfully");
        return "redirect:/dashboard";
    }

    @GetMapping("/transaction/{id}/delete")
    public String deleteTransaction(@PathVariable UUID id, RedirectAttributes redirectAttributes) {
        budgetService.deleteTransactionById(id);
        
        redirectAttributes.addFlashAttribute("message", "Transaction deleted successfully");
        return "redirect:/dashboard";
    }

    @PostMapping("/transaction")
    public String createTransaction(@Valid @ModelAttribute("transaction") TransactionDto transaction,
                                    BindingResult bindingResult,
                                    Model model,
                                    RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            // If validation fails, return to dashboard with errors
            model.addAttribute("dashboard", DashboardDto.builder()
                    .transactionDtoList(budgetService.getAllTransactions())
                    .balance(budgetService.calculateBalance())
                    .build());
            return "dashboard";
        }
        
        if (transaction.getId() == null) {
            transaction.setId(UUID.randomUUID());
        }

        if (transaction.getDate() == null) {
            transaction.setDate(LocalDateTime.now());
        }
        
        budgetService.save(transactionDtoMapper.toTransaction(transaction));
        
        redirectAttributes.addFlashAttribute("transaction", new TransactionDto());
        redirectAttributes.addFlashAttribute("message", "Transaction created successfully");
        return "redirect:/dashboard";
    }
}
