package SistemaElectoral;

import java.util.*;

/**
 *
 * @author kartdei
 */

public class Padron {
    
    ArrayList<Votante> votantes;
    

    public Padron(ArrayList<Votante> votantes) {
        this.votantes = votantes;
    }
    
    void agregarVotante(Votante votante){
        this.votantes.add(votante);
    }
    
    boolean eliminarVotante(int dni){
        Iterator<Votante> iterator = votantes.iterator();
        while (iterator.hasNext()) {
            Votante v = iterator.next();
            int documento = v.getDNI();
            if (documento == dni){
                this.votantes.remove(v);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Votante> getVotantes() {
        return votantes;
    }
    
    public void verPadron(){   
        
        Iterator<Votante> iterator = votantes.iterator();
        System.out.printf("%-15s %-15s %-15s %-15s","Nombre","Apellido","DNI","Voto?");
        while (iterator.hasNext()) {
            Votante v = iterator.next();
            String nombre =  v.getNombre();
            String apellido = v.getApellido();
            int dni = v.getDNI();
            boolean voto = v.isEmitido();
            System.out.println();
            System.out.printf("%-15s %-15s %-15s %-15s",nombre,apellido,dni,voto);
        }
    }
}
