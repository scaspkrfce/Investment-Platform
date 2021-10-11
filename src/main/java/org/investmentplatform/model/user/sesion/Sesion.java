package org.investmentplatform.model.user.sesion;

public class Sesion 
{
	private String userName;
	private String token;
	private String email;
	private boolean isGeneralUser;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isGeneralUser() {
		return isGeneralUser;
	}
	public void setGeneralUser(boolean isGeneralUser) {
		this.isGeneralUser = isGeneralUser;
	}
}
