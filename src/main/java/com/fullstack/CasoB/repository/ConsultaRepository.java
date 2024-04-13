package com.fullstack.CasoB.repository;

import com.fullstack.CasoB.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Repositorio para la entidad Consulta que extiende JpaRepository para operaciones de base de datos
public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {

    // Método para buscar consultas por diagnóstico, ignorando mayúsculas y minúsculas
    List<Consulta> findByDiagnosticoIgnoreCase(String diagnostico);
}
