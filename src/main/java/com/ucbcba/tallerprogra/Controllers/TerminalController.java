package com.ucbcba.tallerprogra.Controllers;

import com.ucbcba.tallerprogra.Entities.Category;
import com.ucbcba.tallerprogra.Entities.Location;
import com.ucbcba.tallerprogra.Entities.Terminal;
import com.ucbcba.tallerprogra.Entities.TerminalHistory;
import com.ucbcba.tallerprogra.Services.*;
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
public class TerminalController {

    private TerminalService terminalService;

    private CategoryService categoryService;

    private UserService userService;
    private TerminalHistoryService terminalHistoryService;

    public TerminalHistoryService getTerminalHistoryService() {
        return terminalHistoryService;
    }

    @Autowired
    public void setTerminalHistoryService(TerminalHistoryService terminalHistoryService) {
        this.terminalHistoryService = terminalHistoryService;
    }

    public UserService getUserService() {
        return userService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public CategoryService getCategoryService() {
        return categoryService;
    }

    public TerminalService getTerminalService() {
        return terminalService;
    }

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }



    @Autowired
    public void setTerminalService(TerminalService terminalService) {
        this.terminalService = terminalService;
    }

    @RequestMapping(value = "/Terminals", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("Terminals", terminalService.listAllTerminals());
        return "Terminals";
    }


    @RequestMapping(value = "/Terminal/{id}", method = RequestMethod.GET)
    public String showTerminal(@PathVariable Integer id, Model model) {
        model.addAttribute("Terminal", terminalService.getTerminalById(id));
        return "Terminal";
    }


    @RequestMapping(value = "/Terminal/delete/{id}", method = RequestMethod.GET)
    public String deleteTerminal(@PathVariable Integer id, Model model) {
        terminalService.deleteTerminal(id);
        return "redirect:/Terminals";
    }

    @RequestMapping(value = "/Terminal/new", method = RequestMethod.GET)
    public String newTerminal(Model model) {
        model.addAttribute("Terminal", new Terminal());
        model.addAttribute("categories",categoryService.listAllCategories());
        model.addAttribute("Users",userService.listAllUsers());
        return "TerminalForm";
    }

    @RequestMapping("Terminal/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("Terminal", terminalService.getTerminalById(id));
        model.addAttribute("categories",categoryService.listAllCategories());
        model.addAttribute("Users",userService.listAllUsers());
        return "TerminalForm";
    }


    @RequestMapping(value = "Terminal", method = RequestMethod.POST)
    public String saveTerminal(@Valid Terminal terminal, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("Terminal", terminal);
            model.addAttribute("categories",categoryService.listAllCategories());
            model.addAttribute("Users",userService.listAllUsers());

            return "TerminalForm";
        }
        if(terminal.getActive()==null){
            terminal.setActive(false);
        }
        terminalService.saveTerminal(terminal);
        terminalHistoryService.saveTerminalHistory(new TerminalHistory(terminal.getSerial(),terminal.getActive(),terminal.getCategoryId().getId(),terminal.getUserId().getId(),terminal));
        return "redirect:/Terminal/" + terminal.getId();
    }

    @RequestMapping(value = "/Terminal/Active/{id}", method = RequestMethod.GET)
    public String activeTerminal(@PathVariable Integer id){
        Terminal a=terminalService.getTerminalById(id);
        if(a.getActive()==true) {
            a.setActive(false);
        }else{
            a.setActive(true);
        }
        terminalService.saveTerminal(a);
        return "redirect:/Terminals";
    }

}
