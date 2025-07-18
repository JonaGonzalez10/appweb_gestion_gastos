package com.controlgastos.control_gastos.servicio;

import com.controlgastos.control_gastos.entidades.ControlGastos_entidad;
import com.controlgastos.control_gastos.entidades.ControlGastos_entidad_ObtenerGastosxcategoriaSP;
import com.controlgastos.control_gastos.repositorio.ControlGastos_Repositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ControlGastos_Servicio {
    @Autowired
    ControlGastos_Repositorio controlGastosRepositorio;

    public Page<ControlGastos_entidad> obtenerGastos(Pageable pageable){

        return controlGastosRepositorio.findAll(pageable);
    }

    public ControlGastos_entidad obtenerGastosPorId(int id){
        return controlGastosRepositorio.findById(id).orElse(null);
    }

    public void guardaoActualiza(ControlGastos_entidad controlGastos){
        controlGastosRepositorio.save(controlGastos);
    }
    public void elimina(int id){

        controlGastosRepositorio.deleteById(id);
    }
    @Transactional
    public List<ControlGastos_entidad_ObtenerGastosxcategoriaSP> obtenerSumaGastosPorCategoria() {
        List<Object[]> resultados = controlGastosRepositorio.obtenerSumaGastosPorCategoria();
        List<ControlGastos_entidad_ObtenerGastosxcategoriaSP> gastos = new ArrayList<>();
        for (Object[] result : resultados) {
            gastos.add(new ControlGastos_entidad_ObtenerGastosxcategoriaSP(result));
        }
        return gastos;
    }

}
