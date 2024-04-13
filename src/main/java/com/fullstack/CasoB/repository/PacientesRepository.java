package com.fullstack.CasoB.repository;

import com.fullstack.CasoB.model.Pacientes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Repositorio para la entidad Pacientes que extiende JpaRepository para operaciones de base de datos
public interface PacientesRepository extends JpaRepository<Pacientes, Integer> {

    // Método para buscar pacientes por apellido, ignorando mayúsculas y minúsculas
    List<Pacientes> findByApellidoIgnoreCase(String apellido);
}
