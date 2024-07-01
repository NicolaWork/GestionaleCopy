package com.copy.copy_vesuviana.service;

import org.springframework.stereotype.Service;

import com.copy.copy_vesuviana.repository.ClsRepository;

@Service
public class ClsService {

    private ClsRepository clsRepository;

    public ClsService(ClsRepository clsRepository){
        this.clsRepository = clsRepository;    
    }

}
