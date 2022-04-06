package Crear_Ejercicios.Ejercicio_1;

import java.util.Scanner;

public class Main{
    
    public static  void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        Pila<Users> pila_users = new PilaImpList<Users>();
        Pila<Articles> pila_articles = new VectorStack<Articles>();
        Menu menu = new Menu();
        int opc;

        System.out.println("1- Users Program");
        System.out.println("2- Articles Program");
        opc = sc.nextInt();

        switch(opc){
            case 1:
                menu.usersMenu(pila_users);
                break;
            case 2: 
                menu.articlesMenu(pila_articles);
                break;
        }
    }

    
}