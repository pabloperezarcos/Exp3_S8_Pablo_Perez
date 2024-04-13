package com.fullstack.CasoA.model;

// Anotaciones de JPA para el mapeo de objetos a la base de datos relacional
import jakarta.persistence.Column; // Para especificar el mapeo de una columna de base de datos a un atributo de entidad Java
import jakarta.persistence.Entity; // Para indicar que una clase Java es una entidad JPA
import jakarta.persistence.GeneratedValue; // Para especificar cómo se generan los valores de clave primaria para una entidad
import jakarta.persistence.GenerationType; // Enumeración que define los diferentes tipos de estrategias de generación de claves primarias
import jakarta.persistence.Id; // Para especificar que un atributo es una clave primaria de la entidad
import jakarta.persistence.Table; // Para especificar el nombre de la tabla en la base de datos a la que se mapea la entidad
import jakarta.persistence.SequenceGenerator; // Para especificar el uso de una secuencia en la generación de claves primarias

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

// Clase que representa la entidad Usuarios en la base de datos
@Entity
@Table(name = "usuarios")
@SequenceGenerator(name = "usuarioSeq", sequenceName = "usuarios_seq", allocationSize = 1)
public class Usuarios {

    // Identificador único de usuario
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuarioSeq")
    @Column(name = "id")
    private int id;

    // Nombre del usuario
    @NotBlank(message = "El nombre es obligatorio")
    @Column(name = "nombre")
    private String nombre;

    // Correo electrónico del usuario
    @NotBlank(message = "El correo electrónico es obligatorio")
    @Email(message = "El correo electrónico debe tener un formato válido")
    @Column(name = "correo")
    private String correo;

    // Rol del usuario (Administrador, Cliente, etc.)
    @NotBlank(message = "El rol es obligatorio")
    @Column(name = "rol")
    private String rol;

    // Dirección de despacho del usuario
    @Column(name = "direccion_despacho")
    private String direccionDespacho;

    // Contraseña del usuario
    @NotBlank(message = "La contraseña es obligatoria")
    @Column(name = "password")
    private String password;

    // Constructor
    public Usuarios() {
    }

    // Getters para obtener los valores de los atributos
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getRol() {
        return rol;
    }

    public String getDireccionDespacho() {
        return direccionDespacho;
    }

    public String getPassword() {
        return password;
    }

    // Setters para establecer los valores de los atributos
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public void setDireccionDespacho(String direccionDespacho) {
        this.direccionDespacho = direccionDespacho;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
