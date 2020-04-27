package com.duhjent.postsmachine.entities.commands;

import javax.persistence.Entity;

import com.duhjent.postsmachine.entities.Tape;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class RightCommand extends Command{
    private int next;
    
    public RightCommand(int next){
        this.next = next;
    }

    @Override
    public int execute(Tape tape){
        tape.moveRight();
        return next;
    }

    @Override
    public String toString(){
        return "Right: " + next;
    }
}