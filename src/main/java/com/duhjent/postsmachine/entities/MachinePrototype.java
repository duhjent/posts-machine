package com.duhjent.postsmachine.entities;

import com.duhjent.postsmachine.entities.commands.CommandReader;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class MachinePrototype {
    private String tapeString;
    private MultipartFile commandFile;

    public Machine getMachine(){
        Machine machine = new Machine();
        machine.setTape(new Tape(tapeString));
        machine.setCommands(CommandReader.read(commandFile));
        return machine;
    }
}