package com.ariel.lectura.Ejercicios.Ejercicio_1.Services.PeopleService;

import com.ariel.lectura.Ejercicios.Ejercicio_1.Db.MongoColl;
import com.ariel.lectura.Ejercicios.Ejercicio_1.Interfaces.ISelectOne;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class SelectOnePerson implements ISelectOne {

    private final MongoCollection<Document> peopleCollection;
    private static SelectOnePerson instance;

    private SelectOnePerson(){
        peopleCollection = new MongoColl("person_db").getCollection("people");
    }

    public static SelectOnePerson getInstance(){
        if(instance == null){
            instance = new SelectOnePerson();
        }
        return instance;
    }

    /**
     *
     * @param number is a dni integer
     * @return a document
     */
    @Override
    public Document getOneElement(int number) {
        Document find = new Document("dni", number);
        Document person = peopleCollection.find(find).first();
        return person;
    }
}
