package org.investmentplatform.model.project;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long>
{
	Collection<Project> findByProjectName(String projectName);
}
