package com.brycen.hrm.service.empTask;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.brycen.hrm.model.empTask.ProjectType;

public interface ProjectTypeService {
	List<ProjectType> findAll();
	
	Page<ProjectType> pageAll(Pageable pageable);
	
	void save(ProjectType projectType);
}
