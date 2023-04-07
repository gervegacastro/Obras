package com.hernan.obras.DTO;

import com.hernan.obras.model.Camion;
import lombok.Data;
import java.util.List;

@Data
public class TitularDTO {

    private Long id;
    private Long cuit;
    private String nombre;
    private String apellido;
    private Long celular;
    private String mail;
    private List<Camion> camiones;
}
