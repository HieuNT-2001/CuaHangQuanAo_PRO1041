/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.bson.Document;
import utils.MongoDBUtil;

/**
 *
 * @author thanh
 */
public class ActivityLogService {

    private final MongoCollection<Document> collection;

    public ActivityLogService() {
        MongoDatabase db = MongoDBUtil.getDatabase();
        collection = db.getCollection("activity_logs");
    }

    public void writeActivity(String username, String activity, boolean success, String ip, String note) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        Document doc = new Document()
                .append("username", username)
                .append("activity", activity)
                .append("success", success)
                .append("ip", ip)
                .append("note", note)
                .append("timestamp", LocalDateTime.now().format(formatter));

        collection.insertOne(doc);
    }

}
