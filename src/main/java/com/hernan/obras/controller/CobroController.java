package com.hernan.obras.controller;

import com.hernan.obras.DTO.CobroDTO;
import com.hernan.obras.service.ICobroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("cobro")
public class CobroController {

    @Autowired
    ICobroService cobroService;

    @PostMapping
    public CobroDTO save (@RequestBody CobroDTO cobroDTO) {
        return cobroService.save(cobroDTO);
    }

    @GetMapping ("/{id}")
    public CobroDTO find (@PathVariable Long id) {
        return cobroService.find(id);
    }

    @GetMapping
    public List<CobroDTO> findAll () {
        return cobroService.findAll();
    }

    @PutMapping ("/{id}")
    public String edit (@PathVariable Long id, @RequestBody CobroDTO cobroDTO) {
        cobroDTO = cobroService.edit(id, cobroDTO);
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
        cobroService.delete(id);
        return "Objeto eliminado";
    }

}
