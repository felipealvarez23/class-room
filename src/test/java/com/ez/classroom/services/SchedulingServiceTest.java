package com.ez.classroom.services;

import com.ez.classroom.model.Scheduling;
import com.ez.classroom.repositories.SchedulingRepository;
import com.ez.classroom.services.impl.SchedulingServiceImpl;
import com.ez.classroom.utils.TestUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.DayOfWeek;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

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
        List<Scheduling> result = schedulingService.getSchedulingList(DayOfWeek.MONDAY);
        assertFalse(result.isEmpty());
    }

}
