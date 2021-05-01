package org.investmentplatform;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.investmentplatform.security.TokenAuthentication;
import org.junit.jupiter.api.Test;

class TokenTest {

	@Test
	void test() 
	{
		String token = TokenAuthentication.getJWTToken("sc@outlook.com");
		System.out.println(token);
		Boolean isTokenValid = TokenAuthentication.validateToken(token, "sc@outlook.com");
		assertTrue(isTokenValid);
	}

}
