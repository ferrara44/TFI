package SistemaElectoral;

/**
 *
 * @author kartdei
 */

public class Votante extends Persona{
    boolean emitido;

    public Votante(String nombre, String apellido, int dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = dni;
        this.emitido = false;
    }
    

    public void setEmitido(boolean emitido) {
        this.emitido = emitido;
    }

    public boolean isEmitido() {
        return emitido;
    }
    
}