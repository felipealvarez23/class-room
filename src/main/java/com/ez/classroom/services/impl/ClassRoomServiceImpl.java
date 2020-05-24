
package com.ez.classroom.services.impl;


import com.ez.classroom.model.ClassRoom;
import com.ez.classroom.repositories.ClassRoomRepository;
import com.ez.classroom.services.ClassRoomService;
import io.vavr.control.Either;
import io.vavr.control.Try;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ClassRoomServiceImpl implements ClassRoomService {

	private ClassRoomRepository classRoomRepository;

	@Autowired
	public ClassRoomServiceImpl(ClassRoomRepository classRoomRepository) {
		this.classRoomRepository = classRoomRepository;
	}

	@Override
	public Either<Error,ClassRoom> saveClassRoom(ClassRoom classRoom) {
		return Try.of(()-> classRoomRepository.save(classRoom))
			.onFailure(throwable -> log.error("Error al intentar guardar la clase {}", classRoom.getDescription()))
			.toEither(new Error());
	}

	@Override
	public ClassRoom getClassRoom(Long id) {
		return null;
	}

	@Override
	public Either<Error,List<ClassRoom>> getClassRooms() {
		Either<Error,List<ClassRoom>> either = Try.of(()-> classRoomRepository.findAll())
			.onFailure(throwable -> log.error("Error al consultar las clases",throwable))
			.toEither(new Error());

		return either;
	}


	@Override
	public ClassRoom updateClassRoom(ClassRoom classRoom) {
		return null;
	}

	@Override
	public ClassRoom deleteClassRoom(Long id) {
		return null;
	}
}
