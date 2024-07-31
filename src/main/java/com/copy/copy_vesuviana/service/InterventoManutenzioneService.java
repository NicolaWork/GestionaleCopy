package com.copy.copy_vesuviana.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.copy.copy_vesuviana.model.InterventoManutenzione;
import com.copy.copy_vesuviana.repository.InterventoManutenzioneRepository;

import java.util.List;

@Service
public class InterventoManutenzioneService {

    @Autowired
    private InterventoManutenzioneRepository repository;

    public List<InterventoManutenzione> getAllInterventi() {
        return repository.findAll();
    }

    public InterventoManutenzione getInterventoById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public InterventoManutenzione saveIntervento(InterventoManutenzione intervento) {
        return repository.save(intervento);
    }

    public void deleteIntervento(Long id) {
        repository.deleteById(id);
    }
}
