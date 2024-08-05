package com.copy.copy_vesuviana.repository;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.copy.copy_vesuviana.model.Bnr;

@Repository
public interface BnrRepository extends ListCrudRepository<Bnr,Long> {

    List<Bnr> findByMacchinaIdIsNull();

    List<Bnr> findByMatricolaContainingIgnoreCase(String matricola);

    boolean existsByMatricola(String matricola);

}
