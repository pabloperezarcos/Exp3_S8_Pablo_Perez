package com.fullstack.CasoB.service;

import com.fullstack.CasoB.model.Consulta;
import com.fullstack.CasoB.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Clase de implementación del servicio de consultas
@Service
public class ConsultaServiceImpl implements ConsultaService {
    @Autowired
    private ConsultaRepository consultaRepository;

    // Método para obtener todas las consultas
    @Override
    public List<Consulta> getConsultas() {
        return consultaRepository.findAll();
    }

    // Método para obtener una consulta por su ID
    @Override
    public ResponseEntity<?> getConsultaById(int id) {
        Optional<Consulta> consulta = consultaRepository.findById(id);
        return consulta.map(c -> {
            EntityModel<Consulta> resource = EntityModel.of(c);
            // resource.add(linkTo(methodOn(ConsultaController.class).getConsultaById(id)).withSelfRel());
            return ResponseEntity.ok(resource);
        }).orElse(ResponseEntity.notFound().build());
    }

    // Método para obtener consultas por su diagnóstico
    @Override
    public ResponseEntity<?> getConsultasByDiagnostico(String diagnostico) {
        List<Consulta> consultas = consultaRepository.findByDiagnosticoIgnoreCase(diagnostico);
        return ResponseEntity.ok(consultas);
    }

    // Método para crear una nueva consulta
    @Override
    public Consulta createConsulta(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    // Método para actualizar una consulta existente
    @Override
    public Consulta updateConsulta(int id, Consulta consulta) {
        consulta.setId(id);
        return consultaRepository.save(consulta);
    }

    // Método para eliminar una consulta por su ID
    @Override
    public void deleteConsulta(int id) {
        consultaRepository.deleteById(id);
    }
}
