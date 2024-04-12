package com.fullstack.CasoA.repository;

import org.springframework.data.jpa.repository.JpaRepository; // Importación de la interfaz JpaRepository de Spring Data JPA

import com.fullstack.CasoA.model.Usuarios;

import java.util.Optional;

// Interfaz que extiende JpaRepository para realizar operaciones CRUD en la entidad Usuarios
public interface UsuariosRepository extends JpaRepository<Usuarios, Integer> {

    Optional<Usuarios> findByCorreo(String correo);

}
