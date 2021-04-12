package org.investmentplatform.model.company;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel (description = "this class represents companies")
@Entity

public class Company 
{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "Unique identifier of the company.", 
    required = false, position = 0, hidden = true)
	private Long companyId;
	@ApiModelProperty(notes = "Name of the company.", 
    required = false, position = 1)
	private String companyName;
	@ApiModelProperty(notes = "Address of the company", 
    required = false, position = 2)
	private String address;
	@ApiModelProperty(notes = "City where the company is based", 
	required = false, position = 3)
	private String city;
	@ApiModelProperty(notes = "State where the company is based", 
    required = false, position = 4)
	private String state;
	@ApiModelProperty(notes = "Administrative id of the company", 
    required = false, position = 5)
	private String NIT;
	
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getNIT() {
		return NIT;
	}
	public void setNIT(String nIT) {
		NIT = nIT;
	}
}
