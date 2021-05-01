package org.investmentplatform.security;

import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenAuthentication 
{

	public static String getJWTToken(String email) 
	{
		String token = Jwts.builder().setIssuedAt(new Date()).setIssuer(ISSUER_INFO)
				.setSubject(email)
				.setExpiration(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS512, SUPER_SECRET_KEY).compact();
		return token;
	}
	
	public static Boolean validateToken(String token, String email) 
	{
		if (token != null) 
		{
			// The token is processed
			String user = Jwts.parser()
						.setSigningKey(SUPER_SECRET_KEY)
						.parseClaimsJws(token.replace(TOKEN_BEARER_PREFIX, ""))
						.getBody()
						.getSubject();

			if (user.equals(email)) 
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
	private final static String ISSUER_INFO = "InvestmentPlatform";
	private final static Long TOKEN_EXPIRATION_TIME = 600000L;
	private final static String SUPER_SECRET_KEY = "mySecretKey";
	private final static String TOKEN_BEARER_PREFIX = "";
}
