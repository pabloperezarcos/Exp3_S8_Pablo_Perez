package com.fullstack.CasoB.service;

import com.fullstack.CasoB.model.Consulta;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ConsultaService {
    List<Consulta> getConsultas();

    ResponseEntity<?> getConsultaById(int id);

    ResponseEntity<?> getConsultasByDiagnostico(String diagnostico);

    Consulta createConsulta(Consulta consulta);

    Consulta updateConsulta(int id, Consulta consulta);

    void deleteConsulta(int id);
}
