package org.investmentplatform.model.access;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel (description = "this class represents user's access")
@Entity
@Table (name = "access" , schema = "public")
public class Access {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "Unique identifier of the access.", 
    required = true, position = 0, hidden = true)
	private Long accessId;
	@ApiModelProperty(notes = "Unique identifier of the user.", 
    required = true, position = 1, hidden = true)
	private Long userId;
	@ApiModelProperty(notes = "Unique volatile key for access.", 
    required = true, position = 2, hidden = true)
	private String otp;
	@ApiModelProperty(notes = "Number of invalid attempts.", 
    required = true, position = 3, hidden = true)
	private int invalidAttempts;
	public Long getAccessId() {
		return accessId;
	}
	public void setAccessId(Long accessId) {
		this.accessId = accessId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public int getInvalidAttempts() {
		return invalidAttempts;
	}
	public void setInvalidAttempts(int invalidAtempts) {
		this.invalidAttempts = invalidAtempts;
	}
}
