package com.duhjent.postsmachine;

import javax.validation.Valid;

import com.duhjent.postsmachine.data.CommandRepo;
import com.duhjent.postsmachine.data.MachineRepo;
import com.duhjent.postsmachine.data.TapeRepo;
import com.duhjent.postsmachine.entities.Machine;
import com.duhjent.postsmachine.entities.MachinePrototype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/design")
public class MachineDesignController {
    private MachineRepo machineRepo;
    private TapeRepo tapeRepo;
    private CommandRepo commandRepo;

    @Autowired
    public MachineDesignController(MachineRepo machineRepo, TapeRepo tapeRepo, CommandRepo commandRepo){
        this.machineRepo = machineRepo;
        this.tapeRepo = tapeRepo;
        this.commandRepo = commandRepo;
    }
    
    @ModelAttribute(name = "design")
    public MachinePrototype design(){
        return new MachinePrototype();
    }
    
    @GetMapping
    public String showDesignForm(){
        return "design";
    }

    @PostMapping
    public String saveDesign(@Valid MachinePrototype design, Errors errors){
        if(errors.hasErrors()){
            return "design";
        }
        Machine machine = design.getMachine();

        tapeRepo.save(machine.getTape());
        commandRepo.saveAll(machine.getCommands());
        machineRepo.save(machine);

        return "design";
    }
}