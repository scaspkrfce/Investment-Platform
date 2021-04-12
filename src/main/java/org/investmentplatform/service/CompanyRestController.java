package org.investmentplatform.service;

import java.util.List;

import org.investmentplatform.model.company.Company;
import org.investmentplatform.model.company.CompanyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyRestController 
{
	private static final Logger log = LoggerFactory.getLogger(CompanyRestController.class );
	@Autowired
	CompanyRepository companyRepository;
	@GetMapping ("/companies")
	List<Company> companies() 
	{
		log.info("found companies");
		return companyRepository.findAll();
	}
	@GetMapping ("/company/{companyId}")
	Company getCompany(@PathVariable Long companyId)
	{
		log.info("found company "+companyId);
		return companyRepository.findById(companyId).get();
	}
	@PostMapping ("/company")
	Company newCompany(@RequestBody Company company) 
	{
		
		log.info("created company "+company.getCompanyName());
		return companyRepository.save(company);
	}
	@PatchMapping ("/company/{companyId}")
	Company updateCompany(@RequestBody Company company, @PathVariable Long companyId)
	{
		log.info("updated company "+company.getCompanyName());
		return companyRepository.findById(companyId)
		.map(thisCompany->
		{
            if(!company.getCompanyName().equals(""))
            	thisCompany.setCompanyName(company.getCompanyName());
            if(!company.getAddress().equals(""))
            	thisCompany.setAddress(company.getAddress());
            if(!company.getCity().equals(""))
            	thisCompany.setCity(company.getCity());
            if(!company.getState().equals(""))
            	thisCompany.setState(company.getState());
            if(!company.getNIT().equals(""))
            	thisCompany.setNIT(company.getNIT());
            return this.companyRepository.save(thisCompany);
        })
        .orElseGet(()->
        {
            company.setCompanyId(companyId);
            return this.companyRepository.save(company);
        });
	}
	@DeleteMapping ("/company/{companyId}")
	void deleteCompany(@PathVariable Long companyId)
	{
		log.info("deleted company "+companyId);
		companyRepository.deleteById(companyId);
	}
}
