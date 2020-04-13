package com.duhjent.postsmachine.entities.commands;

import com.duhjent.postsmachine.entities.Tape;

import lombok.Data;

@Data
public class RightCommand implements Command{
    int next;

    @Override
    public int execute(Tape tape){
        tape.moveRight();
        return next;
    }
}