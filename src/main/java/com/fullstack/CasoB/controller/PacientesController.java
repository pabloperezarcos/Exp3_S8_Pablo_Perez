package com.fullstack.CasoB.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
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

    @GetMapping
    public List<Pacientes> getPacientes() {
        return pacientesService.getPacientes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPacienteById(@PathVariable int id) {
        return pacientesService.getPacienteById(id);
    }

    @GetMapping("/apellido/{apellido}")
    public ResponseEntity<?> getPacientesByApellido(@PathVariable String apellido) {
        return pacientesService.getPacientesByApellido(apellido);
    }

    @PostMapping
    public Pacientes createPaciente(@RequestBody Pacientes paciente) {
        return pacientesService.createPaciente(paciente);
    }

    @PutMapping("/{id}")
    public Pacientes updatePaciente(@PathVariable int id, @RequestBody Pacientes paciente) {
        return pacientesService.updatePaciente(id, paciente);
    }

    @DeleteMapping("/{id}")
    public void deletePaciente(@PathVariable int id) {
        pacientesService.deletePaciente(id);
    }
}
