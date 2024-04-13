package com.fullstack.CasoB.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
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

    @GetMapping
    public List<Consulta> getConsultas() {
        return consultaService.getConsultas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getConsultaById(@PathVariable int id) {
        return consultaService.getConsultaById(id);
    }

    @GetMapping("/diagnostico/{diagnostico}")
    public ResponseEntity<?> getConsultasByDiagnostico(@PathVariable String diagnostico) {
        return consultaService.getConsultasByDiagnostico(diagnostico);
    }

    @PostMapping
    public Consulta createConsulta(@RequestBody Consulta consulta) {
        return consultaService.createConsulta(consulta);
    }

    @PutMapping("/{id}")
    public Consulta updateConsulta(@PathVariable int id, @RequestBody Consulta consulta) {
        return consultaService.updateConsulta(id, consulta);
    }

    @DeleteMapping("/{id}")
    public void deleteConsulta(@PathVariable int id) {
        consultaService.deleteConsulta(id);
    }
}
