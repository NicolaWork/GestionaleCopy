package com.copy.copy_vesuviana.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.copy.copy_vesuviana.model.Cliente;

@Repository
public interface ClienteRepository extends ListCrudRepository<Cliente,Long> {

    

}
