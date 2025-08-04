package poo.model;

import poo.util.ExportableACSV;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SerieDeTV extends ContenidoAudiovisual implements ExportableACSV {
    private List<Temporada> temporadas;

    // Constructor sin parámetros (requerido para FileManager)
    public SerieDeTV() {
        super();
        this.temporadas = new ArrayList<>();
    }

    // Constructor principal
    public SerieDeTV(String titulo, int duracionEpisodio, String genero, int temporadasIniciales) {
        super(titulo, duracionEpisodio, genero);
        this.temporadas = new ArrayList<>();
        if (temporadasIniciales > 0) {
            for (int i = 1; i <= temporadasIniciales; i++) {
                this.temporadas.add(new Temporada(i, 10)); // 10 capítulos por defecto
            }
        }
    }

    //=== Implementación CSV ===//
    @Override
    public String toCSV() {
        String baseCSV = super.toCSV();
        String temporadasCSV = temporadas.stream()
            .map(Temporada::toCSV)
            .collect(Collectors.joining("|"));
        
        return String.format("%s,%d,%s", 
            baseCSV,
            temporadas.size(),
            temporadasCSV);
    }

    @Override
    public void fromCSV(String lineaCSV) {
        String[] partes = lineaCSV.split(",(?=(?:[^\\\\]*\\\\[^\\\\]*)*[^\\\\]*$)", -1);
        
        // Parte 1-4: Datos base (id,titulo,duracion,genero)
        super.fromCSV(String.join(",", partes[0], partes[1], partes[2], partes[3]));
        
        // Parte 5: Número de temporadas (ya no se usa, se calcula)
        // Parte 6: Lista de temporadas
        if (partes.length > 5 && !partes[5].isEmpty()) {
            String[] tempsCSV = partes[5].split("\\|");
            for (String tempCSV : tempsCSV) {
                Temporada t = new Temporada();
                t.fromCSV(tempCSV);
                this.temporadas.add(t);
            }
        }
    }

    //=== Métodos de gestión de temporadas ===//
    public boolean agregarTemporada(Temporada temporada) {
        if (temporada == null) {
            throw new IllegalArgumentException("La temporada no puede ser nula");
        }
        if (existeTemporada(temporada.getNumero())) {
            return false;
        }
        return temporadas.add(temporada);
    }

    private boolean existeTemporada(int numeroTemporada) {
        return temporadas.stream().anyMatch(t -> t.getNumero() == numeroTemporada);
    }

    //=== Factory Method para FileManager ===//
    public static SerieDeTV fromCSVStatic(String lineaCSV) {
        SerieDeTV serie = new SerieDeTV();
        serie.fromCSV(lineaCSV);
        return serie;
    }

    //=== Getters ===//
    public List<Temporada> getTemporadas() {
        return new ArrayList<>(temporadas); // Copia defensiva
    }

    //=== Visualización ===//
    @Override
    public void mostrarDetalles() {
        System.out.println("\n=== SERIE DE TV ===");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración por episodio: " + getDuracionEnMinutos() + " min");
        System.out.println("Género: " + getGenero());
        System.out.println("Total temporadas: " + temporadas.size());
        
        temporadas.forEach(t -> {
            System.out.printf("  - Temporada %d: %d capítulos\n", 
                t.getNumero(), t.getCapitulos());
        });
    }
}