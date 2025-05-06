package com.fbdls.port1.service;

import com.fbdls.port1.entity.Reply;
import com.fbdls.port1.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyService {

    @Autowired
    private ReplyRepository replyRepository;

    public List<Reply> getAllReply() {
        return replyRepository.findAll();
    }


    public Reply saveReply(Reply reply) {
        return replyRepository.save(reply);
    }
}
