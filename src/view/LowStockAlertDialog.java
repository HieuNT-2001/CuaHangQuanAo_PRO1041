package view;

import entity.InventoryAlert;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class LowStockAlertDialog extends JDialog {

    private JTable table;
    private DefaultTableModel model;

    public LowStockAlertDialog(Frame parent, List<InventoryAlert> alerts) {
        super(parent, "Cảnh báo tồn kho thấp", true);
        setSize(650, 400);
        setLocationRelativeTo(parent);

        initUI(alerts);
    }

    private void initUI(List<InventoryAlert> alerts) {
        setLayout(new BorderLayout());

        JLabel lblTitle = new JLabel("Danh sách sản phẩm có tồn kho thấp", JLabel.CENTER);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTitle.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(lblTitle, BorderLayout.NORTH);

        String[] columns = {"Mã SP", "Tên SP", "Tồn kho", "Ngưỡng < 10", "Thời gian"};
        model = new DefaultTableModel(columns, 0);

        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Load data
        for (InventoryAlert alert : alerts) {
            model.addRow(new Object[]{
                    alert.getProductId(),
                    alert.getProductName(),
                    alert.getCurrentStock(),
                    alert.getMessage(),
                    alert.getAlertTime().toString()
            });
        }

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        
        JButton btnDetails = new JButton("Xem chi tiết");
        JButton btnMarkRead = new JButton("Đánh dấu đã xem");
        JButton btnClose = new JButton("Đóng");

        bottomPanel.add(btnDetails);
        bottomPanel.add(btnMarkRead);
        bottomPanel.add(btnClose);

        add(bottomPanel, BorderLayout.SOUTH);

        btnClose.addActionListener(e -> dispose());

        btnDetails.addActionListener(e -> showProductDetail());
        btnMarkRead.addActionListener(e -> markAsRead());
    }

    private void showProductDetail() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Hãy chọn một sản phẩm!");
            return;
        }

        String productId = model.getValueAt(row, 0).toString();
        JOptionPane.showMessageDialog(this,
                "Chi tiết sản phẩm:\n\nMã: " + productId,
                "Thông tin sản phẩm", JOptionPane.INFORMATION_MESSAGE);
    }

    private void markAsRead() {
        JOptionPane.showMessageDialog(this, "Đã đánh dấu là đã xem!");
    }
}

