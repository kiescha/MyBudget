package budget.mypersonalbudget.controller;


import budget.mypersonalbudget.dto.DashboardDto;
import budget.mypersonalbudget.dto.TransactionDto;
import budget.mypersonalbudget.mapper.TransactionDtoMapper;
import budget.mypersonalbudget.service.BudgetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
public class DashboardController {

    private final BudgetService budgetService;
    private final TransactionDtoMapper transactionDtoMapper;

    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setDate(LocalDateTime.now()); // Set default date to now
        
        model.addAttribute("transaction", transactionDto);
        model.addAttribute("dashboard", DashboardDto.builder()
                .transactionDtoList(budgetService.getAllTransactions())
                .balance(budgetService.calculateBalance())
                .build());
        return "dashboard";
    }


    @PostMapping("/transaction")
    public String createTransaction(@ModelAttribute("transaction") TransactionDto transaction) {

        if (transaction.getDate() == null) {
            transaction.setDate(LocalDateTime.now());
        }
        
        budgetService.save(transactionDtoMapper.toTransaction(transaction));
        return "redirect:/dashboard";
    }
}
