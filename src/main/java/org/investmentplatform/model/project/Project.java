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
	
	
}
