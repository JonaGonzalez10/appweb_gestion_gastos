package com.controlgastos.control_gastos.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexControlador {
    @GetMapping("/index")
    public String MuestraIndex() {
        return "index";
    }

}
