package com.brycen.hrm.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.brycen.hrm.model.Status;

public interface StatusService {
	Page<Status> findAllStatus(Pageable pageable);
	
	Optional<Status> findStatusById(int id);
	
	void save(Status status);
	
	void remove(Status status);
}
