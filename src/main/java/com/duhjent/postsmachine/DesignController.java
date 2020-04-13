package com.duhjent.postsmachine;

import com.duhjent.postsmachine.entities.Machine;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/design")
public class DesignController {
    @GetMapping
    public String machineDesignForm(Model model){
        return "design";
    }

    @PostMapping
    public String saveDesign(Machine machine){
        return "redirect:/design";
    }
}