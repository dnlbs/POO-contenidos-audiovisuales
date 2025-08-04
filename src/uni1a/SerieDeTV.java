/**
 * Class SerieDeTV
 */
package uni1a;

import java.util.ArrayList;
import java.util.List;

// Subclase SerieDeTV que extiende de ContenidoAudiovisual
public class SerieDeTV extends ContenidoAudiovisual {
    private int temporadas;
    private List<Temporada> listaTemporadas; // Relación de composición con Temporada

    public SerieDeTV(String titulo, int duracionEnMinutos, String genero, int temporadas) {
        super(titulo, duracionEnMinutos, genero);
        this.temporadas = temporadas;
        this.listaTemporadas = new ArrayList<>();
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    // Métodos para gestionar temporadas (composición)
    public List<Temporada> getListaTemporadas() {
        return listaTemporadas;
    }

    public void agregarTemporada(Temporada temporada) {
        listaTemporadas.add(temporada);
        this.temporadas = listaTemporadas.size(); // Actualizar el contador
    }

    public void eliminarTemporada(Temporada temporada) {
        listaTemporadas.remove(temporada);
        this.temporadas = listaTemporadas.size(); // Actualizar el contador
    }

    public Temporada buscarTemporada(int numeroTemporada) {
        for (Temporada temporada : listaTemporadas) {
            if (temporada.getNumeroTemporada() == numeroTemporada) {
                return temporada;
            }
        }
        return null;
    }

    public void mostrarTemporadas() {
        if (listaTemporadas.isEmpty()) {
            System.out.println("No hay temporadas registradas para esta serie.");
        } else {
            System.out.println("Temporadas de la serie:");
            for (Temporada temporada : listaTemporadas) {
                System.out.println("Temporada " + temporada.getNumeroTemporada() + 
                                 " - " + temporada.getNumeroEpisodios() + " episodios");
            }
        }
        System.out.println();
    }
    
    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles de la serie de TV:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración en minutos: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Número de temporadas: " + this.temporadas);
        mostrarTemporadas();
    }
}