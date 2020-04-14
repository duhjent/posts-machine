package com.duhjent.postsmachine.entities.commands;

import com.duhjent.postsmachine.entities.Tape;

import lombok.Data;

@Data
public class IfCommand implements Command{
    private final int notCommand, yesCommand;

    @Override
    public int execute(Tape tape){
        return tape.getState() ? yesCommand : notCommand;
    }

    @Override
    public String toString(){
        return "If: " + notCommand + " " + yesCommand;
    }

}