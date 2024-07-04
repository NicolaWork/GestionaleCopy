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

import com.copy.copy_vesuviana.model.Macchina;
import com.copy.copy_vesuviana.service.MacchinaService;

@Controller
@RequestMapping("/macchina")
public class MacchinaController {

    private MacchinaService macchinaService;

    public MacchinaController(MacchinaService macchinaService){
        this.macchinaService = macchinaService;
    }

    @GetMapping("/new")
    public String newMacchinaForm(Model model) {
        model.addAttribute("macchina", new Macchina());
        return "newmacchina";  // Questo dovrebbe corrispondere al nome del template
    }

    @PostMapping("/form")
    public String postMacchinaForm(@ModelAttribute Macchina macchina) {
        macchinaService.saveMacchina(macchina);        
        return "redirect:/home";
    }

    @PostMapping("/findall")
    @ResponseBody
    public List<Macchina> allMacchina(){
        return macchinaService.getAllMacchina();
    }

    @PostMapping("/find/{id}")
    @ResponseBody
    public Macchina findRiciclatore(@PathVariable(name="id")Long id){
        return macchinaService.getMacchinaById(id);
    }


}
