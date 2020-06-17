package com.brycen.hrm.repository.cms;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brycen.hrm.model.cms.Cms;

@Repository
public interface CmsRepository extends JpaRepository<Cms, Integer>{
	
}
