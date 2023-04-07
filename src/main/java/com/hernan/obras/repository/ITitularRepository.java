package com.hernan.obras.repository;

import com.hernan.obras.model.Titular;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITitularRepository extends CrudRepository <Titular, Long> {

}
