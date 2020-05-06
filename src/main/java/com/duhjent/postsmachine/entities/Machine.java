package com.duhjent.postsmachine.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.duhjent.postsmachine.MachineException;
import com.duhjent.postsmachine.entities.commands.Command;

import lombok.Data;

@Entity
@Data
public class Machine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String name;
    @OneToMany(targetEntity = Command.class)
    private List<Command> commands;
    @OneToOne(targetEntity = Tape.class)
    private Tape tape;

    public Tape execute() throws MachineException {
        int nextCommand = commands.get(0).execute(tape);
        while (nextCommand != -1) {
            if (Thread.currentThread().interrupted()) {
                throw new MachineException("Machine ran out of time");
            }
            nextCommand = commands.get(nextCommand).execute(tape);
        }
        return tape;
    }
}