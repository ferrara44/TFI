package SistemaElectoral;

import java.util.*;

/**
 *
 * @author kartdei
 */
public class UsoEleccion {
    
    public static void main(String[] args){
        /*Cargamos algunos votantes de ejemplo*/
        Votante juan = new Votante("Juan", "Mascota", 35);
        Votante pedro = new Votante("Pedro", "Surucho", 12);
        Votante luis = new Votante("Luis", "Lopez", 25);
        Votante ana = new Votante("Ana", "Mengana", 24);
        Votante tulio = new Votante("Tulio", "Miguel", 65);
        Votante atos = new Votante("Atos", "Portos", 20);
        Votante aramis = new Votante("Aramis", "Dartagnan", 95);
        Votante laura = new Votante("Laura", "Damas", 85);
        Votante pepa = new Votante("Peppa", "Peeg", 42);
        Votante jaime = new Votante("Jayay", "Avioncito", 31);
        Votante croc = new Votante("Crocodile", "Alligator", 15);

        /*Generamos un HashSet que contenga a todos y lo asignamos al padron*/
        ArrayList<Votante> listaVotantes = new ArrayList<>(
            Arrays.asList(
            juan, pedro, luis,
            ana, tulio, atos,
            aramis, laura, pepa,
            jaime, croc
            )
        );
        Padron padron = new Padron(listaVotantes);
        
        /*Generamos algunos partidos en campaña y los guardamos en listas*/
        Partido azul = new Partido("azul",juan);
        Partido rojo = new Partido("rojo", pedro);
        Partido verde = new Partido("verde", luis);
        ArrayList<Partido> listaPartidos = new ArrayList<>(
            Arrays.asList(azul,rojo,verde)
        );
        Lista lista = new Lista(listaPartidos);
        
        /*Fin de la Inicializacion*/
        
        System.out.println("Bienvenido al sistema de voto electronico, por favor seleccione una opción:");
        
        Scanner scan = new Scanner(System.in);
        int loop = 1;
        
        while (loop == 1){
            
            System.out.println("1 - Ver padrón.");
            System.out.println("2 - Agregar una persona al padrón.");
            System.out.println("3 - Quitar una persona del padrón.");
            System.out.println("4 - Ver Listas");
            System.out.println("5 - Agregar una Lista");
            System.out.println("6 - Quitar una Lista");
            System.out.println("7 - Iniciar Votación.");
            System.out.println("8 - Salir.");
            
            int input = scan.nextInt();
            
            switch(input) {
                case 1:
                    padron.verPadron();
                    break;
                    
                case 2:
                    System.out.println("Ingrese el nombre de la persona que desea agregar al padrón.");
                    String nombre = scan.next();
                    System.out.println("Ingrese el apellido.");
                    String apellido = scan.next();
                    System.out.println("Ingrese el dni");
                    int dni = scan.nextInt();
                    Votante vot = new Votante(nombre,apellido,dni);
                    padron.agregarVotante(vot);
                    break;
                    
                case 3:
                    System.out.println("Ingrese el dni de la persona que desea remover del padrón:");
                    dni = scan.nextInt();
                    if (padron.eliminarVotante(dni)){
                        System.out.println("Elemento eliminado del padrón.");
                    }
                    else{
                        System.out.println("No se ha encontrado ningun elemento con tal DNI.");
                    }
                
                case 4:
                    Listas
                    
                case 6:
                    System.out.println("Está seguro?");
                    System.out.println("Una vez cerrado el padrón electoral no podrá volver a modificarse.");
                    System.out.println("Y/N");
                    int innerloop = 1;
                    while (innerloop == 1){
                        String cerrarPadron = scan.next();
                        char answer = cerrarPadron.charAt(0);
                        switch (answer) {
                            case 'Y':
                            case 'y':
                                loop = 0;
                                innerloop = 0;
                                break;
                            case 'N':
                            case 'n':
                                innerloop = 0;
                                break;
                            default:
                                System.out.println("Valor ingresado incorrecto, vuelva a intentar.");
                                innerloop = 1;
                                break;
                        }
                    }
                    
                case 7: 
                    return;
            }
            
            /* Votacion Iniciada */
            
            System.out.println("");
            
        }
    }
    
}
