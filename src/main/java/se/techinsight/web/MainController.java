package se.techinsight.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import se.techinsight.dto.Record;

import javax.validation.Valid;

@Controller
public class MainController {

    @GetMapping("/")
    public String index(
        @RequestParam(name = "name", required = false, defaultValue = "World") String name,
        Model model
    ) {
        model.addAttribute("name", name);
        return "index";
    }

    @GetMapping("/add")
    public String getRecord(Model model) {
        model.addAttribute("record", new Record());
        return "record/new";
    }

    @PostMapping("/add-new")
    public String addRecord(@ModelAttribute @Valid Record record, Model model) {

        System.out.println(record);
//        model.addAttribute("record", new Record());
        return "index";
    }
}
