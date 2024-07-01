package com.copy.copy_vesuviana.service;

import org.springframework.stereotype.Service;

import com.copy.copy_vesuviana.repository.ClienteRepository;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }
}
