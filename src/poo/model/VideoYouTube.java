package poo.model;

public class VideoYouTube extends ContenidoAudiovisual {
    private String canal;
    private int likes;

    // Constructor que llama al constructor de la clase padre (ContenidoAudiovisual)
    public VideoYouTube(String titulo, int duracionEnMinutos, String genero, String canal) {
        super(titulo, duracionEnMinutos, genero);  // Obligatorio: llama al constructor padre
        this.canal = canal;
        this.likes = 0;  // Inicializa likes en 0
    }

    // Método para incrementar likes
    public void darLike() {
        likes++;
    }

    // Implementación del método abstracto de la clase padre (OBLIGATORIO)
    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles de VideoYouTube:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración: " + getDuracionEnMinutos() + " minutos");
        System.out.println("Género: " + getGenero());
        System.out.println("Canal: " + this.canal);
        System.out.println("Likes: " + this.likes);
        System.out.println();  // Salto de línea para mejor formato
    }

    // Getters y Setters (opcionales, pero recomendados)
    public String getCanal() {
        return canal;
    }

    public void setCanal(String canal) {
        this.canal = canal;
    }

    public int getLikes() {
        return likes;
    }
}