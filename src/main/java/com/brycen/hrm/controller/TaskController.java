package com.brycen.hrm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.brycen.hrm.model.Task;
import com.brycen.hrm.service.TaskService;

@RestController
public class TaskController {
	private TaskService taskService;

	@Autowired
	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}
	
	@GetMapping(value = "/tasks")
	public ResponseEntity<List<Task>> findAllTasks(){
		List<Task> tasks = taskService.findAllTasks();
		if(tasks.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(tasks, HttpStatus.OK);
	}
	
	@GetMapping(value = "/tasks/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Task> findTaskById(@PathVariable("id") int id){
		Optional<Task> task = taskService.findById(id);
		if(!task.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(task.get(), HttpStatus.OK);
	}
	
	@PostMapping(value = "/tasks/create")
	public ResponseEntity<Task> createTask(@RequestBody Task task, UriComponentsBuilder builder){
		taskService.save(task);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/tasks/{id}").buildAndExpand(task.getId()).toUri());
		return new ResponseEntity<>(task, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/tasks/{id}")
	public ResponseEntity<Task> updateTask(@PathVariable("id") int id, @RequestBody Task task){
		Optional<Task> currentTask = taskService.findById(id);
		if(!currentTask.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		currentTask.get().setName(task.getName());
		currentTask.get().setInside_project(task.isInside_project());
		taskService.save(currentTask.get());
		return new ResponseEntity<>(currentTask.get(), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/tasks/{id}")
	public ResponseEntity<Task> deleteTask(@PathVariable("id") int id){
		Optional<Task> task = taskService.findById(id);
		if(!task.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		taskService.remove(task.get());
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
