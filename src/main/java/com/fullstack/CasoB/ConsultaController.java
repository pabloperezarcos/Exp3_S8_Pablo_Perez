package com.fullstack.CasoB;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ConsultaController {
    private List<Consulta> consultas = new ArrayList<>();

    // Constructor para inicializar la lista de consultas
    public ConsultaController() {
        consultas.add(new Consulta(1, "2024-03-23", "Dolor de cabeza", "Cefalea tensional", 1));
        consultas.add(new Consulta(2, "2024-03-24", "Dolor de estómago", "Gastritis", 2));
        consultas.add(new Consulta(3, "2024-03-25", "Dolor de espalda", "Lumbalgia", 3));
        consultas.add(new Consulta(4, "2024-03-26", "Fiebre", "Gripe", 4));
        consultas.add(new Consulta(5, "2024-03-27", "Dolor de garganta", "Faringitis", 5));
        consultas.add(new Consulta(6, "2024-03-28", "Fatiga", "Síndrome de fatiga crónica", 6));
        consultas.add(new Consulta(7, "2024-03-29", "Dolor abdominal", "Apendicitis", 7));
        consultas.add(new Consulta(8, "2024-03-30", "Mareos", "Vértigo", 8));
        consultas.add(new Consulta(9, "2024-04-01", "Tos persistente", "Bronquitis", 9));
        consultas.add(new Consulta(10, "2024-04-02", "Dolor en las articulaciones", "Artritis", 10));
    }

    // Método para obtener todas las consultas
    @GetMapping("/consultas")
    public List<Consulta> getConsultas() {
        System.out.println("Obteniendo todas las consultas");
        return consultas;
    }

    // Método para obtener todas los consultas por su ID
    @GetMapping("/consultas/{id}")
    public ResponseEntity<?> obtenerConsultasPorId(@PathVariable int id) {
        System.out.println("Buscando consultas con ID: " + id);
        // Recorremos la lista de consultas para encontrar la consulta con el ID
        // esperado
        for (Consulta consultas : consultas) {
            if (consultas.getId() == id) {
                // Devolver la consulta si se encuentra
                System.out.println("Consulta encontrada Nro: " + consultas);
                return ResponseEntity.ok(consultas);
            }
        }
        // Si no encuentra la consulta, devuelve un mensaje por pantalla.
        String mensaje = "La consulta con ID " + id + " no encontrada";
        System.out.println(mensaje);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensaje);
    }

    // Método para obtener consultas por diagnostico (filtro)
    @GetMapping("/consultas/diagnostico/{diagnostico}")
    public ResponseEntity<?> obtenerconsultasPordiagnostico(@PathVariable String diagnostico) {
        // Creamos una lista para almacenar los consultas que coincidan con el
        // diagnostico
        List<Consulta> consultasporDiagnostico = new ArrayList<>();
        for (Consulta consultas : consultas) {
            // Verificamos si el dianostico de la consulta coincide (ignorando
            // mayúsculas/minúsculas)
            if (consultas.getDiagnostico().equalsIgnoreCase(diagnostico)) {
                // Si el diagnostico coincide, agregamos la consulta a la lista
                consultasporDiagnostico.add(consultas);
            }
        }
        // Verificamos si se encontraron consultas con el diagnostico especificado
        if (!consultasporDiagnostico.isEmpty()) {
            // Si todo salió bien, devolvemos un código de estado OK y la lista de consultas
            return ResponseEntity.ok(consultasporDiagnostico);
        } else {
            // Si no se encontraron consultas, devolvemos un mensaje de error
            String mensaje = "No se encontraron consultas con el diagnóstico: " + diagnostico;
            System.out.println(mensaje); // Mostramos el mensaje por consola
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensaje);
        }
    }

}