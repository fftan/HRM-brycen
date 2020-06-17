package com.brycen.hrm.service.employee;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.brycen.hrm.model.employee.Status;

public interface StatusService {
	Page<Status> findAllStatus(Pageable pageable);
	
	List<Status> listAll();
	
	Optional<Status> findStatusById(int id);
	
	void save(Status status);
	
	void remove(Status status);
}
