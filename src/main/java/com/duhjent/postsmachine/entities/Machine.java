package com.duhjent.postsmachine.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.duhjent.postsmachine.MachineException;
import com.duhjent.postsmachine.entities.commands.Command;

import lombok.Data;

@Entity
@Data
public class Machine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(targetEntity = Command.class)
    private List<Command> commands;
    @OneToOne(targetEntity = Tape.class)
    private Tape tape;

    public void execute() throws MachineException{
        //TODO
    }
}