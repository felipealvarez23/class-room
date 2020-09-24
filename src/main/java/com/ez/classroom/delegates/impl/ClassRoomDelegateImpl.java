package com.ez.classroom.delegates.impl;

import com.ez.classroom.delegates.ClassRoomDelegate;
import com.ez.classroom.model.ClassRoom;
import com.ez.classroom.model.Response;
import com.ez.classroom.services.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassRoomDelegateImpl implements ClassRoomDelegate {

	private ClassRoomService classRoomService;

	@Autowired
	public ClassRoomDelegateImpl(ClassRoomService classRoomService) {
		this.classRoomService = classRoomService;
	}

    @Override
    public Response getClassRooms() {
        return Response.builder()
                .data(classRoomService.getClassRooms())
                .build();
    }

	@Override
	public Response getClassRoom(Long id) {
			return Response.builder()
					.data(classRoomService.getClassRoom(id))
					.build();
	}
	@Override
	public Response saveClassRoom(ClassRoom classRoom) {
			return Response.builder()
					.data(classRoomService.saveClassRoom(classRoom))
					.build();
	}

    @Override
    public Response deleteClassRoom(Long id) {
        classRoomService.deleteClassRoom(id);
        return Response.builder()
                .data("Success removing class room with id " + id)
                .build();
    }

}
