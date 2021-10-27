package org.investmentplatform.model.user;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel (description = "this class represents users")
@Entity

public class User implements UserDetails, Serializable
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
	@ApiModelProperty(notes = "Hash code of the user's password.", 
    required = true, position = 5)
	private String passwordHash;
	@ApiModelProperty(notes = "Determines if user is enabled.", 
    required = true, position = 6)
	private boolean enabled = true;
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
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
	public Long getUserId() {
		return userId;
	}
	public String getPasswordHash() {
		return passwordHash;
	}
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}
	@Override
	public String getPassword() {
		return null;
	}
	@Override
	public String getUsername() {
		return null;
	}
	@Override
	public boolean isAccountNonExpired() {
		return this.enabled;
	}
	@Override
	public boolean isAccountNonLocked() {
		return this.enabled;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return this.enabled;
	}
	@Override
	public boolean isEnabled() {
		return this.enabled;
	}
}
