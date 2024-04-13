package com.fullstack.CasoB.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus; // No se usa, puedes eliminarlo
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return pacientesService.getPacientesByApellido(apellido);
    }

    // Endpoint para crear un nuevo paciente
    @PostMapping
    public Pacientes createPaciente(@RequestBody Pacientes paciente) {
        return pacientesService.createPaciente(paciente);
    }

    // Endpoint para actualizar un paciente existente
    @PutMapping("/{id}")
    public Pacientes updatePaciente(@PathVariable int id, @RequestBody Pacientes paciente) {
        return pacientesService.updatePaciente(id, paciente);
    }

    // Endpoint para eliminar un paciente por su ID
    @DeleteMapping("/{id}")
    public void deletePaciente(@PathVariable int id) {
        pacientesService.deletePaciente(id);
    }
}
