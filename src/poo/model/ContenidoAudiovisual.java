package poo.model;

import poo.util.ExportableACSV;

public abstract class ContenidoAudiovisual implements ExportableACSV {
    protected int id;
    protected String titulo;
    protected int duracionEnMinutos;
    protected String genero;

    // Constructor sin parámetros (OBLIGATORIO para FileManager)
    public ContenidoAudiovisual() {
        this(0, "", 0, ""); // Valores por defecto
    }

    // Constructor con parámetros básicos
    public ContenidoAudiovisual(String titulo, int duracionEnMinutos, String genero) {
        this(0, titulo, duracionEnMinutos, genero); // ID se genera automáticamente
    }

    // Constructor completo (para CSV)
    protected ContenidoAudiovisual(int id, String titulo, int duracionEnMinutos, String genero) {
        this.id = id;
        setTitulo(titulo);
        setDuracionEnMinutos(duracionEnMinutos);
        setGenero(genero);
    }

    //=== Implementación CSV ===//
    @Override
    public String toCSV() {
        return String.format("%d,%s,%d,%s",
            id,
            titulo.replace(",", "\\,"), // Escapar comas
            duracionEnMinutos,
            genero.replace(",", "\\,"));
    }

    @Override
    public void fromCSV(String lineaCSV) {
        String[] partes = lineaCSV.split(",(?=(?:[^\\\\]*\\\\[^\\\\]*)*[^\\\\]*$)", -1);
        
        if (partes.length < 4) {
            throw new IllegalArgumentException("Formato CSV inválido");
        }

        this.id = Integer.parseInt(partes[0]);
        setTitulo(partes[1].replace("\\,", ","));
        setDuracionEnMinutos(Integer.parseInt(partes[2]));
        setGenero(partes[3].replace("\\,", ","));
    }

    //=== Getters y Setters con validación ===//
    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("ID no puede ser negativo");
        }
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("El título no puede estar vacío");
        }
        this.titulo = titulo.trim();
    }

    public int getDuracionEnMinutos() {
        return duracionEnMinutos;
    }

    public void setDuracionEnMinutos(int duracionEnMinutos) {
        if (duracionEnMinutos <= 0) {
            throw new IllegalArgumentException("La duración debe ser positiva");
        }
        this.duracionEnMinutos = duracionEnMinutos;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        if (genero == null || genero.trim().isEmpty()) {
            throw new IllegalArgumentException("El género no puede estar vacío");
        }
        this.genero = genero.trim();
    }

    //=== Método abstracto para mostrar detalles ===//
    public abstract void mostrarDetalles();
}