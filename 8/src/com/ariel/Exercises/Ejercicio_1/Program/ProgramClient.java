package com.ariel.Exercises.Ejercicio_1.Program;

import com.ariel.Exercises.Ejercicio_1.Interfaces.IDelete;
import com.ariel.Exercises.Ejercicio_1.Interfaces.IInsert;
import com.ariel.Exercises.Ejercicio_1.Interfaces.ISelect;
import com.ariel.Exercises.Ejercicio_1.Interfaces.IUpdate;
import com.ariel.Exercises.Ejercicio_1.InterfacesImp.Client.DeleteClient;
import com.ariel.Exercises.Ejercicio_1.InterfacesImp.Client.InsertClient;
import com.ariel.Exercises.Ejercicio_1.InterfacesImp.Client.SelectClient;
import com.ariel.Exercises.Ejercicio_1.InterfacesImp.Client.UpdateClient;
import com.ariel.Exercises.Ejercicio_1.Models.Client;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class ProgramClient {

    private final Scanner sc;
    private static ProgramClient instance;

    private ProgramClient(){
        sc = new Scanner(System.in);
    }

    public static ProgramClient getInstance(){
        if(instance == null){
            instance = new ProgramClient();
        }
        return instance;
    }

    public void ShowClients(){
        ISelect<Client> selectClients = SelectClient.getInstance();
        List<Client> clients =  selectClients.getElements();

        if(clients.isEmpty()){
            System.out.println("There's no data");
        }
        else{
            System.out.println("[");
            for(Client client: clients){
                System.out.println("\t{");
                System.out.println("\t\t Id: " + client.getId());
                System.out.println("\t\tName: " + client.getName());
                System.out.println("\t\tLastName: " + client.getLastName());
                System.out.println("\t\tAddress: " + client.getAddress());
                System.out.println("\t\tDni: " + client.getDni());
                System.out.println("\t\tYearOfBorn: "+ client.getYearOfBorn());
                System.out.println("\t}");
            }
            System.out.println("]");
        }
    }

    public void insetClient(){
        IInsert<Client> insertClient = InsertClient.getInstance();
        String name;
        String lastName;
        String address;
        int dni, year, month, day;

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

        System.out.println("Insert client's year of born of the : ");
        year = sc.nextInt();

        System.out.println("Insert client's month of born: ");
        month = sc.nextInt();

        System.out.println("Insert client's day of born: ");
        day = sc.nextInt();

        insertClient.insertElement(new Client(name, lastName, address, dni, Date.valueOf(year+"-"+month+"-"+day)));
    }

    public void updateClient(){
        IUpdate<Client> updateClient = UpdateClient.getInstance();
        String name;
        String lastName;
        String address;
        int dni, id, year, month, day;

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

        System.out.println("Insert client's year of born of the : ");
        year = sc.nextInt();

        System.out.println("Insert client's month of born: ");
        month = sc.nextInt();

        System.out.println("Insert client's day of born: ");
        day = sc.nextInt();

        updateClient.updateElement(new Client(id, name, lastName, address, dni, Date.valueOf(year+"-"+month+"-"+day)));
    }

    public void deleteClient(){
        IDelete deleteClient = DeleteClient.getInstance();
        int id;

        System.out.println("Insert id: ");
        id = sc.nextInt();

        deleteClient.deleteElement(id);
    }

}
