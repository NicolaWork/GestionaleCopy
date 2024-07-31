package com.copy.copy_vesuviana.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

import com.copy.copy_vesuviana.model.Fornitore;

@Repository
public interface FornitoreRepository extends ListCrudRepository<Fornitore,Long> {

    List<Fornitore> findByRagioneSocialeContainingIgnoreCase(String ragioneSociale);
    
}