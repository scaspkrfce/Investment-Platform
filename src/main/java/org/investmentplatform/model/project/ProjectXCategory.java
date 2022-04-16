package org.investmentplatform.model.project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import io.swagger.annotations.ApiModel;

@ApiModel (description = "this class represents the relation between projects and categories")
@Entity

public class ProjectXCategory 
{
	@Id
    @Column(name="project_x_category_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectXCategoryId;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project projectId;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category categoryId;

	public Long getProjectXCategoryId() {
		return projectXCategoryId;
	}

	public void setProjectXCategoryId(Long projectXCategoryId) {
		this.projectXCategoryId = projectXCategoryId;
	}

	public Project getProjectId() {
		return projectId;
	}

	public void setProjectId(Project projectId) {
		this.projectId = projectId;
	}

	public Category getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Category categoryId) {
		this.categoryId = categoryId;
	}
}
