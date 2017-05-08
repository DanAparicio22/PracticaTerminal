package com.ucbcba.tallerprogra.Controllers;

import com.ucbcba.tallerprogra.Entities.Company;
import com.ucbcba.tallerprogra.Services.CompanyService;
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
public class CompanyController {

    private CompanyService companyService;

    public CompanyService getCompanyService() {
        return companyService;
    }

    @Autowired
    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
    }

    @RequestMapping(value = "/Companies", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("Companies", companyService.listAllCompanies());
        return "Companies";
    }


    @RequestMapping(value = "/Company/{id}", method = RequestMethod.GET)
    public String showUser(@PathVariable Integer id, Model model) {
        model.addAttribute("Company", companyService.getCompanyById(id));
        return "Company";
    }


    @RequestMapping(value = "/Company/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable Integer id, Model model) {
        companyService.deleteCompany(id);
        return "redirect:/Companies";
    }

    @RequestMapping(value = "/Company/new", method = RequestMethod.GET)
    public String newUser(Model model) {
        model.addAttribute("Company", new Company());
        return "CompanyForm";
    }

    @RequestMapping("Company/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("Company", companyService.getCompanyById(id));
        return "CompanyForm";
    }


    @RequestMapping(value = "Company", method = RequestMethod.POST)
    public String saveUser(@Valid Company company, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("Company", company);
            return "CompanyForm";
        }
        companyService.saveCompany(company);
        return "redirect:/Company/" + company.getId();
    }
}
