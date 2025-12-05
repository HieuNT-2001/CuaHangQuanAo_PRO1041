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
public class InventoryAlert {

    private int productId;
    private String productName;
    private int currentStock;
    private String message;
    private LocalDateTime alertTime;

    public InventoryAlert() {
    }

    public InventoryAlert(int productId, String productName, int currentStock, String message, LocalDateTime alertTime) {
        this.productId = productId;
        this.productName = productName;
        this.currentStock = currentStock;
        this.message = message;
        this.alertTime = alertTime;
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

    public int getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(int currentStock) {
        this.currentStock = currentStock;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getAlertTime() {
        return alertTime;
    }

    public void setAlertTime(LocalDateTime alertTime) {
        this.alertTime = alertTime;
    }

}
