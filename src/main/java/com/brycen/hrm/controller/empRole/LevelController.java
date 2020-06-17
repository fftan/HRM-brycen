package com.brycen.hrm.controller.empRole;

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

import com.brycen.hrm.model.employee.Level;
import com.brycen.hrm.model.response.LevelResponse;
import com.brycen.hrm.service.employee.LevelService;

@CrossOrigin
@RestController
public class LevelController {
	private LevelService levelService;

	@Autowired
	public LevelController(LevelService levelService) {
		super();
		this.levelService = levelService;
	}

	@GetMapping("/levels")
	public ResponseEntity<List<Level>> findAll() {
		List<Level> levels = levelService.findAllLevel();
		if (levels.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(levels, HttpStatus.OK);
	}
	
	@GetMapping("/level")
	public Page<LevelResponse> getPage(@RequestParam(name = "page", defaultValue = "1") int page,
			@RequestParam(name = "size", defaultValue = "5") int size) {
		PageRequest pageRequest = PageRequest.of(page -1, size);
		Page<Level> pageResult = levelService.pageAll(pageRequest);

		List<LevelResponse> levels = pageResult.stream().map(LevelResponse::new).collect(Collectors.toList());
		return new PageImpl<>(levels, pageRequest, pageResult.getTotalElements());
	}
	
	@PostMapping("/levels/create")
	public ResponseEntity<Level> create(@RequestBody Level level) {
		levelService.save(level);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
