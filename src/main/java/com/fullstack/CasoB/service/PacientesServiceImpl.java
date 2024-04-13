package com.fullstack.CasoB.service;

import com.fullstack.CasoB.model.Pacientes;
import com.fullstack.CasoB.repository.PacientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Implementación de los servicios definidos en PacientesService
@Service
public class PacientesServiceImpl implements PacientesService {
    @Autowired
    private PacientesRepository pacientesRepository;

    // Obtiene todos los pacientes
    @Override
    public List<Pacientes> getPacientes() {
        return pacientesRepository.findAll();
    }

    // Obtiene un paciente por su ID
    @Override
    public ResponseEntity<?> getPacienteById(int id) {
        Optional<Pacientes> paciente = pacientesRepository.findById(id);
        return paciente.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Obtiene pacientes por su apellido
    @Override
    public ResponseEntity<?> getPacientesByApellido(String apellido) {
        List<Pacientes> pacientes = pacientesRepository.findByApellidoIgnoreCase(apellido);
        return ResponseEntity.ok(pacientes);
    }

    // Crea un nuevo paciente
    @Override
    public Pacientes createPaciente(Pacientes paciente) {
        return pacientesRepository.save(paciente);
    }

    // Actualiza un paciente existente
    @Override
    public Pacientes updatePaciente(int id, Pacientes paciente) {
        paciente.setId(id);
        return pacientesRepository.save(paciente);
    }

    // Elimina un paciente por su ID
    @Override
    public void deletePaciente(int id) {
        pacientesRepository.deleteById(id);
    }
}
