package com.duhjent.postsmachine.entities.commands;

import javax.persistence.Entity;

import com.duhjent.postsmachine.MachineException;
import com.duhjent.postsmachine.entities.Tape;

import lombok.Data;

@Data
@Entity
public class EraseCommand extends Command{
    private final int next;

    @Override
    public int execute(Tape tape){
        if(!tape.getState())
            throw new MachineException("You tried to erase an empty field");
        tape.setState(false);
        return next;
    }

    @Override
    public String toString(){
        return "Erase: " + next;
    }

}