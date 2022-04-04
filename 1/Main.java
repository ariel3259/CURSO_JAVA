import java.util.Scanner;

public class Main{

    private final Scanner scan = new Scanner(System.in);

    public static void main(String[] args){
        Main program = new Main();

        int opc;

        Scanner scanner = new Scanner(System.in);

        System.out.println("1- programa del Triangulo");
        System.out.println("2- programa del numero primo");
        opc = scanner.nextInt();

        switch(opc){

            case 1:
                program.programaTriangulo();
                break;
            case 2:
                program.programaNumeroPrimo();
                break;
            default: 
                System.out.println("Ingrese una opcion valida");
        }


    }

    public void programaTriangulo(){
        int ladoA, ladoB, ladoC;

        

        System.out.println("Ingrese el valor del lado A: ");
        ladoA = scan.nextInt();

        System.out.println("Ingrese el valor del lado B: ");
        ladoB = scan.nextInt();

        System.out.println("Ingrese el valor del lado C: ");
        ladoC = scan.nextInt();

        scan.close();

        Triangulo triangulo = new Triangulo(ladoA, ladoB, ladoC);

        System.out.println("El triangulo es "+triangulo.queSoy());
    }

    public void programaNumeroPrimo(){
        int numero;

        System.out.println("Ingrese el numero:");
        numero = scan.nextInt();

        Primo primo = new Primo(numero);

        String resultado = (primo.soyPrimo()) ? "es primo" : "no es primo";

        System.out.println("El numero "+resultado );
    }

}