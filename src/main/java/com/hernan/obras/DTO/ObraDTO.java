package com.hernan.obras.DTO;

import com.hernan.obras.model.Camion;
import com.hernan.obras.model.Cliente;
import com.hernan.obras.model.Cobro;
import com.hernan.obras.model.Pago;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public class ObraDTO {

    private Long id;
    private LocalDate fechaInicio;
    private LocalDate fechaFinal;
    private int precioPorMetro;
    private int cantidadMetrosExtraer;
    private Cliente cliente;
    private List<Camion> camiones;
    private List<Pago> pagos;
    private List<Cobro> cobros;
}
