package com.ucbcba.tallerprogra.Controllers;

import com.ucbcba.tallerprogra.Entities.TerminalHistory;
import com.ucbcba.tallerprogra.Services.TerminalHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by da_20 on 8/5/2017.
 */
@Controller
public class TerminalHistoryController {

    private TerminalHistoryService terminalHistoryService;


    public TerminalHistoryService getTerminalHistoryService() {
        return terminalHistoryService;
    }

    @Autowired
    public void setTerminalHistoryService(TerminalHistoryService terminalHistoryService) {
        this.terminalHistoryService = terminalHistoryService;
    }

    @RequestMapping(value = "/TerminalHistories", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("TerminalHistories", terminalHistoryService.listAllTerminalHistory());
        return "TerminalHistories";
    }


    @RequestMapping(value = "/TerminalHistory/{id}", method = RequestMethod.GET)
    public String showTerminalHistory(@PathVariable Integer id, Model model) {
        model.addAttribute("TerminalHistory", terminalHistoryService.getTerminalHistoryById(id));
        return "TerminalHistory";
    }


    @RequestMapping(value = "/TerminalHistory/delete/{id}", method = RequestMethod.GET)
    public String deleteTerminal(@PathVariable Integer id, Model model) {
        terminalHistoryService.deleteTerminalHistory(id);
        return "redirect:/TerminalHistories";
    }

    @RequestMapping(value = "/TerminalHistory/new", method = RequestMethod.GET)
    public String newTerminal(Model model) {
        model.addAttribute("TerminalHistory", new TerminalHistory());
        return "TerminalHistoryForm";
    }

    @RequestMapping("TerminalHistory/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("TerminalHistory", terminalHistoryService.getTerminalHistoryById(id));
        return "TerminalHistoryForm";
    }


    @RequestMapping(value = "TerminalHistory", method = RequestMethod.POST)
    public String saveTerminal(@Valid TerminalHistory terminalHistory, Model model) {
        terminalHistoryService.saveTerminalHistory(terminalHistory);
        return "redirect:/TerminalHistory/" + terminalHistory.getId();
    }


}
