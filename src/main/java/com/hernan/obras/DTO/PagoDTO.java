package com.hernan.obras.DTO;

import com.hernan.obras.model.Obra;
import com.hernan.obras.model.Titular;
import lombok.Data;
import java.time.LocalDate;

@Data
public class PagoDTO {

    public Long id;
    public LocalDate fecha;
    public int monto;
    public Titular titular;
    public Obra obra;
}
