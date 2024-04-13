package com.fullstack.CasoB.service;

import com.fullstack.CasoB.model.Pacientes;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PacientesService {
    List<Pacientes> getPacientes();

    ResponseEntity<?> getPacienteById(int id);

    ResponseEntity<?> getPacientesByApellido(String apellido);

    Pacientes createPaciente(Pacientes paciente);

    Pacientes updatePaciente(int id, Pacientes paciente);

    void deletePaciente(int id);
}
