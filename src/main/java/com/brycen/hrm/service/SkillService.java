package com.brycen.hrm.service;

import java.util.List;
import java.util.Optional;

import com.brycen.hrm.model.Skill;

public interface SkillService {
	List<Skill> findAllSkill();
	
	Optional<Skill> findSkillbyId(int id);
	
	void save(Skill skill);
	
	void remove(Skill skill);
}
