package org.investmentplatform.service;

import org.investmentplatform.model.user.User;
import org.investmentplatform.model.user.UserRepository;
import org.investmentplatform.model.user.sesion.Sesion;
import org.investmentplatform.security.TokenAuthentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationRestController 
{
	private static final Logger log = LoggerFactory.getLogger(AuthenticationRestController.class );
	@Autowired
	UserRepository userRepository;
	@PostMapping ("/user")
	User newUser(@RequestBody User user) 
	{
		
		log.info("created user "+user.getUserId());
		return userRepository.save(user);
	}
	
	@PostMapping("/login") //to do authentication
	public Sesion sesion(@RequestParam("email") String email, @RequestParam("password") String pwd) {
		
		String token = TokenAuthentication.getJWTToken(email);
		Sesion sesion = new Sesion();
		User user = userRepository.findByEmail(email);
		sesion.setUserName(user.getFirstName()+" "+user.getSurname());
		sesion.setToken(token);		
		sesion.setEmail(email);
		return sesion;
	}

}
