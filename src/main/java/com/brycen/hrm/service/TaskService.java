package com.brycen.hrm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.brycen.hrm.model.Task;

public interface TaskService {
	Page<Task> findAllTasks(Pageable pageable);
	
	List<Task> findAllTasks();
	
	Optional<Task> findById(int id);
	
	void save(Task task);
	
	void remove(Task task);
}
