package org.investmentplatform.exception;

import org.springframework.security.core.AuthenticationException;

public class UserNotFoundException extends AuthenticationException
{
	public UserNotFoundException(String email) {
		super(email);
	}

	private static final long serialVersionUID = 1L;

}
