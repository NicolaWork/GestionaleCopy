package com.copy.copy_vesuviana.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.copy.copy_vesuviana.model.Fornitore;
import com.copy.copy_vesuviana.service.FornitoreService;

@Controller
@RequestMapping("/fornitore")
public class FornitoreController {

    private FornitoreService fornitoreService;

    public FornitoreController(FornitoreService fornitoreService) {
        this.fornitoreService = fornitoreService;
    }

     @GetMapping("/new")
    public String newMacchinaForm(Model model) {
        model.addAttribute("fornitore", new Fornitore());
        return "newfornitore";  // Questo dovrebbe corrispondere al nome del template
    }

        @PostMapping("/form")
    public String postFornitoreForm(@ModelAttribute Fornitore fornitore) {
        fornitoreService.saveFornitore(fornitore);        
        return "redirect:/home";
    }

}
