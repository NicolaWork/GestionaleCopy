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
        clsRepository.save(cls);
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

}
