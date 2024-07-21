package com.copy.copy_vesuviana.controller;

import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/listafornitori")
    public String getListaFornitori(Model model){
        List<Fornitore> listafornitori = fornitoreService.getAllFornitore();
        listafornitori.sort(Comparator.comparing(Fornitore::getId));
        model.addAttribute("listafornitori", listafornitori);
        return "listafornitori";
    }

    @GetMapping("/find/{id}")
    public String findFornitore(@PathVariable(name="id")Long id, Model model){

        Fornitore fornitore = fornitoreService.getFornitoreById(id);
        model.addAttribute("fornitore", fornitore);        

        return "schedafornitore";
    }


}
