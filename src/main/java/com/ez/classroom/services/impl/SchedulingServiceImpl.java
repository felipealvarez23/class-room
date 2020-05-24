
package com.ez.classroom.services.impl;


import com.ez.classroom.model.ClassRoom;
import com.ez.classroom.model.Scheduling;
import com.ez.classroom.repositories.SchedulingRepository;
import com.ez.classroom.services.SchedulingService;
import io.vavr.control.Either;
import io.vavr.control.Try;
import java.time.DayOfWeek;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Either<Error, List<Scheduling>> getSchedulingList(DayOfWeek dayOfWeek) {

		Either<Error,List<Scheduling>> either = Try.of(()->schedulingRepository.getAllByDayOfWeek(dayOfWeek))
			.onFailure(throwable -> log.error("Error recuperando scheduling",throwable))
			.toEither(new Error());

		return either;
	}
}
