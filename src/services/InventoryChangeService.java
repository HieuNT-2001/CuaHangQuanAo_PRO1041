/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import entity.InventoryChange;

import java.time.format.DateTimeFormatter;

import org.bson.Document;
import utils.MongoDBUtil;

/**
 *
 * @author thanh
 */
public class InventoryChangeService {

    private final MongoCollection<Document> collection;

    public InventoryChangeService() {
        MongoDatabase db = MongoDBUtil.getDatabase();
        this.collection = db.getCollection("inventory_changes");
    }

    public void logChange(InventoryChange change) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        Document doc = new Document()
                .append("productId", change.getProductId())
                .append("productName", change.getProductName())
                .append("changeAmount", change.getChangeAmount())
                .append("oldStock", change.getOldStock())
                .append("newStock", change.getNewStock())
                .append("reason", change.getReason())
                .append("username", change.getUsername())
                .append("timestamp", change.getTimestamp().format(formatter));

        collection.insertOne(doc);
    }

}
