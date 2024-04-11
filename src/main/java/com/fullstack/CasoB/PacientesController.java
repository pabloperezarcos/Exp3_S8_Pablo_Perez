package com.fullstack.CasoB;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PacientesController {
    private List<Pacientes> pacientes = new ArrayList<>();

    // Constructor para inicializar la lista de pacientes
    public PacientesController() {
        // Agregamos pacientes a nuestro Array
        pacientes.add(new Pacientes(1, "Juan", "Pérez", "1990-05-15"));
        pacientes.add(new Pacientes(2, "María", "García", "1985-10-20"));
        pacientes.add(new Pacientes(3, "Carlos", "Rodríguez", "1978-03-12"));
        pacientes.add(new Pacientes(4, "Ana", "Martínez", "1995-07-30"));
        pacientes.add(new Pacientes(5, "Luis", "López", "2000-01-25"));
        pacientes.add(new Pacientes(6, "Laura", "Sánchez", "1982-09-08"));
        pacientes.add(new Pacientes(7, "Pedro", "González", "1970-12-03"));
        pacientes.add(new Pacientes(8, "Sofía", "Díaz", "1993-06-18"));
        pacientes.add(new Pacientes(9, "Daniel", "Ramírez", "1988-04-22"));
        pacientes.add(new Pacientes(10, "Paula", "Fernández", "1997-11-10"));
    }

    // Método para obtener todos los pacientes
    @GetMapping("/pacientes")
    public List<Pacientes> getPaciente() {
        System.out.println("Obteniendo todos los pacientes");
        return pacientes;
    }

    // Método para obtener todos los pacientes por su ID
    @GetMapping("/pacientes/{id}")
    public ResponseEntity<?> obtenerpacientePorId(@PathVariable int id) {
        System.out.println("Buscando paciente con ID: " + id);
        // Recorremos la lista de pacientes para encontrar el paciente con el ID esperado
        for (Pacientes paciente : pacientes) {
            if (paciente.getId() == id) {
                // Devolver el paciente si se encuentra
                System.out.println("paciente encontrado: " + paciente);
                return ResponseEntity.ok(paciente);
            }
        }
        // Si no encuentra el paciente, devuelve un mensaje por pantalla.
        String mensaje = "paciente con ID " + id + " no encontrado";
        System.out.println(mensaje);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensaje);
    }

    // Método para obtener pacientes por apellido (filtro)
    @GetMapping("/pacientes/apellido/{apellido}")
    public ResponseEntity<?> obtenerpacientesPorapellido(@PathVariable String apellido) {
        // Creamos una lista para almacenar los pacientes que coincidan con el apellido
        List<Pacientes> pacientesPorapellido = new ArrayList<>();
        for (Pacientes paciente : pacientes) {
            // Verificamos si el apellido del paciente coincide (ignorando mayúsculas/minúsculas)
            if (paciente.getApellido().equalsIgnoreCase(apellido)) {
                // Si el apellido coincide, agregamos el paciente a la lista
                pacientesPorapellido.add(paciente);
            }
        }
        // Verificamos si se encontraron pacientes con el apellido especificado
        if (!pacientesPorapellido.isEmpty()) {
            // Si todo salió bien, devolvemos un código de estado OK y la lista de pacientes
            return ResponseEntity.ok(pacientesPorapellido);
        } else {
            // Si no se encontraron pacientes, devolvemos un mensaje de error
            String mensaje = "No se encontraron pacientes con el apellido: " + apellido;
            System.out.println(mensaje); // Mostramos el mensaje por consola
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensaje);
        }
    }
}