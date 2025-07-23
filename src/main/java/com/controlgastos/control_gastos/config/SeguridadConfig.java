package com.controlgastos.control_gastos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SeguridadConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Desactiva CSRF
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login","/login.html", "/registro", "/static/**","/js/**","/css/**","/img/").permitAll() // Permite acceso a estas rutas
                        .anyRequest().authenticated() // Requiere autenticación para cualquier otra solicitud
                )
                .formLogin(form -> form
                        .loginPage("/login.html") // Configura la página de login personalizada
                        //.loginProcessingUrl("/login") // URL para procesar el login
                        .defaultSuccessUrl("/index", true)
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout") // Configura la URL de logout
                        .logoutSuccessUrl("/login.html?logout=true") // Redirige tras el logout
                        .permitAll()
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED) // Configura la política de creación de sesiones
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}