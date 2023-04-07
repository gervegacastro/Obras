package com.hernan.obras.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table (name = "cliente")
@Data
public class Cliente {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreEmpresa;
    private Long cuit;
    private String celular;
    private String mail;
    private String dirección;

    @OneToMany (mappedBy = "cliente")
    private List<Obra> obras;

    @OneToMany (mappedBy = "cliente")
    private List<Cobro> cobros;


}
