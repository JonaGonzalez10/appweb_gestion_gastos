package com.controlgastos.control_gastos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.controlgastos.control_gastos.servicio.ContraseñaEncrypServicio;

@Component
public class EjecucionComando implements CommandLineRunner {
    @Autowired
    private ContraseñaEncrypServicio contraseñaEncrypServicio;
    @Override
    public void run(String... args) throws Exception {
        // Llama al método para encriptar las contraseñas al iniciar la aplicación
        contraseñaEncrypServicio.encriptarContraseña();
    }
}
