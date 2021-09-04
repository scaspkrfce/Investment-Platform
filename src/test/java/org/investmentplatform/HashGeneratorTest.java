package org.investmentplatform;

import static org.junit.jupiter.api.Assertions.*;

import org.investmentplatform.security.HashGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.lambdaworks.crypto.SCryptUtil;

class HashGeneratorTest {

	@BeforeEach
	void setUp() throws Exception 
	{
		
	}

	@Test
	void testGenerateHash() 
	{
		String userPassword = "password";
		String hashPassword = HashGenerator.GenerateHashFromPassword(userPassword);
		
        boolean matched = SCryptUtil.check("password", hashPassword);
        assertTrue(matched);
         
        matched = SCryptUtil.check("passwordno", hashPassword);
        assertFalse(matched);
        
	}
	void testMatchStringToHash()
	{
		String userPassword = "password";

		String userHash = HashGenerator.GenerateHashFromPassword(userPassword);
		
		assertTrue(HashGenerator.check(userPassword, userHash));
		
		userPassword = "notPassword";
		assertFalse(HashGenerator.check(userPassword, userHash));
	}

}
