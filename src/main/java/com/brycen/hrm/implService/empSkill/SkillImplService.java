package com.brycen.hrm.implService.empSkill;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.brycen.hrm.model.empSkill.Skill;
import com.brycen.hrm.repository.empSkill.SkillRepository;
import com.brycen.hrm.service.empSkill.SkillService;

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

	@Override
	public List<Skill> findAllSkill() {
		return (List<Skill>) skillRep.findAll();
	}

}
