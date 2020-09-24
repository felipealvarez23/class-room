package com.ez.classroom.services;

import com.ez.classroom.model.Scheduling;
import io.vavr.control.Either;
import java.time.DayOfWeek;
import java.util.List;

public interface SchedulingService {

	List<Scheduling> getSchedulingList(DayOfWeek dayOfWeek);
}
