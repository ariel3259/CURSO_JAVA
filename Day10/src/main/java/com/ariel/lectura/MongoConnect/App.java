package com.ariel.lectura.MongoConnect;


import com.mongodb.client.*;
import org.bson.Document;


public class App {
    public static void main(String[] args) {

        //Connection
        MongoClient client = MongoClients.create();

     /*
        //Watch all databases
        List<Document> database = client.listDatabases().into(new ArrayList<>());
        database.forEach( (element) -> {
            System.out.println(element.toJson());
        });*/

        //Get database from client connection
        MongoDatabase db = client.getDatabase("articles_db");

        //Get collection form the database
        MongoCollection<Document> articles = db.getCollection("articles");

        //Find all products
        FindIterable<Document> allArticles = articles.find();
        for(Document article: allArticles){
            System.out.println(article.get("description"));
        }
        System.out.println(articles.find(new Document("description", "Auriculares noga")).first() == null);



            //Save document
        Document articleToSave = new Document();
        articleToSave.append("description", "Mouse noga");
        articleToSave.append("price", 2.5);
        articleToSave.append("stock", 50);
        //articles.insertOne(articleToSave);

    }
}
