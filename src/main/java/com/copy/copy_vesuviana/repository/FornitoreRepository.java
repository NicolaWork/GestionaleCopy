package com.copy.copy_vesuviana.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.ListCrudRepository;

import com.copy.copy_vesuviana.model.Fornitore;

@Repository
public interface FornitoreRepository extends ListCrudRepository<Fornitore,Long> {

    
}