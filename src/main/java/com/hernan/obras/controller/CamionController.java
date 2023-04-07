package com.hernan.obras.controller;

import com.hernan.obras.DTO.CamionDTO;
import com.hernan.obras.service.ICamionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("camion")
public class CamionController {

    @Autowired
    ICamionService camionService;

    @PostMapping
    public CamionDTO save (@RequestBody CamionDTO camionDTO) {
        return camionService.save(camionDTO);
    }

    @GetMapping ("/{id}")
    public CamionDTO find (@PathVariable Long id) {
        return camionService.find(id);
    }

    @GetMapping
    public List<CamionDTO> findAll () {
        return camionService.findAll();
    }

    @PutMapping ("/{id}")
    public String edit (@PathVariable Long id, @RequestBody CamionDTO camionDTO ) {
        camionDTO = camionService.edit(id, camionDTO);
        if (id == null){
            return "El objeto no existe";
        }
        return "Objeto editado";
    }

    @DeleteMapping ("/{id}")
    public String delete (@PathVariable Long id) {
        if (id == null){
            return "El objeto no existe";
        }
        camionService.delete(id);
        return "Objeto eliminado";
    }



}
