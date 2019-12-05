package SistemaElectoral;

import java.util.*;

/**
 *
 * @author kartdei
 */

public class Padron {
    ArrayList<Votante> votantes;
    ArrayList<Votante> emitidos;
    int nVotos;
    int blancos;
    int nulos;
    boolean urnasCerradas;

    public Padron(ArrayList<Votante> votantes) {
        this.votantes = votantes;
        this.emitidos = null;
        this.nVotos = 0;
        this.blancos = 0;
        this.nulos = 0;
        this.urnasCerradas = false;
    }
    
    void agregarVotante(Votante votante){
        this.votantes.add(votante);
    }
    
    void eliminarVotante(Votante votante){
        this.votantes.remove(votante);
    }
    
    void registrarEmision(Votante votante, Partido partido){
        this.votantes.remove(votante);
        this.emitidos.add(votante);
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

    public boolean isUrnasCerradas() {
        return urnasCerradas;
    }

    public void setUrnasCerradas(boolean urnasCerradas) {
        this.urnasCerradas = urnasCerradas;
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
