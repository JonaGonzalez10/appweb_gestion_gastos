package com.controlgastos.control_gastos.repositorio;

import com.quesitoCoding.control_gastos.modelo.UsuarioModelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepositorio extends JpaRepository<UsuarioModelo, Long> {
    UsuarioModelo findByUsernameAndPassword(String username, String password);

}
