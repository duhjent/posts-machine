package com.duhjent.postsmachine.entities.commands;

import com.duhjent.postsmachine.entities.Tape;

import lombok.Data;

@Data
public class LeftCommand implements Command {

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