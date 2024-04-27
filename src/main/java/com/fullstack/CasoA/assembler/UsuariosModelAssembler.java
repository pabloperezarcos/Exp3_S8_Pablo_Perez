package com.fullstack.CasoA.assembler;

import com.fullstack.CasoA.controller.UsuariosController;
import com.fullstack.CasoA.model.Usuarios;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class UsuariosModelAssembler extends RepresentationModelAssemblerSupport<Usuarios, EntityModel<Usuarios>> {

    // Constructor que define el controlador y el tipo del modelo HATEOAS
    public UsuariosModelAssembler() {
        super(UsuariosController.class, (Class<EntityModel<Usuarios>>) (Class<?>) EntityModel.class); 
    }

    @Override
    public EntityModel<Usuarios> toModel(Usuarios usuario) {
        EntityModel<Usuarios> entityModel = EntityModel.of(usuario);
        entityModel.add(linkTo(methodOn(UsuariosController.class).getUsuarioById(usuario.getId())).withSelfRel());
        entityModel.add(linkTo(methodOn(UsuariosController.class).getUsuarios()).withRel("usuarios"));
        return entityModel;
    }
}
