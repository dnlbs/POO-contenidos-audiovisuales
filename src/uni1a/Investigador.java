/**
 * Class Investigador
 * Representa un investigador que participa en la creación de documentales
 */
package uni1a;

public class Investigador {
    private String nombre;
    private String apellido;
    private String especialidad; // campo de investigación
    private String institucion; // universidad, centro de investigación, etc.
    private int anosExperiencia;
    private String tituloAcademico; // PhD, MSc, etc.

    public Investigador(String nombre, String apellido, String especialidad, 
                       String institucion, int anosExperiencia, String tituloAcademico) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
        this.institucion = institucion;
        this.anosExperiencia = anosExperiencia;
        this.tituloAcademico = tituloAcademico;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public int getAnosExperiencia() {
        return anosExperiencia;
    }

    public void setAnosExperiencia(int anosExperiencia) {
        this.anosExperiencia = anosExperiencia;
    }

    public String getTituloAcademico() {
        return tituloAcademico;
    }

    public void setTituloAcademico(String tituloAcademico) {
        this.tituloAcademico = tituloAcademico;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    public String getCredenciales() {
        return tituloAcademico + " " + getNombreCompleto();
    }

    public void mostrarInformacion() {
        System.out.println("Información del Investigador:");
        System.out.println("Nombre completo: " + getNombreCompleto());
        System.out.println("Título académico: " + tituloAcademico);
        System.out.println("Especialidad: " + especialidad);
        System.out.println("Institución: " + institucion);
        System.out.println("Años de experiencia: " + anosExperiencia);
        System.out.println();
    }
} 