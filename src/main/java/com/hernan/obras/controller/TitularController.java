package com.hernan.obras.controller;

import com.hernan.obras.DTO.TitularDTO;
import com.hernan.obras.service.ITitularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("titular")
public class TitularController {

    @Autowired
    ITitularService titularService;

    @PostMapping
    public TitularDTO save (@RequestBody TitularDTO titularDTO) {
        return titularService.save(titularDTO);
    }

    @GetMapping ("/{id}")
    public TitularDTO find (@PathVariable Long id) {
        return titularService.find(id);
    }

    @GetMapping
    public List<TitularDTO> findAll () {
        return titularService.findAll();
    }

    @PutMapping ("/{id}")
    public String edit (@PathVariable Long id, @RequestBody TitularDTO titularDTO) {
        titularDTO = titularService.edit(id, titularDTO);
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
        titularService.delete(id);
        return "Objeto eliminado";
    }
}
