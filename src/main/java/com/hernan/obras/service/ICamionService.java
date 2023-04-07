package com.hernan.obras.service;

import com.hernan.obras.DTO.CamionDTO;

import java.util.List;

public interface ICamionService {

    CamionDTO save (CamionDTO camionDTO);

    CamionDTO find (Long id);

    List<CamionDTO> findAll ();

    CamionDTO edit (Long id, CamionDTO camionDTO);

    boolean delete (Long id);
}
