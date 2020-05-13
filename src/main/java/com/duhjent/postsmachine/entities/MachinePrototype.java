package com.duhjent.postsmachine.entities;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.duhjent.postsmachine.entities.commands.CommandReader;
import com.duhjent.postsmachine.exceptions.ParseException;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class MachinePrototype {
    @NotBlank(message = "The tape shouldn't be empty")
    private String tapeString;

    // @NotNull
    @Size(min = 5, message = "The name must be at least 5 characters long")
    private String name;

    @NotNull
    private MultipartFile commandFile;

    public Machine getMachine() throws ParseException{
        Machine machine = new Machine();
        machine.setTape(new Tape(tapeString));
        machine.setCommands(CommandReader.read(commandFile));
        machine.setName(name);
        return machine;
    }
}