package com.fullstack.CasoB.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

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
        // Obtiene las consultas por diagnóstico desde el servicio
        ResponseEntity<?> responseEntity = consultaService.getConsultasByDiagnostico(diagnostico);

        // Verifica si se encontraron consultas
        Object body = responseEntity.getBody();
        if (body instanceof List && !((List<?>) body).isEmpty()) {
            // Devuelve las consultas encontradas
            return responseEntity;
        } else {
            // Devuelve un mensaje de error si no se encontraron consultas
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron consultas con el diagnóstico: " + diagnostico);
        }
    }

    // Método para crear una nueva consulta
    @PostMapping
    public ResponseEntity<?> createConsulta(@RequestBody Consulta consulta) {
        try {
            // Crea la consulta y devuelve un mensaje de éxito con el ID de la consulta
            // creada
            Consulta createdConsulta = consultaService.createConsulta(consulta);
            return ResponseEntity.ok("Consulta creada exitosamente con ID: " + createdConsulta.getId());
        } catch (Exception e) {
            // Devuelve un mensaje de error si no se pudo crear la consulta
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al crear la consulta: " + e.getMessage());
        }
    }

    // Método para actualizar una consulta existente
    @PutMapping("/{id}")
    public ResponseEntity<?> updateConsulta(@PathVariable int id, @RequestBody Consulta consulta) {
        try {
            // Actualiza la consulta y devuelve un mensaje de éxito con el ID de la consulta
            // actualizada
            Consulta updatedConsulta = consultaService.updateConsulta(id, consulta);
            return ResponseEntity.ok("Consulta actualizada exitosamente con ID: " + updatedConsulta.getId());
        } catch (Exception e) {
            // Devuelve un mensaje de error si no se pudo actualizar la consulta
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al actualizar la consulta con ID " + id + ": " + e.getMessage());
        }
    }

    // Endpoint para eliminar una consulta por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteConsulta(@PathVariable int id) {
        try {
            // Elimina la consulta y devuelve un mensaje de éxito
            consultaService.deleteConsulta(id);
            return ResponseEntity.ok("Consulta con ID " + id + " eliminada exitosamente");
        } catch (Exception e) {
            // Devuelve un mensaje de error si no se pudo eliminar la consulta
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("No se pudo eliminar la consulta con ID " + id + ". Error: " + e.getMessage());
        }
    }

}
