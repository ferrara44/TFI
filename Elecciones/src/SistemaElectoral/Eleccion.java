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
    
    public void calcularGanador(){
        Iterator<Partido> iterator = partidos.partidos.iterator();
        String ganador = null;
        String electoNombre = null;
        String electoApellido = null;
        int masVotos = 0;
        while (iterator.hasNext()) {
                Partido p = iterator.next();
                String nombre = p.getNombre();
                int votos = p.getVotos();
                if (votos > masVotos){
                    electoNombre = p.getCandidato().getNombre();
                    electoApellido = p.getCandidato().getApellido();
                    masVotos = votos;
                    ganador = nombre;
                }
                System.out.println();
                System.out.println("Partido " + nombre + " tiene " + votos + " votos. (" + (votos*100/this.nVotos) + "%)");
                }
        System.out.println("El partido ganador es " + ganador + " con una base de " + masVotos + " votos.");
        System.out.println("A esto se le suman " + this.blancos + " votos en blanco. Total: " + (this.blancos+masVotos) + " votos. (" + ((this.blancos+masVotos)*100/this.nVotos) +"%)");
        System.out.println(electoNombre +" "+ electoApellido + " ha ganado las elecciones.");
    }
    
}
