import java.util.Scanner;

public class EsCapicua{

    public static void main(String[] args){
        int numero;
        Scanner scan = new Scanner(System.in);

        System.out.println("Ingrese un numero:");
        numero = scan.nextInt();

        scan.close();

        String numeroConvertido = String.valueOf(numero);

        String numeroInverso = new StringBuilder(numeroConvertido).reverse().toString();
        
        if(numeroConvertido.equals(numeroInverso)) System.out.println("El numero es capicua");
        else System.out.println("El numero no es capicua");

    }
}