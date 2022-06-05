package org.investmentplatform.service;

import java.util.Collection;
import java.util.NoSuchElementException;

import org.investmentplatform.exception.InvalidPasswordException;
import org.investmentplatform.exception.UserNotFoundException;
import org.investmentplatform.model.access.Access;
import org.investmentplatform.model.access.AccessRepository;
import org.investmentplatform.model.user.User;
import org.investmentplatform.model.user.UserRepository;
import org.investmentplatform.model.user.sesion.Sesion;
import org.investmentplatform.model.userxrole.UserXRole;
import org.investmentplatform.model.userxrole.UserXRoleRepository;
import org.investmentplatform.security.UserAuthenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationRestController 
{
	@Autowired
	UserRepository userRepository;	
	@Autowired
	UserXRoleRepository userXRoleRepository;
	@Autowired
	UserAuthenticator userAuthenticator;
	@Autowired
	AccessRepository accessRepository;
	@Autowired
	private SendEmail sendEmail;
	private final int MAX_ATEMPTS = 9;
	private final int ADMIN_ROLE_ID = 10;
	@GetMapping("/login") Sesion sesion(@RequestParam("email") String email, @RequestParam("password") String password) {
		Sesion sesion = new Sesion();
		String token = "";
		try {
			token = userAuthenticator.validateUser(email, password);
			User user = userRepository.findByEmail(email).get();
			sesion.setId(user.getUserId());
			sesion.setUserName(user.getFirstName()+" "+user.getSurname());
			sesion.setToken(token);		
			sesion.setEmail(email);
			sesion.setAdmin(isAdmin(user, this.userXRoleRepository));
			Long id = user.getUserId();
			Access access = accessRepository.findByUserId(id).get();
			access.setOtp(null);
			access = accessRepository.save(access);
		} catch (NoSuchElementException e) {
			System.out.println("User with email: "+email+" does not exist");
		} catch (InvalidPasswordException e) {
			System.out.println("Invalid password entered with email: "+email);
			addAttempt(email);
		}
		return sesion;
	}
	private void addAttempt(String email) {
		User user = userRepository.findByEmail(email).get();
		Long id = user.getUserId();
		Access access = accessRepository.findByUserId(id).get();
		if(access.getInvalidAttempts()==MAX_ATEMPTS)
		{
			access.setInvalidAttempts(0);
			System.out.println((MAX_ATEMPTS+1)+" Invalid password atempts with email: "+email);
			sendEmail.sendEmail(email, "Información de Seguridad", "Se han realizado más de "+(MAX_ATEMPTS+1)+" intentos para acceder a tu cuenta de FusaNest.");
		}
		else
		{
			int invalidAttempts = access.getInvalidAttempts()+1;
			access.setInvalidAttempts(invalidAttempts);
		}
		access = accessRepository.save(access);
	}
	public boolean isAdmin(User user,UserXRoleRepository userXRoleRepository) {
		Collection<UserXRole> userXRoleList = userXRoleRepository.findByUser(user);
		for(UserXRole index: userXRoleList)
		{
			if(index.getRole().getRoleId()==ADMIN_ROLE_ID)
			{
				return true;
			}
		}
		return false;
	}

}
