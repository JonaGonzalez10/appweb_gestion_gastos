package com.controlgastos.control_gastos.controlador;

import com.controlgastos.control_gastos.entidades.ControlGastos_entidad;
import com.controlgastos.control_gastos.servicio.ControlGastos_Servicio;
import com.controlgastos.control_gastos.entidades.ControlGastos_entidad_ObtenerGastosxcategoriaSP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping(path = "api/v1/controlGastos")
@CrossOrigin(origins = "http://localhost:63342") // ruta a la que se le permitiran hacer peticiones
@RestController
public class ControlGastos_controlador {

    @Autowired
    private final ControlGastos_Servicio controlGastosServicio;


    // Constructor
    public ControlGastos_controlador(ControlGastos_Servicio controlGastosServicio) {
        this.controlGastosServicio = controlGastosServicio;
    }
    // End of Constructor

    @GetMapping("/{id}")
    public ControlGastos_entidad obtenerPorId(@PathVariable("id") int id){
        return controlGastosServicio.obtenerGastosPorId(id);
    }
    @GetMapping("/")
    public Page<ControlGastos_entidad> obtieneTodo(@RequestParam(defaultValue = "0") int page,
                                                   @RequestParam(defaultValue = "30") int size){
        Pageable pageable = PageRequest.of(page, size);
        return controlGastosServicio.obtenerGastos(pageable);
    }
    @GetMapping("/sumaGastosPorCategoria")
    @CrossOrigin(origins = "http://localhost:63342") // ruta a la que se le permitiran hacer peticiones
    public List<ControlGastos_entidad_ObtenerGastosxcategoriaSP> obtieneSumaGastosPorCategoria(){

        return controlGastosServicio.obtenerSumaGastosPorCategoria();
    }
    @PostMapping("/")
    public void guardaOActualiza(@RequestBody ControlGastos_entidad controlGastos){
        controlGastosServicio.guardaoActualiza(controlGastos);
    }
    @DeleteMapping("/{id}")
    public void guardaOActualiza(@PathVariable("id") int id){

        controlGastosServicio.elimina(id);
    }



}
