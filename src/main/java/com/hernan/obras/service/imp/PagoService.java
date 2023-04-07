package com.hernan.obras.service.imp;

import com.hernan.obras.DTO.PagoDTO;
import com.hernan.obras.model.Pago;
import com.hernan.obras.repository.IPagoRepository;
import com.hernan.obras.service.IPagoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PagoService implements IPagoService {

    private IPagoRepository pagoRepository;
    private ModelMapper modelMapper;

    public PagoService(IPagoRepository pagoRepository, ModelMapper modelMapper) {
        this.pagoRepository = pagoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PagoDTO save(PagoDTO pagoDTO) {
        Pago pago = modelMapper.map (pagoDTO, Pago.class);
        pago = pagoRepository.save(pago);
        return modelMapper.map (pago, PagoDTO.class);
    }

    @Override
    public PagoDTO find(Long id) {
        Pago pago = pagoRepository.findById(id).orElse(null);
        if (pago == null){
        return null;
        }
        return modelMapper.map (pago, PagoDTO.class);
    }

    @Override
    public List<PagoDTO> findAll() {
        List<Pago> pagos = (List<Pago>) pagoRepository.findAll();
        List<PagoDTO> pagosDTO = new ArrayList<>();
        for (Pago pag : pagos){
            PagoDTO pagoDTO = modelMapper.map (pag, PagoDTO.class);
            pagosDTO.add(pagoDTO);
        }
        return pagosDTO;
    }

    @Override
    public PagoDTO edit(Long id, PagoDTO pagoDTO) {
        Pago pago = pagoRepository.findById(id).orElse(null);
        if (pago == null) {
        return null;
        }
        pago = modelMapper.map (pagoDTO, Pago.class);
        pago.setId(id);
        pago = pagoRepository.save(pago);
        return modelMapper.map (pago, PagoDTO.class);
    }

    @Override
    public boolean delete(Long id) {
        Pago pago = pagoRepository.findById(id).orElse(null);
        if (pago == null){
        return false;
        }
        pagoRepository.deleteById(id);
        return true;
    }
}
