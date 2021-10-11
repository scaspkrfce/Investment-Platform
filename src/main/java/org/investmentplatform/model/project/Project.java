package org.investmentplatform.model.project;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel (description = "this class represents projects")
@Entity

public class Project {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "Unique identifier of the project.", 
    required = true, position = 0, hidden = true)
	private Long projectId;
	@ApiModelProperty(notes = "Name of the project.", 
    required = true, position = 1)
	private String projectName;
	@ApiModelProperty(notes = "Description of the project.", 
    required = true, position = 2)
	private String projectDescription;
	@ApiModelProperty(notes = "Rating of the project.", 
    required = true, position = 3)
	private Long projectRating;
	@ApiModelProperty(notes = "Array of investors Ids.", 
    required = false, position = 4)
	private Long[] investorsIds;
	@ApiModelProperty(notes = "Array of entrepreneurs Ids.", 
    required = true, position = 5)
	private Long[] entrepreneursIds;
	@ApiModelProperty(notes = "About product: function, benefits, patents, competitors, clients, avant guard.", 
    required = false, position = 6)
	private String aboutProject;
	@ApiModelProperty(notes = "About sales: target market, size, expected growth, market collectives, expansion plan.", 
	required = true, position = 7)
	private String aboutSales;
	@ApiModelProperty(notes = "About management: founders, managers, associates, landmarks, roadmap, structure.", 
	required = true, position = 8)
	private String aboutManagement;
	@ApiModelProperty(notes = "About management: Earning model, costs, loss period, possible buyers, spending.", 
	required = true, position = 9)
	private String aboutFinancing;
	
	

	public String getAboutProject() {
		return aboutProject;
	}
	public void setAboutProject(String aboutProject) {
		this.aboutProject = aboutProject;
	}
	public String getAboutSales() {
		return aboutSales;
	}
	public void setAboutSales(String aboutSales) {
		this.aboutSales = aboutSales;
	}
	public String getAboutManagement() {
		return aboutManagement;
	}
	public void setAboutManagement(String aboutManagement) {
		this.aboutManagement = aboutManagement;
	}
	public String getAboutFinancing() {
		return aboutFinancing;
	}
	public void setAboutFinancing(String aboutFinancing) {
		this.aboutFinancing = aboutFinancing;
	}
	public Long getProjectId() {
		return projectId;
	}
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectDescription() {
		return projectDescription;
	}
	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}
	public Long getProjectRating() {
		return projectRating;
	}
	public void setProjectRating(Long projectRating) {
		this.projectRating = projectRating;
	}
	public Long[] getInvestorsIds() {
		return investorsIds;
	}
	public void setInvestorsIds(Long[] investorsIds) {
		this.investorsIds = investorsIds;
	}
	public Long[] getEntrepreneursIds() {
		return entrepreneursIds;
	}
	public void setEntrepreneursIds(Long[] entrepreneursIds) {
		this.entrepreneursIds = entrepreneursIds;
	}
	
	
}
