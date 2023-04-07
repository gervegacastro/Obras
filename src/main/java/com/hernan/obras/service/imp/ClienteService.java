package com.hernan.obras.service.imp;

import com.hernan.obras.DTO.ClienteDTO;
import com.hernan.obras.model.Cliente;
import com.hernan.obras.repository.IClienteRepository;
import com.hernan.obras.service.IClienteService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService implements IClienteService {

    private IClienteRepository clienteRepository;
    private ModelMapper modelMapper;

    public ClienteService(IClienteRepository clienteRepository, ModelMapper modelMapper) {
        this.clienteRepository = clienteRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ClienteDTO save(ClienteDTO clienteDTO) {
        Cliente cliente = modelMapper.map(clienteDTO, Cliente.class);
        cliente = clienteRepository.save(cliente);
        return modelMapper.map(cliente, ClienteDTO.class);
    }

    @Override
    public ClienteDTO find(Long id) {
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        if (cliente == null){
        return null;
        }
        return modelMapper.map(cliente, ClienteDTO.class);
    }

    @Override
    public List<ClienteDTO> findAll() {
        List<Cliente> clientes = (List<Cliente>) clienteRepository.findAll();
        List<ClienteDTO> clientesDTO = new ArrayList<>();
        for (Cliente cli : clientes){
            ClienteDTO clienteDTO = modelMapper.map(cli, ClienteDTO.class);
            clientesDTO.add(clienteDTO);
        }
        return clientesDTO;
    }

    @Override
    public ClienteDTO edit(Long id, ClienteDTO clienteDTO) {
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        if (cliente == null){
        return null;
        }
        cliente = modelMapper.map(clienteDTO, Cliente.class);
        cliente.setId(id);
        cliente = clienteRepository.save(cliente);
        return modelMapper.map(cliente, ClienteDTO.class);
    }

    @Override
    public boolean delete(Long id) {
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        if (cliente == null){
        return false;
        }
        clienteRepository.deleteById(id);
        return true;
    }
}
