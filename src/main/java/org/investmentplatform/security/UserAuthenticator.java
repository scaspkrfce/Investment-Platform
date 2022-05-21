package org.investmentplatform.security;

import org.investmentplatform.exception.InvalidPasswordException;
import org.investmentplatform.exception.UserNotFoundException;
import org.investmentplatform.model.user.User;
import org.investmentplatform.model.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAuthenticator 
{	
	@Autowired
	UserRepository userRepository;
	public String validateUser (String email, String password) throws UserNotFoundException, InvalidPasswordException
	{
		String token = "";
		User user = userRepository.findByEmail(email).get();
		if(user == null)
		{
			throw new UserNotFoundException(email);
			
		}
		else
		{
			boolean validatePassword = HashGenerator.check(password, user.getPasswordHash());
			if(validatePassword)
			{
				token = TokenAuthentication.getJWTToken(email);
			}
			else
			{
				throw new InvalidPasswordException();
			}
		}
		return token;
	}
	
}
