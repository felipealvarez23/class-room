package com.ez.classroom.exceptions;

import lombok.Data;

import java.io.Serializable;

@Data
public class ClassRoomException extends RuntimeException implements Serializable {

    private String prettyMessage;

    public ClassRoomException(String prettyMessage) {
        super();
        this.prettyMessage = prettyMessage;
    }

    public ClassRoomException(String prettyMessage, Throwable cause) {
        super(cause);
        this.prettyMessage = prettyMessage;
    }
}
