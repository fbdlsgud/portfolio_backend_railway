package com.fbdls.port1.controller;

import com.fbdls.port1.entity.Skill;
import com.fbdls.port1.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SkillController {

    @Autowired
    private SkillService skillService;

    @GetMapping("/skillsList")
    public ResponseEntity<List<Skill>> getSkills() {
        System.out.println("🧠 /skillsList 호출됨!");
        return ResponseEntity.ok(skillService.findAll());
    }

    @PostMapping("/addSkill")
    public ResponseEntity<String> addSkill(@RequestBody Skill skill) {
        Skill s = skillService.saveSkill(skill);

        return ResponseEntity.status(HttpStatus.CREATED).body("스킬 등록 완료 : "  + s.getSkillName());

    }

    @PutMapping("/skillEdit")
    public ResponseEntity<String> editSkill(@RequestBody Skill skill) {
        Skill s = skillService.saveSkill(skill);

        return ResponseEntity.ok("스킬 수정 완료 : " + s.getSkillName());
    }

}
