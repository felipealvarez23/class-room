
package com.ez.classroom.services.impl;


import com.ez.classroom.exceptions.SchedulingException;
import com.ez.classroom.model.Scheduling;
import com.ez.classroom.repositories.SchedulingRepository;
import com.ez.classroom.services.SchedulingService;
import io.vavr.control.Either;
import io.vavr.control.Try;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.util.List;

@Slf4j
@Service
public class SchedulingServiceImpl implements SchedulingService {

	private SchedulingRepository schedulingRepository;

	@Autowired
	public SchedulingServiceImpl(
		SchedulingRepository schedulingRepository) {
		this.schedulingRepository = schedulingRepository;
	}

	@Override
	public List<Scheduling> getSchedulingList(DayOfWeek dayOfWeek) {
		try{
			log.info("Start query to current scheduling, [{}] day", dayOfWeek.getValue());
			return schedulingRepository.getAllByDayOfWeek(dayOfWeek);
		} catch (Exception e){
			throw new SchedulingException(
					String.format("Error querying the scheduling list to [%s] day", dayOfWeek.getValue()));
		}

	}
}
