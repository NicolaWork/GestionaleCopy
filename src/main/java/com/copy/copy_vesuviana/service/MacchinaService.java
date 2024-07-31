package com.copy.copy_vesuviana.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.copy.copy_vesuviana.model.Macchina;
import com.copy.copy_vesuviana.repository.MacchinaRepository;

@Service
public class MacchinaService {

    private MacchinaRepository macchinaRepository;

    public MacchinaService(MacchinaRepository macchinaRepository){
        this.macchinaRepository = macchinaRepository;
    }

    public void saveMacchina(Macchina macchina){
        macchinaRepository.save(macchina);
    }

    public List<Macchina> getAllMacchina(){
        return macchinaRepository.findAll();
    }

    public Macchina getMacchinaById(Long id){
        return macchinaRepository.findById(id).orElseThrow();
    }

    public void delMacchina(Long id){
        macchinaRepository.deleteById(id);
    }

    public List<Macchina> getMacchinaByClienteNull(){
        return macchinaRepository.findByClienteIdIsNull();
    }

    public Macchina getMacchinaByClienteId(Long id) {
        return macchinaRepository.getMacchinaByClienteId(id);
    }

    public List<Macchina> findByMatricola(String matricola) {
        return macchinaRepository.findByMatricolaContainingIgnoreCase(matricola);
    }

}
