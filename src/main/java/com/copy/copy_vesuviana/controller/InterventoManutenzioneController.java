package com.copy.copy_vesuviana.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.copy.copy_vesuviana.model.InterventoManutenzione;
import com.copy.copy_vesuviana.service.InterventoManutenzioneService;
import com.copy.copy_vesuviana.service.MacchinaService;
import com.copy.copy_vesuviana.service.BnrService;
import com.copy.copy_vesuviana.service.ClienteService;
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

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public String getAllInterventi(
            @RequestParam(value = "cliente", required = false) String cliente,
            @RequestParam(value = "matricola", required = false) String matricola,
            @RequestParam(value = "startDate", required = false) String startDate,
            @RequestParam(value = "endDate", required = false) String endDate,
            Model model) {
        
        LocalDate start = (startDate != null && !startDate.isEmpty()) ? LocalDate.parse(startDate) : null;
        LocalDate end = (endDate != null && !endDate.isEmpty()) ? LocalDate.parse(endDate) : null;
        
        List<InterventoManutenzione> interventi = interventoService.searchInterventi(matricola, start, end);
        model.addAttribute("interventi", interventi);
        model.addAttribute("matricola", matricola);
        model.addAttribute("startDate", startDate);
        model.addAttribute("endDate", endDate);
        
        return "interventi/list";
    }

    @GetMapping("/new")
    public String createInterventoForm(Model model) {
        model.addAttribute("intervento", new InterventoManutenzione());
        model.addAttribute("macchine", macchinaService.getAllMacchina());
        model.addAttribute("bnrs", bnrService.getAllBnr());
        model.addAttribute("clss", clsService.getAllCls());
        model.addAttribute("riciclatori", riciclatoreService.getAllRiciclatore());
        model.addAttribute("clienti", clienteService.getAllCliente());
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
        model.addAttribute("clienti", clienteService.getAllCliente());
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
