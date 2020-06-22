package com.brycen.hrm.implService.empTask;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.brycen.hrm.model.empTask.Task;
import com.brycen.hrm.repository.empTask.TaskRepository;
import com.brycen.hrm.service.empTask.TaskService;

@Service
public class TaskImplService implements TaskService {
	private TaskRepository taskRep;

	@Autowired
	public TaskImplService(TaskRepository taskRep) {
		this.taskRep = taskRep;
	}

	@Override
	public Page<Task> findAllTasks(Pageable pageable, int id) {
		if(id != 0) {
			return taskRep.findByTypeId(pageable, id);
		}
		return taskRep.findAll(pageable);
	}

	@Override
	public Optional<Task> findById(int id) {
		return taskRep.findById(id);
	}

	@Override
	public void save(Task task) {
		taskRep.save(task);
	}

	@Override
	public void remove(Task task) {
		taskRep.delete(task);
	}

//	Dashboard
	@Override
	public List<Task> findAllTasks() {
		return (List<Task>) taskRep.findAll();
	}
}
