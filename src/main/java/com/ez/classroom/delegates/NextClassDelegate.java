package com.ez.classroom.delegates;

import com.ez.classroom.model.ClassRoom;

public interface NextClassDelegate {

	void checkNextClass();

	void notifyNextClass(ClassRoom classRoom);

}
