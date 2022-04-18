package com.ariel.lectura.Ejercicios.Ejercicio_1.Services.PeopleService;

import com.ariel.lectura.Ejercicios.Ejercicio_1.Db.MongoColl;
import com.ariel.lectura.Ejercicios.Ejercicio_1.Interfaces.ISelect;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class SelectPeople implements ISelect {

    private final MongoCollection<Document> peopleCollection;

    private static SelectPeople instance;

    private SelectPeople(){
        peopleCollection = new MongoColl("person_db").getCollection("people");
    }

    public static SelectPeople getInstance(){
        if(instance == null){
            instance = new SelectPeople();
        }
        return instance;
    }

    @Override
    public FindIterable<Document> getElements() {
        FindIterable<Document> people = peopleCollection.find();
        return people;
    }
}
