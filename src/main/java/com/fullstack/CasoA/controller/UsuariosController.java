package com.fullstack.CasoA.controller;

import org.springframework.beans.factory.annotation.Autowired; // Para la inyección de dependencias
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*; // Para las anotaciones de controlador REST

import javax.validation.Valid;

import com.fullstack.CasoA.model.Usuarios;
import com.fullstack.CasoA.service.UsuariosService;

import java.util.List; // Importación para Listas
import java.util.Optional; // Importación para Optional (para manejar posibles valores nulos)

// Controlador REST para manejar las solicitudes relacionadas con las películas
@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
    @Autowired
    private UsuariosService usuariosService;

    // Método para obtener todos los usuarios
    @GetMapping
    public List<Usuarios> getUsuarios() {
        return usuariosService.getUsuarios();
    }

    // Método para obtener un usuario por su ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getUsuarioById(@PathVariable int id) {
        // Obtiene el usuario por su ID desde el servicio
        Optional<Usuarios> usuarioOptional = usuariosService.getUsuarioById(id);

        // Verifica si se encontró el usuario
        if (usuarioOptional.isPresent()) {
            // Devuelve el usuario encontrado
            Usuarios usuario = usuarioOptional.get();
            return ResponseEntity.ok(usuario);
        } else {
            // Devuelve un mensaje de error si no se encontró el usuario
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontró ningún usuario con el ID: " + id);
        }
    }

    // Método para crear un nuevo usuario
    @PostMapping
    public ResponseEntity<?> createUsuario(@Valid @RequestBody Usuarios usuario) {
        try {
            // Crea el usuario y devuelve un mensaje de éxito con el ID del usuario creado
            Usuarios newUsuario = usuariosService.createUsuario(usuario);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Usuario creado exitosamente con ID: " + newUsuario.getId());
        } catch (Exception e) {
            // Devuelve un mensaje de error si no se pudo crear el usuario
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al intentar crear un nuevo usuario. Error: " + e.getMessage());
        }
    }

    // Método para actualizar un usuario existente
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUsuario(@PathVariable int id, @Valid @RequestBody Usuarios usuario) {
        try {
            // Actualiza el usuario y devuelve un mensaje de éxito
            Usuarios updatedUsuario = usuariosService.updateUsuario(id, usuario);
            if (updatedUsuario != null) {
                return ResponseEntity.ok("Usuario actualizado exitosamente");
            } else {
                // Devuelve un mensaje de error si no se encontró el usuario
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("No se encontró ningún usuario con el ID: " + id);
            }
        } catch (Exception e) {
            // Devuelve un mensaje de error si no se pudo actualizar el usuario
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al intentar actualizar el usuario con ID: " + id + ". Error: " + e.getMessage());
        }
    }

    // Método para eliminar un usuario existente
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUsuario(@PathVariable int id) {
        // Obtiene el usuario por su ID desde el servicio
        Optional<Usuarios> usuarioOptional = usuariosService.getUsuarioById(id);
        if (usuarioOptional.isPresent()) {
            try {
                // Elimina el usuario y devuelve un mensaje de éxito
                usuariosService.deleteUsuario(id);
                return ResponseEntity.ok("Usuario eliminado exitosamente");
            } catch (Exception e) {
                // Devuelve un mensaje de error si no se pudo eliminar el usuario
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Error al intentar eliminar al usuario con ID: " + id);
            }
        } else {
            // Devuelve un mensaje de error si no se encontró el usuario
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontró ningún usuario con el ID: " + id);
        }
    }

    // Método para el inicio de sesión de usuario
    @PostMapping("/login")
    public ResponseEntity<String> loginUsuario(@RequestParam String correo, @RequestParam String password) {
        // Busca el usuario por su correo electrónico
        Optional<Usuarios> usuarioOptional = usuariosService.getUsuarioByCorreo(correo);

        // Verifica si el usuario existe y si la contraseña coincide
        if (usuarioOptional.isPresent() && usuarioOptional.get().getPassword().equals(password)) {
            // Devuelve un mensaje de éxito si el inicio de sesión fue exitoso
            return ResponseEntity.ok("Inicio de sesión exitoso");
        } else {
            // Devuelve un mensaje de error si las credenciales son incorrectas
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas");
        }
    }

}
