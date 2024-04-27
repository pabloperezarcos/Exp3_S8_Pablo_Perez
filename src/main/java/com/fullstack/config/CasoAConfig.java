package com.fullstack.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("casoA") // Activar solo para el perfil "casoA"
@ComponentScan(basePackages = {"com.fullstack.CasoA"}) // Solo componentes del Caso A
public class CasoAConfig {
    
}
