package com.brycen.hrm.repository.empTask;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brycen.hrm.model.empTask.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer>{
	Page<Task> findByTypeId(Pageable pageable, int id);
}
