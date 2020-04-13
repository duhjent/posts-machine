package com.duhjent.postsmachine.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.duhjent.postsmachine.MachineException;
import com.duhjent.postsmachine.entities.commands.Command;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;

@Entity
@Data
public class Machine {
    @Id
    private Long id;
    private List<Command> commands;
    private Tape tape;

    @Autowired
    public Machine(List<Command> commands, Tape tape){
        this.commands = commands;
        this.tape = tape;
    }

    public void execute() throws MachineException{
        //TODO
    }
}