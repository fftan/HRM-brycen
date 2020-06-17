package com.brycen.hrm.service.employee;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.brycen.hrm.model.employee.Level;

public interface LevelService {
	List<Level> findAllLevel();
	
	Page<Level> pageAll(Pageable pageable);
	
	void save(Level level);
}
