package com.fullstack.CasoB.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus; // No se usa, puedes eliminarlo
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fullstack.CasoB.model.Consulta;
import com.fullstack.CasoB.service.ConsultaService;

import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    // Endpoint para obtener todas las consultas
    @GetMapping
    public List<Consulta> getConsultas() {
        return consultaService.getConsultas();
    }

    // Endpoint para obtener una consulta por su ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getConsultaById(@PathVariable int id) {
        return consultaService.getConsultaById(id);
    }

    // Endpoint para obtener consultas por su diagnóstico
    @GetMapping("/diagnostico/{diagnostico}")
    public ResponseEntity<?> getConsultasByDiagnostico(@PathVariable String diagnostico) {
        return consultaService.getConsultasByDiagnostico(diagnostico);
    }

    // Endpoint para crear una nueva consulta
    @PostMapping
    public Consulta createConsulta(@RequestBody Consulta consulta) {
        return consultaService.createConsulta(consulta);
    }

    // Endpoint para actualizar una consulta existente
    @PutMapping("/{id}")
    public Consulta updateConsulta(@PathVariable int id, @RequestBody Consulta consulta) {
        return consultaService.updateConsulta(id, consulta);
    }

    // Endpoint para eliminar una consulta por su ID
    @DeleteMapping("/{id}")
    public void deleteConsulta(@PathVariable int id) {
        consultaService.deleteConsulta(id);
    }
}
