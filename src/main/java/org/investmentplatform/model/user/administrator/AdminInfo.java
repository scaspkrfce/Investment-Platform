package org.investmentplatform.model.user.administrator;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class AdminInfo {

	@Id
	private Long adminId;
	private String firstName;
	private String surname;
	private String jobTitle;
	private String department;
	private String contractType;
	private String salary;
	private Date hiringDate;
	private String document;
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
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
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
