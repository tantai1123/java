package Database;

import java.sql.*;
import javax.swing.*;

public class Connect {
    public static Connection conn = null;
//Phuong thuc thuc hien ket noi CSDL
    public static Connection connectSQL() throws SQLException{
        try {
            String userName ="ba";
            String password = "8888";
            String url = "jdbc:sqlserver://DESKTOP-KFG376F\\SQLEXPRESS:1432;databaseName=QuanLyNhaHang;";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url,userName,password);
            return conn;
        }
        catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null,"Ket noi CSDL that bai","Thong bao",1);
            return null;
        }
    }
    
    //Phuong thuc dung de truy van CSDL
    public ResultSet LoadData(String sql){
        ResultSet result = null;
        try {
            Statement statement = conn.createStatement();
            return statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return null ;
        }
    }
    
    //Phuong thuc thuc hien Them, Xoa, Sua du lieu
    public void UpdateData(String sql){
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate(sql);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}