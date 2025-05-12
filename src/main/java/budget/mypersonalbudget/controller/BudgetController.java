package budget.mypersonalbudget.controller;


import budget.mypersonalbudget.dto.TransactionDto;
import budget.mypersonalbudget.service.BudgetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class BudgetController {

    private final BudgetService budgetService;

    @GetMapping("/budget")
    public String openMyBudget(Model model) {
        model.addAttribute("transaction", new TransactionDto());
        return "budget";
    }

    @PostMapping("/budget")
    public String createTransaction(TransactionDto transactionDto) {
        budgetService.save(transactionDto);
        budgetService.getAllTransactions().forEach(System.out::println);
        System.out.println(transactionDto);
        return "home";
    }
}
