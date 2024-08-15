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

    public InterventoManutenzione getInterventoById(String id) {
        return interventoManutenzioneRepository.findById(id).orElse(null);
    }

    public InterventoManutenzione saveIntervento(InterventoManutenzione intervento) {
        return interventoManutenzioneRepository.save(intervento);
    }

    public void deleteIntervento(String id) {
        interventoManutenzioneRepository.deleteById(id);
    }

    public List<InterventoManutenzione> searchInterventi(String componente, String matricola, LocalDate startDate, LocalDate endDate) {
        
        switch (componente) {
            case "Bnr":
                if (matricola != null && !matricola.isEmpty() && startDate != null && endDate != null) {
                    return interventoManutenzioneRepository.findByBnr_MatricolaContainingIgnoreCaseAndDataInterventoBetween(matricola, startDate, endDate);
                } else if (matricola != null && !matricola.isEmpty()) {
                    return interventoManutenzioneRepository.findByBnr_MatricolaContainingIgnoreCase(matricola);
                }
            break;

            case "Cls":
                if (matricola != null && !matricola.isEmpty() && startDate != null && endDate != null) {
                    return interventoManutenzioneRepository.findByCls_MatricolaContainingIgnoreCaseAndDataInterventoBetween(matricola, startDate, endDate);
                } else if (matricola != null && !matricola.isEmpty()) {
                    return interventoManutenzioneRepository.findByCls_MatricolaContainingIgnoreCase(matricola);
                }            
            break;

            case "Riciclatore":            
                if (matricola != null && !matricola.isEmpty() && startDate != null && endDate != null) {
                    return interventoManutenzioneRepository.findByRiciclatore_MatricolaContainingIgnoreCaseAndDataInterventoBetween(matricola, startDate, endDate);
                } else if (matricola != null && !matricola.isEmpty()) {
                    return interventoManutenzioneRepository.findByRiciclatore_MatricolaContainingIgnoreCase(matricola);
                }            
            break;

            case "Macchina":
                if (matricola != null && !matricola.isEmpty() && startDate != null && endDate != null) {
                    return interventoManutenzioneRepository.findByMacchina_MatricolaContainingIgnoreCaseAndDataInterventoBetween(matricola, startDate, endDate);
                } else if (matricola != null && !matricola.isEmpty()) {
                    return interventoManutenzioneRepository.findByMacchina_MatricolaContainingIgnoreCase(matricola);   
                }         
            break;
        
            case "Cliente":
                if (matricola != null && !matricola.isEmpty() && startDate != null && endDate != null) {
                    return interventoManutenzioneRepository.findByCliente_RagioneSocialeContainingIgnoreCaseAndDataInterventoBetween(matricola, startDate, endDate);
                } else if (matricola != null && !matricola.isEmpty()) {
                    return interventoManutenzioneRepository.findByCliente_RagioneSocialeContainingIgnoreCase(matricola);   
                }               
            break;
                
        }
        return interventoManutenzioneRepository.findAll();

    }

}
