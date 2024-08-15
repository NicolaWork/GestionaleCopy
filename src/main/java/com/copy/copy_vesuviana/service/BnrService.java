package com.copy.copy_vesuviana.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.copy.copy_vesuviana.model.Bnr;
import com.copy.copy_vesuviana.repository.BnrRepository;

@Service
public class BnrService {

    private BnrRepository bnrRepository;

    public BnrService(BnrRepository bnrRepository){
        this.bnrRepository = bnrRepository;
    }

    public void saveBnr (Bnr bnr){

        if (bnrRepository.existsByMatricola(bnr.getMatricola())){
            throw new IllegalArgumentException("Matricola Bnr già esistente");
        }
        if (bnr.isAssistenza()==null) {
            bnr.setAssistenza(false);            
        }
        bnrRepository.save(bnr);
    }

    public void updateBnr(Bnr bnrForm){
        Bnr bnr = bnrRepository.findById(bnrForm.getId()).orElseThrow(() -> new IllegalArgumentException("Matricola Bnr già esistente"));
        if (!bnrRepository.existsByMatricolaAndIdNot(bnrForm.getMatricola(),bnrForm.getId())){
            bnr.setMatricola(bnrForm.getMatricola());
            bnr.setModello(bnrForm.getModello());
            bnr.setAssistenza(bnrForm.getAssistenza());
            bnr.setMacchina(bnrForm.getMacchina());
            bnr.setFornitore(bnrForm.getFornitore());
            bnrRepository.save(bnr);
        } else{
            throw new IllegalArgumentException("Matricola Bnr già esistente");
        }
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
    
    public List<Bnr> getBnrByMacchinaNull(){
        return bnrRepository.findByMacchinaIdIsNull();
    }

    public List<Bnr> findByMatricola(String matricola) {
        return bnrRepository.findByMatricolaContainingIgnoreCase(matricola);
    }


}
