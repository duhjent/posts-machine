package com.duhjent.postsmachine.entities.commands;

import javax.persistence.Entity;

import com.duhjent.postsmachine.MachineException;
import com.duhjent.postsmachine.entities.Tape;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class MarkCommand extends Command{
    private int next;

    public MarkCommand(int next){
        this.next = next;
    }

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