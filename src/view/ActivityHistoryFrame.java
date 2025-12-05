/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import utils.MongoDBUtil;

public class ActivityHistoryFrame extends JFrame {

    private JTable table;
    private JTextField txtSearch;
    private DefaultTableModel model;

    private MongoCollection<Document> collection;

    public ActivityHistoryFrame() {
        setTitle("Lịch Sử Hoạt Động");
        setSize(900, 600);
        setLocationRelativeTo(null);

        MongoDatabase db = MongoDBUtil.getDatabase();
        collection = db.getCollection("activity_logs");

        initUI();
        loadData();
    }

    private void initUI() {
        setLayout(new BorderLayout());

        // Search panel
        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT));
        txtSearch = new JTextField(30);
        JButton btnSearch = new JButton("Tìm kiếm");
        top.add(new JLabel("Tìm theo tên người dùng:"));
        top.add(txtSearch);
        top.add(btnSearch);

        btnSearch.addActionListener(e -> loadData());

        add(top, BorderLayout.NORTH);

        // Table
        model = new DefaultTableModel(
                new String[]{"Nhân viên", "Hoạt động", "Trạng thái", "IP", "Ghi chú", "Thời gian"},
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
            String name = doc.getString("username").toLowerCase();

            if (!keyword.isEmpty() && !name.contains(keyword)) {
                continue;
            }

            model.addRow(new Object[]{
                doc.getString("username"),
                doc.getString("activity"),
                doc.getBoolean("success"),
                doc.getString("ip"),
                doc.getString("note"),
                doc.getString("timestamp"),
            });
        }
    }
}
