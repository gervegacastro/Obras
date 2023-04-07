package com.hernan.obras.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table (name = "pago")
@Data
public class Pago {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fecha;
    public int monto;

    @ManyToOne
    @JoinColumn (name = "obra", referencedColumnName = "id")
    public Obra obra;

    @ManyToOne
    @JoinColumn (name = "titular", referencedColumnName = "id")
    private Titular titular;

}
