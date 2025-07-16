package com.controlgastos.control_gastos.servicio;

import com.quesitoCoding.control_gastos.modelo.UsuarioModelo;
import com.quesitoCoding.control_gastos.repositorio.LoginRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServicio {
    @Autowired
    private LoginRepositorio loginRepositorio;

    public UsuarioModelo findByUsernameAndPassword(String username, String password) {
        return loginRepositorio.findByUsernameAndPassword(username, password);
    }
}
