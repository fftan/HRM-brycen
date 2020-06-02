package com.brycen.hrm.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brycen.hrm.model.Cms;

@Repository
public interface CmsRepository extends JpaRepository<Cms, Integer>{
	
}
