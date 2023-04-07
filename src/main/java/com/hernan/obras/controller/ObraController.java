package com.hernan.obras.controller;

import com.hernan.obras.DTO.ObraDTO;
import com.hernan.obras.service.IObraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("obra")
public class ObraController {

    @Autowired
    IObraService obraService;

    @PostMapping
    public ObraDTO save (@RequestBody ObraDTO obraDTO) {
        return obraService.save(obraDTO);
    }

    @GetMapping ("/{id}")
    public ObraDTO find (@PathVariable Long id) {
        return obraService.find(id);
    }

    @GetMapping
    public List<ObraDTO> findAll () {
        return obraService.findAll();
    }

    @PutMapping ("/{id}")
    public String edit (@PathVariable Long id, @RequestBody ObraDTO obraDTO) {
        obraDTO = obraService.edit(id, obraDTO);
        if (id == null){
            return "El objeto no se ha encontrado";
        }
        return "Objeto editado";
    }

    @DeleteMapping ("/{id}")
    public String delete (Long id) {
        if (id == null){
            return "El objeto no se ha encontrado";
        }
        obraService.delete(id);
        return "Objeto eliminado";
    }

}
