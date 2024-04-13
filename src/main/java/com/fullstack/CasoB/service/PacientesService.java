package com.fullstack.CasoB.service;

import com.fullstack.CasoB.model.Pacientes;
import org.springframework.http.ResponseEntity;

import java.util.List;

// Interfaz que define los servicios disponibles para la entidad Pacientes
public interface PacientesService {
    
    // Método para obtener todos los pacientes
    List<Pacientes> getPacientes();

    // Método para obtener un paciente por su ID
    ResponseEntity<?> getPacienteById(int id);

    // Método para obtener pacientes por su apellido
    ResponseEntity<?> getPacientesByApellido(String apellido);

    // Método para crear un nuevo paciente
    Pacientes createPaciente(Pacientes paciente);

    // Método para actualizar un paciente existente
    Pacientes updatePaciente(int id, Pacientes paciente);

    // Método para eliminar un paciente por su ID
    void deletePaciente(int id);
}
