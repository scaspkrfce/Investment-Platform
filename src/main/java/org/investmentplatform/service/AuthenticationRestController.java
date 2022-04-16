package org.investmentplatform.service;

import java.util.Collection;

import org.investmentplatform.exception.InvalidPasswordException;
import org.investmentplatform.exception.UserNotFoundException;
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
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidPasswordException e) {
			e.printStackTrace();
		}
		return sesion;
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
