package org.investmentplatform.service;

import java.util.ArrayList;
import java.util.List;

import org.investmentplatform.model.user.User;
import org.investmentplatform.model.user.UserRepository;
import org.investmentplatform.model.user.administrator.AdminInfo;
import org.investmentplatform.model.user.administrator.Administrator;
import org.investmentplatform.model.user.administrator.AdministratorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdministratorRestController 
{
	private static final Logger log = LoggerFactory.getLogger(ProjectRestController.class );
	@Autowired
	AdministratorRepository adminRepository;
	@Autowired
	UserRepository userRepository;
	@GetMapping ("/administrators")
	List<Administrator> admins() 
	{
		log.info("found administrators");
		return adminRepository.findAll();
	}
	@GetMapping ("/admins/info")
	List<AdminInfo> adminsInfo() 
	{
		log.info("found admins info");
		List<AdminInfo> adminInfoList = new ArrayList<AdminInfo>();
		for(Administrator index: adminRepository.findAll())
		{
			AdminInfo adminInfo = new AdminInfo();
			adminInfo.setAdminId(index.getAdminId());
			User user = userRepository.findById(index.getAdminId()).get();
			adminInfo.setFirstName(user.getFirstName());
			adminInfo.setSurname(user.getSurname());
			adminInfo.setJobTitle(index.getJobTitle());
			adminInfo.setDepartment(index.getDepartment());
			adminInfo.setContractType(index.getContractType());
			adminInfo.setHiringDate(index.getHiringDate());
			adminInfo.setDocument(index.getDocument());
			adminInfoList.add(adminInfo);
		}
		System.out.print(adminInfoList);
		return adminInfoList;
	}
	@GetMapping ("/admins/info/{id}")
	AdminInfo adminInfo(@PathVariable Long id) 
	{
		log.info("found admin info");
		AdminInfo adminInfo = new AdminInfo();
		adminInfo.setAdminId(id);
		User user = userRepository.findById(id).get();
		Administrator admin = adminRepository.findById(id).get();
		adminInfo.setFirstName(user.getFirstName());
		adminInfo.setSurname(user.getSurname());
		adminInfo.setJobTitle(admin.getJobTitle());
		adminInfo.setDepartment(admin.getDepartment());
		adminInfo.setContractType(admin.getContractType());
		adminInfo.setHiringDate(admin.getHiringDate());
		adminInfo.setDocument(admin.getDocument());
		return adminInfo;
	}
}
