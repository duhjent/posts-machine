package com.duhjent.postsmachine.entities.commands;

import javax.persistence.Entity;

import com.duhjent.postsmachine.entities.Tape;

import lombok.Data;

@Data
@Entity
public class RightCommand extends Command{
    private final int next;

    @Override
    public int execute(Tape tape){
        tape.moveRight();
        return next;
    }

    @Override
    public String toString(){
        return "Right: " + next;
    }
}