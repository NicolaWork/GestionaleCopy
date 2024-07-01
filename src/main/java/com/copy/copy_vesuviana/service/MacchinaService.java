package com.copy.copy_vesuviana.service;

import org.springframework.stereotype.Service;

import com.copy.copy_vesuviana.repository.MacchinaRepository;

@Service
public class MacchinaService {

    private MacchinaRepository macchinaRepository;

    public MacchinaService(MacchinaRepository macchinaRepository){
        this.macchinaRepository = macchinaRepository;
    }

}
