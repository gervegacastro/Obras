package com.hernan.obras.service;

import com.hernan.obras.DTO.TitularDTO;

import java.util.List;

public interface ITitularService {

    TitularDTO save (TitularDTO titularDTO);

    TitularDTO find (Long id);

    List<TitularDTO> findAll ();

    TitularDTO edit (Long id, TitularDTO titularDTO);

    boolean delete (Long id);
}
