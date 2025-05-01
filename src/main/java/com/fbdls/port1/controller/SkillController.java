package com.fbdls.port1.controller;

import com.fbdls.port1.entity.Skill;
import com.fbdls.port1.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SkillController {

    @Autowired
    private SkillService skillService;

    @GetMapping("/skillsList")
    public List<Skill> getAllSkills() {
        return skillService.getAllSkill();
    }

    @PostMapping("/addSkill")
    public ResponseEntity<String> addSkill(@RequestBody Skill skillName) {
        Skill s = skillService.saveSkill(skillName);

        return ResponseEntity.status(HttpStatus.CREATED).body("스킬 등록 완료 : "  + s.getSkillName());

    }

}
