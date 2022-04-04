package lectura;
import java.util.Scanner;

public class DiferenciacionDeRaices{

    public static void main(String[] args){
        int a, b, c; //a = x2, b = x y c = Z  
        double discriminante;

        Scanner scan = new Scanner(System.in);

        System.out.println("Ingrese el valor de x2: ");
        a = scan.nextInt();

        System.out.println("Ingrese el valor de x: ");
        b = scan.nextInt();

        System.out.println("Ingrese el valor de Z: ");
        c = scan.nextInt();

        scan.close();

        discriminante = Math.sqrt((b*b) + 4 *(a*c)); 

        System.out.println("Discriminante: "+ discriminante);
        if(discriminante > 0 ) System.out.println("Hay dos raizes reales distintas");
        if(discriminante == 0) System.out.println("Hay dos raizes reales iguagles");
        if(discriminante < 0) System.out.println("Hay dos raízes imaginarias conjugadas");
    }
}