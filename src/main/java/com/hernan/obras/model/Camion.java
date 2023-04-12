package com.hernan.obras.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table (name = "camion")
@Data
public class Camion {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String patente;
    private int capacidadCarga;

    @ManyToMany (mappedBy = "camiones")
    private List<Obra> obras;
}
