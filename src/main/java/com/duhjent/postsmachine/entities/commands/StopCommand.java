package com.duhjent.postsmachine.entities.commands;

import javax.persistence.Entity;

import com.duhjent.postsmachine.entities.Tape;

@Entity
public class StopCommand extends Command {

    @Override
    public int execute(Tape tape) {
        return -1;
    }

    @Override
    public String toString(){
        return "Stop";
    }
    
}