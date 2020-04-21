package com.duhjent.postsmachine.entities.commands;

import javax.persistence.Entity;

import com.duhjent.postsmachine.entities.Tape;

import lombok.Data;

@Data
@Entity
public class IfCommand extends Command{
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