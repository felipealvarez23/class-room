
package com.ez.classroom.delegates;


import com.ez.classroom.model.ClassRoom;
import com.ez.classroom.model.Response;
import io.vavr.control.Either;

import javax.transaction.Transactional;
import java.util.List;

public interface ClassRoomDelegate {

	Response saveClassRoom(ClassRoom classRoom);

	Response getClassRooms();

	Response getClassRoom(Long id);

	Response deleteClassRoom(Long id);

}
