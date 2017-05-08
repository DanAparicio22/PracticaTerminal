package com.ucbcba.tallerprogra.Controllers;

import com.ucbcba.tallerprogra.Entities.Category;
import com.ucbcba.tallerprogra.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by da_20 on 26/4/2017.
 */
@Controller
public class CategoryController {
    private CategoryService categoryService;

    public CategoryService getCategoryService() {
        return categoryService;
    }

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(value = "/Categories", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("Categories", categoryService.listAllCategories());
        return "Categories";
    }


    @RequestMapping(value = "/Category/{id}", method = RequestMethod.GET)
    public String showCategory(@PathVariable Integer id, Model model) {
        model.addAttribute("Category", categoryService.getCategoryById(id));
        return "Category";
    }


    @RequestMapping(value = "/Category/delete/{id}", method = RequestMethod.GET)
    public String deleteCategory(@PathVariable Integer id, Model model) {
        categoryService.deleteCategory(id);
        return "redirect:/Categories";
    }

    @RequestMapping(value = "/Category/new", method = RequestMethod.GET)
    public String newCategory(Model model) {
        model.addAttribute("Category", new Category());
        return "CategoryForm";
    }

    @RequestMapping("Category/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("Category", categoryService.getCategoryById(id));
        return "CategoryForm";
    }


    @RequestMapping(value = "Category", method = RequestMethod.POST)
    public String saveCategory(@Valid Category category, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("Category", category);
            return "CategoryForm";
        }
        categoryService.saveCategory(category);
        return "redirect:/Category/" + category.getId();
    }
}
