package com.fullstack.CasoB.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import com.fullstack.CasoB.model.Pacientes;
import com.fullstack.CasoB.service.PacientesService;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacientesController {

    @Autowired
    private PacientesService pacientesService;

    // Endpoint para obtener todos los pacientes
    @GetMapping
    public List<Pacientes> getPacientes() {
        return pacientesService.getPacientes();
    }

    // Endpoint para obtener un paciente por su ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getPacienteById(@PathVariable int id) {
        return pacientesService.getPacienteById(id);
    }

    // Endpoint para obtener pacientes por su apellido
    @GetMapping("/apellido/{apellido}")
    public ResponseEntity<?> getPacientesByApellido(@PathVariable String apellido) {
        ResponseEntity<?> responseEntity = pacientesService.getPacientesByApellido(apellido);

        Object body = responseEntity.getBody();

        if (body instanceof List && !((List<?>) body).isEmpty()) {
            return responseEntity;
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron pacientes con el apellido: " + apellido);
        }
    }

    // Endpoint para crear un nuevo paciente
    @PostMapping
    public ResponseEntity<?> createPaciente(@RequestBody Pacientes paciente) {
        try {
            Pacientes newPaciente = pacientesService.createPaciente(paciente);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Paciente creado exitosamente con ID: " + newPaciente.getId());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al intentar crear un nuevo paciente. Error: " + e.getMessage());
        }
    }

    // Endpoint para actualizar un paciente existente
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePaciente(@PathVariable int id, @RequestBody Pacientes paciente) {
        try {
            Pacientes updatedPaciente = pacientesService.updatePaciente(id, paciente);
            if (updatedPaciente != null) {
                return ResponseEntity.ok("Paciente actualizado exitosamente");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("No se encontró el paciente con ID: " + id);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al intentar actualizar el paciente con ID: " + id + ". Error: " + e.getMessage());
        }
    }

    // Endpoint para eliminar un paciente por su ID
    @DeleteMapping("/pacientes/{id}")
    public ResponseEntity<String> deletePaciente(@PathVariable int id) {
        try {
            pacientesService.deletePaciente(id);
            return ResponseEntity.ok("Paciente con ID " + id + " eliminado exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al intentar eliminar al paciente con ID: " + id);
        }
    }
}
