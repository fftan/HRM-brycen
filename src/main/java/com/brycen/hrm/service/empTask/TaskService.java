package com.brycen.hrm.service.empTask;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.brycen.hrm.model.empTask.Task;

public interface TaskService {
	Page<Task> findAllTasks(Pageable pageable, int id);
	
	List<Task> findAllTasks();
	
	Optional<Task> findById(int id);
	
	void save(Task task);
	
	void remove(Task task);
}
