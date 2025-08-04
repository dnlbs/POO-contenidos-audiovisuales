/**
 * Class Actor
 * Representa un actor que puede participar en películas
 */
package uni1a;

public class Actor {
    private String nombre;
    private String apellido;
    private int edad;
    private String nacionalidad;
    private String especialidad; // drama, comedia, acción, etc.

    public Actor(String nombre, String apellido, int edad, String nacionalidad, String especialidad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.nacionalidad = nacionalidad;
        this.especialidad = especialidad;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    public void mostrarInformacion() {
        System.out.println("Información del Actor:");
        System.out.println("Nombre completo: " + getNombreCompleto());
        System.out.println("Edad: " + edad + " años");
        System.out.println("Nacionalidad: " + nacionalidad);
        System.out.println("Especialidad: " + especialidad);
        System.out.println();
    }
} 