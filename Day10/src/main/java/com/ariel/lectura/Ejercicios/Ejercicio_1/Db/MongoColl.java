package com.ariel.lectura.Ejercicios.Ejercicio_1.Db;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoColl {
    private final MongoDatabase db;

    public MongoColl(String database){
        db  = new MongoCon().getDatabase(database);
    }

    public MongoCollection<Document> getCollection(String collection){
        return db.getCollection(collection);
    }

}
