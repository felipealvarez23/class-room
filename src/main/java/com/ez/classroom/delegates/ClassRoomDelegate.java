
package com.ez.classroom.delegates;


import com.ez.classroom.model.ClassRoom;
import io.vavr.control.Either;
import java.util.List;

public interface ClassRoomDelegate {

	Either<Error, ClassRoom> saveClassRoom(ClassRoom classRoom);

	Either<Error, List<ClassRoom>> getClassRooms();

}
