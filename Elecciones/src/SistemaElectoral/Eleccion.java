package SistemaElectoral;

import java.util.*;

/**
 *
 * @author kartdei
 */
public class Eleccion {
    Padron padron;
    ArrayList partidos;
    int nVotos;
    int blancos;
    int nulos;
    boolean urnasCerradas;

    public Eleccion(Padron padron, ArrayList partidos) {
        this.padron = padron;
        this.partidos = partidos;
        this.nVotos = 0;
        this.nulos = 0;
        this.urnasCerradas = false;
    }
    
    void registrarEmision(Votante votante, Partido partido){
        partido.agregarVoto();
        this.nVotos += 1;
    }

    void votoBlanco(){
        this.nVotos +=1;
        this.blancos += 1;
    }
    
    void votoNulo(){
        this.nVotos +=1;
        this.nulos +=1;
    }
    
}
