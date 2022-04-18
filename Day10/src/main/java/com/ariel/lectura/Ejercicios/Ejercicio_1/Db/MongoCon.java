package com.ariel.lectura.Ejercicios.Ejercicio_1.Db;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;


public class MongoCon {

    private final MongoClient client;

    public MongoCon(){
        client = MongoClients.create();
    }

    public MongoDatabase getDatabase(String database){
        return client.getDatabase(database);
    }
}
