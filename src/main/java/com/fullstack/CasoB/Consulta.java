package com.fullstack.CasoB;

public class Consulta {
    // Agregamos los atributos según se requieran
    private int id;
    private String fecha;
    private String motivo;
    private String diagnostico;
    private int idPaciente;

    // Constructor
    public Consulta(int id, String fecha, String motivo, String diagnostico, int idPaciente) {
        this.id = id;
        this.fecha = fecha;
        this.motivo = motivo;
        this.diagnostico = diagnostico;
        this.idPaciente = idPaciente;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getFecha() {
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
}
