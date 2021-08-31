package org.investmentplatform.service;

import java.util.List;

import org.investmentplatform.model.project.Project;
import org.investmentplatform.model.project.ProjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectRestController 
{
	private static final Logger log = LoggerFactory.getLogger(ProjectRestController.class );
	@Autowired
	ProjectRepository projectRepository;
	@GetMapping ("/projects")
	List<Project> projects() 
	{
		log.info("found projects");
		return projectRepository.findAll();
	}
	@GetMapping ("/project/{projectId}")
	Project getproject(@PathVariable Long projectId)
	{
		log.info("found project "+projectId);
		return projectRepository.findById(projectId).get();
	}
	@PostMapping ("/project")
	Project newProject(@RequestBody Project project) 
	{
		
		log.info("created project "+project.getProjectName());
		return projectRepository.save(project);
	}
	@PatchMapping ("/project/{projectId}")
	Project updateProject(@RequestBody Project project, @PathVariable Long projectId)
	{
		log.info("updated project "+project.getProjectName());
		return projectRepository.findById(projectId)
		.map(thisProject->
		{
            if(!project.getProjectName().equals(""))
            	thisProject.setProjectName(project.getProjectName());
            if(!project.getProjectDescription().equals(""))
            	thisProject.setProjectDescription(project.getProjectDescription());
            if(!project.getProjectRating().equals(""))
            	thisProject.setProjectRating(project.getProjectRating());

            return this.projectRepository.save(thisProject);
        })
        .orElseGet(()->
        {
            project.setProjectId(projectId);
            return this.projectRepository.save(project);
        });
	}
	@DeleteMapping ("/project/{projectId}")
	void deleteProject(@PathVariable Long projectId)
	{
		log.info("deleted project "+projectId);
		projectRepository.deleteById(projectId);
	}
}
