package com.ez.classroom.repositories;

import com.ez.classroom.model.Scheduling;
import java.time.DayOfWeek;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchedulingRepository extends JpaRepository<Scheduling,Long> {
	List<Scheduling> getAllByDayOfWeek(DayOfWeek dayOfWeek);
}
