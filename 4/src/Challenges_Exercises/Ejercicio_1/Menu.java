package Challenges_Exercises.Ejercicio_1;

import Challenges_Exercises.Ejercicio_1.Exceptions.DemasiadoRapidoException;
import Challenges_Exercises.Ejercicio_1.Models.Remolque;
import Challenges_Exercises.Ejercicio_1.Models.VehiculoCarga;
import Challenges_Exercises.Ejercicio_1.Models.VehiculoParticular;

import java.util.Scanner;

public class Menu {

    private final Scanner sc;

    private String matricula;

    public Menu(){
        sc = new Scanner(System.in);
    }

    public void vehiculoParticularMenu() throws DemasiadoRapidoException {
        int numeroDePuertas;
        boolean stop = false;
        int opc, velocidad;
        System.out.println("Ingrese la matricula: ");
        matricula = sc.next();
        System.out.println("Ingrese el numero de puetras: ");
        numeroDePuertas = sc.nextInt();
        VehiculoParticular auto = new VehiculoParticular(matricula, numeroDePuertas);
        while(!stop){
            System.out.println("1- Aumentar velocidad");
            System.out.println("2- Mostrar numero de puertas");
            System.out.println("3- Mostrar velocidad");
            System.out.println("4- Mostrar caracteristicas del vehiculo");
            System.out.println("5- Detener");
            System.out.println("Ingrese opcion");
            opc = sc.nextInt();
            switch(opc){
                case 1:
                    System.out.println("Ingrese la velocidad a la que se desea aumentar");
                    velocidad = sc.nextInt();
                    auto.AumentarVelocidad(velocidad);
                    break;
                case 2:
                    System.out.println("Puertas: "+auto.mostrarPuertas());
                    break;
                case 3:
                    System.out.println("Velocidad: "+auto.getVelocidad());
                    break;
                case 4:
                    System.out.println("Auto: "+ auto);
                    break;
                case 5:
                    stop = true;
            }
        }
    }

    public void vehiculoCargaMenu() throws DemasiadoRapidoException {
        boolean stop = false;
        int opc, velocidad, peso;
        System.out.println("Ingrese la matricula: ");
        matricula = sc.next();

        VehiculoCarga auto = new VehiculoCarga(matricula);
        while(!stop){
            System.out.println("1- Aumentar velocidad");
            System.out.println("2- Montar remolque");
            System.out.println("3- Desmontar remolque");
            System.out.println("4- Mostrar velocidad");
            System.out.println("5- Mostrar características del vehículo");
            System.out.println("6- Detener");
            System.out.println("Ingrese opcion");
            opc = sc.nextInt();
            switch(opc){
                case 1:
                    System.out.println("Ingrese la velocidad a la que se desea aumentar");
                    velocidad = sc.nextInt();
                    auto.AumentarVelocidad(velocidad);
                    break;
                case 2:
                    System.out.println("Ingrese el peso del remolque");
                    peso = sc.nextInt();
                    auto.ponRemolque(new Remolque(peso));
                    System.out.println("El auto fue remolcado");
                    break;
                case 3:
                    auto.quitarRemolque();
                    System.out.println("El auto se libero");
                    break;
                case 4:
                    System.out.println("Velocidad: "+auto.getVelocidad());
                    break;
                case 5:
                    System.out.println("Auto carga: "+auto);
                    break;
                case 6:
                    stop = true;
            }
        }
    }


}
