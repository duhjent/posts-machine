package com.duhjent.postsmachine;

public class MachineException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public MachineException(String message) {
        super(message);
    }
}