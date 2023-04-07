package com.hernan.obras.service;

import com.hernan.obras.DTO.PagoDTO;

import java.util.List;

public interface IPagoService {

    PagoDTO save (PagoDTO pagoDTO);

    PagoDTO find (Long id);

    List<PagoDTO> findAll ();

    PagoDTO edit (Long id, PagoDTO pagoDTO);

    boolean delete (Long id);
}
