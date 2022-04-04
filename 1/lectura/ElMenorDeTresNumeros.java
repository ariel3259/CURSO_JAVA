package lectura;
import java.util.Scanner;

public class ElMenorDeTresNumeros{

    public static void main(String[] args){
        int n1, n2, n3;

        Scanner scan = new Scanner(System.in);

        System.out.println("Ingrese el primer numero: ");
        n1 = scan.nextInt();

        System.out.println("Ingrese el segundo numero: ");
        n2 = scan.nextInt();

        System.out.println("Ingrese el tercer numero: ");
        n3 = scan.nextInt();

        scan.close();

        if((n1 < n2) && (n1 < n3)) System.out.println("El primer numero es el menor");
        else if((n2 < n1) && (n2 < n3)) System.out.println("El segundo numero es el menor");
        else if((n3 < n1) && (n3 < n2)) System.out.println("El tercer numero es el menor");
        else System.out.println("No hay numeros menores");

    }

}