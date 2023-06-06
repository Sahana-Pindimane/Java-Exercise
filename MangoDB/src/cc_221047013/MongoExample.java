package cc_221047013;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Scanner;

public class MongoExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the database
        try (var client = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase database = client.getDatabase("dbdemo");

            // Get the collection
            MongoCollection<Document> collection = database.getCollection("collection1");

            // Show the menu
            while (true) {
                System.out.println("Please choose an option:");
                System.out.println("1. Add a document");
                System.out.println("2. Retrieve a document");
                System.out.println("3. Exit");

                // Get the user's choice
                int choice = scanner.nextInt();

                if (choice == 1) {
                    // Add a new document
                    System.out.print("Enter name: ");
                    String name = scanner.next();

                    System.out.print("Enter email: ");
                    String email = scanner.next();

                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();

                    // Create a new document to insert into the collection
                    Document doc = new Document("name", name)
                            .append("email", email)
                            .append("age", age);

                    // Insert the document into the collection
                    collection.insertOne(doc);

                    System.out.println("Document added successfully.");
                } else if (choice == 2) {
                    // Retrieve a document
                    System.out.print("Enter name to retrieve: ");
                    String name = scanner.next();

                    // Retrieve the document from the collection
                    Document retrievedDoc = collection.find(new Document("name", name)).first();

                    // Print the retrieved document
                    System.out.println("Retrieved document: " + retrievedDoc.toJson());
                } else if (choice == 3) {
                    // Exit
                    break;
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }
}
