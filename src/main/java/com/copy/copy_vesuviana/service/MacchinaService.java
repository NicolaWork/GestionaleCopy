package com.copy.copy_vesuviana.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.copy.copy_vesuviana.model.Macchina;
import com.copy.copy_vesuviana.repository.MacchinaRepository;

import jakarta.transaction.Transactional;

@Service
public class MacchinaService {

    private MacchinaRepository macchinaRepository;

    public MacchinaService(MacchinaRepository macchinaRepository){
        this.macchinaRepository = macchinaRepository;
    }

    public void saveMacchina(Macchina macchina){
        if (macchinaRepository.existsByMatricola(macchina.getMatricola())){
            throw new IllegalArgumentException("Matricola Macchina già esistente");
        }
        macchinaRepository.save(macchina);
    }

    @Transactional
    public void updateMacchina(Macchina macchinaForm) {
        Macchina macchina = macchinaRepository.findById(macchinaForm.getId())
                .orElseThrow(() -> new IllegalArgumentException("Macchina non trovata"));

        if (macchinaRepository.existsByMatricolaAndIdNot(macchinaForm.getMatricola(), macchinaForm.getId())) {
            throw new IllegalArgumentException("Matricola già esistente");
        }

        macchina.setMatricola(macchinaForm.getMatricola());
        macchina.setModello(macchinaForm.getModello());
        macchina.setDataAcquisto(macchinaForm.getDataAcquisto());
        macchina.setDataUltimoAvviso(macchinaForm.getDataUltimoAvviso());
        macchina.setCliente(macchinaForm.getCliente());
        macchina.setBnr(macchinaForm.getBnr());
        macchina.setCls(macchinaForm.getCls());
        macchina.setRiciclatore(macchinaForm.getRiciclatore());
        macchina.setFornitore(macchinaForm.getFornitore());

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
