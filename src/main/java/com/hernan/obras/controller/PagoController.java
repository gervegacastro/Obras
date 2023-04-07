package com.hernan.obras.controller;

import com.hernan.obras.DTO.PagoDTO;
import com.hernan.obras.service.IPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("pago")
public class PagoController {

    @Autowired
    IPagoService pagoService;

    @PostMapping
    public PagoDTO save (@RequestBody PagoDTO pagoDTO) {
        return pagoService.save(pagoDTO);
    }

    @GetMapping ("/{id}")
    public PagoDTO find (@PathVariable Long id) {
        return pagoService.find(id);
    }

    @GetMapping
    public List<PagoDTO> findAll () {
        return pagoService.findAll();
    }

    @PutMapping ("/{id}")
    public String edit (@PathVariable Long id, @RequestBody PagoDTO pagoDTO) {
        pagoDTO = pagoService.edit(id, pagoDTO);
        if (id == null) {
            return "El objeto no existe";
        }
        return "Objeto editado";
    }

    @DeleteMapping ("/{id}")
    public String delete (@PathVariable Long id) {
        if (id == null) {
            return "El objeto no existe";
        }
        pagoService.delete(id);
        return "Objeto eliminado";
    }
}
