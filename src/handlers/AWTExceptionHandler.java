/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package handlers;

import services.LogService;

/**
 *
 * @author thanh
 */
public class AWTExceptionHandler {
    public void handle(Throwable ex) {
        LogService log = new LogService();
        log.error("UI Thread Exception", ex);
    }
}
