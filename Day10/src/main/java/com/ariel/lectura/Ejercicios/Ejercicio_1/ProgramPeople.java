package com.ariel.lectura.Ejercicios.Ejercicio_1;

import com.ariel.lectura.Ejercicios.Ejercicio_1.Interfaces.IDelete;
import com.ariel.lectura.Ejercicios.Ejercicio_1.Interfaces.IInsert;
import com.ariel.lectura.Ejercicios.Ejercicio_1.Interfaces.ISelect;
import com.ariel.lectura.Ejercicios.Ejercicio_1.Interfaces.ISelectOne;
import com.ariel.lectura.Ejercicios.Ejercicio_1.Services.PeopleService.DeletePerson;
import com.ariel.lectura.Ejercicios.Ejercicio_1.Services.PeopleService.InsertPerson;
import com.ariel.lectura.Ejercicios.Ejercicio_1.Services.PeopleService.SelectOnePerson;
import com.ariel.lectura.Ejercicios.Ejercicio_1.Services.PeopleService.SelectPeople;
import com.mongodb.client.FindIterable;
import org.bson.Document;

import java.util.Scanner;

public class ProgramPeople {

    private final Scanner sc;

    public ProgramPeople(){
        sc = new Scanner(System.in);
    }


    public void ShowPeople(){
        ISelect peopleSelect = SelectPeople.getInstance();
        FindIterable<Document> people = peopleSelect.getElements();
        if(people.first() == null){
            System.out.println("There's no people");
        }
        else{
            for(Document person: people){
                System.out.println(person.toJson());
            }
        }
    }

    public void InsertPerson(){
        IInsert insertPerson = InsertPerson.getInstance();
        Document person = new Document();
        String name, lastName, address;
        int dni;

        System.out.println("Insert name: ");
        name = sc.next();


        System.out.println("Insert last name: ");
        lastName = sc.next();

        sc.nextLine();
        System.out.println("Insert address: ");
        address = sc.nextLine();

        System.out.println("Insert dni: ");
        dni = sc.nextInt();

        person.append("name", name);
        person.append("last_name", lastName);
        person.append("address", address);
        person.append("dni", dni);

        insertPerson.insertElement(person);

    }

    public void ShowOnePerson(){
        ISelectOne selectOnePerson = SelectOnePerson.getInstance();
        Document person;
        int dni;

        System.out.println("Insert dni of user: ");
        dni = sc.nextInt();

        try{
            person = selectOnePerson.getOneElement(dni);
            System.out.println(person.toJson());
        }catch (Exception e){
            System.out.println("There's no person");
        }

    }

    public void DeletePerson(){
        IDelete deletePerson = DeletePerson.getInstance();
        int dni;

        System.out.println("Insert person dni: ");
        dni = sc.nextInt();

        deletePerson.deleteElement(dni);
    System.out.println("Person deleted");
    }
}
