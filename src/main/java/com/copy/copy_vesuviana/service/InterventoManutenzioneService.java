package com.copy.copy_vesuviana.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.copy.copy_vesuviana.model.InterventoManutenzione;
import com.copy.copy_vesuviana.repository.InterventoManutenzioneRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class InterventoManutenzioneService {

    @Autowired
    private InterventoManutenzioneRepository interventoManutenzioneRepository;

    public List<InterventoManutenzione> getAllInterventi() {
        return interventoManutenzioneRepository.findAll();
    }

    public InterventoManutenzione getInterventoById(Long id) {
        return interventoManutenzioneRepository.findById(id).orElse(null);
    }

    public InterventoManutenzione saveIntervento(InterventoManutenzione intervento) {
        return interventoManutenzioneRepository.save(intervento);
    }

    public void deleteIntervento(Long id) {
        interventoManutenzioneRepository.deleteById(id);
    }

    public List<InterventoManutenzione> searchInterventi(String matricola, LocalDate startDate, LocalDate endDate) {
        if (matricola != null && !matricola.isEmpty() && startDate != null && endDate != null) {
            return interventoManutenzioneRepository.findByMacchina_MatricolaContainingIgnoreCaseAndDataInterventoBetween(matricola, startDate, endDate);
        } else if (matricola != null && !matricola.isEmpty()) {
            return interventoManutenzioneRepository.findByMacchina_MatricolaContainingIgnoreCase(matricola);
        } else if (startDate != null && endDate != null) {
            return interventoManutenzioneRepository.findByDataInterventoBetween(startDate, endDate);
        } else {
            return interventoManutenzioneRepository.findAll();
        }
    }
}
