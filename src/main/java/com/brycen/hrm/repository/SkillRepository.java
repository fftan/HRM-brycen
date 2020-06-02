package com.brycen.hrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brycen.hrm.model.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer>{

}
