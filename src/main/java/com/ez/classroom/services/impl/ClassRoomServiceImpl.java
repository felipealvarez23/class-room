
package com.ez.classroom.services.impl;


import com.ez.classroom.exceptions.ClassRoomException;
import com.ez.classroom.model.ClassRoom;
import com.ez.classroom.repositories.ClassRoomRepository;
import com.ez.classroom.repositories.SchedulingRepository;
import com.ez.classroom.services.ClassRoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ClassRoomServiceImpl implements ClassRoomService {

    private ClassRoomRepository classRoomRepository;
    private SchedulingRepository schedulingRepository;

    @Autowired
    public ClassRoomServiceImpl(ClassRoomRepository classRoomRepository, SchedulingRepository schedulingRepository) {
        this.classRoomRepository = classRoomRepository;
        this.schedulingRepository = schedulingRepository;
    }

    @Override
    public ClassRoom saveClassRoom(ClassRoom classRoom) {
        return Optional.of(classRoomRepository.save(classRoom))
                .orElseThrow(() -> new ClassRoomException(
                        String.format("Error saving class room register")));
    }

    @Override
    public ClassRoom getClassRoom(Long id) {
        return classRoomRepository.findById(id)
                .orElseThrow(() -> new ClassRoomException(
                        String.format("Error querying class room [%s]", id)));
    }

    @Override
    public List<ClassRoom> getClassRooms() {
        return classRoomRepository.findAll();
    }


    @Override
    public ClassRoom updateClassRoom(ClassRoom classRoom) {
        return null;
    }

    @Override
    public void deleteClassRoom(Long id) {
        try {
			log.info("Starting to delete class room [{}]", id);
            classRoomRepository.deleteById(id);
        } catch (Exception e) {
            throw new ClassRoomException(String
                    .format("Error removing class room register with id [%s]", id));
        }
    }


}
