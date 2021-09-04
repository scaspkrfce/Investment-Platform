package org.investmentplatform.model.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel (description = "this class represents users")
@Entity

public class User 
{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "Unique identifier of the user.", 
    required = true, position = 0, hidden = true)
	private Long userId;
	@ApiModelProperty(notes = "First name of the user.", 
    required = true, position = 1)
	private String firstName;
	@ApiModelProperty(notes = "Surname of the user.", 
    required = true, position = 2)
	private String surname;
	@ApiModelProperty(notes = "Email contact of the user.", 
    required = true, position = 3)
	private String email;
	@ApiModelProperty(notes = "Phone contact of the user.", 
    required = true, position = 4)
	private Long phoneNumber;
	@ApiModelProperty(notes = "Personal document of the user.", 
    required = true, position = 5)
	private String document;
	@ApiModelProperty(notes = "Current status of the user.", 
    required = true, position = 6)
	private int status;
	@ApiModelProperty(notes = "Hash code of the user's password.", 
    required = true, position = 7)
	private String passwordHash;
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getDocument() {
		return document;
	}
	public void setDocument(String document) {
		this.document = document;
	}
	public Long getUserId() {
		return userId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getPasswordHash() {
		return passwordHash;
	}
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}
	
}
