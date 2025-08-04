/**
 * Class Temporada
 * Representa una temporada de una serie de televisión
 */
package uni1a;

import java.util.ArrayList;
import java.util.List;

public class Temporada {
    private int numeroTemporada;
    private int numeroEpisodios;
    private int duracionPromedioEpisodio; // en minutos
    private String fechaEstreno;
    private String fechaFinalizacion;
    private List<String> episodios; // Lista de nombres de episodios

    public Temporada(int numeroTemporada, int numeroEpisodios, int duracionPromedioEpisodio, 
                     String fechaEstreno, String fechaFinalizacion) {
        this.numeroTemporada = numeroTemporada;
        this.numeroEpisodios = numeroEpisodios;
        this.duracionPromedioEpisodio = duracionPromedioEpisodio;
        this.fechaEstreno = fechaEstreno;
        this.fechaFinalizacion = fechaFinalizacion;
        this.episodios = new ArrayList<>();
    }

    // Getters y Setters
    public int getNumeroTemporada() {
        return numeroTemporada;
    }

    public void setNumeroTemporada(int numeroTemporada) {
        this.numeroTemporada = numeroTemporada;
    }

    public int getNumeroEpisodios() {
        return numeroEpisodios;
    }

    public void setNumeroEpisodios(int numeroEpisodios) {
        this.numeroEpisodios = numeroEpisodios;
    }

    public int getDuracionPromedioEpisodio() {
        return duracionPromedioEpisodio;
    }

    public void setDuracionPromedioEpisodio(int duracionPromedioEpisodio) {
        this.duracionPromedioEpisodio = duracionPromedioEpisodio;
    }

    public String getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(String fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public String getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(String fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public List<String> getEpisodios() {
        return episodios;
    }

    public void setEpisodios(List<String> episodios) {
        this.episodios = episodios;
    }

    // Métodos para gestionar episodios
    public void agregarEpisodio(String nombreEpisodio) {
        episodios.add(nombreEpisodio);
    }

    public void eliminarEpisodio(String nombreEpisodio) {
        episodios.remove(nombreEpisodio);
    }

    public int getDuracionTotalTemporada() {
        return numeroEpisodios * duracionPromedioEpisodio;
    }

    public void mostrarInformacion() {
        System.out.println("Información de la Temporada " + numeroTemporada + ":");
        System.out.println("Número de episodios: " + numeroEpisodios);
        System.out.println("Duración promedio por episodio: " + duracionPromedioEpisodio + " minutos");
        System.out.println("Duración total de la temporada: " + getDuracionTotalTemporada() + " minutos");
        System.out.println("Fecha de estreno: " + fechaEstreno);
        System.out.println("Fecha de finalización: " + fechaFinalizacion);
        
        if (!episodios.isEmpty()) {
            System.out.println("Episodios:");
            for (int i = 0; i < episodios.size(); i++) {
                System.out.println("  " + (i + 1) + ". " + episodios.get(i));
            }
        }
        System.out.println();
    }
} 