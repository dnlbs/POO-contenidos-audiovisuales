/**
 * Class PruebaRelaciones
 * Demuestra las relaciones implementadas entre las clases
 */
package poo;

import uni1a.*;

public class PruebaRelaciones {
    public static void main(String[] args) {
        System.out.println("=== DEMOSTRACIÓN DE RELACIONES ENTRE CLASES ===\n");

        // 1. Prueba de relación Actor - Película (Asociación)
        System.out.println("1. RELACIÓN ACTOR - PELÍCULA (ASOCIACIÓN)");
        System.out.println("==========================================");
        
        // Crear actores
        Actor actor1 = new Actor("Tom", "Hanks", 65, "Estadounidense", "Drama");
        Actor actor2 = new Actor("Julia", "Roberts", 55, "Estadounidense", "Romance");
        
        // Crear película
        Pelicula pelicula = new Pelicula("Forrest Gump", 142, "Drama", "Paramount Pictures");
        
        // Establecer relación (asociación)
        pelicula.agregarActor(actor1);
        pelicula.agregarActor(actor2);
        
        // Mostrar información
        pelicula.mostrarDetalles();
        actor1.mostrarInformacion();
        actor2.mostrarInformacion();

        // 2. Prueba de relación Temporada - SerieDeTV (Composición)
        System.out.println("2. RELACIÓN TEMPORADA - SERIE DE TV (COMPOSICIÓN)");
        System.out.println("=================================================");
        
        // Crear serie de TV
        SerieDeTV serie = new SerieDeTV("Breaking Bad", 45, "Drama", 0);
        
        // Crear temporadas (composición - las temporadas pertenecen a la serie)
        Temporada temp1 = new Temporada(1, 7, 45, "20/01/2008", "09/03/2008");
        temp1.agregarEpisodio("Pilot");
        temp1.agregarEpisodio("Cat's in the Bag...");
        temp1.agregarEpisodio("...And the Bag's in the River");
        
        Temporada temp2 = new Temporada(2, 13, 45, "08/03/2009", "31/05/2009");
        temp2.agregarEpisodio("Seven Thirty-Seven");
        temp2.agregarEpisodio("Grilled");
        temp2.agregarEpisodio("Bit by a Dead Bee");
        
        // Establecer relación (composición)
        serie.agregarTemporada(temp1);
        serie.agregarTemporada(temp2);
        
        // Mostrar información
        serie.mostrarDetalles();
        temp1.mostrarInformacion();
        temp2.mostrarInformacion();

        // 3. Prueba de relación Investigador - Documental (Asociación)
        System.out.println("3. RELACIÓN INVESTIGADOR - DOCUMENTAL (ASOCIACIÓN)");
        System.out.println("==================================================");
        
        // Crear investigadores
        Investigador inv1 = new Investigador("Carlos", "Méndez", "Biología Marina", 
                                            "Universidad de Guayaquil", 15, "PhD");
        Investigador inv2 = new Investigador("Ana", "García", "Oceanografía", 
                                            "Instituto Oceanográfico", 12, "MSc");
        
        // Crear documental
        Documental documental = new Documental("Los Secretos del Océano", 120, "Científico", 
                                              "Vida marina en las profundidades");
        
        // Establecer relación (asociación)
        documental.agregarInvestigador(inv1);
        documental.agregarInvestigador(inv2);
        
        // Mostrar información
        documental.mostrarDetalles();
        inv1.mostrarInformacion();
        inv2.mostrarInformacion();

        System.out.println("=== FIN DE LA DEMOSTRACIÓN ===");
    }
} 