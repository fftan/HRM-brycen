package com.brycen.hrm.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.brycen.hrm.model.Level;

@Repository
public interface LevelRepository extends PagingAndSortingRepository<Level, Integer>{

}
