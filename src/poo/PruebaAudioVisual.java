package poo;

import poo.model.*;
import poo.util.FileManager;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException; // Importación faltante
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileWriter;

public class PruebaAudioVisual {
    private static final String DIRECTORIO_DATA = "data/";
    private static final String ARCHIVO_CONTENIDOS = DIRECTORIO_DATA + "contenidos.csv";

    public static void main(String[] args) {
        try {
            // 1. Crear y guardar datos
            List<ContenidoAudiovisual> contenidos = crearDatosPrueba();
            guardarDatos(contenidos);
            
            // 2. Cargar y mostrar
            System.out.println("\n=== CONTENIDOS CARGADOS ===");
            cargarYMostrarDatos();
            
        } catch (Exception e) {
            System.err.println("❌ Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static List<ContenidoAudiovisual> crearDatosPrueba() {
        List<ContenidoAudiovisual> contenidos = new ArrayList<>();
        
        // 1. Crear Película
        Pelicula avatar = new Pelicula("Avatar", 162, "Ciencia Ficción", "20th Century Fox");
        avatar.agregarActor(new Actor("Leonardo DiCaprio", "Protagonista"));
        contenidos.add(avatar);
        
        // 2. Crear Serie (sin duplicar temporadas)
        SerieDeTV got = new SerieDeTV("Game of Thrones", 60, "Fantasía", 1);
        contenidos.add(got);
        
        // 3. Crear Documental
        Documental cosmos = new Documental("Cosmos", 45, "Ciencia", "Astronomía");
        cosmos.setInvestigador(new Investigador("Jane Goodall", "Primatología"));
        contenidos.add(cosmos);
        
        return contenidos;
    }

    private static void guardarDatos(List<ContenidoAudiovisual> contenidos) throws IOException {
        new File(DIRECTORIO_DATA).mkdirs();
        
        try (PrintWriter writer = new PrintWriter(new FileWriter(ARCHIVO_CONTENIDOS))) {
            for (ContenidoAudiovisual contenido : contenidos) {
                writer.println(contenido.toCSV());
            }
        }
        System.out.println("✅ Datos guardados en: " + ARCHIVO_CONTENIDOS);
    }

    private static void cargarYMostrarDatos() throws Exception {
        // Cargar usando Class<T>
        List<Pelicula> peliculas = FileManager.cargarContenidos(ARCHIVO_CONTENIDOS, Pelicula.class);
        List<SerieDeTV> series = FileManager.cargarContenidos(ARCHIVO_CONTENIDOS, SerieDeTV.class);
        List<Documental> docs = FileManager.cargarContenidos(ARCHIVO_CONTENIDOS, Documental.class);
        
        // Mostrar resultados
        mostrarContenidos("🎬 PELÍCULAS", peliculas);
        mostrarContenidos("📺 SERIES", series);
        mostrarContenidos("📝 DOCUMENTALES", docs);
    }

    private static <T extends ContenidoAudiovisual> void mostrarContenidos(String titulo, List<T> contenidos) {
        System.out.println("\n" + titulo);
        if (contenidos.isEmpty()) {
            System.out.println("(No hay registros)");
        } else {
            contenidos.forEach(ContenidoAudiovisual::mostrarDetalles);
        }
    }
}