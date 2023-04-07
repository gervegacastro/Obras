package com.hernan.obras.service.imp;

import com.hernan.obras.DTO.TitularDTO;
import com.hernan.obras.model.Titular;
import com.hernan.obras.repository.ITitularRepository;
import com.hernan.obras.service.ITitularService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TitularService implements ITitularService {

    private ITitularRepository titularRepository;
    private ModelMapper modelMapper;

    public TitularService(ITitularRepository titularRepository, ModelMapper modelMapper) {
        this.titularRepository = titularRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public TitularDTO save(TitularDTO titularDTO) {
        Titular titular = modelMapper.map(titularDTO, Titular.class);
        titular = titularRepository.save(titular);
        return modelMapper.map(titular, TitularDTO.class);
    }

    @Override
    public TitularDTO find(Long id) {
        Titular titular = titularRepository.findById(id).orElse(null);
        if (titular == null){
        return null;
        }
        return modelMapper.map(titular, TitularDTO.class);
    }

    @Override
    public List<TitularDTO> findAll() {
        List<Titular> titulares = (List<Titular>) titularRepository.findAll();
        List<TitularDTO> titularesDTO = new ArrayList<>();
        for (Titular tit : titulares){
            TitularDTO titularDTO = modelMapper.map(tit, TitularDTO.class);
            titularesDTO.add(titularDTO);
        }
        return titularesDTO;
    }

    @Override
    public TitularDTO edit(Long id, TitularDTO titularDTO) {
        Titular titular = titularRepository.findById(id).orElse(null);
        if (titular == null){
        return null;
        }
        titular = modelMapper.map(titularDTO, Titular.class);
        titular.setId(id);
        titular = titularRepository.save(titular);
        return modelMapper.map (titular, TitularDTO.class);
    }

    @Override
    public boolean delete(Long id) {
        Titular titular = titularRepository.findById(id).orElse(null);
        if (titular == null){
        return false;
        }
        titularRepository.deleteById(id);
        return true;
    }
}
