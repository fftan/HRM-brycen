package com.brycen.hrm.service;

import java.util.List;
import java.util.Optional;

import com.brycen.hrm.model.Task;

public interface TaskService {
	List<Task> findAllTasks();
	
	Optional<Task> findById(int id);
	
	void save(Task task);
	
	void remove(Task task);
}
