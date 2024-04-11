package com.fullstack.CasoA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// Importamos esta herramienta para que Spring pueda buscar nuestros directorios.
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
// Usamos la herramienta para que busque en los directorios "CasoA" y "CasoB" para poder trabajar con ambos casos con nuestro archivo main.
@ComponentScan(basePackages = {"com.fullstack.CasoA", "com.fullstack.CasoB"})
public class Exp2S6Application {

	public static void main(String[] args) {
		SpringApplication.run(Exp2S6Application.class, args);
	}

}
