package com.duhjent.postsmachine.entities;

import java.util.List;

import javax.persistence.Entity;

import com.duhjent.postsmachine.MachineException;
import com.duhjent.postsmachine.entities.commands.Command;

import lombok.Data;

@Entity
@Data
public class Machine {
    private List<Command> commands;
    private Tape tape;

    public void execute() throws MachineException{
        //TODO
    }
}