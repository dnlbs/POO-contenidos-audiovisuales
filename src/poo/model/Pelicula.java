package poo.model;

import poo.util.ExportableACSV;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Pelicula extends ContenidoAudiovisual implements ExportableACSV {
    private String estudio;
    private List<Actor> actores;

    // Constructor sin parámetros (requerido para FileManager)
    public Pelicula() {
        super();
        this.estudio = "";
        this.actores = new ArrayList<>();
    }

    // Constructor principal
    public Pelicula(String titulo, int duracion, String genero, String estudio) {
        super(titulo, duracion, genero);
        setEstudio(estudio);
        this.actores = new ArrayList<>();
    }

    //=== Implementación CSV ===//
    @Override
    public String toCSV() {
        String baseCSV = super.toCSV();
        String actoresCSV = actores.stream()
            .map(Actor::toCSV)
            .collect(Collectors.joining("|"));
        
        return String.format("%s,%s,%s",
            baseCSV,
            escapeCSV(estudio), // Usa el método default de la interfaz
            actoresCSV);
    }

    @Override
    public void fromCSV(String lineaCSV) {
        String[] partes = lineaCSV.split(",(?=(?:[^\\\\]*\\\\[^\\\\]*)*[^\\\\]*$)", -1);
        
        // Parte 1-4: Datos base (id,titulo,duracion,genero)
        super.fromCSV(String.join(",", partes[0], partes[1], partes[2], partes[3]));
        
        // Parte 5: Estudio
        this.estudio = unescapeCSV(partes[4]);
        
        // Parte 6: Actores (opcional)
        if (partes.length > 5 && !partes[5].isEmpty()) {
            String[] actoresCSV = partes[5].split("\\|");
            for (String actorCSV : actoresCSV) {
                Actor actor = new Actor();
                actor.fromCSV(actorCSV);
                this.actores.add(actor);
            }
        }
    }

    //=== Métodos de negocio ===//
    public void agregarActor(Actor actor) {
        if (actor == null) {
            throw new IllegalArgumentException("El actor no puede ser nulo");
        }
        this.actores.add(actor);
    }

    public List<Actor> getActoresPorPersonaje(String personaje) {
        return actores.stream()
            .filter(a -> a.getPersonaje().equalsIgnoreCase(personaje))
            .collect(Collectors.toList());
    }

    //=== Getters y Setters ===//
    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        if (estudio == null || estudio.trim().isEmpty()) {
            throw new IllegalArgumentException("El estudio no puede estar vacío");
        }
        this.estudio = estudio.trim();
    }

    public List<Actor> getActores() {
        return new ArrayList<>(actores); // Copia defensiva
    }

    //=== Visualización ===//
    @Override
    public void mostrarDetalles() {
        System.out.println("\n=== PELÍCULA ===");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración: " + getDuracionEnMinutos() + " minutos");
        System.out.println("Género: " + getGenero());
        System.out.println("Estudio: " + estudio);
        
        if (!actores.isEmpty()) {
            System.out.println("\nReparto:");
            actores.forEach(a -> System.out.printf("  - %s como %s\n", 
                a.getNombre(), a.getPersonaje()));
        }
    }
}