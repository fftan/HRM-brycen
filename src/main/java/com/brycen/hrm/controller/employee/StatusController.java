package com.brycen.hrm.controller.employee;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.brycen.hrm.model.employee.Status;
import com.brycen.hrm.model.response.StatusResponse;
import com.brycen.hrm.service.employee.StatusService;

@CrossOrigin
@RestController
public class StatusController {
	private StatusService statusService;

	@Autowired
	public StatusController(StatusService statusService) {
		this.statusService = statusService;
	}
	
	@GetMapping(value = "/status")
	public Page<StatusResponse> findAllStatus(@RequestParam(name = "page", defaultValue = "1") int page, @RequestParam(name = "size", defaultValue = "5") int size){
		PageRequest pageRequest = PageRequest.of(page - 1, size);
		Page<Status> pageResult = statusService.findAllStatus(pageRequest);
		List<StatusResponse> status = pageResult.stream().map(StatusResponse::new).collect(Collectors.toList());
		return new PageImpl<>(status, pageRequest, pageResult.getTotalElements());
	}
	
	@GetMapping(value = "/status/list")
	public ResponseEntity<List<Status>> listAll() {
		List<Status> status = statusService.listAll();
		if (status.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(status, HttpStatus.OK);
	}
	
	@GetMapping(value = "/status/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> findStatusById(@PathVariable("id") int id){
		Optional<Status> status = statusService.findStatusById(id);
		if(!status.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(status.get(), HttpStatus.OK);
	}
	
	@PostMapping(value = "/status/create")
	public ResponseEntity<Status> createStatus(@RequestBody Status status, UriComponentsBuilder builder){
		statusService.save(status);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/status/{id}").buildAndExpand(status.getId()).toUri());
		return new ResponseEntity<>(status, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/status/{id}")
	public ResponseEntity<Status> updateStatus(@PathVariable("id") int id, @RequestBody Status status) {
		Optional<Status> currentStatus = statusService.findStatusById(id);
		if(!currentStatus.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		currentStatus.get().setName(status.getName());
		currentStatus.get().setChange_date(status.getChange_date());
		statusService.save(currentStatus.get());
		return new ResponseEntity<Status>(currentStatus.get(), HttpStatus.OK);
	}
}
