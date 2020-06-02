package com.brycen.hrm.service;

import java.util.List;
import java.util.Optional;

import com.brycen.hrm.model.Cms;

public interface CmsService {
	List<Cms> findAllCms();
	
	Optional<Cms> findCmsById(int id);
	
	void save(Cms cms);
	
	void remove(Cms cms);
}
