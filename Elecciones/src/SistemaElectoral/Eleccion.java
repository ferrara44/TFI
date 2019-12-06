package SistemaElectoral;

import java.util.*;

/**
 *
 * @author kartdei
 */
public class Eleccion {
    Padron padron;
    Lista partidos;
    int nVotos;
    int blancos;
    int nulos;

    public Eleccion(Padron padron, Lista partidos) {
        this.padron = padron;
        this.partidos = partidos;
        this.nVotos = 0;
        this.nulos = 0;
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

    public int getnVotos() {
        return nVotos;
    }

    public int getBlancos() {
        return blancos;
    }

    public int getNulos() {
        return nulos;
    }
    
    
    
}
