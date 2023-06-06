package cc_221047013;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDBFunctionality {

    public static void addDocument(String name, String email, int age) {
        // Connect to the MongoDB server
        try (var client = MongoClients.create("mongodb://localhost:27017")) {
            // Get the database
            MongoDatabase database = client.getDatabase("mydb");

            // Get the collection
            MongoCollection<Document> collection = database.getCollection("mycollection");

            // Create a new document to insert into the collection
            Document doc = new Document("name", name)
                    .append("email", email)
                    .append("age", age);

            // Insert the document into the collection
            collection.insertOne(doc);

            System.out.println("Document added successfully.");
        }
    }

    public static void retrieveDocument(String name) {
        // Connect to the MongoDB server
        try (var client = MongoClients.create("mongodb://localhost:27017")) {
            // Get the database
            MongoDatabase database = client.getDatabase("mydb");

            // Get the collection
            MongoCollection<Document> collection = database.getCollection("mycollection");

            // Retrieve the document from the collection
            Document retrievedDoc = collection.find(new Document("name", name)).first();

            // Print the retrieved document
            System.out.println("Retrieved document: " + retrievedDoc.toJson());
        }
    }
}
