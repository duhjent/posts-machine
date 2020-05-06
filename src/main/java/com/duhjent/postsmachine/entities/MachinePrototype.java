package com.duhjent.postsmachine.entities;

import javax.validation.constraints.NotNull;

import com.duhjent.postsmachine.entities.commands.CommandReader;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class MachinePrototype {
    @NotNull
    private String tapeString;

    private String name;
    
    @NotNull
    private MultipartFile commandFile;

    public Machine getMachine(){
        Machine machine = new Machine();
        machine.setTape(new Tape(tapeString));
        machine.setCommands(CommandReader.read(commandFile));
        machine.setName(name);
        return machine;
    }
}