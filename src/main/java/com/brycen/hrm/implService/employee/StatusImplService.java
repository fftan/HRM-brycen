package com.brycen.hrm.implService.employee;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.brycen.hrm.model.employee.Status;
import com.brycen.hrm.repository.employee.StatusRepository;
import com.brycen.hrm.service.employee.StatusService;

@Service
public class StatusImplService implements StatusService{
	private StatusRepository statusRep;

	@Autowired
	public StatusImplService(StatusRepository statusRep) {
		this.statusRep = statusRep;
	}

	@Override
	public Page<Status> findAllStatus(Pageable pageable) {
		return statusRep.findAll(pageable);
	}

	@Override
	public Optional<Status> findStatusById(int id) {
		Optional<Status> status = statusRep.findById(id);
		return status;
	}

	@Override
	public void save(Status status) {
		statusRep.save(status);
	}

	@Override
	public void remove(Status status) {
		statusRep.delete(status);
	}

	@Override
	public List<Status> listAll() {
		return (List<Status>) statusRep.findAll();
	}
}
