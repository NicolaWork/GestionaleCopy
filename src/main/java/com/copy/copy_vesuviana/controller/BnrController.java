package com.copy.copy_vesuviana.controller;


import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        return "new/newbnr";  // Questo dovrebbe corrispondere al nome del template
    }

    @PostMapping("/form")
    public String postBnrForm(@ModelAttribute Bnr bnr) {
        Long idFornitore = bnr.getFornitore().getId();
        bnr.setFornitore(fornitoreService.getFornitoreById(idFornitore));
        bnrService.saveBnr(bnr);        
        return "redirect:/home";
    }

    @GetMapping("/find/{id}")
    public String findBnr(@PathVariable(name="id")Long id, Model model){
        Bnr bnr = bnrService.getBnrById(id);
        model.addAttribute("bnr", bnr);
        return "scheda/schedabnr";
    }

    @GetMapping("/listabnr")
    public String getListaBnr(Model model) {
        List<Bnr> listabnr = bnrService.getAllBnr();
        listabnr.sort(Comparator.comparing(Bnr::getId));
        model.addAttribute("listabnr", listabnr);
        return "lista/listabnr";
    }

    @GetMapping("/search")
    public String searchBnrByMatricola(@RequestParam("matricola") String matricola, Model model) {
        List<Bnr> listabnr = bnrService.findByMatricola(matricola);
        listabnr.sort(Comparator.comparing(Bnr::getId));
        model.addAttribute("listabnr", listabnr);
        return "lista/listabnr :: bnrListFragment";
    }

    @GetMapping
    public String showBnrList(Model model) {
        List<Bnr> listabnr = bnrService.getAllBnr();
        listabnr.sort(Comparator.comparing(Bnr::getId));
        model.addAttribute("listabnr", listabnr);
        return "lista/listabnr";
    }

    @GetMapping("/listabnrmagazzino")
    public String getListaBnrMagazzino(Model model) {
        List<Bnr> listabnr = bnrService.getBnrByMacchinaNull();
        listabnr.sort(Comparator.comparing(Bnr::getId));
        model.addAttribute("listabnr", listabnr);
        return "magazzino/listabnrmagazzino";
    }

    @GetMapping("/searchmagazzino")
    public String searchmagazzinoBnrByMatricola(@RequestParam("matricola") String matricola, Model model) {
        List<Bnr> listabnr = bnrService.findByMatricola(matricola);

        List<Bnr> listabnrFiltered = listabnr.stream().
            filter(bnr -> bnr.getMacchina() == null).
            collect(Collectors.toList());

        listabnrFiltered.sort(Comparator.comparing(Bnr::getId));
        model.addAttribute("listabnr", listabnrFiltered);
        return "magazzino/listabnrmagazzino :: bnrListMagazzinoFragment";
    }

}
