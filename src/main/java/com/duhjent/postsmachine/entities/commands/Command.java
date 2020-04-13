package com.duhjent.postsmachine.entities.commands;

import com.duhjent.postsmachine.entities.Tape;

public interface Command {
    int execute(Tape tape);
}