package com.ez.classroom.exceptions;

import lombok.Data;

import java.io.Serializable;

@Data
public class SchedulingException extends RuntimeException implements Serializable {

    private String prettyMessage;

    public SchedulingException(String prettyMessage) {
        super();
        this.prettyMessage = prettyMessage;
    }

    public SchedulingException(Throwable cause, String prettyMessage) {
        super(cause);
        this.prettyMessage = prettyMessage;
    }
}
