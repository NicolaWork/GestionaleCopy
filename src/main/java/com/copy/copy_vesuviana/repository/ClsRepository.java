package com.copy.copy_vesuviana.repository;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.copy.copy_vesuviana.model.Cls;

@Repository
public interface ClsRepository extends ListCrudRepository<Cls,Long>{
    
    List<Cls> findByMacchinaIdIsNull();

    List<Cls> findByMatricolaContainingIgnoreCase(String matricola);

}
