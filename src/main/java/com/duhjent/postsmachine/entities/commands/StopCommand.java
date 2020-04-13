package com.duhjent.postsmachine.entities.commands;

import com.duhjent.postsmachine.entities.Tape;

public class StopCommand implements Command {

    @Override
    public int execute(Tape tape) {
        return -1;
    }
    
}