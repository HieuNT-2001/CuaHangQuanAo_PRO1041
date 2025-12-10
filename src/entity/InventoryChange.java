/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.time.LocalDateTime;

/**
 *
 * @author thanh
 */
public class InventoryChange {

    private int productId;
    private String productName;

    private int changeAmount; // +10 nhập hàng, -2 bán hàng…
    private int oldStock;
    private int newStock;

    private String reason;
    private String username;

    private LocalDateTime timestamp;

    public InventoryChange() {
    }

    public InventoryChange(
            int productId,
            String productName,
            int changeAmount,
            int oldStock,
            int newStock,
            String reason,
            String username) {
        this.productId = productId;
        this.productName = productName;
        this.changeAmount = changeAmount;
        this.oldStock = oldStock;
        this.newStock = newStock;
        this.reason = reason;
        this.username = username;
        this.timestamp = LocalDateTime.now();
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getChangeAmount() {
        return changeAmount;
    }

    public void setChangeAmount(int changeAmount) {
        this.changeAmount = changeAmount;
    }

    public int getOldStock() {
        return oldStock;
    }

    public void setOldStock(int oldStock) {
        this.oldStock = oldStock;
    }

    public int getNewStock() {
        return newStock;
    }

    public void setNewStock(int newStock) {
        this.newStock = newStock;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

}
