package com.fullstack.CasoA.model;

// Anotaciones de JPA para el mapeo de objetos a la base de datos relacional
import jakarta.persistence.Column; // Para especificar el mapeo de una columna de base de datos a un atributo de entidad Java
import jakarta.persistence.Entity; // Para indicar que una clase Java es una entidad JPA
import jakarta.persistence.GeneratedValue; // Para especificar cómo se generan los valores de clave primaria para una entidad
import jakarta.persistence.GenerationType; // Enumeración que define los diferentes tipos de estrategias de generación de claves primarias
import jakarta.persistence.Id; // Para especificar que un atributo es una clave primaria de la entidad
import jakarta.persistence.Table; // Para especificar el nombre de la tabla en la base de datos a la que se mapea la entidad

@Entity
@Table(name = "usuarios")
public class Usuarios {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "correo")
    private String correo;

    @Column(name = "rol")
    private String rol;

    @Column(name = "direccion_despacho")
    private String direccionDespacho;

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
}