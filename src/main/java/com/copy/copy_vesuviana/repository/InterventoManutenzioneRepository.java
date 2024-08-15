package com.copy.copy_vesuviana.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

import com.copy.copy_vesuviana.model.InterventoManutenzione;

public interface InterventoManutenzioneRepository extends ListCrudRepository<InterventoManutenzione, String> {

    List<InterventoManutenzione> findByDataInterventoAfter(LocalDate data);

    List<InterventoManutenzione> findByDataInterventoBetween(LocalDate startDate, LocalDate endDate);

    List<InterventoManutenzione> findByMacchina_MatricolaContainingIgnoreCase(String matricola);
    
    List<InterventoManutenzione> findByMacchina_MatricolaContainingIgnoreCaseAndDataInterventoBetween(
        String matricola, LocalDate startDate, LocalDate endDate);

    List<InterventoManutenzione> findByBnr_MatricolaContainingIgnoreCase(String matricola);

    List<InterventoManutenzione> findByBnr_MatricolaContainingIgnoreCaseAndDataInterventoBetween(
        String matricola, LocalDate startDate, LocalDate endDate);

    List<InterventoManutenzione> findByCls_MatricolaContainingIgnoreCase(String matricola);

    List<InterventoManutenzione> findByCls_MatricolaContainingIgnoreCaseAndDataInterventoBetween(
        String matricola, LocalDate startDate, LocalDate endDate);

    List<InterventoManutenzione> findByRiciclatore_MatricolaContainingIgnoreCase(String matricola);
    
    List<InterventoManutenzione> findByRiciclatore_MatricolaContainingIgnoreCaseAndDataInterventoBetween(
        String matricola, LocalDate startDate, LocalDate endDate);

    List<InterventoManutenzione> findByCliente_RagioneSocialeContainingIgnoreCase(String ragioneSociale);

    List<InterventoManutenzione> findByCliente_RagioneSocialeContainingIgnoreCaseAndDataInterventoBetween(
        String ragioneSociale, LocalDate startDate, LocalDate endDate);
}
