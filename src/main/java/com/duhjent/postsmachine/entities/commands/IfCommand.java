package com.duhjent.postsmachine.entities.commands;

import javax.persistence.Entity;

import com.duhjent.postsmachine.entities.Tape;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class IfCommand extends Command{
    private int notCommand, yesCommand;

    public IfCommand(int notCommand, int yesCommand){
        this.notCommand = notCommand;
        this.yesCommand = yesCommand;
    }

    @Override
    public int execute(Tape tape){
        return tape.getState() ? yesCommand : notCommand;
    }

    @Override
    public String toString(){
        return "If: " + notCommand + " " + yesCommand;
    }

}