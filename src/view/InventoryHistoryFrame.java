/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import utils.MongoDBUtil;

public class InventoryHistoryFrame extends JFrame {

    private JTable table;
    private JTextField txtSearch;
    private DefaultTableModel model;

    private MongoCollection<Document> collection;

    public InventoryHistoryFrame() {
        setTitle("Lịch Sử Thay Đổi Tồn Kho");
        setSize(900, 600);
        setLocationRelativeTo(null);

        MongoDatabase db = MongoDBUtil.getDatabase();
        collection = db.getCollection("inventory_changes");

        initUI();
        loadData();
    }

    private void initUI() {
        setLayout(new BorderLayout());

        // Search panel
        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT));
        txtSearch = new JTextField(30);
        JButton btnSearch = new JButton("Tìm kiếm");
        top.add(new JLabel("Tìm theo tên sản phẩm:"));
        top.add(txtSearch);
        top.add(btnSearch);

        btnSearch.addActionListener(e -> loadData());

        add(top, BorderLayout.NORTH);

        // Table
        model = new DefaultTableModel(
                new String[]{"Sản phẩm", "Thay đổi", "Tồn cũ", "Tồn mới", "Lý do", "Nhân viên", "Thời gian"},
                0
        );
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    private void loadData() {
        model.setRowCount(0);

        String keyword = txtSearch.getText().trim().toLowerCase();

        FindIterable<Document> docs = collection.find();

        for (Document doc : docs) {
            String name = doc.getString("productName").toLowerCase();

            if (!keyword.isEmpty() && !name.contains(keyword)) {
                continue;
            }

            model.addRow(new Object[]{
                doc.getString("productName"),
                doc.getInteger("changeAmount"),
                doc.getInteger("oldStock"),
                doc.getInteger("newStock"),
                doc.getString("reason"),
                doc.getString("username"),
                doc.getString("timestamp")
            });
        }
    }
}
