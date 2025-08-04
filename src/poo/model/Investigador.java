package poo.model;

import poo.util.ExportableACSV;

public class Investigador implements ExportableACSV {
    private String nombre;
    private String especialidad;

    // Constructor principal
    public Investigador(String nombre, String especialidad) {
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    // Constructor vacío (requerido para fromCSV)
    public Investigador() {}

    //=== Implementación CSV ===//
    @Override
    public String toCSV() {
        return String.format("%s,%s",
            nombre.replace(",", "\\,"),  // Escapa comas
            especialidad.replace(",", "\\,"));
    }

    @Override
    public void fromCSV(String lineaCSV) {
        String[] datos = lineaCSV.split(",(?=(?:[^\\\\]*\\\\[^\\\\]*\\\\[^\\\\]*\\\\[^\\\\]*\\\\[^\\\\]*\\\\[^\\\\]*$)|(?:[^\\\\]*$))");
        this.nombre = datos[0].replace("\\,", ",");
        this.especialidad = datos.length > 1 ? datos[1].replace("\\,", ",") : "";
    }

    //=== Getters y Setters ===//
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    //=== Método toString() ===//
    @Override
    public String toString() {
        return String.format("%s (%s)", nombre, especialidad);
    }

    //=== Método de clonación ===//
    public Investigador clone() {
        return new Investigador(this.nombre, this.especialidad);
    }
}