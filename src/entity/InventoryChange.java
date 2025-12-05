/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.time.LocalDateTime;
import org.bson.Document;

/**
 *
 * @author thanh
 */
public class InventoryChange {

    private int productId;
    private String productName;

    private int changeAmount;     // +10 nhập hàng, -2 bán hàng…
    private int oldStock;
    private int newStock;

    private String reason;
    private String username;

    private LocalDateTime timestamp;
    
    public InventoryChange() {}

    public InventoryChange(
            int productId,
            String productName,
            int changeAmount,
            int oldStock,
            int newStock,
            String reason,
            String username
    ) {
        this.productId = productId;
        this.productName = productName;
        this.changeAmount = changeAmount;
        this.oldStock = oldStock;
        this.newStock = newStock;
        this.reason = reason;
        this.username = username;
        this.timestamp = LocalDateTime.now();
    }

    public Document toDocument() {
        return new Document()
                .append("productId", productId)
                .append("productName", productName)
                .append("changeAmount", changeAmount)
                .append("oldStock", oldStock)
                .append("newStock", newStock)
                .append("reason", reason)
                .append("username", username)
                .append("timestamp", timestamp.toString());
    }
}
