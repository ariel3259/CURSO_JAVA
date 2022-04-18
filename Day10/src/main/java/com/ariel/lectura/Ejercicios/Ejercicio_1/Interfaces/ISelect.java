package com.ariel.lectura.Ejercicios.Ejercicio_1.Interfaces;

import com.mongodb.client.FindIterable;
import org.bson.Document;

public interface ISelect {
    public FindIterable<Document> getElements();
}

