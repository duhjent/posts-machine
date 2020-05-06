package com.duhjent.postsmachine;

import java.util.stream.Collectors;

import com.duhjent.postsmachine.data.MachineRepo;
import com.duhjent.postsmachine.entities.Machine;
import com.duhjent.postsmachine.entities.Tape;
import com.duhjent.postsmachine.entities.commands.Command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        model.addAttribute("pageTitle", machineRepo.findById(id).get().getName());
        return "machineView";
    }

    @PostMapping("/{id}")
    public String executeMachine(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        Machine machine = this.machineRepo.findById(id).get();
        try {
            Tape tape = machine.execute();
            redirectAttributes.addFlashAttribute("result", tape.toString());
        } catch (MachineException e) {
            redirectAttributes.addFlashAttribute("result", e.toString());
        }
        return "redirect:/machines/{id}";
    }
}