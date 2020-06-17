package com.brycen.hrm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.brycen.hrm.model.Skill;

public interface SkillService {
	Page<Skill> findAllSkill(Pageable pageable);
	
	List<Skill> findAllSkill();
	
	Optional<Skill> findSkillbyId(int id);
	
	void save(Skill skill);
	
	void remove(Skill skill);
}
