package se.techinsight.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import se.techinsight.dto.CategoryDto;
import se.techinsight.service.CategoryService;

import javax.validation.Valid;

@Controller
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public String category(Model model) {
        model.addAttribute("categories", categoryService.getAll());
        return "category/list";
    }

    @GetMapping("/add")
    public String categoryAdd(Model model) {
        model.addAttribute("category", new CategoryDto());
        return "category/add";
    }

    @PostMapping("/add")
    public String addRecord(@ModelAttribute @Valid CategoryDto category, Model model) {
        categoryService.save(category);
        return "redirect:/category";
    }

    @GetMapping("/{id}")
    public String editCategory(@PathVariable("id") int id, Model model) {
        model.addAttribute("category", categoryService.get(id));
        return "category/edit";
    }
}
