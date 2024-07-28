package com.copy.copy_vesuviana.repository;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.copy.copy_vesuviana.model.Cliente;

@Repository
public interface ClienteRepository extends ListCrudRepository<Cliente,Long> {

    List<Cliente> findByRagioneSocialeContainingIgnoreCase(String ragioneSociale);

    List<Cliente> findByAliasContainingIgnoreCase(String ragioneSociale);

}
