package com.hernan.obras.service;

import com.hernan.obras.DTO.ClienteDTO;

import java.util.List;

public interface IClienteService {

    ClienteDTO save (ClienteDTO clienteDTO);

    ClienteDTO find (Long id);

    List<ClienteDTO> findAll ();

    ClienteDTO edit (Long id, ClienteDTO clienteDTO);

    boolean delete (Long id);
}
