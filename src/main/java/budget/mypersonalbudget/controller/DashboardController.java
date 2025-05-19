package budget.mypersonalbudget.controller;


import budget.mypersonalbudget.dto.DashboardDto;
import budget.mypersonalbudget.dto.TransactionDto;
import budget.mypersonalbudget.dto.TransactionFormDto;
import budget.mypersonalbudget.mapper.TransactionMapper;
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
    private final TransactionMapper transactionMapper;

    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        model.addAttribute("transaction", new TransactionDto());
        model.addAttribute("dashboard", DashboardDto.builder()
                .transactionDtoList(budgetService.getAllTransactions())
//                .balance(budgetService.calculateBalance())
                .build());
        return "dashboard";
    }


    @PostMapping("/transaction")
    public String createTransaction(@ModelAttribute("transactionForm") TransactionFormDto transactionFormDto) {

        TransactionDto dto = transactionMapper.fromTransactionFormDto(transactionFormDto);
        budgetService.save(dto);
        return "redirect:/dashboard";
    }


}
