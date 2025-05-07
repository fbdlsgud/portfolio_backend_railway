package com.fbdls.port1.controller;


import com.fbdls.port1.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

@Repository
public class VisitController {

    @Autowired
    private VisitService visitService;


    @GetMapping("/visit")
    public Map<String, Integer> visit() {

        visitService.increaseVisit();

        int today = visitService.getTodayVisitCount();
        int total = visitService.getTotalCount();

        Map<String, Integer> result = new HashMap<>();
        result.put("today", today);
        result.put("total", total);

        return  result;

    }


}
