package com.hernan.obras.service.imp;

import com.hernan.obras.DTO.CamionDTO;
import com.hernan.obras.model.Camion;
import com.hernan.obras.repository.ICamionRepository;
import com.hernan.obras.service.ICamionService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CamionService implements ICamionService {

    private ICamionRepository camionRepository;
    private ModelMapper modelMapper;

    public CamionService(ICamionRepository camionRepository, ModelMapper modelMapper) {
        this.camionRepository = camionRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CamionDTO save (CamionDTO camionDTO) {
        Camion camion = modelMapper.map(camionDTO, Camion.class);
        camion = camionRepository.save(camion);
        return modelMapper.map(camion, CamionDTO.class);
    }

    @Override
    public CamionDTO find (Long id) {
        Camion camion = camionRepository.findById(id).orElse(null);
        if (camion == null){
            return null;
        }
        return modelMapper.map(camion, CamionDTO.class);
    }

    @Override
    public List<CamionDTO> findAll() {
        List<Camion> camiones = (List<Camion>) camionRepository.findAll();
        List<CamionDTO> camionesDTO = new ArrayList<>();
        for (Camion cam : camiones){
            CamionDTO camionDTO = modelMapper.map(cam, CamionDTO.class);
            camionesDTO.add(camionDTO);
        }
        return camionesDTO;
    }

    @Override
    public CamionDTO edit(Long id, CamionDTO camionDTO) {
        Camion camion = camionRepository.findById(id).orElse(null);
        if (camion == null){
            return null;
        }
        camion = modelMapper.map(camionDTO, Camion.class);
        camion.setId(id);
        camion = camionRepository.save(camion);
        return modelMapper.map(camion, CamionDTO.class);
    }

    @Override
    public boolean delete(Long id) {
        Camion camion = camionRepository.findById(id).orElse(null);
        if (camion == null){
        return false;
        }
        camionRepository.deleteById(id);
        return true;
    }
}
