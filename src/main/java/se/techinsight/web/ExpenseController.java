package se.techinsight.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import se.techinsight.service.ExpenseService;

@Controller
@RequestMapping("/expense")
@RequiredArgsConstructor
public class ExpenseController {

    private final ExpenseService expenseService;
    @GetMapping
    public String category(Model model) {
        model.addAttribute("categories", expenseService.getAll());
        return "category/list";
    }

}
