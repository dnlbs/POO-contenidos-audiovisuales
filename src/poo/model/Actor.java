package poo.model;

import poo.util.ExportableACSV;

public class Actor implements ExportableACSV {
    private String nombre;
    private String personaje;

    // Constructor principal (para creación manual)
    public Actor(String nombre, String personaje) {
        this.nombre = nombre;
        this.personaje = personaje;
    }

    // Constructor vacío (OBLIGATORIO para FileManager)
    public Actor() {}

    @Override
    public String toCSV() {
        return String.format("%s,%s",
            nombre.replace(",", "\\,"),  // Escapa comas con backslash
            personaje.replace(",", "\\,"));
    }

    @Override
    public void fromCSV(String lineaCSV) {
        // Regex que ignora comas escapadas
        String[] datos = lineaCSV.split("(?<!\\\\),");
        this.nombre = datos[0].replace("\\,", ",");
        this.personaje = datos[1].replace("\\,", ",");
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPersonaje() {
        return personaje;
    }

    public void setPersonaje(String personaje) {
        this.personaje = personaje;
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", nombre, personaje);
    }
}