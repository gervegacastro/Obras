package com.hernan.obras.DTO;

import com.hernan.obras.model.Titular;
import lombok.Data;

@Data
public class CamionDTO {

    private Long id;
    private String patente;
    private int capacidadCarga;
    private Titular titular;
}
