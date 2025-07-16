package com.controlgastos.control_gastos.entidades;

import jakarta.persistence.NamedStoredProcedureQuery;
import lombok.Data;

import java.math.BigDecimal;


@Data
@NamedStoredProcedureQuery(name = "ControlGastos_entidad.obtenerGastosPorId", procedureName = "obtenerSumaGastosPorCategoria")

public class ControlGastos_entidad_ObtenerGastosxcategoriaSP {

    private String Categoria;
    private BigDecimal TotalPorCategoria;

    public ControlGastos_entidad_ObtenerGastosxcategoriaSP(Object[] columnas){
        this.Categoria = (String) columnas[0];
        this.TotalPorCategoria = (BigDecimal) columnas[1];

    }

}
