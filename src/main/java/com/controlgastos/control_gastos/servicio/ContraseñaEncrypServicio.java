package com.controlgastos.control_gastos.servicio;

import com.controlgastos.control_gastos.repositorio.LoginRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.controlgastos.control_gastos.modelo.UsuarioModelo;
import org.springframework.security.crypto.password.PasswordEncoder;
@Service
public class ContraseñaEncrypServicio {
    @Autowired
    private LoginRepositorio loginRepositorio;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public void encriptarContraseña(){
        List<UsuarioModelo> usuarios = loginRepositorio.findAll();
        for (UsuarioModelo usuario : usuarios) {
            if (!usuario.getPassword().startsWith("{bcrypt}")) { // Verifica si la contraseña ya está encriptada
                String contrasenaEncriptada = passwordEncoder.encode(usuario.getPassword());
                usuario.setPassword(contrasenaEncriptada);
                loginRepositorio.save(usuario); // Guarda el usuario con la contraseña encriptada
            }
        }
    }
}
