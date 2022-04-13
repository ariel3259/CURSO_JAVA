package com.ariel.CreateExercises.Exercise_One;

import com.ariel.CreateExercises.Exercise_One.MetodosDePago.Creditos;
import com.ariel.CreateExercises.Exercise_One.MetodosDePago.Efectivo;
import com.ariel.CreateExercises.Exercise_One.MetodosDePago.SaldoBancario;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Caja cajaDePago;

        Scanner sc = new Scanner(System.in);
        int opc;
        double plata;
        boolean flag = false;

            while(!flag){
                System.out.println("Escoga en que metodo efectuar el pago: ");
                System.out.println("1- Credito");
                System.out.println("2- Efectivo");
                System.out.println("3- salir");
                opc = sc.nextInt();

                switch (opc){
                    case 1:
                        System.out.println("Credito disponible: "+ SaldoBancario.getInstance().getFondoCredito());
                        System.out.println("Ingrese la cantidad tiene que pagar");
                        plata = sc.nextDouble();
                        cajaDePago = new Caja(new Creditos(plata));
                        cajaDePago.pagar();
                        System.out.println("Saldo pagado");
                        break;
                    case 2:
                        System.out.println("Ingrese la cantidad de plata que tiene que pagar");
                        plata = sc.nextDouble();
                        cajaDePago = new Caja(new Efectivo(plata));
                        cajaDePago.pagar();
                        System.out.println("Saldo pagado");
                        break;
                    case 3:
                        flag = true;
                        break;
                }
            }
    }
}
