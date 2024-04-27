package com.fullstack.exp3_s8.CasoA.controller;

import com.fullstack.CasoA.model.Usuarios;
import com.fullstack.CasoA.service.UsuariosService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;

@WebMvcTest(UsuariosController.class)
public class UsuariosControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsuariosService usuariosService;

    @Test
    public void testGetUsuarioById() throws Exception {
        Usuarios usuario = new Usuarios();
        usuario.setNombre("Pedro Sanchez");
        usuario.setCorreo("pedro.sanchez@example.com");
        usuario.setRol("Cliente");
        usuario.setPassword("12345");

        when(usuariosService.getUsuarioById(1)).thenReturn(Optional.of(usuario));

        mockMvc.perform(get("/usuarios/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Pedro Sanchez"));
    }

    @Test
    public void testCreateUsuario() throws Exception {
        Usuarios usuario = new Usuarios();
        usuario.setNombre("María Rodriguez");
        usuario.setCorreo("maria.rodriguez@example.com");
        usuario.setRol("Cliente");
        usuario.setPassword("12345");

        when(usuariosService.createUsuario(any(Usuarios.class))).thenReturn(usuario);

        String usuarioJson = "{ \"nombre\": \"María Rodriguez\", \"correo\": \"maria.rodriguez@example.com\", \"rol\": \"Cliente\", \"password\": \"12345\" }";

        mockMvc.perform(post("/usuarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(usuarioJson))
                .andExpect(status().isCreated())
                .andExpect(content().string("Usuario creado exitosamente con ID: 0")); // Verifica que el mensaje de éxito se devuelva.
    }
}