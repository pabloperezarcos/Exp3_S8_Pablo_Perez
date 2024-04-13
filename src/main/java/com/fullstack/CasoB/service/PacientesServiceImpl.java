package com.fullstack.CasoB.service;

import com.fullstack.CasoB.model.Pacientes;
import com.fullstack.CasoB.repository.PacientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacientesServiceImpl implements PacientesService {
    @Autowired
    private PacientesRepository pacientesRepository;

    @Override
    public List<Pacientes> getPacientes() {
        return pacientesRepository.findAll();
    }

    @Override
    public ResponseEntity<?> getPacienteById(int id) {
        Optional<Pacientes> paciente = pacientesRepository.findById(id);
        return paciente.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<?> getPacientesByApellido(String apellido) {
        List<Pacientes> pacientes = pacientesRepository.findByApellidoIgnoreCase(apellido);
        return ResponseEntity.ok(pacientes);
    }

    @Override
    public Pacientes createPaciente(Pacientes paciente) {
        return pacientesRepository.save(paciente);
    }

    @Override
    public Pacientes updatePaciente(int id, Pacientes paciente) {
        paciente.setId(id);
        return pacientesRepository.save(paciente);
    }

    @Override
    public void deletePaciente(int id) {
        pacientesRepository.deleteById(id);
    }
}
