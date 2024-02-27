package com.elasticsearch.elasticsearch.serviceImpl;

import com.elasticsearch.elasticsearch.entity.Company;
import com.elasticsearch.elasticsearch.entity.JobPosting;
import com.elasticsearch.elasticsearch.repository.CompanyRepository;
import com.elasticsearch.elasticsearch.repository.JobPostingRepository;
import com.elasticsearch.elasticsearch.service.CompanyService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private JobPostingRepository jobPostingRepository;
    @Override
    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    @Transactional
    public void deleteCompany(Long companyId) {
        companyRepository.findById(companyId).ifPresent(company -> {
            // Delete associated job postings before deleting the company
            jobPostingRepository.deleteAllByCompany(company);
            companyRepository.delete(company);
        });


    }

    @Override
    public Company updateCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company getCompanyById(Long companyId) {
        return companyRepository.findByCompanyId(companyId).orElse(null);
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public JobPosting createJobPosting(Long companyId, JobPosting jobPosting) {
        companyRepository.findByCompanyId(companyId).ifPresent(jobPosting::setCompany);
        return jobPostingRepository.save(jobPosting);
    }

    @Override
    public void deleteJobPosting(Long companyId, Long jobPostingId) {
        companyRepository.findById(companyId).ifPresent(company -> {
            // Delete job posting only if it belongs to the specified company
            jobPostingRepository.deleteByJobPostingIdAndCompany(jobPostingId, company);
        });

    }

    @Override
    public List<JobPosting> getAllJobPostingsByCompanyId(Long companyId) {
        Company company = companyRepository.findById(companyId).orElse(null);
        if (company != null) {
            return jobPostingRepository.findAllByCompany(company);
        }
        return null;
    }
}
