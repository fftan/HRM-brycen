package com.brycen.hrm.implService.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.brycen.hrm.model.employee.Level;
import com.brycen.hrm.repository.employee.LevelRepository;
import com.brycen.hrm.service.employee.LevelService;

@Service
public class LevelImplService implements LevelService{
	private LevelRepository levelRep;

	@Autowired
	public LevelImplService(LevelRepository levelRep) {
		super();
		this.levelRep = levelRep;
	}

	@Override
	public List<Level> findAllLevel() {
		return (List<Level>) levelRep.findAll();
	}

	@Override
	public void save(Level level) {
		levelRep.save(level);
	}

	@Override
	public Page<Level> pageAll(Pageable pageable) {
		return levelRep.findAll(pageable);
	}
	
}
