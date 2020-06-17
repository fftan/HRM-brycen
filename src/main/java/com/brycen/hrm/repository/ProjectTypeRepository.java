package com.brycen.hrm.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.brycen.hrm.model.ProjectType;

@Repository
public interface ProjectTypeRepository extends PagingAndSortingRepository<ProjectType, Integer>{

}
