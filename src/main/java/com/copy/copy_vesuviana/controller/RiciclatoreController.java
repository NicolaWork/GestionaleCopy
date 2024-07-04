package com.copy.copy_vesuviana.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.copy.copy_vesuviana.model.Riciclatore;
import com.copy.copy_vesuviana.service.RiciclatoreService;

@Controller
@RequestMapping("/riciclatore")
public class RiciclatoreController {

    private RiciclatoreService riciclatoreService;

    public RiciclatoreController(RiciclatoreService riciclatoreService){
        this.riciclatoreService = riciclatoreService;
    }

    @GetMapping("/new")
    public String newRiciclatoreForm(Model model) {
        model.addAttribute("riciclatore", new Riciclatore());
        return "newriciclatore";  // Questo dovrebbe corrispondere al nome del template
    }

    @PostMapping("/form")
    public String postRiciclatoreForm(@ModelAttribute Riciclatore riciclatore) {
        riciclatoreService.saveRiciclatore(riciclatore);        
        return "redirect:/home";
    }

    @PostMapping("/findall")
    @ResponseBody
    public List<Riciclatore> allRiciclatore(){
        return riciclatoreService.getAllRiciclatore();
    }

    @PostMapping("/find/{id}")
    @ResponseBody
    public Riciclatore findRiciclatore(@PathVariable(name="id")Long id){
        return riciclatoreService.getRiciclatoreById(id);
    }




}
