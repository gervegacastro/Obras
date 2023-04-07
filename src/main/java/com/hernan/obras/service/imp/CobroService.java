package com.hernan.obras.service.imp;

import com.hernan.obras.DTO.CobroDTO;
import com.hernan.obras.model.Cobro;
import com.hernan.obras.repository.ICobroRepository;
import com.hernan.obras.service.ICobroService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CobroService implements ICobroService {

    private ICobroRepository cobroRepository;
    private ModelMapper modelMapper;

    public CobroService(ICobroRepository cobroRepository, ModelMapper modelMapper) {
        this.cobroRepository = cobroRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public CobroDTO save(CobroDTO cobroDTO) {
        Cobro cobro = modelMapper.map(cobroDTO, Cobro.class);
        cobro = cobroRepository.save(cobro);
        return modelMapper.map(cobro, CobroDTO.class);
    }

    @Override
    public CobroDTO find(Long id) {
        Cobro cobro = cobroRepository.findById(id).orElse(null);
        if (cobro == null){
        return null;
        }
        return modelMapper.map(cobro, CobroDTO.class);
    }

    @Override
    public List<CobroDTO> findAll() {
        List<Cobro> cobros = (List<Cobro>) cobroRepository.findAll();
        List<CobroDTO> cobrosDTO = new ArrayList<>();
        for (Cobro cob : cobros){
            CobroDTO cobroDTO = modelMapper.map(cob, CobroDTO.class);
            cobrosDTO.add(cobroDTO);
        }
        return cobrosDTO;
    }

    @Override
    public CobroDTO edit(Long id, CobroDTO cobroDTO) {
        Cobro cobro = cobroRepository.findById(id).orElse(null);
        if (cobro == null){
        return null;
        }
        cobro = modelMapper.map(cobroDTO, Cobro.class);
        cobro.setId(id);
        cobro = cobroRepository.save(cobro);
        return modelMapper.map (cobro, CobroDTO.class);
    }

    @Override
    public boolean delete(Long id) {
        Cobro cobro = cobroRepository.findById(id).orElse(null);
        if (cobro == null){
        return false;
        }
        cobroRepository.deleteById(id);
        return true;
    }
}
