package poo.model;

import poo.util.ExportableACSV;

public class Documental extends ContenidoAudiovisual implements ExportableACSV {
    private String tema;
    private Investigador investigador;

    // Constructor sin parámetros (requerido para FileManager)
    public Documental() {
        super();
        this.tema = "";
        this.investigador = null;
    }

    // Constructor principal
    public Documental(String titulo, int duracion, String genero, String tema) {
        super(titulo, duracion, genero);
        setTema(tema);
    }

    //=== Implementación CSV ===//
    @Override
    public String toCSV() {
        String baseCSV = super.toCSV();
        String investigadorCSV = (investigador != null) ? investigador.toCSV() : "null,null";
        
        return String.format("%s,%s,%s",
            baseCSV,
            escapeCSV(tema),
            investigadorCSV);
    }

    @Override
    public void fromCSV(String lineaCSV) {
        String[] partes = lineaCSV.split(",(?=(?:[^\\\\]*\\\\[^\\\\]*)*[^\\\\]*$)", -1);
        
        if (partes.length < 6) {
            throw new IllegalArgumentException("Formato CSV inválido para Documental");
        }

        // Parte 1-4: Datos base (id,titulo,duracion,genero)
        super.fromCSV(String.join(",", partes[0], partes[1], partes[2], partes[3]));
        
        // Parte 5: Tema
        setTema(unescapeCSV(partes[4]));
        
        // Parte 6: Investigador
        if (!partes[5].equals("null,null")) {
            this.investigador = new Investigador();
            investigador.fromCSV(partes[5]);
        } else {
            this.investigador = null;
        }
    }

    //=== Métodos de negocio ===//
    public void setInvestigador(Investigador investigador) {
        this.investigador = investigador;
    }

    public Investigador getInvestigador() {
        return investigador;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        if (tema == null || tema.trim().isEmpty()) {
            throw new IllegalArgumentException("El tema no puede estar vacío");
        }
        this.tema = tema.trim();
    }

    //=== Visualización ===//
    @Override
    public void mostrarDetalles() {
        System.out.println("\n=== DOCUMENTAL ===");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración: " + getDuracionEnMinutos() + " minutos");
        System.out.println("Género: " + getGenero());
        System.out.println("Tema: " + tema);
        
        if (investigador != null) {
            System.out.println("Investigador: " + investigador.getNombre() + 
                             " (" + investigador.getEspecialidad() + ")");
        } else {
            System.out.println("Sin investigador asignado");
        }
    }

    //=== Factory Method ===//
    public static Documental fromCSVStatic(String lineaCSV) {
        Documental doc = new Documental();
        doc.fromCSV(lineaCSV);
        return doc;
    }
}