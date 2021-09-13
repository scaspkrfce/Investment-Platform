package org.investmentplatform.service;

import java.util.List;

import org.investmentplatform.model.user.administrator.Administrator;
import org.investmentplatform.model.user.administrator.AdministratorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdministratorRestController 
{
	private static final Logger log = LoggerFactory.getLogger(ProjectRestController.class );
	@Autowired
	AdministratorRepository adminRepository;
	@GetMapping ("/administrators")
	List<Administrator> admins() 
	{
		log.info("found administrators");
		return adminRepository.findAll();
	}

}
