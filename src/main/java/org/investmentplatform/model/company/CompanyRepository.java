package org.investmentplatform.model.company;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long>
{
	Collection<Company> findByCompanyName(String companyName);
}
