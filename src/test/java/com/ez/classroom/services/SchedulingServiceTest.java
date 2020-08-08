package com.ez.classroom.services;

import static org.mockito.ArgumentMatchers.any;
import static  org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.ez.classroom.model.Scheduling;
import com.ez.classroom.repositories.SchedulingRepository;
import com.ez.classroom.services.impl.SchedulingServiceImpl;
import com.ez.classroom.utils.TestUtils;
import com.twilio.rest.bulkexports.v1.export.Day;
import io.vavr.control.Either;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.DayOfWeek;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class SchedulingServiceTest {

    @Mock
    private SchedulingRepository schedulingRepository;

    @InjectMocks
    private SchedulingServiceImpl schedulingService;

    @Test
    public void given_getSchedulingListIsCalled_and_dayOfWeekIsValid_then_shouldRight(){
        when(schedulingRepository.getAllByDayOfWeek(any(DayOfWeek.class)))
                .thenReturn(TestUtils.buildSchedulingListMock());
        Either<Error, List<Scheduling>> result = schedulingService.getSchedulingList(DayOfWeek.MONDAY);
        assertTrue(result.isRight());
    }

    @Test
    public void given_getSchedulingListIsCalled_and_generateError_then_shouldLeft(){
        when(schedulingRepository.getAllByDayOfWeek(any(DayOfWeek.class)))
                .thenThrow(new Error());
        Either<Error, List<Scheduling>> result = schedulingService.getSchedulingList(DayOfWeek.MONDAY);
        assertTrue(result.isLeft());
    }

}
