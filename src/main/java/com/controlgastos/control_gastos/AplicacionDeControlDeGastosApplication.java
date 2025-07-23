package com.controlgastos.control_gastos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@SpringBootApplication
public class AplicacionDeControlDeGastosApplication {

	public static void main(String[] args) {

		SpringApplication.run(AplicacionDeControlDeGastosApplication.class, args);
		//verificarPassword();
	}
	/*private static void verificarPassword() {

	// Instancia del PasswordEncoder
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	// Contraseña en texto plano
	String rawPassword = "America10";

	// Hash almacenado en la base de datos
	String storedHash = "$2a$10$Q5/PkPpSvZ2XRja8bp7OROm16f8egOhkXac80ot8Qaj19IAsH6.3G";

	// Verificar si la contraseña coincide con el hash
	boolean matches = encoder.matches(rawPassword, storedHash);

	// Resultado
        if (matches) {
		System.out.println("La contraseña coincide con el hash almacenado.");
	} else {
		System.out.println("La contraseña NO coincide con el hash almacenado.");
	}
	}*/
}
