package com.copy.copy_vesuviana.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.copy.copy_vesuviana.model.InterventoManutenzione;

public interface InterventoManutenzioneRepository extends JpaRepository<InterventoManutenzione, Long> {

    List<InterventoManutenzione> findByDataInterventoAfter(LocalDate data);

    List<InterventoManutenzione> findByDataInterventoBetween(LocalDate startDate, LocalDate endDate);

    List<InterventoManutenzione> findByMacchina_MatricolaContainingIgnoreCase(String matricola);
    
    List<InterventoManutenzione> findByMacchina_MatricolaContainingIgnoreCaseAndDataInterventoBetween(
        String matricola, LocalDate startDate, LocalDate endDate);

}
