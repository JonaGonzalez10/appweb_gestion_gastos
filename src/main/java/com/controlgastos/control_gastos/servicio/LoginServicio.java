package com.controlgastos.control_gastos.servicio;

import com.controlgastos.control_gastos.modelo.UsuarioModelo;
import com.controlgastos.control_gastos.repositorio.LoginRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginServicio {
    @Autowired
    private LoginRepositorio loginRepositorio;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UsuarioModelo authenticate(String username, String password) {
        UsuarioModelo user = loginRepositorio.findByUsername(username);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            System.out.println("Usuario encontrado: " + user.getUsername());
            return user;
        }
        return null;
    }
}
