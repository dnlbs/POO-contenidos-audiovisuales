/**
 * Class Pelicula
 */
package uni1a;

import java.util.ArrayList;
import java.util.List;

// Subclase Pelicula que extiende de ContenidoAudiovisual
public class Pelicula extends ContenidoAudiovisual {
    private String estudio;
    private List<Actor> actores; // Relación de asociación con Actor

    public Pelicula(String titulo, int duracionEnMinutos, String genero, String estudio) {
        super(titulo, duracionEnMinutos, genero);
        this.estudio = estudio;
        this.actores = new ArrayList<>();
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    // Métodos para gestionar actores
    public List<Actor> getActores() {
        return actores;
    }

    public void agregarActor(Actor actor) {
        actores.add(actor);
    }

    public void eliminarActor(Actor actor) {
        actores.remove(actor);
    }

    public void mostrarActores() {
        if (actores.isEmpty()) {
            System.out.println("No hay actores registrados para esta película.");
        } else {
            System.out.println("Actores de la película:");
            for (Actor actor : actores) {
                System.out.println("- " + actor.getNombreCompleto());
            }
        }
        System.out.println();
    }
    
    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles de la película:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración en minutos: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Estudio: " + estudio);
        mostrarActores();
    }
}