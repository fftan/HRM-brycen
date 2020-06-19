package com.brycen.hrm.controller.empTask;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brycen.hrm.model.empTask.ProjectType;
import com.brycen.hrm.model.response.ProjectTypeResponse;
import com.brycen.hrm.service.empTask.ProjectTypeService;

@CrossOrigin
@RestController
public class ProjectTypeController {
	private ProjectTypeService projectService;
	
	@Autowired
	public ProjectTypeController(ProjectTypeService projectService) {
		super();
		this.projectService = projectService;
	}

	@GetMapping("/project-types/list")
	public ResponseEntity<List<ProjectType>> findAll() {
		List<ProjectType> types = projectService.findAll();
		if (types.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(types, HttpStatus.OK);
	}
	
	@GetMapping("/project-types")
	public Page<ProjectTypeResponse> getPage(@RequestParam(name = "page", defaultValue = "1") int page,
			@RequestParam(name = "size", defaultValue = "5") int size) {
		PageRequest pageRequest = PageRequest.of(page -1, size);
		Page<ProjectType> pageResult = projectService.pageAll(pageRequest);

		List<ProjectTypeResponse> types = pageResult.stream().map(ProjectTypeResponse::new).collect(Collectors.toList());
		return new PageImpl<>(types, pageRequest, pageResult.getTotalElements());
	}
	
	@PostMapping("/project-types/create")
	public ResponseEntity<ProjectType> create(@RequestBody ProjectType projectType) {
		projectService.save(projectType);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
