package com.duhjent.postsmachine.entities.commands;

import javax.persistence.Entity;

import com.duhjent.postsmachine.entities.Tape;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class LeftCommand extends Command {

    private int next;

    public LeftCommand(int next){
        this.next = next;
    }
    
    @Override
    public int execute(Tape tape){
        tape.moveLeft();
        return next;
    }

    @Override
    public String toString(){
        return "Left: " + next;
    }
}