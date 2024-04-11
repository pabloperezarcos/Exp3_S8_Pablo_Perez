package com.fullstack.CasoA;

public class Usuarios {
    //Agregamos los atributos según se requiera
    private int id;
    private String nombre;
    private String correo;
    private String rol;
    private String direccionDespacho;

    // Constructor
    public Usuarios(int id, String nombre, String correo, String rol, String direccionDespacho) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.rol = rol;
        this.direccionDespacho = direccionDespacho;
    }

    // Getters
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
}
