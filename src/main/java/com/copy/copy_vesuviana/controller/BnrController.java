package com.copy.copy_vesuviana.controller;


import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.copy.copy_vesuviana.model.Bnr;
import com.copy.copy_vesuviana.model.Fornitore;
import com.copy.copy_vesuviana.service.BnrService;
import com.copy.copy_vesuviana.service.FornitoreService;

@Controller
@RequestMapping("/bnr")
public class BnrController {

    private BnrService bnrService;
    @Autowired
    FornitoreService fornitoreService;

    public BnrController(BnrService bnrService){
        this.bnrService = bnrService;
    }

    @GetMapping("/new")
    public String newClienteForm(Model model) {
        List<Fornitore> listafornitori = fornitoreService.getAllFornitore();
        model.addAttribute("listafornitori", listafornitori );
        model.addAttribute("bnr", new Bnr());
        return "newbnr";  // Questo dovrebbe corrispondere al nome del template
    }

    @PostMapping("/form")
    public String postBnrForm(@ModelAttribute Bnr bnr) {
        bnrService.saveBnr(bnr);        
        return "redirect:/home";
    }

    @PostMapping("/find/{id}")
    public String findBnr(@PathVariable(name="id")Long id, Model model){
        Bnr bnr = bnrService.getBnrById(id);
        model.addAttribute("bnr", bnr);
        return "schedabnr";
    }

    @GetMapping("/listabnr")
    public String getListaBnr(Model model) {
        List<Bnr> listabnr = bnrService.getAllBnr();
        listabnr.sort(Comparator.comparing(Bnr::getId));
        model.addAttribute("listabnr", listabnr);
        return "listabnr";
    }

}
