package com.duhjent.postsmachine;

import java.util.stream.Collectors;

import com.duhjent.postsmachine.data.MachineRepo;
import com.duhjent.postsmachine.entities.commands.Command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/machines")
public class MachineController {
    private MachineRepo machineRepo;

    @Autowired
    public MachineController(MachineRepo machineRepo) {
        this.machineRepo = machineRepo;
    }

    @GetMapping
    public String showMachines(Model model) {
        model.addAttribute("machineList", machineRepo.findAll());
        return "machines";
    }

    @GetMapping("/{id}")
    public String serveMachine(@PathVariable Long id, Model model) {
        model.addAttribute("tape", machineRepo.findById(id).get().getTape().toString());
        model.addAttribute("commands", machineRepo.findById(id).get().getCommands().stream().map(Command::toString)
                .collect(Collectors.toList()));
        model.addAttribute("pageTitle", "Machine #" + id);
        return "machineView";
    }
}