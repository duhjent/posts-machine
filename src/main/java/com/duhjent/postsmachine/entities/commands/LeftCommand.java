package com.duhjent.postsmachine.entities.commands;

import javax.persistence.Entity;

import com.duhjent.postsmachine.entities.Tape;

import lombok.Data;

@Data
@Entity
public class LeftCommand extends Command {

    private final int next;
    
    @Override
    public int execute(Tape tape){
        tape.moveLeft();
        return next;
    }

    @Override
    public String toString(){
        return "Left: " + next;
    }
}