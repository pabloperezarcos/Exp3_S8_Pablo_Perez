package com.fullstack.exp3_s8.CasoA.service;

import com.fullstack.CasoA.model.Usuarios;
import com.fullstack.CasoA.service.UsuariosService;
import com.fullstack.CasoA.repository.UsuariosRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
//import org.mockito.Mockito;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class UsuariosServiceTest {

    @Autowired
    private UsuariosService usuariosService;

    @MockBean
    private UsuariosRepository usuariosRepository;

    @Test
    public void testCreateUsuario() {
        Usuarios usuario = new Usuarios();
        usuario.setNombre("Ana Garcia");
        usuario.setCorreo("ana.garcia@example.com");
        usuario.setRol("Cliente");
        usuario.setPassword("12345");

        when(usuariosRepository.save(any(Usuarios.class))).thenReturn(usuario);

        Usuarios created = usuariosService.createUsuario(usuario);

        assertThat(created.getNombre()).isEqualTo("Ana Garcia");
    }

    @Test
    public void testGetUsuarioById() {
        Usuarios usuario = new Usuarios();
        usuario.setNombre("Carlos Lopez");
        usuario.setCorreo("carlos.lopez@example.com");
        usuario.setRol("Cliente");
        usuario.setPassword("12345");

        when(usuariosRepository.findById(1)).thenReturn(Optional.of(usuario));

        Optional<Usuarios> found = usuariosService.getUsuarioById(1);

        assertThat(found).isPresent();
        assertThat(found.get().getNombre()).isEqualTo("Carlos Lopez");
    }
}
