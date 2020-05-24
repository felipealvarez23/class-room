package com.ez.classroom.services;

import com.ez.classroom.model.ClassRoom;
import io.vavr.control.Either;
import java.util.List;

public interface ClassRoomService {

	Either<Error,ClassRoom> saveClassRoom(ClassRoom classRoom);

	ClassRoom getClassRoom(Long id);

	Either<Error,List<ClassRoom>> getClassRooms();

	ClassRoom updateClassRoom(ClassRoom classRoom);

	ClassRoom deleteClassRoom(Long id);

}
