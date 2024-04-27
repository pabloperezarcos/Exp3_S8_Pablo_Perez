package com.fullstack.exp3_s8.CasoA.controller;

import com.fullstack.CasoA.controller.UsuariosController; // Importar el controlador del Caso A
import com.fullstack.CasoA.model.Usuarios; // Importar el modelo del Caso A
import com.fullstack.CasoA.service.UsuariosService; // Importar el servicio del Caso A
import org.junit.jupiter.api.Test; // Importar anotaciones de JUnit
import org.springframework.beans.factory.annotation.Autowired; // Para inyección de dependencias
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest; // Para pruebas enfocadas en MVC
import org.springframework.boot.test.mock.mockito.MockBean; // Para simular servicios
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc; // Para pruebas MVC
import org.springframework.http.MediaType; // Para manejar tipos de contenido en solicitudes

import java.util.Optional; // Para manejo de valores opcionales

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*; // Para simular comportamientos con Mockito
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*; // Para realizar solicitudes MVC
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*; // Para verificar resultados

// Prueba solo para el controlador del Caso A
@WebMvcTest(UsuariosController.class)
@ActiveProfiles("casoA") // Activar solo el perfil del Caso A para esta prueba
public class UsuariosControllerTest {

    @Autowired
    private MockMvc mockMvc; // Simulación de solicitudes HTTP

    @MockBean
    private UsuariosService usuariosService; // Simulación del servicio para las pruebas

    @Test
    public void testGetUsuarioById() throws Exception {
        // Simular el comportamiento del servicio
        Usuarios usuario = new Usuarios();
        usuario.setNombre("Pedro Sanchez");
        usuario.setCorreo("pedro.sanchez@example.com");
        usuario.setRol("Cliente");
        usuario.setPassword("12345");

        when(usuariosService.getUsuarioById(1)).thenReturn(Optional.of(usuario)); // Simular la respuesta del servicio

        // Realizar la solicitud y verificar el resultado
        mockMvc.perform(get("/usuarios/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Pedro Sanchez"));
    }

    @Test
    public void testCreateUsuario() throws Exception {
        // Simular el comportamiento del servicio
        Usuarios usuario = new Usuarios();
        usuario.setNombre("María Rodriguez");
        usuario.setCorreo("maria.rodriguez@example.com");
        usuario.setRol("Cliente");
        usuario.setPassword("12345");

        when(usuariosService.createUsuario(any(Usuarios.class))).thenReturn(usuario); // Simular el resultado

        String usuarioJson = "{ \"nombre\": \"María Rodriguez\", \"correo\": \"maria.rodriguez@example.com\", \"rol\": \"Cliente\", \"password\": \"12345\" }";

        // Realizar la solicitud y verificar el resultado
        mockMvc.perform(post("/usuarios")
                .contentType(MediaType.APPLICATION_JSON) // Tipo de contenido
                .content(usuarioJson)) // Datos de la solicitud
                .andExpect(status().isCreated()) // Verificar el estado de respuesta
                .andExpect(content().string("Usuario creado exitosamente con ID: 0")); // Verificar el contenido de la
                                                                                       // respuesta
    }
}
