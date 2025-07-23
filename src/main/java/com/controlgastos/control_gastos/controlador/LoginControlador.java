package com.controlgastos.control_gastos.controlador;

import com.controlgastos.control_gastos.modelo.UsuarioModelo;
import com.controlgastos.control_gastos.servicio.LoginServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping("/login")
public class LoginControlador {

    @Autowired
    private LoginServicio loginServicio;
    @GetMapping
    public String Muestralogin(@RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null) {
            // Si hay un error, se puede agregar un mensaje al modelo para mostrarlo en la vista
            System.out.println("Error de autenticación: " + error);
            model.addAttribute("error", "Usuario o contraseña incorrectos");
        }
        // Si no hay error, simplemente se muestra la vista de login
        System.out.println("Mostrando vista de login");
        return "forward:/login.html";
    }

    @PostMapping
    public String login(@RequestParam String username, @RequestParam String password) {
        UsuarioModelo user = loginServicio.authenticate(username, password);
        if (user != null) {
            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            System.out.println("Usuario autenticado: " + user.getUsername());
            return "redirect:/index";
        } else {
            System.out.println("Error de autenticación para el usuario: " + username);
            /*model.addAttribute("error", "Usuario o contraseña incorrectos");
            return "login";*/
            return "redirect:/login?error=true"; // Redirect to avoid circular view path
        }
    }

}
