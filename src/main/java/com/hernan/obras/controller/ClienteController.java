package com.hernan.obras.controller;

import com.hernan.obras.DTO.ClienteDTO;
import com.hernan.obras.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("cliente")
public class ClienteController {

    @Autowired
    IClienteService clienteService;

    @PostMapping
    public ClienteDTO save (@RequestBody ClienteDTO clienteDTO) {
        return clienteService.save(clienteDTO);
    }

    @GetMapping ("/{id}")
    public ClienteDTO find (@PathVariable Long id) {
        return clienteService.find(id);
    }

    @GetMapping
    public List<ClienteDTO> findAll () {
        return clienteService.findAll();
    }

    @PutMapping ("/{id}")
    public String edit (@PathVariable Long id, @RequestBody ClienteDTO clienteDTO) {
        clienteDTO = clienteService.edit(id, clienteDTO);
        if (id == null){
            return "El objeto no existe";
        }
        return "Objeto editado";
    }

    @DeleteMapping ("/{id}")
    public String delete (@PathVariable Long id) {
        if (id == null) {
            return "El objeto no existe";
        }
        clienteService.delete(id);
        return "Objeto eliminado";
    }
}
