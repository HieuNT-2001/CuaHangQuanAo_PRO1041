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
public class GlobalLogHandler {

    private static boolean initialized = false;

    public static void init() {
        if (initialized) return;

        LogService log = new LogService();

        // Bắt lỗi trong các thread khác EDT
        Thread.setDefaultUncaughtExceptionHandler((thread, ex) -> {
            log.error("Uncaught exception in thread: " + thread.getName(), ex);
        });

        // Bắt lỗi trong EDT (UI thread)
        System.setProperty("sun.awt.exception.handler", AWTExceptionHandler.class.getName());

        initialized = true;
    }
}
