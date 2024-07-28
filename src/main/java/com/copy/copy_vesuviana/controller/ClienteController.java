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
import org.springframework.web.bind.annotation.RequestParam;

import com.copy.copy_vesuviana.model.Cliente;
import com.copy.copy_vesuviana.service.ClienteService;

import jakarta.servlet.http.HttpSession;



@Controller
@RequestMapping("/cliente")
public class ClienteController {
    
    private ClienteService clienteService;

    public ClienteController(ClienteService clientesService){
        this.clienteService=clientesService;
    }


    @GetMapping("/new")
    public String newClienteForm(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "newcliente";  // Questo dovrebbe corrispondere al nome del template
    }

    @PostMapping("/form")
    public String postMethodName(@ModelAttribute("cliente") Cliente cliente) {
        System.out.println(cliente);
        clienteService.saveCliente(cliente);                
        return "redirect:/home";
    }
    

    @GetMapping("/listaclienti")
    public String allCliente(Model model){
        
        List<Cliente> listaclienti = clienteService.getAllCliente();
        listaclienti.sort(Comparator.comparing(Cliente::getRagioneSociale));
        model.addAttribute("listaclienti", listaclienti);
 
        return "listaclienti";
    }

    @GetMapping("/find/{id}")
    public String findCliente(@PathVariable(name="id")Long id, Model model, HttpSession session){

        Cliente cliente = clienteService.getClienteById(id);
        session.setAttribute("clientefm", cliente);
        model.addAttribute("cliente", cliente);        

        return "schedacliente";
    }

    @GetMapping("/search")
    public String searchClienteByRagioneSociale(@RequestParam("ragioneSociale") String ragioneSociale, Model model) {
        List<Cliente> listaclienti = clienteService.findByRagionesociale(ragioneSociale);
        model.addAttribute("listaclienti", listaclienti);
        return "listaclienti :: clienteListFragment";
    }

    @GetMapping
    public String showClinteList(Model model) {
        List<Cliente> listaclienti = clienteService.getAllCliente();
        model.addAttribute("listaclienti", listaclienti);
        return "listaclienti";
    }



}
