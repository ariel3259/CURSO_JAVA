package com.ariel.lectura.Ejercicios.Ejercicio_1;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        ProgramPeople programPeople = new ProgramPeople();
        int opc;
        boolean flag = false;
        Scanner sc = new Scanner(System.in);

        while(!flag){
            System.out.println("Welcome to people management");
            System.out.println("1- Show people");
            System.out.println("2- Show person");
            System.out.println("3- Insert person");
            System.out.println("4- Delete person");
            System.out.println("5- Exit");
            opc = sc.nextInt();
            switch(opc){
                case 1:
                    programPeople.ShowPeople();
                    break;
                case 2:
                    programPeople.ShowOnePerson();
                    break;
                case 3:
                    programPeople.InsertPerson();
                    break;
                case 4:
                    programPeople.DeletePerson();
                    break;
                case 5:
                    flag = true;
            }
        }
    }

}
