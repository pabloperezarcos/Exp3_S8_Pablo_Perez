package com.fullstack.CasoB.repository;

import com.fullstack.CasoB.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {
    List<Consulta> findByDiagnosticoIgnoreCase(String diagnostico);
}
