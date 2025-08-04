package poo.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FileManager {

    public static <T extends ExportableACSV> void guardarContenidos(List<T> objetos, String rutaArchivo) throws IOException {
        new File(rutaArchivo).getParentFile().mkdirs();
        
        try (PrintWriter writer = new PrintWriter(new FileWriter(rutaArchivo))) {
            for (T objeto : objetos) {
                writer.println(objeto.toCSV());
            }
        }
    }

    // Versión con Class<T>
    public static <T extends ExportableACSV> List<T> cargarContenidos(String rutaArchivo, Class<T> clase) throws Exception {
        List<T> objetos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                if (!linea.trim().isEmpty()) {
                    T objeto = clase.getDeclaredConstructor().newInstance();
                    objeto.fromCSV(linea);
                    objetos.add(objeto);
                }
            }
        }
        return objetos;
    }

    // Versión con Function<String, T>
    public static <T extends ExportableACSV> List<T> cargarContenidos(
        String rutaArchivo, 
        Function<String, T> factoryMethod
    ) throws Exception {
        List<T> objetos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                if (!linea.trim().isEmpty()) {
                    objetos.add(factoryMethod.apply(linea));
                }
            }
        }
        return objetos;
    }
}