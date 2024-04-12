package com.fullstack.CasoA.controller;

import org.springframework.beans.factory.annotation.Autowired; // Para la inyección de dependencias
import org.springframework.web.bind.annotation.*; // Para las anotaciones de controlador REST
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;

// Importaciones de clases locales
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

    @GetMapping
    public List<Usuarios> getUsuarios() {
        return usuariosService.getUsuarios();
    }

    @GetMapping("/{id}")
    public Optional<Usuarios> getUsuarioById(@PathVariable int id) {
        return usuariosService.getUsuarioById(id);
    }

    @PostMapping
    public Usuarios createUsuario(@RequestBody Usuarios usuario) {
        return usuariosService.createUsuario(usuario);
    }

    @PutMapping("/{id}")
    public Usuarios updateUsuario(@PathVariable int id, @RequestBody Usuarios usuario) {
        return usuariosService.updateUsuario(id, usuario);
    }

    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable int id) {
        usuariosService.deleteUsuario(id);
    }
}

/*
 * // Método para obtener usuarios por rol (filtro)
 * 
 * @GetMapping("/usuarios/rol/{rol}")
 * public ResponseEntity<?> obtenerUsuariosPorRol(@PathVariable String rol) {
 * // Creamos una lista para almacenar los usuarios que coincidan con el rol
 * List<Usuarios> usuariosPorRol = new ArrayList<>();
 * for (Usuarios usuario : usuarios) {
 * // Verificamos si el rol del usuario coincide (ignorando
 * mayúsculas/minúsculas)
 * if (usuario.getRol().equalsIgnoreCase(rol)) {
 * // Si el rol coincide, agregamos el usuario a la lista
 * usuariosPorRol.add(usuario);
 * }
 * }
 * // Verificamos si se encontraron usuarios con el rol especificado
 * if (!usuariosPorRol.isEmpty()) {
 * // Si todo salió bien, devolvemos un código de estado OK y la lista de
 * usuarios
 * return ResponseEntity.ok(usuariosPorRol);
 * } else {
 * // Si no se encontraron usuarios, devolvemos un mensaje de error
 * String mensaje = "No se encontraron usuarios con el rol: " + rol;
 * System.out.println(mensaje); // Mostramos el mensaje por consola
 * return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensaje);
 * }
 * }
 * }
 */