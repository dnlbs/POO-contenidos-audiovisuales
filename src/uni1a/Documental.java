/**
 * Class Documental
 */
package uni1a;

import java.util.ArrayList;
import java.util.List;

// Subclase Documental que extiende de ContenidoAudiovisual
public class Documental extends ContenidoAudiovisual {
    private String tema;
    private List<Investigador> investigadores; // Relación de asociación con Investigador

    public Documental(String titulo, int duracionEnMinutos, String genero, String tema) {
        super(titulo, duracionEnMinutos, genero);
        this.tema = tema;
        this.investigadores = new ArrayList<>();
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    // Métodos para gestionar investigadores
    public List<Investigador> getInvestigadores() {
        return investigadores;
    }

    public void agregarInvestigador(Investigador investigador) {
        investigadores.add(investigador);
    }

    public void eliminarInvestigador(Investigador investigador) {
        investigadores.remove(investigador);
    }

    public void mostrarInvestigadores() {
        if (investigadores.isEmpty()) {
            System.out.println("No hay investigadores registrados para este documental.");
        } else {
            System.out.println("Investigadores del documental:");
            for (Investigador investigador : investigadores) {
                System.out.println("- " + investigador.getCredenciales() + 
                                 " (" + investigador.getEspecialidad() + ")");
            }
        }
        System.out.println();
    }
    
    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles del documental:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración en minutos: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Tema: " + this.tema);
        mostrarInvestigadores();
    }
}