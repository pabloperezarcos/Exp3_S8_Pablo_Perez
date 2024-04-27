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

@Component
public class UsuariosModelAssembler extends RepresentationModelAssemblerSupport<Usuarios, EntityModel<Usuarios>> {

    @SuppressWarnings("unchecked")
    public UsuariosModelAssembler() {
        super(UsuariosController.class, (Class<EntityModel<Usuarios>>) (Class<?>) EntityModel.class);
    }

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
