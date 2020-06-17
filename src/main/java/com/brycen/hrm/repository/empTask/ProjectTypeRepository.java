package com.brycen.hrm.repository.empTask;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.brycen.hrm.model.empTask.ProjectType;

@Repository
public interface ProjectTypeRepository extends PagingAndSortingRepository<ProjectType, Integer>{

}
