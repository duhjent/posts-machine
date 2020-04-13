package com.duhjent.postsmachine.entities.commands;

import com.duhjent.postsmachine.MachineException;
import com.duhjent.postsmachine.entities.Tape;

import lombok.Data;

@Data
public class MarkCommand implements Command{
    private final int next;

    @Override
    public int execute(Tape tape){
        if(tape.getState())
            throw new MachineException("You tried to mark a marked field");
        tape.setState(true);
        return next;
    }

}