package com.fullstack.CasoB.assembler;

import com.fullstack.CasoB.controller.ConsultaController;
import com.fullstack.CasoB.model.Consulta;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ConsultaAssembler implements RepresentationModelAssembler<Consulta, EntityModel<Consulta>> {

    @SuppressWarnings("null")
    @Override
    public EntityModel<Consulta> toModel(Consulta consulta) {
        return EntityModel.of(consulta,
                linkTo(methodOn(ConsultaController.class).getConsultaById(consulta.getId())).withSelfRel(),
                linkTo(methodOn(ConsultaController.class).getConsultas()).withRel("consultas"));
    }
}