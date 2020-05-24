
package com.ez.classroom.controllers;

import com.ez.classroom.delegates.ClassRoomDelegate;
import com.ez.classroom.model.ClassRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ClassRoomController {

	private ClassRoomDelegate classRoomDelegate;

	@Autowired
	public ClassRoomController(ClassRoomDelegate classRoomDelegate) {
		this.classRoomDelegate = classRoomDelegate;
	}

	@PostMapping("/class-room")
	public ResponseEntity saveClassRoom(@RequestBody ClassRoom classRoom){
		return ResponseEntity.ok(classRoomDelegate.saveClassRoom(classRoom).get());
	}

	@GetMapping("/class-room")
	public ResponseEntity getClassRooms(){
		return ResponseEntity.ok(classRoomDelegate.getClassRooms().get());
	}
}
