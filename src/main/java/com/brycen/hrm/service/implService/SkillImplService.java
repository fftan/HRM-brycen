package com.brycen.hrm.service.implService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.brycen.hrm.model.Skill;
import com.brycen.hrm.repository.SkillRepository;
import com.brycen.hrm.service.SkillService;

@Service
public class SkillImplService implements SkillService {
	private SkillRepository skillRep;

	@Autowired
	public SkillImplService(SkillRepository skillRep) {
		this.skillRep = skillRep;
	}

	@Override
	public Page<Skill> findAllSkill(Pageable pageable) {
		return skillRep.findAll(pageable);
	}

	@Override
	public Optional<Skill> findSkillbyId(int id) {
		Optional<Skill> skill = skillRep.findById(id);
		return skill;
	}

	@Override
	public void save(Skill skill) {
		skillRep.save(skill);
	}

	@Override
	public void remove(Skill skill) {
		skillRep.delete(skill);
	}

}
