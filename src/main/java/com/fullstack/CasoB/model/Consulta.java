package com.fullstack.CasoB.model;

// Importaciones necesarias para las anotaciones JPA y para la validación de datos
import jakarta.persistence.Column; // Para especificar el mapeo de una columna de base de datos a un atributo de entidad Java
import jakarta.persistence.Entity; // Para indicar que una clase Java es una entidad JPA
import jakarta.persistence.GeneratedValue; // Para especificar cómo se generan los valores de clave primaria para una entidad
import jakarta.persistence.GenerationType; // Enumeración que define los diferentes tipos de estrategias de generación de claves primarias
import jakarta.persistence.Id; // Para especificar que un atributo es una clave primaria de la entidad
import jakarta.persistence.Table; // Para especificar el nombre de la tabla en la base de datos a la que se mapea la entidad
import jakarta.persistence.SequenceGenerator; // Para especificar el uso de una secuencia en la generación de claves primarias
import javax.validation.constraints.NotBlank; // Para la validación de datos

import java.util.Date; // Importación para el tipo de dato Date

// Clase que representa la entidad Consulta en la base de datos
@Entity
@Table(name = "consultas")
@SequenceGenerator(name = "consultaSeq", sequenceName = "consultas_seq", allocationSize = 1)
public class Consulta {

    // Identificador único de la consulta
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "consultaSeq")
    @Column(name = "id")
    private int id;

    // Fecha de la consulta
    @NotBlank(message = "La fecha de la consulta es obligatoria")
    @Column(name = "fecha")
    private Date fecha;

    // Motivo de la consulta
    @NotBlank(message = "El motivo de la consulta es obligatorio")
    @Column(name = "motivo")
    private String motivo;

    // Diagnóstico de la consulta
    @NotBlank(message = "El diagnóstico de la consulta es obligatorio")
    @Column(name = "diagnostico")
    private String diagnostico;

    // ID del paciente asociado a la consulta
    @Column(name = "id_paciente")
    private int idPaciente;

    // Constructor vacío
    public Consulta() {
    }

    // Getters para obtener los valores de los atributos
    public int getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getMotivo() {
        return motivo;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    // Setters para establecer los valores de los atributos
    public void setId(int id) {
        this.id = id;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }
}
