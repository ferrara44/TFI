package SistemaElectoral;

import java.util.*;

/**
 *
 * @author kartdei
 */
public class UsoEleccion {
    
    public static void main(String[] args){
        int dni;
        String nombre;
        
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
            System.out.println("5 - Agregar un partido a la lista");
            System.out.println("6 - Quitar una Lista");
            System.out.println("7 - Iniciar Votación.");
            System.out.println("8 - Cancelar y Salir.");
            System.out.println();
            
            int input = scan.nextInt();
            
            switch(input) {
                case 1:
                    padron.verPadron();
                    break;
                    
                case 2:
                    System.out.println("Ingrese el nombre de la persona que desea agregar al padrón.");
                    nombre = scan.next();
                    System.out.println("Ingrese el apellido.");
                    String apellido = scan.next();
                    System.out.println("Ingrese el dni");
                    dni = scan.nextInt();
                    Votante vot = new Votante(nombre,apellido,dni);
                    padron.agregarVotante(vot);
                    System.out.println();
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
                    System.out.println();
                    break;
                    
                case 4:
                    lista.verLista();
                    System.out.println();
                    break;
                    
                case 5:
                    System.out.println("Ingrese el nombre del partido que desea crear.");
                    nombre = scan.next();
                    if (nombre.equals("blanco") || nombre.equals("nulo")){
                        System.out.println("Nombre reservado, intente nuevamente.\n");
                        break;
                    }
                    System.out.println("Ingrese el dni del candidato que desea postular.");
                    dni = scan.nextInt();
                    Votante candidato = padron.getVotante(dni);
                    if (candidato != null){
                        Partido nuevoPartido = new Partido(nombre,candidato);
                        lista.agregarPartido(nuevoPartido);
                        System.out.println("Se ha agregado el partido " + nombre + " y se lo ha agregado a la lista electoral.");
                    }
                    else {
                        System.out.println("No se ha encontrado un candidato con ese dni.");
                    }
                    System.out.println();
                    break;
                    
                case 6:
                    System.out.println("Ingrese el nombre del partido que desea quitar.");
                    nombre = scan.next();
                    boolean eliminado = lista.eliminarPartido(nombre);
                    if (eliminado){
                        System.out.println("Se ha quitado el partido '" + nombre + "' de la lista electoral.");
                    }
                    else {
                        System.out.println("No se ha encontrado el partido '" + nombre + "'");
                    }
                    System.out.println();
                    break;
                    
                case 7:
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
                                System.out.println();
                                break;
                        }
                    }
                    break;
                    
                case 8: 
                    return;
            }
        }
                    
        /* Votacion Iniciada */

        System.out.println();
        padron.inicializarVotacion();
        Eleccion eleccion = new Eleccion(padron,lista);
        loop = 1;

        while (loop == 1){

            System.out.println("1 - Ver partidos.");
            System.out.println("2 - Votar.");
            System.out.println("3 - Cerrar votación y realizar recuento.");
            System.out.println("4 - Cancelar y Salir.");
            System.out.println();

            int input = scan.nextInt();

            switch(input) {
                case 1:
                    lista.verLista();
                    System.out.println();
                    break;
                    
                case 2:
                    System.out.println("Ingrese dni del votante:");
                    dni = scan.nextInt();
                    int estado = padron.evaluarVotante(dni);
                    switch(estado){
                        case 1:
                            System.out.println("El documento es valido para votar.");
                            lista.verLista();
                            System.out.println();
                            System.out.println("A continuacion, escriba el nombre del partido que desea votar.");
                            nombre = scan.next();
                            switch (nombre) {
                                case "blanco":
                                    eleccion.votoBlanco();
                                    padron.firmarPlanilla(dni);
                                    System.out.println("Su voto se ha registrado correctamente.");
                                    System.out.println();
                                    break;
                                case "nulo":
                                    eleccion.votoNulo();
                                    padron.firmarPlanilla(dni);
                                    System.out.println("Su voto se ha registrado correctamente.");
                                    System.out.println();
                                    break;
                                default:
                                    Votante votante = padron.getVotante(dni);
                                    padron.firmarPlanilla(dni);
                                    Partido partido = lista.getPartido(nombre);
                                    if (partido == null){
                                        System.out.println("Error: No se ha encontrado el partido, intente nuevamente.");
                                        System.out.println();
                                        break;
                                    }
                                    eleccion.registrarEmision(votante, partido);
                                    System.out.println("Su voto se ha registrado correctamente.");
                                    System.out.println();
                                    break;
                            }
                            break;

                        case 2:
                            System.out.println("Error: Este documento no está registrado en el padrón.");
                            break;
                            
                        case 3:
                            System.out.println("Error: Ya se ha emitido un voto con este documento.");
                            break;
                    }
                    break;
                
                case 3:
                    System.out.println("Está seguro?");
                    System.out.println("Una vez cerradas las urnas no se podrán cargar más votos.");
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
                                System.out.println();
                                break;
                        }
                    }
                    break;
                
                case 4:
                    return;
            }
        }
        
        /*Proceso electoral finalizado*/
        
        int votosTotales = eleccion.getnVotos();
        int votosBlancos = eleccion.getBlancos();
        int votosNulos = eleccion.getNulos();
        ArrayList partidos = lista.getPartidos();
        System.out.println(partidos.toString());
    }
    
}
