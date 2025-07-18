package com.controlgastos.control_gastos.config;

import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
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
                .csrf().disable() // Desactiva CSRF para simplificar la configuración
                .authorizeRequests()
                .requestMatchers("/login.html", "/registro","/static/**").permitAll() // Permite acceso a las páginas de login y registro
                .anyRequest().authenticated() // Requiere autenticación para cualquier otra solicitud
                .and()
                .formLogin().loginPage("/login.html").permitAll() // Configura la página de login personalizada
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/login.html?logout=true").permitAll(); // Configura el logout
        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();


    }
}
