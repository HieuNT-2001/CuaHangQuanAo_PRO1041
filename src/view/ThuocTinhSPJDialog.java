/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import dao.KichThuocDAO;
import dao.MauSacDAO;
import entity.KichThuoc;
import entity.MauSac;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import utils.MsgBox;

/**
 *
 * @author PC
 */
public class ThuocTinhSPJDialog extends javax.swing.JDialog {

    MauSacDAO msDAO = new MauSacDAO();
    KichThuocDAO ktDAO = new KichThuocDAO();
    int comboBoxIndex = 0;
    int tableIndex = -1;

    /**
     * Creates new form ThuocTinhSPJDialog
     */
    public ThuocTinhSPJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        fillTable();
    }

    private void fillTable() {
        if (comboBoxIndex == 0) {
            fillTable1();
        } else if (comboBoxIndex == 1) {
            fillTable2();
        }
    }

    private void fillTable1() {
        DefaultTableModel model = (DefaultTableModel) tblThuocTinhSP.getModel();
        model.setRowCount(0);
        List<MauSac> list = msDAO.SelectAll();
        for (MauSac ms : list) {
            Object[] rowData = {
                ms.getMaMS(),
                ms.getMauSac()
            };
            model.addRow(rowData);
        }
    }

    private void fillTable2() {
        DefaultTableModel model = (DefaultTableModel) tblThuocTinhSP.getModel();
        model.setRowCount(0);
        List<KichThuoc> list = ktDAO.SelectAll();
        for (KichThuoc kt : list) {
            Object[] rowData = {
                kt.getMaKT(),
                kt.getKichThuoc()
            };
            model.addRow(rowData);
        }
    }

    private void insert() {
        String value = txtGiaTri.getText();
        if (comboBoxIndex == 0) {
            MauSac ms = new MauSac();
            ms.setMauSac(value);
            msDAO.insert(ms);
            MsgBox.alert(this, "Thêm màu sắc thành công!");
        } else if (comboBoxIndex == 1) {
            KichThuoc kt = new KichThuoc();
            kt.setKichThuoc(value);
            ktDAO.insert(kt);
            MsgBox.alert(this, "Thêm kích thước thành công!");
        }
        fillTable();
    }

    private void update() {
        int id = (int) tblThuocTinhSP.getValueAt(this.tableIndex, 0);
        String value = txtGiaTri.getText();
        if (comboBoxIndex == 0) {
            MauSac ms = msDAO.SelectById(id);
            ms.setMauSac(value);
            msDAO.update(ms);
            MsgBox.alert(this, "Sửa màu sắc thành công!");
        } else if (comboBoxIndex == 1) {
            KichThuoc kt = ktDAO.SelectById(id);
            kt.setKichThuoc(value);
            ktDAO.update(kt);
            MsgBox.alert(this, "Sửa kích thước thành công!");
        }
        this.tableIndex = -1;
        fillTable();
    }

    private void delete() {
        int id = (int) tblThuocTinhSP.getValueAt(this.tableIndex, 0);
        if (comboBoxIndex == 0) {
            msDAO.delete(id);
            MsgBox.alert(this, "Xóa màu sắc thành công!");
        } else if (comboBoxIndex == 1) {
            ktDAO.delete(id);
            MsgBox.alert(this, "Xóa kích thước thành công!");
        }
        this.tableIndex = -1;
        fillTable();
    }

    private void setForm() {
        String value = tblThuocTinhSP.getValueAt(this.tableIndex, 1).toString();
        txtGiaTri.setText(value);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cboThuocTinh = new javax.swing.JComboBox<>();
        txtGiaTri = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblThuocTinhSP = new javax.swing.JTable();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Thuộc tính sản phẩm");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Thuộc tính sản phẩm");

        jLabel2.setText("Thuộc tính:");

        jLabel3.setText("Giá trị: ");

        cboThuocTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Màu sắc", "Kích thước" }));
        cboThuocTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboThuocTinhActionPerformed(evt);
            }
        });

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        tblThuocTinhSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã", "Giá trị: "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblThuocTinhSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblThuocTinhSPMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblThuocTinhSP);

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cboThuocTinh, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnThem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSua)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnXoa))
                            .addComponent(txtGiaTri))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cboThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtGiaTri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboThuocTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboThuocTinhActionPerformed
        // TODO add your handling code here:
        this.comboBoxIndex = (int) cboThuocTinh.getSelectedIndex();
        fillTable();
    }//GEN-LAST:event_cboThuocTinhActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        insert();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        this.tableIndex = tblThuocTinhSP.getSelectedRow();
        if (tableIndex >= 0) {
            delete();
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        this.tableIndex = tblThuocTinhSP.getSelectedRow();
        if (tableIndex >= 0) {
            update();
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void tblThuocTinhSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThuocTinhSPMouseClicked
        // TODO add your handling code here:
        this.tableIndex = tblThuocTinhSP.getSelectedRow();
        if (tableIndex >= 0) {
            setForm();
        }
    }//GEN-LAST:event_tblThuocTinhSPMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ThuocTinhSPJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThuocTinhSPJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThuocTinhSPJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThuocTinhSPJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ThuocTinhSPJDialog dialog = new ThuocTinhSPJDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cboThuocTinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblThuocTinhSP;
    private javax.swing.JTextField txtGiaTri;
    // End of variables declaration//GEN-END:variables
}
