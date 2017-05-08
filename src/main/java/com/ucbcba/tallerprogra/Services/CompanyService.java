package com.ucbcba.tallerprogra.Services;

import com.ucbcba.tallerprogra.Entities.Company;

/**
 * Created by da_20 on 26/4/2017.
 */
public interface CompanyService {
    Iterable<Company> listAllCompanies();

    Company getCompanyById(Integer id);

    Company saveCompany(Company company);

    void deleteCompany(Integer id);
}
