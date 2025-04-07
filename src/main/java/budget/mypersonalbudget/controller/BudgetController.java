package budget.mypersonalbudget.controller;


import budget.mypersonalbudget.HttpEndPoints;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BudgetController {

    @GetMapping(HttpEndPoints.MY_BUDGET)
    public String openMyBudget() {
        return "budget";
    }
}
