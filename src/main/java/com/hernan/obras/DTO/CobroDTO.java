package com.hernan.obras.DTO;

import com.hernan.obras.model.Cliente;
import com.hernan.obras.model.Obra;
import lombok.Data;
import java.time.LocalDate;

@Data
public class CobroDTO {

    public Long id;
    public LocalDate fecha;
    public int monto;
    public Cliente cliente;
    public Obra obra;
}
