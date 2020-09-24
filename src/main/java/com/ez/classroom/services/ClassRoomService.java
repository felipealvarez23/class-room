package com.ez.classroom.services;

import com.ez.classroom.model.ClassRoom;
import io.vavr.control.Either;
import java.util.List;

public interface ClassRoomService {

	ClassRoom saveClassRoom(ClassRoom classRoom);

	ClassRoom getClassRoom(Long id);

	List<ClassRoom> getClassRooms();

	ClassRoom updateClassRoom(ClassRoom classRoom);

	void deleteClassRoom(Long id);

}
