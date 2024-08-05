package com.copy.copy_vesuviana.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.copy.copy_vesuviana.model.Fornitore;
import com.copy.copy_vesuviana.repository.FornitoreRepository;

@Service
public class FornitoreService {

    private FornitoreRepository fornitoreRepository;
    
    public FornitoreService(FornitoreRepository fornitoreRepository) {
        this.fornitoreRepository = fornitoreRepository;
    }

    public void saveFornitore(Fornitore fornitore){

        if (fornitoreRepository.existsByRagioneSociale(fornitore.getRagioneSociale())){
            throw new IllegalArgumentException("Ragione Sociale già esistente");
        }
        if (fornitoreRepository.existsByEmail(fornitore.getEmail())){
            throw new IllegalArgumentException("Email già esistente");
        }

        fornitoreRepository.save(fornitore);
    }

    public List<Fornitore> getAllFornitore (){
        return fornitoreRepository.findAll();
    }

    public Fornitore getFornitoreById(Long id){
        return fornitoreRepository.findById(id).orElseThrow();
    }

    public void delFornitore(Long id){
        fornitoreRepository.deleteById(id);
    }

    public List<Fornitore> findByRagionesociale(String ragioneSociale) {
        return fornitoreRepository.findByRagioneSocialeContainingIgnoreCase(ragioneSociale);
    }


    
}