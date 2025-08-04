package poo.model;

public class Animacion extends ContenidoAudiovisual {
    private String estudioAnimacion;
    private String tecnica; // Ej: "2D", "3D", "Stop Motion"
    private boolean aptaParaNinos;

    public Animacion(String titulo, int duracionEnMinutos, String genero, 
                    String estudioAnimacion, String tecnica, boolean aptaParaNinos) {
        super(titulo, duracionEnMinutos, genero);
        this.estudioAnimacion = estudioAnimacion;
        this.tecnica = tecnica;
        this.aptaParaNinos = aptaParaNinos;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles de Animación:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración: " + getDuracionEnMinutos() + " minutos");
        System.out.println("Género: " + getGenero());
        System.out.println("Estudio: " + this.estudioAnimacion);
        System.out.println("Técnica: " + this.tecnica);
        System.out.println("Apta para niños: " + (this.aptaParaNinos ? "Sí" : "No"));
        System.out.println();
    }

    // Método adicional para cambiar la técnica de animación
    public void cambiarTecnica(String nuevaTecnica) {
        this.tecnica = nuevaTecnica;
        System.out.println("Técnica actualizada a: " + this.tecnica);
    }

    // Getters y Setters
    public String getEstudioAnimacion() {
        return estudioAnimacion;
    }

    public void setEstudioAnimacion(String estudioAnimacion) {
        this.estudioAnimacion = estudioAnimacion;
    }

    public String getTecnica() {
        return tecnica;
    }

    public boolean isAptaParaNinos() {
        return aptaParaNinos;
    }
}