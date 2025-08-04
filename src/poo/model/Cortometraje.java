package poo.model;

public class Cortometraje extends ContenidoAudiovisual {
    private String festival;
    private int añoEstreno;

    public Cortometraje(String titulo, int duracionEnMinutos, String genero, String festival, int añoEstreno) {
        super(titulo, duracionEnMinutos, genero);
        this.festival = festival;
        this.añoEstreno = añoEstreno;
    }

    // Implementación OBLIGATORIA del método abstracto
    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles del Cortometraje:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración: " + getDuracionEnMinutos() + " minutos");
        System.out.println("Género: " + getGenero());
        System.out.println("Festival: " + this.festival);
        System.out.println("Año de Estreno: " + this.añoEstreno);
        System.out.println(); // Salto de línea
    }

    // Getters y Setters
    public String getFestival() {
        return festival;
    }

    public void setFestival(String festival) {
        this.festival = festival;
    }

    public int getAñoEstreno() {
        return añoEstreno;
    }

    public void setAñoEstreno(int añoEstreno) {
        this.añoEstreno = añoEstreno;
    }
}