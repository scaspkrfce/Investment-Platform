package org.investmentplatform.model.project;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectXCategoryRepository extends JpaRepository<ProjectXCategory, Long>
{
	List<ProjectXCategory> findByCategoryId(Category categoryId);
}
