package com.duhjent.postsmachine.entities;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.duhjent.postsmachine.entities.commands.CommandReader;
import com.duhjent.postsmachine.exceptions.ParseException;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class MachineBuilder {
    @NotBlank(message = "The tape shouldn't be empty")
    @Pattern(regexp = "^[0-1]*$", message = "The tape should only contain 0s and 1s")
    private String tapeString;

    @Size(min = 5, message = "The name must be at least 5 characters long")
    private String name;

    private MultipartFile commandFile;

    public Machine getMachine() throws ParseException{
        Machine machine = new Machine();
        machine.setTape(new Tape(tapeString));
        machine.setCommands(CommandReader.read(commandFile));
        machine.setName(name);
        return machine;
    }
}