package com.fbdls.port1.controller;

import com.fbdls.port1.entity.Reply;
import com.fbdls.port1.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

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


    @PostMapping("deleteReply")
    public ResponseEntity<String> deleteReply(@RequestBody Reply reply) {

        Reply replyPwdChk = replyService.findByRid(reply.getRid());

        if (replyPwdChk == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("댓글이 존재하지 않습니다.");
        }

        if (!replyPwdChk.getUserPwd().equals(reply.getUserPwd())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("비밀번호가 일치하지 않습니다.");
        }

        replyService.deleteReply(reply.getRid());
        return ResponseEntity.ok("삭제 완료!");
    }


}
