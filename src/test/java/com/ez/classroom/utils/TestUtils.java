package com.ez.classroom.utils;

import com.ez.classroom.model.ClassRoom;
import com.ez.classroom.model.Scheduling;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class TestUtils {

    public static List<Scheduling> buildSchedulingListMock(){
        ClassRoom classRoom = new ClassRoom();
        return new ArrayList<Scheduling>(){{
            add(new Scheduling(1L, DayOfWeek.MONDAY,"9:00",classRoom));
        }};
    }

}
