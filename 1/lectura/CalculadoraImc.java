package lectura;
import java.util.Scanner;

public class CalculadoraImc{

    public static void main(String[] args){
        
        double altura; //en metros
        double peso; //en kilos
        double imc; 

        Scanner scan = new Scanner(System.in);

        System.out.println("Ingrese su altura (en centimetros)");
        altura = scan.nextDouble();

        System.out.println("Ingrese su peso (en kilos)");
        peso = scan.nextDouble();

        scan.close();
        
        imc = peso / (altura * altura);
        
        System.out.println("Diagnostico: ");
        
        if(imc < 20) System.out.println("Mal estado");
        
        else if((imc > 20) && (imc < 22 )) System.out.println("Bajo peso");
        
        else if((imc > 22) && (imc < 25)) System.out.println("Peso normal");
        
        else if((imc > 25) && (imc < 30)) System.out.println("Sobre peso");
        
        else if((imc > 30) && (imc < 40)) System.out.println("Sobre peso cronico");
        
        else if( imc > 40 ) System.out.println("Hospitalizado"); 
        
    }   
}