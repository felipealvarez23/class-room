package com.ez.classroom.controllers;

import com.ez.classroom.delegates.impl.SchedulingDelegate;
import com.ez.classroom.services.SchedulingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.DayOfWeek;

@RestController
public class SchedulingController {

    private SchedulingDelegate schedulingDelegate;

    @Autowired
    public SchedulingController(SchedulingDelegate schedulingDelegate) {
        this.schedulingDelegate = schedulingDelegate;
    }

    @GetMapping("/scheduling/{dayOfWeek}")
    public ResponseEntity findSchedulingByDayOfWeek(@PathVariable DayOfWeek dayOfWeek){
        return ResponseEntity.ok(schedulingDelegate.getSchedulingByDayOfWeek(dayOfWeek));
    }

}
