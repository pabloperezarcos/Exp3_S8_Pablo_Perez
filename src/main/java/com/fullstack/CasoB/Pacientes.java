package com.fullstack.CasoB;

public class Pacientes {
    // Agregamos los atributos según se requieran
    private int id;
    private String nombre;
    private String apellido;
    private String fechaNacimiento;

    // Constructor
    public Pacientes(int id, String nombre, String apellido, String fechaNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
    }

    // Getters
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
}