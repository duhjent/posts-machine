package com.duhjent.postsmachine.entities.commands;

import javax.persistence.Entity;

import com.duhjent.postsmachine.MachineException;
import com.duhjent.postsmachine.entities.Tape;

import lombok.Data;

@Data
@Entity
public class MarkCommand extends Command{
    private final int next;

    @Override
    public int execute(Tape tape){
        if(tape.getState())
            throw new MachineException("You tried to mark a marked field");
        tape.setState(true);
        return next;
    }

    @Override
    public String toString(){
        return "Mark: " + next;
    }

}