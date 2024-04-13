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

// Clase que representa la entidad Pacientes en la base de datos
@Entity
@Table(name = "pacientes")
@SequenceGenerator(name = "pacienteSeq", sequenceName = "pacientes_seq", allocationSize = 1)
public class Pacientes {

    // Identificador único del paciente
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pacienteSeq")
    @Column(name = "id")
    private int id;

    // Nombre del paciente
    @NotBlank(message = "El nombre es obligatorio")
    @Column(name = "nombre")
    private String nombre;

    // Apellido del paciente
    @NotBlank(message = "El apellido es obligatorio")
    @Column(name = "apellido")
    private String apellido;

    // Fecha de nacimiento del paciente
    @NotBlank(message = "La fecha de nacimiento es obligatoria")
    @Column(name = "fecha_nacimiento")
    private String fechaNacimiento;

    // Constructor vacío
    public Pacientes() {
    }

    // Getters para obtener los valores de los atributos
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    // Setters para establecer los valores de los atributos
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
