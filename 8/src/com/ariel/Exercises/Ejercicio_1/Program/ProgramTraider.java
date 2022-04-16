package com.ariel.Exercises.Ejercicio_1.Program;

import com.ariel.Exercises.Ejercicio_1.Interfaces.IDelete;
import com.ariel.Exercises.Ejercicio_1.Interfaces.IInsert;
import com.ariel.Exercises.Ejercicio_1.Interfaces.ISelect;
import com.ariel.Exercises.Ejercicio_1.Interfaces.IUpdate;
import com.ariel.Exercises.Ejercicio_1.InterfacesImp.Traider.DeleteTraider;
import com.ariel.Exercises.Ejercicio_1.InterfacesImp.Traider.InsertTraider;
import com.ariel.Exercises.Ejercicio_1.InterfacesImp.Traider.SelectTraiders;
import com.ariel.Exercises.Ejercicio_1.InterfacesImp.Traider.UpdateTraider;
import com.ariel.Exercises.Ejercicio_1.Models.Traider;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class ProgramTraider {

    private final Scanner sc;
    private static ProgramTraider instance;

    private  ProgramTraider(){
        sc = new Scanner(System.in);
    }

    public static ProgramTraider getInstance(){
        if(instance == null){
            instance = new ProgramTraider();
        }
        return instance;
    }

    public void ShowTraders(){
        ISelect<Traider> traderSelect = SelectTraiders.getInstance();
        List<Traider> traders = traderSelect.getElements();
        if(traders.isEmpty()){
            System.out.println("There's no traders");
        }
        else{
            System.out.println("[");
            for(Traider trader: traders){
                System.out.println("\t{");
                System.out.println("\t\tId: " + trader.getId());
                System.out.println("\t\tName: " + trader.getName());
                System.out.println("\t\tLast Name: " + trader.getLastName());
                System.out.println("\t\tAddress: " + trader.getAddress());
                System.out.println("\t\tDni: " + trader.getDni());
                System.out.println("\t\tSalary: " + trader.getSalary());
                System.out.println("\t\tYear of born: " + trader.getYearOfBorn());
                System.out.println("\t}");
            }
            System.out.println("]");
        }
    }

    public void insetTrader(){
        IInsert<Traider> insertTrader = InsertTraider.getInstance();
        String name;
        String lastName;
        String address;
        int dni, year, month, day;
        double salary;

        System.out.println("Insert name: ");
        name = sc.next();

        sc.nextLine();
        System.out.println("Insert last name: ");
        lastName = sc.nextLine();

        sc.nextLine();
        System.out.println("Insert address: ");
        address = sc.nextLine();

        System.out.println("Insert dni with no point: ");
        dni = sc.nextInt();

        System.out.println("Insert salary: ");
        salary = sc.nextDouble();

        System.out.println("Insert trader's year of born of the : ");
        year = sc.nextInt();

        System.out.println("Insert trader's month of born: ");
        month = sc.nextInt();

        System.out.println("Insert trader's day of born: ");
        day = sc.nextInt();

        insertTrader.insertElement(new Traider(name, lastName, dni, address, salary, Date.valueOf(year+"-"+month+"-"+day)));
    }

    public void updateTrader(){
        IUpdate<Traider> updateTrader = UpdateTraider.getInstance();
        String name;
        String lastName;
        String address;
        int dni, id, year, month, day;
        double salary;

        System.out.println("Insert id: ");
        id = sc.nextInt();

        System.out.println("Insert name: ");
        name = sc.next();

        sc.nextLine();
        System.out.println("Insert last name: ");
        lastName = sc.nextLine();

        sc.nextLine();
        System.out.println("Insert address: ");
        address = sc.nextLine();

        System.out.println("Insert dni with no point: ");
        dni = sc.nextInt();

        System.out.println("Insert salary: ");
        salary = sc.nextDouble();

        System.out.println("Insert trader's year of born of the : ");
        year = sc.nextInt();

        System.out.println("Insert trader's month of born: ");
        month = sc.nextInt();

        System.out.println("Insert trader's day of born: ");
        day = sc.nextInt();

        updateTrader.updateElement(new Traider(id, name, lastName, dni, address, salary, Date.valueOf(year+"-"+month+"-"+day)));
    }

    public void deleteTrader(){
        IDelete deleteTrader = DeleteTraider.getInstance();
        int id;

        System.out.println("Insert trader's id: ");
        id = sc.nextInt();

        deleteTrader.deleteElement(id);
    }
}
