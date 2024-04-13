package com.fullstack.CasoB.repository;

import com.fullstack.CasoB.model.Pacientes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PacientesRepository extends JpaRepository<Pacientes, Integer> {
    List<Pacientes> findByApellidoIgnoreCase(String apellido);
}
