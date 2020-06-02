package com.brycen.hrm.service.implService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brycen.hrm.model.Task;
import com.brycen.hrm.repository.TaskRepository;
import com.brycen.hrm.service.TaskService;

@Service
public class TaskImplService implements TaskService{
	private TaskRepository taskRep;

	@Autowired
	public TaskImplService(TaskRepository taskRep) {
		this.taskRep = taskRep;
	}

	@Override
	public List<Task> findAllTasks() {
		return (List<Task>) taskRep.findAll();
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

}
