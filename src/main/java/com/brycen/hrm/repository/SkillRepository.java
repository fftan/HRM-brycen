package com.brycen.hrm.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.brycen.hrm.model.Skill;

@Repository
public interface SkillRepository extends PagingAndSortingRepository<Skill, Integer>{

}
