package com.brycen.hrm.service;

import java.util.List;
import java.util.Optional;

import com.brycen.hrm.model.Status;

public interface StatusService {
	List<Status> findAllStatus();
	
	Optional<Status> findStatusById(int id);
	
	void save(Status status);
	
	void remove(Status status);
}
