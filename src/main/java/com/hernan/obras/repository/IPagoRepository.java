package com.hernan.obras.repository;

import com.hernan.obras.model.Pago;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPagoRepository extends CrudRepository <Pago, Long> {

}
