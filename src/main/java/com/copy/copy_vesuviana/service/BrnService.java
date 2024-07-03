package com.copy.copy_vesuviana.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.copy.copy_vesuviana.model.Bnr;
import com.copy.copy_vesuviana.repository.BnrRepository;

@Service
public class BrnService {

    private BnrRepository bnrRepository;

    public BrnService(BnrRepository bnrRepository){
        this.bnrRepository = bnrRepository;
    }

    public void saveBnr (Bnr bnr){
        bnrRepository.save(bnr);
    }

    public List<Bnr> getAllBnr (){
        return bnrRepository.findAll();
    }

    public Bnr getBnrById (Long id){
        return bnrRepository.findById(id).orElseThrow();
    }

    public void delBnr(Long id){
        bnrRepository.deleteById(id);
    }
    

}
