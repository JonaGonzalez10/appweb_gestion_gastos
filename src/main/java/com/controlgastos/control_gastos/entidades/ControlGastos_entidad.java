package com.controlgastos.control_gastos.entidades;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Table(name = "tbl_control_gastos")
@Data
//@NamedStoredProcedureQuery(name = "ControlGastos_entidad.obtenerGastosPorId", procedureName = "obtenerSumaGastosPorCategoria")

public class ControlGastos_entidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "America/Mexico_City")
    private Date fecha;
    private String mes;
    private String categoria;
    private String subcategoria;
    private String descripcion;
    private Double monto;
}
