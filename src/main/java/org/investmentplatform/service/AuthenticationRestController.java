package org.investmentplatform.service;

import org.investmentplatform.exception.InvalidPasswordException;
import org.investmentplatform.exception.UserNotFoundException;
import org.investmentplatform.model.user.User;
import org.investmentplatform.model.user.UserRepository;
import org.investmentplatform.model.user.sesion.Sesion;
import org.investmentplatform.security.UserAuthenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationRestController 
{
	@Autowired
	UserRepository userRepository;	
	@PostMapping("/login")
	public Sesion sesion(@RequestParam("email") String email, @RequestParam("password") String password) {
		
		Sesion sesion = new Sesion();
		String token = "";
		try {
			token = UserAuthenticator.validateUser(email, password);
			User user = userRepository.findByEmail(email);
			sesion.setUserName(user.getFirstName()+" "+user.getSurname());
			sesion.setToken(token);		
			sesion.setEmail(email);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidPasswordException e) {
			e.printStackTrace();
		}
		return sesion;
	}

}
