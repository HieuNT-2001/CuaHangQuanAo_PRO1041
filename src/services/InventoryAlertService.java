/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import entity.InventoryAlert;
import java.time.format.DateTimeFormatter;
import org.bson.Document;
import utils.MongoDBUtil;

/**
 *
 * @author thanh
 */
public class InventoryAlertService {

    private final MongoCollection<Document> collection;

    public InventoryAlertService() {
        MongoDatabase db = MongoDBUtil.getDatabase();
        this.collection = db.getCollection("low_stock_alerts");
    }

    public void logInventoryAlert(InventoryAlert alert) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        Document doc = new Document()
                .append("productId", alert.getProductId())
                .append("productName", alert.getProductName())
                .append("currentStock", alert.getCurrentStock())
                .append("message", alert.getMessage())
                .append("timestamp", alert.getAlertTime().format(formatter));

        collection.insertOne(doc);
    }
}
