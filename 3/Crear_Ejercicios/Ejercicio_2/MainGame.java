package Crear_Ejercicios.Ejercicio_2;

import java.util.Scanner;

public class MainGame {
    public static void main(String[] args) {
        System.out.println("Se acerca el monstruo");
        Monstruo monstruo = new Goblin();
        System.out.println("Es un "+monstruo.getName());
        Heroe heroe = new Heroe();
        batalla(heroe,monstruo);
        System.out.println("Se acerca otro monstruo");
        monstruo = new Minotauro();
        System.out.println("Es un "+monstruo.getName());
        batalla(heroe, monstruo);
    }

    private static void batalla(Heroe heroe, Monstruo monstruo) {
        boolean gameOver = false;
        Scanner scanner = new Scanner(System.in);
        while(!gameOver){
            System.out.println("Heroe ataca!!");
            int damage = monstruo.recieveDamage(heroe.getAttackType(), heroe.getDamage());
            System.out.println("Hizo "+String.valueOf(damage)+" de damage");
            if(monstruo.isAlive()){
                System.out.println(monstruo.getName()+" sigue vivo!!");
                monstruo.specialAbility(heroe);
                System.out.println(monstruo.getName()+ " te ha aplicado "+heroe.getStatus());
            } else {
                System.out.println(monstruo.getName()+ " ha muerto");
                gameOver = true;
            }
            scanner.nextLine();
        }
    }
}
