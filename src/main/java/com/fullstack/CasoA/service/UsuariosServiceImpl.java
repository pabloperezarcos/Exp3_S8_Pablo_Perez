package com.fullstack.CasoA.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;

import com.fullstack.CasoA.model.Usuarios;
import com.fullstack.CasoA.repository.UsuariosRepository;

import java.util.List; // Importación para Listas
import java.util.Optional; // Importación para Optional (para manejar posibles valores nulos)

// Implementación de los métodos definidos en PeliculasService
@Service
public class UsuariosServiceImpl implements UsuariosService {
    @Autowired
    private UsuariosRepository usuariosRepository;

    // Obtener todas los usuarios
    @Override
    public List<Usuarios> getUsuarios() {
        return usuariosRepository.findAll();
    }

    // Obtener un usuario por su ID
    @SuppressWarnings("null")
    @Override
    public Optional<Usuarios> getUsuarioById(int id) {
        return usuariosRepository.findById(id);
    }

    // Crear un nuevo usuario
    @SuppressWarnings("null")
    @Override
    public Usuarios createUsuario(Usuarios usuario) {
        return usuariosRepository.save(usuario);
    }

    // Actualizar un usuario existente
    @SuppressWarnings("null")
    @Override
    public Usuarios updateUsuario(int id, Usuarios usuario) {
        if (usuariosRepository.existsById(id)) {
            usuario.setId(id);
            return usuariosRepository.save(usuario);
        } else {
            // Manejar el caso cuando el usuario no existe
            return null;
        }
    }

    // Eliminar un usuario por su ID
    @SuppressWarnings("null")
    @Override
    public void deleteUsuario(int id) {
        usuariosRepository.deleteById(id);
    }

        // Implementación del nuevo método para buscar usuario por correo electrónico
        @Override
        public Optional<Usuarios> getUsuarioByCorreo(String correo) {
            return usuariosRepository.findByCorreo(correo);
        }
        
}
