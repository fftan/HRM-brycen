package com.brycen.hrm.service.empTask;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.brycen.hrm.model.empTask.Task;
import com.brycen.hrm.model.request.TaskRequest;

public interface TaskService {
	Page<Task> findAllTasks(Pageable pageable, int id);
	
	List<Task> findAllTasks();
	
	Page<Task> findAllByTypeId(int id, Pageable pageable);
	
	Optional<Task> findById(int id);
	
	void save(Task task);
	
	void remove(Task task);
}
