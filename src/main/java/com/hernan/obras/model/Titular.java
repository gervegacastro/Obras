package com.hernan.obras.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table (name = "titular")
@Data
public class Titular {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private Long cuit;
    private String nombre;
    private String apellido;
    private Long celular;
    private String mail;

    @OneToMany (mappedBy = "titular")
    private List<Camion> camiones;

    @OneToMany (mappedBy = "titular")
    private List<Pago> pagos;
}
