package com.controlgastos.control_gastos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SeguridadConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Desactiva CSRF
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login","/login.html", "/registro", "/static/**").permitAll() // Permite acceso a estas rutas
                        .anyRequest().authenticated() // Requiere autenticación para cualquier otra solicitud
                )
                .formLogin(form -> form
                        .loginPage("/login.html") // Configura la página de login personalizada
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout") // Configura la URL de logout
                        .logoutSuccessUrl("/login.html?logout=true") // Redirige tras el logout
                        .permitAll()
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}