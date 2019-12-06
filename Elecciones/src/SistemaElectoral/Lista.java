package SistemaElectoral;

import java.util.*;

/**
 *
 * @author kartdei
 */
public class Lista {
    
    ArrayList<Partido> partidos;
    

    public Lista(ArrayList<Partido> partidos) {
        this.partidos = partidos;
    }
    
    void agregarPartido(Partido partido){
        this.partidos.add(partido);
    }
    
    boolean eliminarPartido(String nombre){
        Iterator<Partido> iterator = partidos.iterator();
        while (iterator.hasNext()) {
            Partido p = iterator.next();
            if(p.getNombre().equals(nombre)){
                this.partidos.remove(p);
            }
        }
        return false;
    }
    
    public Partido getPartido(String nombre){
        Iterator<Partido> iterator = partidos.iterator();
        while (iterator.hasNext()) {
                Partido p = iterator.next();
                if(p.getNombre().equals(nombre)){
                    return p;
                }
        return null;
    }
    return null;
    }

    public ArrayList<Partido> getPartidos() {
        return partidos;
    }
    
    public void verLista(){   
        
        Iterator<Partido> iterator = partidos.iterator();
        System.out.printf("%-15s %-15s","Nombre","Candidato");
        while (iterator.hasNext()) {
            Partido p = iterator.next();
            String lista =  p.getNombre();
            String nombre = p.getCandidato().getNombre();
            String apellido = p.getCandidato().getApellido();
            System.out.println();
            System.out.printf("%-15s %s %s",lista,nombre,apellido);
        }
    }
}
