package SistemaElectoral;

import java.util.*;

/**
 *
 * @author kartdei
 */

public class Padron {
    
    ArrayList<Votante> votantes;
    ArrayList<Votante> pendientes;

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
        System.out.printf("%-15s %-15s %-15s","Nombre","Apellido","DNI");
        while (iterator.hasNext()) {
            Votante v = iterator.next();
            String nombre =  v.getNombre();
            String apellido = v.getApellido();
            int dni = v.getDNI();
            boolean voto = v.isEmitido();
            System.out.println();
            System.out.printf("%-15s %-15s %-15s",nombre,apellido,dni);
        }
    }
    
    public Votante getVotante(int dni){
        Iterator<Votante> iterator = votantes.iterator();
        while (iterator.hasNext()) {
            Votante v = iterator.next();
            if (dni == v.getDNI()){
                return v;
            }
        }
        return null;
    }
    
    public void inicializarVotacion(){
        this.pendientes = new ArrayList<>(this.votantes);
    }
    
    public void firmarPlanilla(int dni){
        Iterator<Votante> iterator = votantes.iterator();
        while (iterator.hasNext()) {
            Votante v = iterator.next();
            if (v.getDNI() == dni){
                this.pendientes.remove(v);
            }
        }
    }
    
    public int evaluarVotante(int dni){
        Iterator<Votante> iterator = votantes.iterator();
        while (iterator.hasNext()) {
            Votante v = iterator.next();
            if (v.getDNI() == dni){
                Iterator<Votante> reiterator = pendientes.iterator();
                while (reiterator.hasNext()) {
                    Votante w = reiterator.next();
                    if (w.getDNI() == dni){
                        return 1;
                    }
                    return 3;
                }
            }
            else return 2;
        }
        System.out.print("FUUUUCK");
        return 0;
    }
}
