package com.copy.copy_vesuviana.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.copy.copy_vesuviana.model.InterventoManutenzione;
import com.copy.copy_vesuviana.service.InterventoManutenzioneService;
import com.copy.copy_vesuviana.service.MacchinaService;
import com.copy.copy_vesuviana.service.BnrService;
import com.copy.copy_vesuviana.service.ClsService;
import com.copy.copy_vesuviana.service.RiciclatoreService;

@Controller
@RequestMapping("/interventi")
public class InterventoManutenzioneController {

    @Autowired
    private InterventoManutenzioneService interventoService;

    @Autowired
    private MacchinaService macchinaService;

    @Autowired
    private BnrService bnrService;

    @Autowired
    private ClsService clsService;

    @Autowired
    private RiciclatoreService riciclatoreService;

    @GetMapping
    public String getAllInterventi(Model model) {
        model.addAttribute("interventi", interventoService.getAllInterventi());
        return "interventi/list";
    }

    @GetMapping("/new")
    public String createInterventoForm(Model model) {
        model.addAttribute("intervento", new InterventoManutenzione());
        model.addAttribute("macchine", macchinaService.getAllMacchina());
        model.addAttribute("bnrs", bnrService.getAllBnr());
        model.addAttribute("clss", clsService.getAllCls());
        model.addAttribute("riciclatori", riciclatoreService.getAllRiciclatore());
        return "interventi/form";
    }

    @PostMapping
    public String saveIntervento(@ModelAttribute InterventoManutenzione intervento) {
        interventoService.saveIntervento(intervento);
        return "redirect:/interventi";
    }

    @GetMapping("/edit/{id}")
    public String editInterventoForm(@PathVariable Long id, Model model) {
        model.addAttribute("intervento", interventoService.getInterventoById(id));
        model.addAttribute("macchine", macchinaService.getAllMacchina());
        model.addAttribute("bnrs", bnrService.getAllBnr());
        model.addAttribute("clss", clsService.getAllCls());
        model.addAttribute("riciclatori", riciclatoreService.getAllRiciclatore());
        return "interventi/form";
    }

    @PostMapping("/{id}")
    public String updateIntervento(@PathVariable Long id, @ModelAttribute InterventoManutenzione intervento) {
        intervento.setId(id);
        interventoService.saveIntervento(intervento);
        return "redirect:/interventi";
    }

    @GetMapping("/delete/{id}")
    public String deleteIntervento(@PathVariable Long id) {
        interventoService.deleteIntervento(id);
        return "redirect:/interventi";
    }
}
