package com.hernan.obras.DTO;

import com.hernan.obras.model.Obra;
import lombok.Data;
import java.util.List;

@Data
public class ClienteDTO {

    private Long id;
    private String nombreEmpresa;
    private Long cuit;
    private String celular;
    private String mail;
    private String dirección;
    private List<Obra> obras;
}
