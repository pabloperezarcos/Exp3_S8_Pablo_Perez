package com.fullstack.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("casoB") // Activar solo para el perfil "casoB"
@ComponentScan(basePackages = {"com.fullstack.CasoB"}) // Solo componentes del Caso B
public class CasoBConfig {
    
}
