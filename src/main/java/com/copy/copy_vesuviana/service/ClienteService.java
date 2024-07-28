package com.copy.copy_vesuviana.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.copy.copy_vesuviana.model.Cliente;
import com.copy.copy_vesuviana.repository.ClienteRepository;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    public void saveCliente(Cliente cliente){
        System.out.println("-------------------save----------------");
        clienteRepository.save(cliente);
    }

    public void updateCliente(Cliente cliente){
        System.out.println("-------------------update----------------");
        cliente.setIndirizzo(cliente.getIndirizzo());
        cliente.setragioneSociale(cliente.getragioneSociale());
        clienteRepository.save(cliente);
    }

    public List<Cliente> getAllCliente(){
        return clienteRepository.findAll();
    }

    public Cliente getClienteById(Long id){
        return clienteRepository.findById(id).orElseThrow();
    }

    public void delCliente(Long id){
        clienteRepository.deleteById(id);
    }

}
