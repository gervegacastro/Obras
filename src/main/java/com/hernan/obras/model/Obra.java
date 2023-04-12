package com.hernan.obras.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table (name = "obra")
@Data
public class Obra {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fechaInicio;
    private LocalDate fechaFinal;
    private int precioPorMetro;
    private int cantidadMetrosExtraer;


    @ManyToMany
    @JoinTable (
            name = "obra_camion",
            joinColumns = {@JoinColumn(name = "obra_id")},
            inverseJoinColumns = {@JoinColumn(name = "camion_id")}
    )
    @JoinColumn (name = "camion_id", referencedColumnName = "id")
    private List<Camion> camiones;

    @OneToMany
    @JoinColumn (name = "obra_id", referencedColumnName = "id")
    private List<Pago> pagos;

    @OneToMany
    @JoinColumn (name = "obra_id", referencedColumnName = "id")
    private List<Cobro> cobros;
}
