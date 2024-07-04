package com.copy.copy_vesuviana.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.copy.copy_vesuviana.model.Cliente;
import com.copy.copy_vesuviana.service.ClienteService;



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
    public String postMethodName(@ModelAttribute Cliente cliente) {
        clienteService.saveCliente(cliente);        
        return "redirect:/home";
    }
    

    @PostMapping("/findall")
    @ResponseBody
    public List<Cliente> allCliente(){
        return clienteService.getAllCliente();
    }

    @PostMapping("/find/{id}")
    @ResponseBody
    public Cliente findCliente(@PathVariable(name="id")Long id){
        return clienteService.getClienteById(id);
    }


}
