package com.copy.copy_vesuviana.controller;

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

import com.copy.copy_vesuviana.model.Bnr;
import com.copy.copy_vesuviana.model.Cliente;
import com.copy.copy_vesuviana.model.Cls;
import com.copy.copy_vesuviana.model.Macchina;
import com.copy.copy_vesuviana.model.Riciclatore;
import com.copy.copy_vesuviana.service.BnrService;
import com.copy.copy_vesuviana.service.ClsService;
import com.copy.copy_vesuviana.service.MacchinaService;
import com.copy.copy_vesuviana.service.RiciclatoreService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/macchina")
public class MacchinaController {

    private MacchinaService macchinaService;

    public MacchinaController(MacchinaService macchinaService){
        this.macchinaService = macchinaService;
    }

    @Autowired
    private ClsService clsService;
    @Autowired
    private BnrService bnrService;
    @Autowired
    private RiciclatoreService riciclatoreService;

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

    @GetMapping("/schedamacchina")
    public String allMacchina(Model model){
        model.addAttribute("macchina", new Macchina());

        List<Macchina> listamacchine = macchinaService.getMacchinaByClienteNull();
        model.addAttribute("listamacchine", listamacchine);
        
        List<Cls> listacls = clsService.getClsByMacchinaNull();
        model.addAttribute("listacls", listacls);

        List<Bnr> listabnr = bnrService.getBnrByMacchinaNull();
        model.addAttribute("listabnr", listabnr);

        List<Riciclatore> listariciclatore = riciclatoreService.getBnrByMacchinaNull();
        model.addAttribute("listariciclatore", listariciclatore);
        return "schedamacchina";
    }

    @PostMapping("/modifica")
    public String modificaMacchina(@ModelAttribute("macchina") Macchina macchinaForm, HttpSession session) {
    
    Long idMacchina = macchinaForm.getId();
    if (idMacchina != null && idMacchina != -1) {
        Macchina macchina = macchinaService.getMacchinaById(idMacchina);
        //setto il bnr
        Long idBnr = macchinaForm.getBnr().getId();
        Bnr bnr = bnrService.getBnrById(idBnr);
        bnr.setMacchina(macchina);
        macchina.setBnr(bnr);
        
        //setto il cls
        Long idCls = macchinaForm.getCls().getId();
        Cls cls = clsService.getClsById(idCls);
        cls.setMacchina(macchina);
        macchina.setCls(cls);
        
        //setto il riciclatore
        Long idRiciclatore = macchinaForm.getRiciclatore().getId();
        Riciclatore riciclatore = riciclatoreService.getRiciclatoreById(idRiciclatore);
        riciclatore.setMacchina(macchina);
        macchina.setRiciclatore(riciclatore);

        //setto il cliente
        Cliente cliente = (Cliente) session.getAttribute("clientefm");
        macchina.setCliente(cliente);
        session.removeAttribute("clientefm");

        macchinaService.saveMacchina(macchina);

        System.out.println("----------"+macchina);
    } else {
        // Gestione del caso in cui l'ID non sia presente o non sia valido
        System.out.println("ID della macchina non presente o non valido");
    }
    return "redirect:/home";
}

    @GetMapping("/find/{id}")
    public String findMacchina(@PathVariable(name="id") Long id, Model model){

        Macchina macchina = macchinaService.getMacchinaById(id);
        model.addAttribute("macchina", macchina);
        
        List<Macchina> listamacchine = macchinaService.getMacchinaByClienteNull();
        model.addAttribute("listamacchine", listamacchine);
       
        List<Cls> listacls = clsService.getClsByMacchinaNull();
        model.addAttribute("listacls", listacls);

        List<Bnr> listabnr = bnrService.getBnrByMacchinaNull();
        model.addAttribute("listabnr", listabnr);

        List<Riciclatore> listariciclatore = riciclatoreService.getBnrByMacchinaNull();
        model.addAttribute("listariciclatore", listariciclatore);

        return "macchinaid";
    }

    @PostMapping("/aggiorna")
    public String aggiornaMacchina(@ModelAttribute("macchina") Macchina macchinafm, HttpSession session, @RequestParam("macchinaId") Long macchinaId) {
        Macchina macchinadb = macchinaService.getMacchinaById(macchinaId);
        Boolean cambioMacchina = false;
        
        if (macchinafm.getId() != macchinaId){
            macchinafm.setMatricola(macchinafm.getMatricola());
            macchinafm.setModello(macchinafm.getModello());
            macchinafm.setDataAcquisto(macchinafm.getDataAcquisto());

            macchinafm.setBnr(macchinadb.getBnr());
            macchinafm.setCls(macchinadb.getCls());
            macchinafm.setCliente(macchinadb.getCliente());
            macchinafm.setRiciclatore(macchinadb.getRiciclatore());
            cambioMacchina = true;
        } 
        
        System.out.println(macchinafm.getCls().getId());
        System.out.println(macchinafm.getBnr().getId());
        System.out.println( macchinafm.getRiciclatore().getId());
        
        if (cambioMacchina == true){
            macchinadb.setBnr(null);
            macchinadb.setCls(null);
            macchinadb.setCliente(null);
            macchinadb.setRiciclatore(null);
            macchinaService.saveMacchina(macchinadb);
        }

        session.removeAttribute("clientefm");
        macchinaService.saveMacchina(macchinafm);

        return "redirect:/home";
    }
}
