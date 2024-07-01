package com.copy.copy_vesuviana.service;

import org.springframework.stereotype.Service;

import com.copy.copy_vesuviana.repository.BnrRepository;

@Service
public class BrnService {

    private BnrRepository bnrRepository;

    public BrnService(BnrRepository bnrRepository){
        this.bnrRepository = bnrRepository;
    }

}
