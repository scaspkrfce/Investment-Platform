package org.investmentplatform.service;

import java.util.ArrayList;
import java.util.List;

import org.investmentplatform.model.project.CategoryRepository;
import org.investmentplatform.model.project.Project;
import org.investmentplatform.model.project.ProjectXCategory;
import org.investmentplatform.model.project.ProjectXCategoryRepository;
import org.investmentplatform.model.project.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryRestController 
{
	private static final Logger log = LoggerFactory.getLogger(ProjectRestController.class );
	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	ProjectXCategoryRepository projectXCategoryRepository;
	@GetMapping ("/categories")
	List<Category> categories() 
	{
		log.info("found categories");
		return categoryRepository.findAll();
	}
	@GetMapping ("/category/{categoryName}")
	List<Project> getProjectsByCategory(@PathVariable String categoryName)
	{
		log.info("found category projects of "+categoryName);
		Category category = categoryRepository.findByCategoryName(categoryName);
		List<ProjectXCategory> projectXCategory = projectXCategoryRepository.findByCategoryId(category);
		List<Project> projects = new ArrayList<Project>();
		for (ProjectXCategory projectXCategoryIterator : projectXCategory) 
		{
			projects.add(projectXCategoryIterator.getProjectId());
		}
		return projects;
	}
}
