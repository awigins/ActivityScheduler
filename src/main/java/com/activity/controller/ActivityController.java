package com.activity.controller;

import com.activity.common.result.Result;
import com.activity.service.activity.ActivityService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/activity")
public class ActivityController {

    @Resource
    private ActivityService activityService;

    @PostMapping
    public Result hall() {
        activityService.showAll();
        return null;
    }
}
