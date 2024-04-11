package com.fullstack.CasoA;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuariosController {
    private List<Usuarios> usuarios = new ArrayList<>();

    // Constructor para inicializar la lista de usuarios
    public UsuariosController() {
        // Agregamos usuarios a nuestro Array
        usuarios.add(new Usuarios(1, "Juan Pérez", "juan@gmail.com", "Administrador", "Av. Principal 123"));
        usuarios.add(new Usuarios(2, "María García", "maria@gmail.com", "Cliente", "Calle Secundaria 456"));
        usuarios.add(new Usuarios(3, "Carlos Rodríguez", "carlos@gmail.com", "Cliente", "Av. Central 789"));
        usuarios.add(new Usuarios(4, "Ana Martínez", "ana@gmail.com", "Administrador", "Calle Principal 321"));
        usuarios.add(new Usuarios(5, "Luis López", "luis@gmail.com", "Cliente", "Av. Secundaria 654"));
        usuarios.add(new Usuarios(6, "Laura Sánchez", "laura@gmail.com", "Administrador", "Calle Central 987"));
        usuarios.add(new Usuarios(7, "Pedro González", "pedro@gmail.com", "Cliente", "Av. Norte 147"));
        usuarios.add(new Usuarios(8, "Sofía Díaz", "sofia@gmail.com", "Cliente", "Calle Sur 258"));
        usuarios.add(new Usuarios(9, "Daniel Ramírez", "daniel@gmail.com", "Administrador", "Av. Oeste 369"));
        usuarios.add(new Usuarios(10, "Paula Fernández", "paula@gmail.com", "Cliente", "Calle Este 468"));
    }

    // Método para obtener todos los usuarios
    @GetMapping("/usuarios")
    public List<Usuarios> getUsuarios() {
        System.out.println("Obteniendo todos los usuarios");
        return usuarios;
    }

    // Método para obtener todos los usuarios por su ID
    @GetMapping("/usuarios/{id}")
    public ResponseEntity<?> obtenerUsuarioPorId(@PathVariable int id) {
        System.out.println("Buscando usuario con ID: " + id);
        // Recorremos la lista de usuarios para encontrar el usuario con el ID esperado
        for (Usuarios usuario : usuarios) {
            if (usuario.getId() == id) {
                // Devolver el usuario si se encuentra
                System.out.println("Usuario encontrado: " + usuario);
                return ResponseEntity.ok(usuario);
            }
        }
        // Si no encuentra el usuario, devuelve un mensaje por pantalla.
        String mensaje = "Usuario con ID " + id + " no encontrado";
        System.out.println(mensaje);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensaje);
    }

    // Método para obtener usuarios por rol (filtro)
    @GetMapping("/usuarios/rol/{rol}")
    public ResponseEntity<?> obtenerUsuariosPorRol(@PathVariable String rol) {
        // Creamos una lista para almacenar los usuarios que coincidan con el rol
        List<Usuarios> usuariosPorRol = new ArrayList<>();
        for (Usuarios usuario : usuarios) {
            // Verificamos si el rol del usuario coincide (ignorando mayúsculas/minúsculas)
            if (usuario.getRol().equalsIgnoreCase(rol)) {
                // Si el rol coincide, agregamos el usuario a la lista
                usuariosPorRol.add(usuario);
            }
        }
        // Verificamos si se encontraron usuarios con el rol especificado
        if (!usuariosPorRol.isEmpty()) {
            // Si todo salió bien, devolvemos un código de estado OK y la lista de usuarios
            return ResponseEntity.ok(usuariosPorRol);
        } else {
            // Si no se encontraron usuarios, devolvemos un mensaje de error
            String mensaje = "No se encontraron usuarios con el rol: " + rol;
            System.out.println(mensaje); // Mostramos el mensaje por consola
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensaje);
        }
    }
}