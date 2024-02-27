package com.elasticsearch.elasticsearch.service;

import com.elasticsearch.elasticsearch.entity.Company;
import com.elasticsearch.elasticsearch.entity.JobPosting;

import java.util.List;

public interface CompanyService {

    Company createCompany(Company company);
    void deleteCompany(Long companyId);
    Company updateCompany(Company company);
    Company getCompanyById(Long companyId);
    List<Company> getAllCompanies();

    JobPosting createJobPosting(Long companyId, JobPosting jobPosting);
    void deleteJobPosting(Long companyId, Long jobPostingId);
    List<JobPosting> getAllJobPostingsByCompanyId(Long companyId);
}
