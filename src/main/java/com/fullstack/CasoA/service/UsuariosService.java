package com.fullstack.CasoA.service;

import java.util.List; // Importación para Listas
import java.util.Optional; // Importación para Optional (para manejar posibles valores nulos)

import com.fullstack.CasoA.model.Usuarios;

// Interfaz para definir los métodos del servicio UsuariosService
public interface UsuariosService {

    // Obtener todos los usuarios
    List<Usuarios> getUsuarios();

    // Obtener un usuario por su ID
    Optional<Usuarios> getUsuarioById(int id);

    // Crear un nuevo usuario
    Usuarios createUsuario(Usuarios usuario);

    // Actualizar un usuario existente
    Usuarios updateUsuario(int id, Usuarios usuario);

    // Eliminar un usuario por su ID
    void deleteUsuario(int id);

    // Buscar usuario por correo electrónico
    Optional<Usuarios> getUsuarioByCorreo(String correo);

}
