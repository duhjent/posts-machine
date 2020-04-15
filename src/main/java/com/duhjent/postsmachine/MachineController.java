package com.duhjent.postsmachine;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.duhjent.postsmachine.data.MachineRepo;
import com.duhjent.postsmachine.entities.Machine;
import com.duhjent.postsmachine.entities.Tape;
import com.duhjent.postsmachine.entities.commands.Command;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/machines")
public class MachineController {
    private MachineRepo machineRepo;

    @GetMapping
    public String showMachines(Model model){
        // model.addAttribute("machineList", machineRepo.findAll());
        return "machines";
    }

    @GetMapping("/{id}")
    public String serveMachine(@PathVariable Long id, Model model){
        model.addAttribute("tape", machineRepo.findById(id).get().getTape().toString());
        model.addAttribute(
            "commands",
            machineRepo.findById(id).get().getCommands().stream()
            .map(Command::toString)
            .collect(Collectors.toList()));
        return "machineView";
    }
}