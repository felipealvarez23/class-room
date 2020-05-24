package com.ez.classroom.delegates.impl;

import com.ez.classroom.delegates.NextClassDelegate;
import com.ez.classroom.model.ClassRoom;
import com.ez.classroom.model.Scheduling;
import com.ez.classroom.services.NotificacionService;
import com.ez.classroom.services.SchedulingService;
import io.vavr.control.Either;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class NextClassDelegateImpl implements NextClassDelegate {

	private SchedulingService schedulingService;
	private NotificacionService notificacionService;

	@Autowired
	public NextClassDelegateImpl(SchedulingService schedulingService,
		NotificacionService notificacionService) {
		this.schedulingService = schedulingService;
		this.notificacionService = notificacionService;
	}

	@Override
	public void checkNextClass() {
		LocalDateTime currentDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

		Either<Error, List<Scheduling>> schedulingList = schedulingService
			.getSchedulingList(currentDateTime.getDayOfWeek());

		if (schedulingList.isRight()) {
			schedulingList.get()
				.stream()
				.filter(scheduling -> {
						LocalDateTime programedHour = LocalDateTime
							.parse(scheduling.getHour(), formatter);
						return programedHour.getHour() == currentDateTime.plusHours(1).getHour();
					}
				)
				.findFirst()
				.ifPresent(scheduling -> notifyNextClass(scheduling.getClassRoom()));
		}
	}

	@Override
	public void notifyNextClass(ClassRoom classRoom) {
		notificacionService.whatsAppNotification(buildMessage(classRoom));
	}

	private String buildMessage(ClassRoom classRoom) {
		return String.format("Preparate para la siguiente clase de %s este es el link %s %s"
			, classRoom.getDescription(),
			classRoom.getUrl(),
			(classRoom.getPassword()!=null) ? "\nPassword: " + classRoom.getPassword():""
			);
	}

}
