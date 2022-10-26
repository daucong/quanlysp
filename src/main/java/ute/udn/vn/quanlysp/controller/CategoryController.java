package ute.udn.vn.quanlysp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ute.udn.vn.quanlysp.entity.Category;
import ute.udn.vn.quanlysp.entity.Product;
import ute.udn.vn.quanlysp.repository.CategoryRepository;
import ute.udn.vn.quanlysp.service.CategoryService;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public String listCategories(Model model){
        List<Category> listCategories = categoryService.getAllCategory();
        model.addAttribute("listCategories", listCategories);
        return "categories";
    }
    @GetMapping("/categories/new")
    public String showCategoryNewForm(Model model){
        model.addAttribute("category", new Category());
        return "category_form";
    }
    @PostMapping("/categories/save")
    public String saveCategory(Category category){
        categoryService.saveCategory(category);
        return "redirect:/categories";
    }
    @GetMapping("/categories/edit/{id}")
    public String showEditCategoryForm(@PathVariable("id") Integer id, Model model){
        Category category = categoryService.findCategoryById(id).get();
        model.addAttribute("category", category);

        return "category_form";
    }
}
