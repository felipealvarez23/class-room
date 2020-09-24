package com.ez.classroom.delegates.impl;

import com.ez.classroom.model.Response;
import com.ez.classroom.services.SchedulingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;

@Service
public class SchedulingDelegate {

    private SchedulingService schedulingService;

    @Autowired
    public SchedulingDelegate(SchedulingService schedulingService) {
        this.schedulingService = schedulingService;
    }

    public Response getSchedulingByDayOfWeek(DayOfWeek dayOfWeek){
        return Response.builder()
                .data(schedulingService.getSchedulingList(dayOfWeek))
                .build();
    }

}
