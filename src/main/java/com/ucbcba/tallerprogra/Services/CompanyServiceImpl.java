package com.ucbcba.tallerprogra.Services;

import com.ucbcba.tallerprogra.Entities.Company;
import com.ucbcba.tallerprogra.Repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService{

    private CompanyRepository companyRepository;

    public CompanyRepository getCompanyRepository() {
        return companyRepository;
    }

    @Autowired
    @Qualifier(value = "companyRepository")
    public void setCompanyRepository(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public Iterable<Company> listAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company getCompanyById(Integer id) {
        return companyRepository.findOne(id);
    }

    @Override
    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public void deleteCompany(Integer id) {
        companyRepository.delete(id);
    }
}
