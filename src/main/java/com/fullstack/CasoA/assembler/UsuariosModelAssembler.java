/* 
 * Separamos la lógica para simplificar el mantenimiento del código.
 * Al dividir el ensamblador HATEOAS y el modelo de datos, el código es más modular y fácil de mantener.
 */
package com.fullstack.CasoA.assembler;

import com.fullstack.CasoA.controller.UsuariosController;
import com.fullstack.CasoA.model.Usuarios;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

/**
 * El ensamblador "UsuariosModelAssembler" se encarga de convertir objetos de
 * modelo
 * (como "Usuarios") en EntityModel con enlaces HATEOAS. Esto permite que las
 * respuestas
 * RESTful incluyan enlaces útiles para interactuar con la API.
 */
@Component
public class UsuariosModelAssembler extends RepresentationModelAssemblerSupport<Usuarios, EntityModel<Usuarios>> {

    /**
     * Constructor que especifica el controlador y el tipo del modelo HATEOAS.
     * Utiliza "UsuariosController" como controlador base y "EntityModel<Usuarios>"
     * como tipo de modelo.
     */
    @SuppressWarnings("unchecked")
    public UsuariosModelAssembler() {
        super(UsuariosController.class, (Class<EntityModel<Usuarios>>) (Class<?>) EntityModel.class);
    }

    /**
     * Método para convertir un objeto "Usuarios" en un "EntityModel" que incluye
     * enlaces HATEOAS.
     * Los enlaces se crean utilizando "WebMvcLinkBuilder".
     */
    @SuppressWarnings("null")
    @Override
    public EntityModel<Usuarios> toModel(Usuarios usuario) {
        // Crea un EntityModel a partir del objeto "Usuarios".
        EntityModel<Usuarios> entityModel = EntityModel.of(usuario);

        // Añade un enlace "self" para obtener detalles del usuario.
        entityModel.add(linkTo(methodOn(UsuariosController.class).getUsuarioById(usuario.getId())).withSelfRel());

        // Añade un enlace para obtener todos los usuarios.
        entityModel.add(linkTo(methodOn(UsuariosController.class).getUsuarios()).withRel("usuarios"));

        return entityModel; // Devuelve el EntityModel con enlaces.
    }
}
