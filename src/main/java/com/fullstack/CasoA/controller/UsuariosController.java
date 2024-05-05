package com.fullstack.CasoA.controller;

import org.springframework.beans.factory.annotation.Autowired; // Inyección de dependencias
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*; // Anotaciones para REST
import org.springframework.hateoas.EntityModel; // Para HATEOAS
import org.springframework.hateoas.CollectionModel; // Para colecciones HATEOAS
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*; // Construcción de enlaces

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import com.fullstack.CasoA.assembler.UsuariosModelAssembler; // Ensamblador HATEOAS
import com.fullstack.CasoA.service.UsuariosService; // Servicio
import com.fullstack.CasoA.model.Usuarios; // Modelo

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    private UsuariosService usuariosService;

    @Autowired
    private UsuariosModelAssembler usuariosModelAssembler; // Inyectar ensamblador

    // Método para obtener todos los usuarios
    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<Usuarios>>> getUsuarios() {
        List<Usuarios> usuarios = usuariosService.getUsuarios();
        List<EntityModel<Usuarios>> usuariosModelList = usuarios.stream()
                .map(usuariosModelAssembler::toModel)
                .toList();

        CollectionModel<EntityModel<Usuarios>> collectionModel = CollectionModel.of(
                usuariosModelList,
                linkTo(methodOn(UsuariosController.class).getUsuarios()).withSelfRel() // Enlace a sí mismo
        );

        return ResponseEntity.ok(collectionModel);
    }

    // Método para obtener un usuario por su ID
    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Usuarios>> getUsuarioById(@PathVariable int id) {
        Optional<Usuarios> usuarioOptional = usuariosService.getUsuarioById(id);

        if (usuarioOptional.isPresent()) {
            EntityModel<Usuarios> usuarioModel = usuariosModelAssembler.toModel(usuarioOptional.get());
            return ResponseEntity.ok(usuarioModel); // Respuesta exitosa
        } else {
            // Crear un EntityModel vacío pero con enlaces y mensaje para evitar el uso de
            // un valor nulo
            EntityModel<Usuarios> notFoundModel = EntityModel.of(new Usuarios(), // Crear un objeto vacío para cumplir
                                                                                 // el contrato
                    linkTo(methodOn(UsuariosController.class).getUsuarios()).withRel("usuarios"));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFoundModel); // Indicar que no se encontró
        }
    }

    // Método para crear un nuevo usuario
    @PostMapping
    public ResponseEntity<EntityModel<?>> createUsuario(@Valid @RequestBody Usuarios usuario) {
        try {
            Usuarios newUsuario = usuariosService.createUsuario(usuario);
            EntityModel<Usuarios> usuarioModel = usuariosModelAssembler.toModel(newUsuario);
            return ResponseEntity.status(HttpStatus.CREATED).body(usuarioModel); // Usuario con enlaces
        } catch (Exception e) {
            EntityModel<String> errorModel = EntityModel.of("Error al intentar crear el usuario: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorModel); // Manejo de errores
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
    public ResponseEntity<?> deleteUsuario(@PathVariable int id) {
        Optional<Usuarios> usuarioOptional = usuariosService.getUsuarioById(id);
    
        if (usuarioOptional.isPresent()) {
            try {
                usuariosService.deleteUsuario(id);
                return ResponseEntity.ok("Usuario eliminado exitosamente");
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Error al intentar eliminar el usuario: " + e.getMessage());
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontró el usuario");
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
