package utils;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDBUtil {

    private static MongoClient client;

    public static MongoDatabase getDatabase() {
        if (client == null) {
            client = MongoClients.create("mongodb://localhost:27017");
        }
        return client.getDatabase("app_logs_db");
    }
    
     public static MongoClient getClient() {
        if (client == null) {
            client = MongoClients.create("mongodb://localhost:27017");
        }
        return client;
    }
}
