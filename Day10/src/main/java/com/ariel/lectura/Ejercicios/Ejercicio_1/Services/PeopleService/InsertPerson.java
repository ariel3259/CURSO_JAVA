package com.ariel.lectura.Ejercicios.Ejercicio_1.Services.PeopleService;

import com.ariel.lectura.Ejercicios.Ejercicio_1.Db.MongoColl;
import com.ariel.lectura.Ejercicios.Ejercicio_1.Interfaces.IInsert;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class InsertPerson implements IInsert {

    private final MongoCollection<Document> peopleCollection;
    private static InsertPerson instance;

    private InsertPerson(){
        peopleCollection = new MongoColl("person_db").getCollection("people");
    }

    public static InsertPerson getInstance(){
        if(instance == null){
            instance = new InsertPerson();
        }
        return instance;
    }

    @Override
    public void insertElement(Document element) {
        if(verifyPerson(element.get("dni"))){
                peopleCollection.insertOne(element);
                System.out.println("Saved person");
        }
        else{
            System.out.println("The person already exits");
        }
    }

    private boolean verifyPerson(Object dni){
        Document personVerify = new Document("dni", dni);
        return peopleCollection.find(personVerify).first() == null;
    }
}
