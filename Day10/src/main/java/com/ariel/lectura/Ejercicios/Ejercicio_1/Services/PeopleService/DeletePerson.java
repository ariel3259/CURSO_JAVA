package com.ariel.lectura.Ejercicios.Ejercicio_1.Services.PeopleService;

import com.ariel.lectura.Ejercicios.Ejercicio_1.Db.MongoColl;
import com.ariel.lectura.Ejercicios.Ejercicio_1.Interfaces.IDelete;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class DeletePerson implements IDelete {

    private final MongoCollection<Document> peopleCollection;
    private static DeletePerson instance;

    private DeletePerson(){
        peopleCollection = new MongoColl("person_db").getCollection("people");
    }

    public static DeletePerson getInstance(){
        if(instance == null){
            instance = new DeletePerson();
        }
        return instance;
    }

    /**
     *
     * @param number is a dni
     */
    @Override
    public void deleteElement(int number) {
        Document personToDelete = new Document("dni", number);
        peopleCollection.deleteOne(personToDelete);
    }
}
