
package com.ez.classroom.controllers;

import com.ez.classroom.delegates.ClassRoomDelegate;
import com.ez.classroom.model.ClassRoom;
import io.vavr.control.Either;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
		return ResponseEntity.ok(classRoomDelegate.saveClassRoom(classRoom));
	}

	@GetMapping("/class-room")
	public ResponseEntity getClassRooms(){
		return ResponseEntity.ok(classRoomDelegate.getClassRooms());
	}

	@GetMapping("/class-room/{id}")
	public ResponseEntity getClassRoom(@PathVariable("id") Long id) {
		return ResponseEntity.ok(classRoomDelegate.getClassRoom(id));
	}

	@DeleteMapping("/class-room/{id}")
	public ResponseEntity deleteClassRoom(@PathVariable(value = "id") Long id){
		return ResponseEntity.ok(classRoomDelegate.deleteClassRoom(id));
	}
}
