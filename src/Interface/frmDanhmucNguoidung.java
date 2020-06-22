/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.sql.ResultSet;
import java.sql.SQLException;
import Process.Nguoidung;//Lớp LoaiSP trong Proccess đã thực hiện
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frmDanhmucNguoidung extends javax.swing.JFrame {
    
    private final Nguoidung lsp = new Nguoidung();
    private boolean cothem=true;
    private final DefaultTableModel tableModel = new DefaultTableModel();
    
    //Ham do du lieu vao tableModel
    public void ShowData() throws SQLException{
        ResultSet result= lsp.ShowNguoidung();
        try {
            while(result.next()){ // nếu còn đọc tiếp được một dòng dữ liệu
                String rows[] = new String[5];
                rows[0] = result.getString(1); // lấy dữ liệu tại cột số 1 (ứng với mã hàng)
                rows[1] = result.getString(2); // lấy dữ liệu tai cột số 2 ứng với tên hàng
                rows[2] = result.getString(3);
                rows[3] = result.getString(5);
                tableModel.addRow(rows); // đưa dòng dữ liệu vào tableModel
                //mỗi lần có sự thay đổi dữ liệu ở tableModel thì Jtable sẽ tự động update
            }
        }
        catch (SQLException e) {
        }
    }
    
    //Ham xoa du lieu trong tableModel
    public void ClearData() throws SQLException{
        //Lay chi so dong cuoi cung
        int n=tableModel.getRowCount()-1;
        for(int i=n;i>=0;i--)
        tableModel.removeRow(i);//Remove tung dong
    }
    
    //Ham xoa cac TextField
    private void setNull()
    {
        //Xoa trang cac JtextField
        this.tfTennd.setText(null);
        this.tfTendn.setText(null);
        this.tfMatkhau.setText(null);
        this.tfTennd.requestFocus();
    }
    
    //Ham khoa cac TextField
    private void setKhoa(boolean a)
    {
        //Khoa hoac mo khoa cho Cac JTextField
        this.tfTendn. setEnabled (!a);
        this.tfTennd. setEnabled (!a);
        this.tfMatkhau. setEnabled (!a);
    }
    
    //Ham khoa cac Button
    private void setButton(boolean a)
    {
        //Vo hieu hoac co hieu luc cho cac JButton
        this.btnthem. setEnabled (a);
        this.btnxoa. setEnabled (a);
        this.btnsua. setEnabled (a);
        this.btnluu. setEnabled (!a);
        this.btnkhluu. setEnabled (!a);
        this.btnthoat. setEnabled (a);
    }
    
    public frmDanhmucNguoidung() throws SQLException{
        initComponents();
        String []colsName = {"STT", "Tên người dùng","Tên đăng nhập","Admin"};
        // đặt tiêu đề cột cho tableModel
        tableModel.setColumnIdentifiers(colsName);
        // kết nối jtable với tableModel
        tbnguoidung.setModel(tableModel);
        //gọi hàm ShowData để đưa dữ liệu vào tableModel
        ShowData();
        //goi Ham xoa trang cac TextField
        setNull();
        //Goi ham Khoa cac TextField
        setKhoa(true);
        //Goi vo hieu 2 button Luu, K.Luu. Mo khoa 4 button con lao
        setButton(true);
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
        jLabel2 = new javax.swing.JLabel();
        tfTennd = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfTendn = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfMatkhau = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbnguoidung = new javax.swing.JTable();
        btnthem = new javax.swing.JButton();
        btnxoa = new javax.swing.JButton();
        btnsua = new javax.swing.JButton();
        btnluu = new javax.swing.JButton();
        btnkhluu = new javax.swing.JButton();
        btnthoat = new javax.swing.JButton();

        setTitle("Quản lý nhà hàng");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("DANH MỤC NGƯỜI DÙNG");

        jLabel2.setText("Tên người dùng");

        jLabel3.setText("Tên đăng nhập");

        jLabel4.setText("Mật khẩu");

        jLabel5.setText("Admin");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        tbnguoidung.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "STT", "Tên người dùng", "Tên đăng nhập", "Admin"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbnguoidung.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbnguoidungMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbnguoidung);

        btnthem.setText("Thêm");
        btnthem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnthemMouseClicked(evt);
            }
        });
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

        btnxoa.setText("Xóa");
        btnxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaActionPerformed(evt);
            }
        });

        btnsua.setText("Sửa");
        btnsua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnsuaMouseClicked(evt);
            }
        });
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });

        btnluu.setText("Lưu");
        btnluu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnluuMouseClicked(evt);
            }
        });

        btnkhluu.setText("Không lưu");
        btnkhluu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnkhluuMouseClicked(evt);
            }
        });

        btnthoat.setText("Thoát");
        btnthoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(229, 229, 229))
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfTennd, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfMatkhau, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfTendn, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnthem)
                        .addGap(18, 18, 18)
                        .addComponent(btnxoa)
                        .addGap(18, 18, 18)
                        .addComponent(btnsua)
                        .addGap(18, 18, 18)
                        .addComponent(btnluu)
                        .addGap(18, 18, 18)
                        .addComponent(btnkhluu)
                        .addGap(18, 18, 18)
                        .addComponent(btnthoat)))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfTennd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(tfTendn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfMatkhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnthem)
                    .addComponent(btnxoa)
                    .addComponent(btnsua)
                    .addComponent(btnluu)
                    .addComponent(btnkhluu)
                    .addComponent(btnthoat))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(122, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbnguoidungMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbnguoidungMouseClicked
        try{
        //Lay chi so dong dang chon
                int row =this.tbnguoidung.getSelectedRow();
                String ml=  (this.tbnguoidung.getModel().getValueAt(row,0)).toString();
                int a = Integer.parseInt(ml);
                ResultSet rs= lsp.ShowNguoidung(a);//Goi ham lay du lieu theo ma loai
            if(rs.next())//Neu co du lieu
            {
                this.tfTennd.setText(rs.getString("TENNGUOIDUNG"));
                this.tfTendn.setText(rs.getString("TENDANGNHAP"));
            }
        }
        catch (SQLException e) {
        }
    }//GEN-LAST:event_tbnguoidungMouseClicked

    private void btnthoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthoatActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnthoatActionPerformed

    private void btnxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaActionPerformed
        String ml=tfTennd.getText();
        int row =this.tbnguoidung.getSelectedRow();
        String stt=  (this.tbnguoidung.getModel().getValueAt(row,0)).toString();
        int a = Integer.parseInt(stt);
        try {
            if(ml.length()==0)
                JOptionPane.showMessageDialog(null,"Chọn để xóa",
                "Thông báo",1);
            else
            {
                if( JOptionPane.showConfirmDialog(null, "Bạn muốn xóa tên " + ml + " này hay không ?","Thông báo",2) == 0)
                    {
                        lsp.DeleteData(a);//goi ham xoa du lieu theo ma loai
                        ClearData();//Xoa du lieu trong tableModel
                        ShowData();//Do du lieu vao table Model
                        setNull();//Xoa trang Textfield
                    }
                }
            }
        catch (SQLException ex) {
        JOptionPane.showMessageDialog(null,"Xóa thất bại","Thông báo",1);
        }
    }//GEN-LAST:event_btnxoaActionPerformed

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
        
    }//GEN-LAST:event_btnthemActionPerformed

    private void btnthemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnthemMouseClicked
        setNull();//Xoa trang TextField
        setKhoa(false);//Mo khoa TextField
        setButton(false);//Goi ham khoa cac Button
        cothem=true;//Gan cothem = true de ghi nhan trang thai them moi
    }//GEN-LAST:event_btnthemMouseClicked

    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
        
    }//GEN-LAST:event_btnsuaActionPerformed

    private void btnsuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsuaMouseClicked
        String ml=tfTennd.getText();
        if(ml.length()==0) //Chua chon Ma loai
        JOptionPane.showMessageDialog(null,"Vui lòng chọn để sửa đổi","Thông báo",1);
        else
            {
            setKhoa(false);//Mo khoa cac TextField
            this.tfTendn.enable(true);
            this.tfTennd.enable(true);
            setButton(false); //Khoa cac Button
            cothem=false; //Gan cothem=false de ghi nhan trang thai la sua
            }
    }//GEN-LAST:event_btnsuaMouseClicked

    private void btnkhluuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnkhluuMouseClicked
        setNull();
        setKhoa(true);
        setButton(true);
    }//GEN-LAST:event_btnkhluuMouseClicked

    private void btnluuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnluuMouseClicked
        int row =this.tbnguoidung.getSelectedRow();
        String stt=  (this.tbnguoidung.getModel().getValueAt(row,0)).toString();
        int a = Integer.parseInt(stt);
        
        String ml=tfTendn.getText().trim();
        String tl=tfTennd.getText().trim();
        String mk = tfMatkhau.getText().trim();;
        int ad = 1 ;
        
        if(ml.length()==0 || tl.length()==0)
            JOptionPane.showMessageDialog(null,"Vui lòng nhập đầy đủ","Thông báo",1);
        else
            try {
                if(cothem==true) //Luu cho tthem moi
                    lsp.InsertData(ml, tl,mk,ad);
                else //Luu cho sua
                    lsp.EditData(a,ml, tl,mk,ad);
                    ClearData(); //goi ham xoa du lieu tron tableModel
                    ShowData(); //Do lai du lieu vao Table Model
            }
            catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Cập nhật thất bại","Thông báo",1);
            }
            setKhoa(false);
            setButton(true);
    }//GEN-LAST:event_btnluuMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])throws SQLException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        frmDanhmucNguoidung frmng = new frmDanhmucNguoidung();
        frmng.setVisible(true);
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmDanhmucNguoidung.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmDanhmucNguoidung.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmDanhmucNguoidung.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmDanhmucNguoidung.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new frmDanhmucNguoidung().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnkhluu;
    private javax.swing.JButton btnluu;
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnthem;
    private javax.swing.JButton btnthoat;
    private javax.swing.JButton btnxoa;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbnguoidung;
    private javax.swing.JTextField tfMatkhau;
    private javax.swing.JTextField tfTendn;
    private javax.swing.JTextField tfTennd;
    // End of variables declaration//GEN-END:variables
}