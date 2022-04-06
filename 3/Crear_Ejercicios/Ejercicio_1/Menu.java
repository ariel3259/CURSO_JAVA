package Crear_Ejercicios.Ejercicio_1;

import java.util.Scanner;

public class Menu{

    private final Scanner sc = new Scanner(System.in);

    public Menu(){ }

    public void usersMenu(Pila<Users> pila){
        int opc;
        String name, lastName, email, password;
        boolean getOut = false;
        
        while(!getOut){
            Users user;
         
            System.out.println("1- Add an user");
            System.out.println("2- Deletes last user");
            System.out.println("3- Show last user");
            System.out.println("4- Exit");
            opc = sc.nextInt();
            switch(opc){
                case 1:
                    sc.nextLine();  
                    System.out.println("Write user's name");
                    name = sc.nextLine();

                    sc.nextLine();  
                    System.out.println("Write user's last name");
                    lastName = sc.nextLine();

                    sc.nextLine();  
                    System.out.println("Write user's email");
                    email = sc.nextLine();

                    sc.nextLine();  
                    System.out.println("Write user's password");
                    password = sc.nextLine();

                    user = new Users(name, lastName, email, password);
                    pila.push(user);
                    break;
                case 2:
                    System.out.println(pila.pop().toString());
                    break;
                case 3: 
                    System.out.println(pila.peek().toString());
                    break;
                case 4:
                    System.out.println("Good bye");
                    getOut = true;
                    break;
                default: 
                    System.out.println("Insert a valid option");
                    break;
            }
        }
    }

    public void articlesMenu(Pila<Articles> vector){
        int opc, stock;
        double price;
        String name;
        boolean getOut = false;
        
        while(!getOut){
            Articles article;
         
            System.out.println("1- Add an user");
            System.out.println("2- Deletes last user");
            System.out.println("3- Show last user");
            System.out.println("4- Exit");
            opc = sc.nextInt();
            switch(opc){
                case 1:
                    sc.nextLine();  
                    System.out.println("Write user's name");
                    name = sc.nextLine();

                    sc.nextLine();  
                    System.out.println("Write user's last name");
                    price = sc.nextDouble();

                    sc.nextLine();  
                    System.out.println("Write user's email");
                    stock = sc.nextInt();

                    article = new Articles(name, price, stock);
                    vector.push(article);
                    break;
                case 2:
                    System.out.println(vector.pop().toString());
                    break;
                case 3: 
                    System.out.println(vector.peek().toString());
                    break;
                case 4:
                    System.out.println("Good bye");
                    getOut = true;
                    break;
                default: 
                    System.out.println("Insert a valid option");
                    break;
            }
        }
    }
}