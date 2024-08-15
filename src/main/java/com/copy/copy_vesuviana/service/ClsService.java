package com.copy.copy_vesuviana.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.copy.copy_vesuviana.model.Cls;
import com.copy.copy_vesuviana.repository.ClsRepository;

@Service
public class ClsService {

    private ClsRepository clsRepository;

    public ClsService(ClsRepository clsRepository){
        this.clsRepository = clsRepository;    
    }

    public void saveCls(Cls cls){
        if (clsRepository.existsByMatricola(cls.getMatricola())){
            throw new IllegalArgumentException("Matricola Cls già esistente");
        }
        if (cls.isAssistenza()==null) {
            cls.setAssistenza(false);            
        }
        clsRepository.save(cls);
    }

    public void updateCls(Cls clsForm){
        Cls cls = clsRepository.findById(clsForm.getId()).orElseThrow(() -> new IllegalArgumentException("Matricola Cls già esistente"));
        if (!clsRepository.existsByMatricolaAndIdNot(clsForm.getMatricola(),clsForm.getId())){
            cls.setMatricola(clsForm.getMatricola());
            cls.setModello(clsForm.getModello());
            cls.setAssistenza(clsForm.getAssistenza());
            cls.setMacchina(clsForm.getMacchina());
            cls.setFornitore(clsForm.getFornitore());
            clsRepository.save(cls);
        } else{
            throw new IllegalArgumentException("Matricola Cls già esistente");
        }
    }

    public List<Cls> getAllCls (){
        return clsRepository.findAll();
    }

    public Cls getClsById(Long id){
        return clsRepository.findById(id).orElseThrow();
    }

    public void delCls(Long id){
        clsRepository.deleteById(id);
    }

    public List<Cls> getClsByMacchinaNull(){
        return clsRepository.findByMacchinaIdIsNull();
    }

    public List<Cls> findByMatricola(String matricola) {
        return clsRepository.findByMatricolaContainingIgnoreCase(matricola);
    }

}
