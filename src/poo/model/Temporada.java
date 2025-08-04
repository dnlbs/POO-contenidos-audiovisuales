package poo.model;

import poo.util.ExportableACSV;

public class Temporada implements ExportableACSV {
    private int numero;
    private int capitulos;

    // Constructor principal
    public Temporada(int numero, int capitulos) {
        setNumero(numero);
        setCapitulos(capitulos);
    }

    // Constructor para CSV (sin parámetros)
    public Temporada() {
        this(0, 0); // Valores por defecto que se sobrescribirán al cargar desde CSV
    }

    //=== Implementación CSV ===//
    @Override
    public String toCSV() {
        return String.format("%d,%d", numero, capitulos);
    }

    @Override
    public void fromCSV(String lineaCSV) {
        String[] partes = lineaCSV.split(",");
        if (partes.length != 2) {
            throw new IllegalArgumentException("Formato CSV inválido para Temporada");
        }
        setNumero(Integer.parseInt(partes[0]));
        setCapitulos(Integer.parseInt(partes[1]));
    }

    //=== Getters y Setters con validación ===//
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        if (numero < 0) {
            throw new IllegalArgumentException("El número de temporada no puede ser negativo");
        }
        this.numero = numero;
    }

    public int getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(int capitulos) {
        if (capitulos < 0) {
            throw new IllegalArgumentException("El número de capítulos no puede ser negativo");
        }
        this.capitulos = capitulos;
    }

    //=== Métodos adicionales útiles ===//
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Temporada temporada = (Temporada) obj;
        return numero == temporada.numero;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(numero);
    }

    @Override
    public String toString() {
        return String.format("Temporada %d (%d capítulos)", numero, capitulos);
    }
}