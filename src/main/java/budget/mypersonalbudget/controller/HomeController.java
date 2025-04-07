package budget.mypersonalbudget.controller;


import budget.mypersonalbudget.HttpEndPoints;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(HttpEndPoints.HOME)
    public String openHomePage() {
        return "home";
    }

}
