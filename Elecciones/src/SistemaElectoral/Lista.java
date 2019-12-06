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
    
    boolean eliminarPartido(int dni){
        Iterator<Partido> iterator = partidos.iterator();
        while (iterator.hasNext()) {
            Partido p = iterator.next();
//            int documento = v.getDNI();
//            if (documento == dni){
//                this.votantes.remove(v);
//                return true;
//            }
        }
        return false;
    }

    public ArrayList<Partido> getPartidos() {
        return partidos;
    }
    
    public void verPadron(){   
        
        Iterator<Partido> iterator = partidos.iterator();
//        System.out.printf("%-15s %-15s %-15s %-15s","Nombre","Apellido","DNI","Voto?");
        while (iterator.hasNext()) {
//            Votante v = iterator.next();
//            String nombre =  v.getNombre();
//            String apellido = v.getApellido();
//            int dni = v.getDNI();
//            boolean voto = v.isEmitido();
//            System.out.println();
//            System.out.printf("%-15s %-15s %-15s %-15s",nombre,apellido,dni,voto);
        }
    }
}
