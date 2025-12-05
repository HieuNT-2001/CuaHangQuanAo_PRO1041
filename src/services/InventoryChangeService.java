/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import entity.InventoryChange;
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

    public void logChange(
            int productId,
            String productName,
            int changeAmount,
            int oldStock,
            int newStock,
            String reason,
            String username
    ) {
        InventoryChange log = new InventoryChange(
                productId,
                productName,
                changeAmount,
                oldStock,
                newStock,
                reason,
                username
        );

        collection.insertOne(log.toDocument());
    }

}
