package org.investmentplatform.model.user.administrator;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel (description = "this class represents admins")
@Entity

public class Administrator
{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "Unique identifier of the admin.", 
    required = true, position = 0, hidden = true)
	private Long adminId;
	@ApiModelProperty(notes = "Job of the admin in the company.", 
    required = true, position = 1)
	private String jobTitle;
	@ApiModelProperty(notes = "Company department of the admin.", 
    required = true, position = 2)
	private String department;
	@ApiModelProperty(notes = "Type of contract.", 
    required = true, position = 3)
	private String contractType;
	@ApiModelProperty(notes = "Current salary of the admin.", 
    required = true, position = 4)
	private Long salary;
	@ApiModelProperty(notes = "Academic degrees and courses of the admin.", 
    required = true, position = 5)
	private String educationalBackground;
	@ApiModelProperty(notes = "Date when the admin was hired.", 
    required = true, position = 6)
	private Date hiringDate;
	@ApiModelProperty(notes = "Personal document of the user.", 
    required = true, position = 7)
	private String document;
	
	public Long getAdminId() {
		return adminId;
	}
	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getContractType() {
		return contractType;
	}
	public void setContractType(String contractType) {
		this.contractType = contractType;
	}
	public Long getSalary() {
		return salary;
	}
	public void setSalary(Long salary) {
		this.salary = salary;
	}
	public String getEducationalBackground() {
		return educationalBackground;
	}
	public void setEducationalBackground(String educationalBackground) {
		this.educationalBackground = educationalBackground;
	}
	public Date getHiringDate() {
		return hiringDate;
	}
	public void setHiringDate(Date hiringDate) {
		this.hiringDate = hiringDate;
	}
	public String getDocument() {
		return document;
	}
	public void setDocument(String document) {
		this.document = document;
	}
}
