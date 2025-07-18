package com.controlgastos.control_gastos.controlador;

import com.controlgastos.control_gastos.modelo.UsuarioModelo;
import com.controlgastos.control_gastos.servicio.LoginServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginControlador {

    @Autowired
    private LoginServicio loginServicio;
    @GetMapping
    public String Muestralogin(@RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("error", "Usuario o contraseña incorrectos");
        }
        return "forward:/login.html";
    }

    @PostMapping
    public String login(@RequestParam String username, @RequestParam String password) {
        UsuarioModelo user = loginServicio.authenticate(username, password);
        if (user != null) {
            return "redirect:/index";
        } else {
            /*model.addAttribute("error", "Usuario o contraseña incorrectos");
            return "login";*/
            return "redirect:/login?error=true"; // Redirect to avoid circular view path
        }
    }

}
