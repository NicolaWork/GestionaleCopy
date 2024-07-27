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

import com.copy.copy_vesuviana.model.Bnr;
import com.copy.copy_vesuviana.model.Cliente;
import com.copy.copy_vesuviana.model.Cls;
import com.copy.copy_vesuviana.model.Fornitore;
import com.copy.copy_vesuviana.model.Macchina;
import com.copy.copy_vesuviana.model.Riciclatore;
import com.copy.copy_vesuviana.service.BnrService;
import com.copy.copy_vesuviana.service.ClsService;
import com.copy.copy_vesuviana.service.FornitoreService;
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
    @Autowired
    private FornitoreService fornitoreService;

    @GetMapping("/new")
    public String newMacchinaForm(Model model) {
        model.addAttribute("macchina", new Macchina());
        List<Fornitore> listafornitori = fornitoreService.getAllFornitore();
        model.addAttribute("listafornitori", listafornitori );
        return "newmacchina";  // Questo dovrebbe corrispondere al nome del template
    }

    @PostMapping("/form")
    public String postMacchinaForm(@ModelAttribute Macchina macchina) {
        System.out.println(macchina);
        macchinaService.saveMacchina(macchina);        
        return "redirect:/home";
    }

    @GetMapping("/componimacchina")
    public String allMacchina(Model model){
        model.addAttribute("macchina", new Macchina());

        List<Macchina> listamacchine = macchinaService.getMacchinaByClienteNull();
        model.addAttribute("listamacchine", listamacchine);
        
        List<Cls> listacls = clsService.getClsByMacchinaNull();
        model.addAttribute("listacls", listacls);

        List<Bnr> listabnr = bnrService.getBnrByMacchinaNull();
        model.addAttribute("listabnr", listabnr);

        List<Riciclatore> listariciclatore = riciclatoreService.getRiciclatoreByMacchinaNull();
        model.addAttribute("listariciclatore", listariciclatore);
        return "componimacchina";
    }

    @PostMapping("/modifica") //da form di schedamacchina.html
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

        List<Riciclatore> listariciclatore = riciclatoreService.getRiciclatoreByMacchinaNull();
        model.addAttribute("listariciclatore", listariciclatore);

        return "schedamacchina";
    }

    @PostMapping("/aggiorna") //da form di macchinaid.html
    public String aggiornaMacchina(@ModelAttribute("macchina") Macchina macchinafm, HttpSession session, @RequestParam("macchinaId") Long macchinaId) {
        Macchina macchinadb = macchinaService.getMacchinaById(macchinaId);

        if (macchinafm.getId() != macchinaId) {
            Cliente c = macchinadb.getCliente();

            macchinadb.setBnr(null);
            macchinadb.setCls(null);
            macchinadb.setCliente(null);
            macchinadb.setRiciclatore(null);
            macchinaService.saveMacchina(macchinadb);
            
            Macchina macchinaForm = macchinaService.getMacchinaById(macchinafm.getId());
            macchinaForm.setBnr(macchinafm.getBnr());
            macchinaForm.setCliente(c);
            macchinaForm.setCls(macchinafm.getCls());
            macchinaForm.setRiciclatore(macchinafm.getRiciclatore());
            macchinaService.saveMacchina(macchinaForm);

        } else {
            macchinadb.setBnr(macchinafm.getBnr());
            macchinadb.setCls(macchinafm.getCls());
            macchinadb.setRiciclatore(macchinafm.getRiciclatore());
            macchinaService.saveMacchina(macchinadb);
        }

        session.removeAttribute("clientefm");

        return "redirect:/home";
    }

    @GetMapping("/listamacchine")
    public String getListaMacchine(Model model) {
        List<Macchina> listamacchine = macchinaService.getAllMacchina();
        listamacchine.sort(Comparator.comparing(Macchina::getId));
        model.addAttribute("listamacchine", listamacchine);
        return "listamacchine";
    }
    

    @GetMapping("/search")
    public String searchBnrByMatricola(@RequestParam("matricola") String matricola, Model model) {
        List<Macchina> listamacchine = macchinaService.findByMatricola(matricola);
        model.addAttribute("listamacchine", listamacchine);
        return "listamacchine :: macchineListFragment";
    }

    @GetMapping
    public String showBnrList(Model model) {
        List<Macchina> listamacchine = macchinaService.getAllMacchina();
        model.addAttribute("listamacchine", listamacchine);
        return "listamacchine";
    }


}
