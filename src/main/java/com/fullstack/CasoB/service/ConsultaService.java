package com.fullstack.CasoB.service;

import com.fullstack.CasoB.model.Consulta;
import org.springframework.http.ResponseEntity;

import java.util.List;

// Interfaz que define los métodos para el servicio de consultas
public interface ConsultaService {

    // Método para obtener todas las consultas
    List<Consulta> getConsultas();

    // Método para obtener una consulta por su ID
    ResponseEntity<?> getConsultaById(int id);

    // Método para obtener consultas por su diagnóstico
    ResponseEntity<?> getConsultasByDiagnostico(String diagnostico);

    // Método para crear una nueva consulta
    Consulta createConsulta(Consulta consulta);

    // Método para actualizar una consulta existente
    Consulta updateConsulta(int id, Consulta consulta);

    // Método para eliminar una consulta por su ID
    void deleteConsulta(int id);
}
