package com.duhjent.postsmachine.entities.commands;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.duhjent.postsmachine.entities.Tape;
import com.duhjent.postsmachine.exceptions.MachineException;

import lombok.NoArgsConstructor;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NoArgsConstructor
public abstract class Command {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public abstract int execute(Tape tape) throws MachineException;
    public abstract String toString();
}