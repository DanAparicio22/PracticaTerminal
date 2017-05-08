package com.ucbcba.tallerprogra.Controllers;

import com.ucbcba.tallerprogra.Entities.User;
import com.ucbcba.tallerprogra.Services.CompanyService;
import com.ucbcba.tallerprogra.Services.UserService;
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
public class UserController {

    private UserService userService;
    private CompanyService companyService;

    public CompanyService getCompanyService() {
        return companyService;
    }

    @Autowired
    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
    }

    public UserService getUserService() {
        return userService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/Users", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("Users", userService.listAllUsers());
        return "Users";
    }


    @RequestMapping(value = "/User/{id}", method = RequestMethod.GET)
    public String showUser(@PathVariable Integer id, Model model) {
        model.addAttribute("User", userService.getUserById(id));
        return "User";
    }


    @RequestMapping(value = "/User/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable Integer id, Model model) {
        userService.deleteUser(id);
        return "redirect:/Users";
    }

    @RequestMapping(value = "/User/new", method = RequestMethod.GET)
    public String newUser(Model model) {
        model.addAttribute("User", new User());
        model.addAttribute("Users",userService.listAllUsers());
        model.addAttribute("companies",companyService.listAllCompanies());
        return "UserForm";
    }

    @RequestMapping("User/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("User", userService.getUserById(id));
        model.addAttribute("Users",userService.listAllUsers());
        model.addAttribute("companies",companyService.listAllCompanies());
        return "UserForm";
    }


    @RequestMapping(value = "User", method = RequestMethod.POST)
    public String saveUser(@Valid User user, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("User", user);
            model.addAttribute("Users",userService.listAllUsers());
            model.addAttribute("companies",companyService.listAllCompanies());
            return "UserForm";
        }
        userService.saveUser(user);
        return "redirect:/User/" + user.getId();
    }
}
