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


    @ManyToOne
    @JoinColumn (name = "cliente", referencedColumnName = "id")
    private Cliente cliente;

    @ManyToMany
    @JoinTable (
            name = "obra_camion",
            joinColumns = {@JoinColumn(name = "obra_id")},
            inverseJoinColumns = {@JoinColumn(name = "camion_id")}
    )
    @JoinColumn (name = "camion_id", referencedColumnName = "id")
    private List<Camion> camiones;

    @OneToMany (mappedBy = "obra")
    private List<Pago> pagos;

    @OneToMany (mappedBy = "obra")
    private List<Cobro> cobros;
}
