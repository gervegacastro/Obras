package com.hernan.obras.repository;

import com.hernan.obras.model.Cobro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICobroRepository extends CrudRepository <Cobro, Long> {

}
