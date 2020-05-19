package com.duhjent.postsmachine;

import javax.validation.Valid;

import com.duhjent.postsmachine.data.CommandRepo;
import com.duhjent.postsmachine.data.MachineRepo;
import com.duhjent.postsmachine.data.TapeRepo;
import com.duhjent.postsmachine.entities.Machine;
import com.duhjent.postsmachine.entities.MachineBuilder;
import com.duhjent.postsmachine.exceptions.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/design")
public class MachineDesignController {
    private MachineRepo machineRepo;
    private TapeRepo tapeRepo;
    private CommandRepo commandRepo;

    @Autowired
    public MachineDesignController(MachineRepo machineRepo, TapeRepo tapeRepo, CommandRepo commandRepo) {
        this.machineRepo = machineRepo;
        this.tapeRepo = tapeRepo;
        this.commandRepo = commandRepo;
    }

    @GetMapping
    public String showDesignForm(MachineBuilder machineBuilder) {
        return "designForm";
    }

    @PostMapping
    public String saveDesign(@Valid MachineBuilder machineBuilder, BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors() || machineBuilder.getCommandFile().isEmpty()) {
            return "designForm";
        }
        try {
            Machine machine = machineBuilder.getMachine();

            tapeRepo.save(machine.getTape());
            commandRepo.saveAll(machine.getCommands());
            Machine saved = machineRepo.save(machine);

            redirectAttributes.addFlashAttribute("message", "You succesfully created a machine");
            redirectAttributes.addFlashAttribute("id", saved.getId());
        } catch (ParseException e) {
            redirectAttributes.addFlashAttribute("message", "Error parsing commands");
        }

        return "redirect:/design";
    }
}