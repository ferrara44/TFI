package SistemaElectoral;

/**
 *
 * @author kartdei
 */

public class Partido {
    String nombre;
    Persona candidato;
    int votos;

    public Partido(String nombre, Persona candidato) {
        this.nombre = nombre;
        this.candidato = candidato;
        this.votos = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Persona getCandidato() {
        return candidato;
    }

    public void setCandidato(Persona candidato) {
        this.candidato = candidato;
    }

    public int getVotos() {
        return votos;
    }

    public void agregarVoto() {
        this.votos += 1;
    }
    
}
