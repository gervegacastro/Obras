package com.hernan.obras.service.imp;

import com.hernan.obras.DTO.ObraDTO;
import com.hernan.obras.model.Obra;
import com.hernan.obras.repository.IObraRepository;
import com.hernan.obras.service.IObraService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ObraService implements IObraService {

    private IObraRepository obraRepository;
    private ModelMapper modelMapper;

    public ObraService(IObraRepository obraRepository, ModelMapper modelMapper) {
        this.obraRepository = obraRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ObraDTO save(ObraDTO obraDTO) {
        Obra obra = modelMapper.map(obraDTO, Obra.class);
        obra = obraRepository.save(obra);
        return modelMapper.map(obra, ObraDTO.class);
    }

    @Override
    public ObraDTO find(Long id) {
        Obra obra = obraRepository.findById(id).orElse(null);
        if (obra == null){
        return null;
        }
        return modelMapper.map(obra, ObraDTO.class);
    }

    @Override
    public List<ObraDTO> findAll() {
        List<Obra> obras = (List<Obra>) obraRepository.findAll();
        List<ObraDTO> obrasDTO = new ArrayList<>();
        for (Obra obr : obras){
            ObraDTO obraDTO = modelMapper.map(obr, ObraDTO.class);
            obrasDTO.add(obraDTO);
        }
        return obrasDTO;
    }

    @Override
    public ObraDTO edit(Long id, ObraDTO obraDTO) {
        Obra obra = obraRepository.findById(id).orElse(null);
        if (obra == null){
        return null;}
        obra = modelMapper.map(obraDTO, Obra.class);
        obra.setId(id);
        obra = obraRepository.save(obra);
        return modelMapper.map(obra, ObraDTO.class);
    }

    @Override
    public boolean delete(Long id) {
        Obra obra = obraRepository.findById(id).orElse(null);
        if (obra == null){
        return false;
        }
        obraRepository.deleteById(id);
        return true;
    }
}
