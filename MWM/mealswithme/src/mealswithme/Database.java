/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mealswithme;
import com.mongodb.*;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.*;
import org.bson.Document;
/**
 *
 * @author jencardona
 */
public class Database {
    
    MongoClientURI uri;
    MongoClient mongoClient;
    MongoDatabase db;
    
    public Database () {
        try {
            uri  = new MongoClientURI("mongodb://mealswithme:pusu2016@ds157667.mlab.com:57667/mealswithme");
            mongoClient = new MongoClient(uri);
            db = mongoClient.getDatabase("mealswithme");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("CONNECTED!");
    }
    
    public void sendUser(User user) {
        MongoCollection collection = db.getCollection(user.getUsername());
        
        Document document = new Document();
        List list = user.getInventory();
        Document dc = new Document(user.getUsername(), list);
        System.out.println(collection.find(dc));
        //if (collection.find(dc) != null){
        MongoCursor <Document> cursor = collection.find().iterator();
        if(cursor.hasNext()){
            collection.findOneAndReplace(cursor.next(), dc);
        } else {
           collection.insertOne(dc);
        }
        
        
        //document.put(user.getUsername(), tmp);
        //collection.insertOne(document);
        
        //collection = db.createCollection("users");
        //db.getCollection("users").insert({ item: "card", qty: 15 });
        //collection.in
        
    }
    
    public ArrayList loadIngredients (User user) {
        MongoCollection collection = db.getCollection(user.getUsername());
        MongoCursor <Document> cursor = collection.find().iterator();
        if (!cursor.hasNext())
            return null;
        ArrayList inventory = new ArrayList();
        
        while (cursor.hasNext()) {
            Object value = cursor.next().get(user.getUsername());
            System.out.println(value);
            inventory = (ArrayList<String>) value;
            //List <Document>  inventoryDoc = (List<Document>)cursor.next().get(user.getUsername());
           //for (Document doc: inventoryDoc) {
             //  inventory.add(doc.toString());
           //}
        }
        return inventory;
    }
    
    public void storeRecipe (ArrayList recipes) {
        MongoCollection collection = db.getCollection("recipes");
                Document document = new Document();
        List list = recipes;
        Document dc = new Document("recipes", list);
        MongoCursor <Document> cursor = collection.find().iterator();
        if(cursor.hasNext()){
            collection.findOneAndReplace(cursor.next(), dc);
        } else {
           collection.insertOne(dc);
        }
    }

    
    
}
