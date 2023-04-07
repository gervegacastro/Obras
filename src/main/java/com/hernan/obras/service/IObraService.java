package com.hernan.obras.service;

import com.hernan.obras.DTO.ObraDTO;

import java.util.List;

public interface IObraService {

    ObraDTO save (ObraDTO obraDTO);

    ObraDTO find (Long id);

    List<ObraDTO> findAll ();

    ObraDTO edit (Long id, ObraDTO obraDTO);

    boolean delete (Long id);
}
