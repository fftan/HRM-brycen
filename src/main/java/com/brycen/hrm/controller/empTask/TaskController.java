package com.brycen.hrm.controller.empTask;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.brycen.hrm.model.empTask.Task;
import com.brycen.hrm.model.response.TaskResponse;
import com.brycen.hrm.service.empTask.TaskService;

@CrossOrigin
@RestController
public class TaskController {
	private TaskService taskService;

	@Autowired
	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}

	@GetMapping(value = "/tasks")
	public Page<TaskResponse> findAllTasks(@RequestParam(name = "page", defaultValue = "1") int page,
			@RequestParam(name = "size", defaultValue = "5") int size, @RequestParam(name = "type_id")  int id) {
		PageRequest pageRequest = PageRequest.of(page - 1, size);
		Page<Task> pageResult = taskService.findAllTasks(pageRequest, id);
		List<TaskResponse> tasks = pageResult.stream().map(TaskResponse::new).collect(Collectors.toList());
		return new PageImpl<>(tasks, pageRequest, pageResult.getTotalElements());
	}

	@GetMapping(value = "/tasks/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Task> findTaskById(@PathVariable("id") int id) {
		Optional<Task> task = taskService.findById(id);
		if (!task.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(task.get(), HttpStatus.OK);
	}

//	@GetMapping(value = "/tasks/search/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//	public Page<TaskResponse> findAllTasks(@PathVariable("id") int id, 
//			@RequestParam(name = "page", defaultValue = "1") int page, @RequestParam(name = "size", defaultValue = "5") int size){
//		PageRequest pageRequest = PageRequest.of(page - 1, size);
//		Page<Task> pageResult = taskService.findAllByTypeId(id, pageRequest);
//		List<TaskResponse> tasks = pageResult.stream().map(TaskResponse::new).collect(Collectors.toList());
//		return new PageImpl<>(tasks, pageRequest, pageResult.getTotalElements());
//	}

	@PostMapping(value = "/tasks/create")
	public ResponseEntity<Task> createTask(@RequestBody Task task, UriComponentsBuilder builder) {
		taskService.save(task);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/tasks/{id}").buildAndExpand(task.getId()).toUri());
		return new ResponseEntity<>(task, HttpStatus.CREATED);
	}

	@PutMapping(value = "/tasks/{id}")
	public ResponseEntity<Task> updateTask(@PathVariable("id") int id, @RequestBody Task task) {
		Optional<Task> currentTask = taskService.findById(id);
		if (!currentTask.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		currentTask.get().setName(task.getName());
		currentTask.get().setType(task.getType());
		taskService.save(currentTask.get());
		return new ResponseEntity<>(currentTask.get(), HttpStatus.OK);
	}

	@DeleteMapping(value = "/tasks/{id}")
	public ResponseEntity<Task> deleteTask(@PathVariable("id") int id) {
		Optional<Task> task = taskService.findById(id);
		if (!task.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		taskService.remove(task.get());
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
