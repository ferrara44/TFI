package SistemaElectoral;

import java.util.*;

/**
 *
 * @author kartdei
 */
public class Logic {
    
    public static void main(String[] args){
        Votante juan = new Votante("Juan", "Mascota", 35);
        Votante pedro = new Votante("Pedro", "Surucho", 12);
        Votante luis = new Votante("Luis", "Lopez", 25);
        Votante ana = new Votante("Ana", "Mengana", 24);
        Votante tulio = new Votante("Tulio", "Miguel", 65);
        Votante atos = new Votante("Atos", "Portos", 20);
        Votante aramis = new Votante("Aramis", "Dartagnan", 95);
        Votante laura = new Votante("Laura", "Damas", 85);
        Votante pepa = new Votante("Peppa", "Peeg", 42);
        Votante jaime = new Votante("Jayay", "Avioncito", 31);
        Votante croc = new Votante("Crocodile", "Alligator", 15);

        ArrayList<Votante> listaVotantes = new ArrayList<>(
            Arrays.asList(
            juan, pedro, luis,
            ana, tulio, atos,
            aramis, laura, pepa,
            jaime, croc
            )
        );

        Padron padron = new Padron(listaVotantes);
        
        Partido azul = new Partido("Azul",juan);
        Partido rojo = new Partido("Rojo", pedro);
        
        rojo.agregarVoto();
        
        System.out.println(rojo.getVotos());
    }

}
