package com.brycen.hrm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.brycen.hrm.model.Skill;
import com.brycen.hrm.service.SkillService;

@CrossOrigin
@RestController
public class SkillController {
	private SkillService skillService;

	@Autowired
	public SkillController(SkillService skillService) {
		this.skillService = skillService;
	}

	@GetMapping(value = "/skills")
	public ResponseEntity<List<Skill>> findAllSkills() {
		List<Skill> skills = skillService.findAllSkill();
		if (skills.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(skills, HttpStatus.OK);
	}

	@GetMapping(value = "/skills/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Skill> findSkillById(@PathVariable("id") int id) {
		Optional<Skill> skill = skillService.findSkillbyId(id);
		if (!skill.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(skill.get(), HttpStatus.OK);
	}

	@PostMapping(value = "/skills/create")
	public ResponseEntity<Skill> createSkill(@RequestBody Skill skill, UriComponentsBuilder builder) {
		skillService.save(skill);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/skills/{id}").buildAndExpand(skill.getId()).toUri());
		return new ResponseEntity<>(skill, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/skills/{id}")
	public ResponseEntity<Skill> updateSkill(@PathVariable("id") int id, @RequestBody Skill skill){
		Optional<Skill> currentSkill = skillService.findSkillbyId(id);
		if(!currentSkill.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		currentSkill.get().setName(skill.getName());
		skillService.save(currentSkill.get());
		return new ResponseEntity<Skill>(currentSkill.get(), HttpStatus.OK);
	}
}
