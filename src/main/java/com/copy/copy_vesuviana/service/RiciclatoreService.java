package com.copy.copy_vesuviana.service;

import org.springframework.stereotype.Service;

import com.copy.copy_vesuviana.repository.RiciclatoreRepository;

@Service
public class RiciclatoreService {

    private RiciclatoreRepository riciclatoreRepository;

    public RiciclatoreService(RiciclatoreRepository riciclatoreRepository){
        this.riciclatoreRepository = riciclatoreRepository;
    }

    
}
