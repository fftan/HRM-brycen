package com.brycen.hrm.service.implService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.brycen.hrm.model.ProjectType;
import com.brycen.hrm.repository.ProjectTypeRepository;
import com.brycen.hrm.service.ProjectTypeService;

@Service
public class ProjectTypeImplService implements ProjectTypeService{
	private ProjectTypeRepository projectRep;

	@Autowired
	public ProjectTypeImplService(ProjectTypeRepository projectRep) {
		super();
		this.projectRep = projectRep;
	}

	@Override
	public List<ProjectType> findAll() {
		return (List<ProjectType>) projectRep.findAll();
	}

	@Override
	public void save(ProjectType projectType) {
		projectRep.save(projectType);
	}

	@Override
	public Page<ProjectType> pageAll(Pageable pageable) {
		return projectRep.findAll(pageable);
	}
}
