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
import org.springframework.web.bind.annotation.RequestParam;

import com.copy.copy_vesuviana.model.Fornitore;
import com.copy.copy_vesuviana.model.Riciclatore;
import com.copy.copy_vesuviana.service.FornitoreService;
import com.copy.copy_vesuviana.service.RiciclatoreService;

@Controller
@RequestMapping("/riciclatore")
public class RiciclatoreController {

    private RiciclatoreService riciclatoreService;

    @Autowired
    FornitoreService fornitoreService;

    public RiciclatoreController(RiciclatoreService riciclatoreService){
        this.riciclatoreService = riciclatoreService;
    }

    @GetMapping("/new")
    public String newRiciclatoreForm(Model model) {
        List<Fornitore> listafornitori = fornitoreService.getAllFornitore();
        model.addAttribute("listafornitori", listafornitori );
        model.addAttribute("riciclatore", new Riciclatore());
        return "newriciclatore";  // Questo dovrebbe corrispondere al nome del template
    }

    @PostMapping("/form")
    public String postRiciclatoreForm(@ModelAttribute Riciclatore riciclatore) {
        Long idFornitore = riciclatore.getFornitore().getId();
        riciclatore.setFornitore(fornitoreService.getFornitoreById(idFornitore));
        riciclatoreService.saveRiciclatore(riciclatore);        
        return "redirect:/home";
    }

    @GetMapping("/listariciclatori")
    public String getListaRiciclatore(Model model){
        List<Riciclatore> listariciclatore = riciclatoreService.getAllRiciclatore();
        listariciclatore.sort(Comparator.comparing(Riciclatore::getId));
        model.addAttribute("listariciclatore", listariciclatore);
        return "listariciclatori";
    }

    @GetMapping("/find/{id}")    
    public String findRiciclatore(@PathVariable(name="id")Long id, Model model){
        Riciclatore riciclatore = riciclatoreService.getRiciclatoreById(id);
        model.addAttribute("riciclatore", riciclatore);
        return "schedariciclatore";
    }


    @GetMapping("/search")
    public String searchBnrByMatricola(@RequestParam("matricola") String matricola, Model model) {
        List<Riciclatore> listariciclatore = riciclatoreService.findByMatricola(matricola);
        listariciclatore.sort(Comparator.comparing(Riciclatore::getId));
        model.addAttribute("listariciclatore", listariciclatore);
        return "listariciclatori :: riciclatoreListFragment";
    }

    @GetMapping
    public String showBnrList(Model model) {
        List<Riciclatore> listariciclatore = riciclatoreService.getAllRiciclatore();
        listariciclatore.sort(Comparator.comparing(Riciclatore::getId));
        model.addAttribute("listariciclatore", listariciclatore);
        return "listariciclatori";
    }


}
