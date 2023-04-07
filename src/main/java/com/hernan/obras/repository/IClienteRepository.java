package com.hernan.obras.repository;

import com.hernan.obras.model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends CrudRepository <Cliente, Long> {

}
