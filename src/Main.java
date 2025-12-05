
import handlers.GlobalLogHandler;
import javax.swing.SwingUtilities;
import services.LogService;
import view.DangNhapJFrame;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author thanh
 */
public class Main {

    public static void main(String[] args) {
        GlobalLogHandler.init();
        SwingUtilities.invokeLater(() -> {
            new DangNhapJFrame().setVisible(true);
        });
    }
}
