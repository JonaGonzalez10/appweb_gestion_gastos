package com.controlgastos.control_gastos.repositorio;

import com.quesitoCoding.control_gastos.entidades.ControlGastos_entidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ControlGastos_Repositorio extends JpaRepository<ControlGastos_entidad, Integer>{
    @Procedure(name = "obtenerSumaGastosPorCategoria")
    List<Object[]> obtenerSumaGastosPorCategoria();
}
