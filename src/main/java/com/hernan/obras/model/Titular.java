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

    @OneToMany
    @JoinColumn (name = "titular_id", referencedColumnName = "id")
    private List<Camion> camiones;

    @OneToMany
    @JoinColumn (name = "titular_id", referencedColumnName = "id")
    private List<Pago> pagos;
}
