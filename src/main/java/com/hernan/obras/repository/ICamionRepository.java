package com.hernan.obras.repository;

import com.hernan.obras.model.Camion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICamionRepository extends CrudRepository <Camion, Long> {

}
