package com.hernan.obras.service;

import com.hernan.obras.DTO.CobroDTO;
import java.util.List;

public interface ICobroService {

    CobroDTO save (CobroDTO cobroDTO);

    CobroDTO find (Long id);

    List<CobroDTO> findAll ();

    CobroDTO edit (Long id, CobroDTO cobroDTO);

    boolean delete (Long id);
}
