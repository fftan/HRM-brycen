package com.brycen.hrm.repository.empSkill;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.brycen.hrm.model.empSkill.Skill;

@Repository
public interface SkillRepository extends PagingAndSortingRepository<Skill, Integer>{

}
