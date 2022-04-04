package lectura;
import java.util.Scanner;

public class Promedio{

    public static void main(String[] args){
        double nota1, nota2, nota3;
        double promedio;
        
        Scanner scan = new Scanner(System.in);

        System.out.println("Ingrese la primera nota:");
        nota1 = scan.nextDouble();

        System.out.println("Ingrese la segunda nota:");
        nota2 = scan.nextDouble();

        System.out.println("Ingrese la tercera nota:");
        nota3 = scan.nextDouble();

        promedio = (nota1 + nota2 + nota3)/3;

        if(promedio < 10) System.out.println("Reprobado");
        else if((promedio > 10) && (promedio < 15)) System.out.println("Aprobado");
        else if(promedio > 15) System.out.println("Eximido");
 
    }
}