package com.copy.copy_vesuviana.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.copy.copy_vesuviana.model.Riciclatore;
import com.copy.copy_vesuviana.repository.RiciclatoreRepository;

@Service
public class RiciclatoreService {

    private RiciclatoreRepository riciclatoreRepository;

    public RiciclatoreService(RiciclatoreRepository riciclatoreRepository){
        this.riciclatoreRepository = riciclatoreRepository;
    }

    public void saveRiciclatore(Riciclatore riciclatore){
        if (riciclatoreRepository.existsByMatricola(riciclatore.getMatricola())){
            throw new IllegalArgumentException("Matricola già esistente");
        }
        if (riciclatore.isAssistenza()==null) {
            riciclatore.setAssistenza(false);            
        }
        riciclatoreRepository.save(riciclatore);
    }

    public List<Riciclatore> getAllRiciclatore(){
        return riciclatoreRepository.findAll();
    }

    public Riciclatore getRiciclatoreById (Long id){
        return riciclatoreRepository.findById(id).orElseThrow();
    }

    public void delRiciclatore(Long id){
        riciclatoreRepository.deleteById(id);
    }

    public List<Riciclatore> getRiciclatoreByMacchinaNull(){
        return riciclatoreRepository.findByMacchinaIdIsNull();
    }

    public List<Riciclatore> findByMatricola(String matricola) {
        return riciclatoreRepository.findByMatricolaContainingIgnoreCase(matricola);
    }

}
