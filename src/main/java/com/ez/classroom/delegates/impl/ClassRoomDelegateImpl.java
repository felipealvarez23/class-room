package com.ez.classroom.delegates.impl;

import com.ez.classroom.delegates.ClassRoomDelegate;
import com.ez.classroom.model.ClassRoom;
import com.ez.classroom.services.ClassRoomService;
import io.vavr.control.Either;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassRoomDelegateImpl implements ClassRoomDelegate {

	private ClassRoomService classRoomService;

	@Override
	public Either<Error, List<ClassRoom>> getClassRooms() {
		return classRoomService.getClassRooms();
	}

	@Autowired
	public ClassRoomDelegateImpl(ClassRoomService classRoomService) {
		this.classRoomService = classRoomService;
	}

	@Override
	public Either<Error, ClassRoom> saveClassRoom(ClassRoom classRoom) {
		return classRoomService.saveClassRoom(classRoom);
	}
}
