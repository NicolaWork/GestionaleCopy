package com.copy.copy_vesuviana.controller;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.copy.copy_vesuviana.model.Bnr;
import com.copy.copy_vesuviana.model.Cliente;
import com.copy.copy_vesuviana.model.Cls;
import com.copy.copy_vesuviana.model.InterventoManutenzione;
import com.copy.copy_vesuviana.model.Macchina;
import com.copy.copy_vesuviana.model.Riciclatore;
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
            @RequestParam(value = "componente", required = false) String componente,
            @RequestParam(value = "matricola", required = false) String matricola,
            @RequestParam(value = "startDate", required = false) String startDate,
            @RequestParam(value = "endDate", required = false) String endDate,
            Model model) {
        
        LocalDate start = (startDate != null && !startDate.isEmpty()) ? LocalDate.parse(startDate) : null;
        LocalDate end = (endDate != null && !endDate.isEmpty()) ? LocalDate.parse(endDate) : null;
        
        List<InterventoManutenzione> interventi = interventoService.searchInterventi(componente, matricola, start, end);
        model.addAttribute("interventi", interventi);
        model.addAttribute("matricola", matricola);
        model.addAttribute("startDate", startDate);
        model.addAttribute("endDate", endDate);
        
        return "interventi/list";
    }

    // @GetMapping("/new")
    // public String createInterventoForm(Model model) {
    //     model.addAttribute("intervento", new InterventoManutenzione());
    //     model.addAttribute("componenti", componenti.values());



    //     model.addAttribute("macchine", macchinaService.getAllMacchina());
    //     model.addAttribute("bnrs", bnrService.getAllBnr());
    //     model.addAttribute("clss", clsService.getAllCls());
    //     model.addAttribute("riciclatori", riciclatoreService.getAllRiciclatore());
    //     model.addAttribute("clienti", clienteService.getAllCliente());
    //     return "interventi/form";
    // }


    // ---------------------------------------------------------------------------


    @GetMapping("/newintervento")
    public String newIntervento(Model model) {  
        return "interventi/newintervento";
    }
    


  
    @PostMapping("/searchElement")
    public String getSearchElement(
            @RequestParam(value = "cliente", required = false) String cliente,
            @RequestParam(value = "matricolaBnr", required = false) String matricolaBnr,
            @RequestParam(value = "matricolaCls", required = false) String matricolaCls,
            @RequestParam(value = "matricolaRiciclatore", required = false) String matricolaRiciclatore,
            @RequestParam(value = "matricolaMacchina", required = false) String matricolaMacchina,
            Model model) {
        
        System.out.println("cliente: "+cliente);
        System.out.println("matricolaBnr: "+matricolaBnr);
        System.out.println("matricolaCls: "+matricolaCls);
        System.out.println("matricolaRiciclatore: "+matricolaRiciclatore);
        System.out.println("matricolaMacchina: "+matricolaMacchina);

        if (cliente != null){
            List<Cliente> listaCliente = clienteService.findByRagionesociale(cliente);
            model.addAttribute("listaCliente", listaCliente);
            System.out.println(listaCliente);
            
        }
        
        if (matricolaBnr != null){
            List<Bnr> listaBnr = bnrService.findByMatricola(matricolaBnr);
            model.addAttribute("listaComponent", listaBnr);
            System.out.println(listaBnr);
            
        }

        if (matricolaCls != null){
            List<Cls> listaCls = clsService.findByMatricola(matricolaCls);
            model.addAttribute("listaComponent", listaCls);
            System.out.println(listaCls);
            
        }

        if (matricolaRiciclatore != null){
            List<Riciclatore> listaRiciclatore = riciclatoreService.findByMatricola(matricolaRiciclatore);
            model.addAttribute("listaComponent", listaRiciclatore);
            System.out.println(listaRiciclatore);
            
        }

        if (matricolaMacchina != null){
            List<Macchina> listaMacchina = macchinaService.findByMatricola(matricolaMacchina);
            model.addAttribute("listaMacchina", listaMacchina);
            System.out.println(listaMacchina);
            
        }
        System.out.println("--- RICARICO LA PAGINA ---");
        return "interventi/newintervento";
    }

        

    


   // ---------------------------------------------------------------------------   

    @PostMapping
    public String saveIntervento(@ModelAttribute InterventoManutenzione intervento) {
        interventoService.saveIntervento(intervento);
        return "redirect:/interventi";
    }

    @GetMapping("/edit/{id}")
    public String editInterventoForm(@PathVariable String id, Model model) {
        model.addAttribute("intervento", interventoService.getInterventoById(id));
        model.addAttribute("macchine", macchinaService.getAllMacchina());
        model.addAttribute("bnrs", bnrService.getAllBnr());
        model.addAttribute("clss", clsService.getAllCls());
        model.addAttribute("riciclatori", riciclatoreService.getAllRiciclatore());
        model.addAttribute("clienti", clienteService.getAllCliente());
        return "interventi/form";
    }

    @PostMapping("/{id}")
    public String updateIntervento(@PathVariable String id, @ModelAttribute InterventoManutenzione intervento) {
        intervento.setId(id);
        interventoService.saveIntervento(intervento);
        return "redirect:/interventi";
    }

    @GetMapping("/delete/{id}")
    public String deleteIntervento(@PathVariable String id) {
        interventoService.deleteIntervento(id);
        return "redirect:/interventi";
    }
}
