package com.hernan.obras.repository;

import com.hernan.obras.model.Obra;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IObraRepository extends CrudRepository <Obra, Long> {

}
