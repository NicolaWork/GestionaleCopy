package com.copy.copy_vesuviana.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        
        if (clienteRepository.existsByRagioneSociale(cliente.getRagioneSociale())){
            throw new IllegalArgumentException("Ragione Sociale già esistente");
        }
        if (clienteRepository.existsByPIva(cliente.getpIva())){
            throw new IllegalArgumentException("Partita Iva già esistente");
        }
        if (clienteRepository.existsByEmail(cliente.getEmail())){
            throw new IllegalArgumentException("Email già esistente");
        }
        clienteRepository.save(cliente);
    }

    // public void updateCliente(Cliente cliente){
    //     System.out.println("-------------------update----------------");
    //     cliente.setIndirizzo(cliente.getIndirizzo());
    //     cliente.setRagioneSociale(cliente.getRagioneSociale());
    //     clienteRepository.save(cliente);
    // }

    public List<Cliente> getAllCliente(){
        return clienteRepository.findAll();
    }

    public Cliente getClienteById(Long id){
        return clienteRepository.findById(id).orElseThrow();
    }

    public void delCliente(Long id){
        clienteRepository.deleteById(id);
    }

    public List<Cliente> findByRagionesociale(String ragioneSociale) {
        List<Cliente> list_RS = clienteRepository.findByAliasContainingIgnoreCase(ragioneSociale);
        List<Cliente> list_A = clienteRepository.findByRagioneSocialeContainingIgnoreCase(ragioneSociale);

        Set<Cliente> unDuplicate = new HashSet<>(list_RS);
        unDuplicate.addAll(list_A);
    
        List<Cliente> lUnica = new ArrayList<>(unDuplicate);
        return lUnica;
    }

    public List<Cliente> getByMacchinaIsNull() {
        return clienteRepository.findByMacchinaIsNull();
    }

}
