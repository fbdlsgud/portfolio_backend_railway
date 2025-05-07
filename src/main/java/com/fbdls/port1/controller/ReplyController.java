package com.fbdls.port1.controller;

import com.fbdls.port1.entity.Reply;
import com.fbdls.port1.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReplyController {


    @Autowired
    ReplyService replyService;

    @GetMapping("/replyList")
    public List<Reply> replyList() {
        return replyService.getAllReply();
    }

    @PostMapping("/addReply")
    public ResponseEntity<String> addReply(@RequestBody Reply reply) {
        Reply r = replyService.saveReply(reply);

        return ResponseEntity.ok(r.getUserId());
    }

    @GetMapping("/replyLatest")
    public List<Reply> replyLatest() {
        return replyService.findTop3ByOrderByRidDesc();
    }

}
