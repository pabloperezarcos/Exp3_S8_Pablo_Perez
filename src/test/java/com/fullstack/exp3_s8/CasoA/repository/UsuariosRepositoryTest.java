package com.fullstack.exp3_s8.CasoA.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import com.fullstack.CasoA.model.Usuarios;
import com.fullstack.CasoA.repository.UsuariosRepository;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UsuariosRepositoryTest {

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Test
    public void testFindByCorreo() {
        // Crear un usuario de prueba
        Usuarios usuario = new Usuarios();
        usuario.setNombre("Juan Perez");
        usuario.setCorreo("juan.perez@example.com");
        usuario.setRol("Cliente");
        usuario.setPassword("12345");

        // Guardar el usuario y luego buscarlo por correo
        usuariosRepository.save(usuario);
        Optional<Usuarios> found = usuariosRepository.findByCorreo("juan.perez@example.com");

        assertThat(found).isPresent();
        assertThat(found.get().getNombre()).isEqualTo("Juan Perez");
    }
}
