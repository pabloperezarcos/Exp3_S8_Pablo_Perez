package com.fullstack.CasoB.service;

import com.fullstack.CasoB.model.Consulta;
import com.fullstack.CasoB.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaServiceImpl implements ConsultaService {
    @Autowired
    private ConsultaRepository consultaRepository;

    @Override
    public List<Consulta> getConsultas() {
        return consultaRepository.findAll();
    }

    @Override
    public ResponseEntity<?> getConsultaById(int id) {
        Optional<Consulta> consulta = consultaRepository.findById(id);
        return consulta.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<?> getConsultasByDiagnostico(String diagnostico) {
        List<Consulta> consultas = consultaRepository.findByDiagnosticoIgnoreCase(diagnostico);
        return ResponseEntity.ok(consultas);
    }

    @Override
    public Consulta createConsulta(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    @Override
    public Consulta updateConsulta(int id, Consulta consulta) {
        consulta.setId(id);
        return consultaRepository.save(consulta);
    }

    @Override
    public void deleteConsulta(int id) {
        consultaRepository.deleteById(id);
    }
}
