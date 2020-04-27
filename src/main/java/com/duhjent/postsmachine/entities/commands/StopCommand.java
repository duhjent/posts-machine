package com.duhjent.postsmachine.entities.commands;

import javax.persistence.Entity;

import com.duhjent.postsmachine.entities.Tape;

import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
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