/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Process;

import java.sql.*;
import Database.Connect;

public class Nguoidung {
    public Connect cn= new Connect();
    //Truy van tat ca du lieu trong Table LoaiSP
    public ResultSet ShowNguoidung() throws SQLException{
        cn.connectSQL();
        String sql = "SELECT * FROM NGUOIDUNG WHERE XT = 0";
        return cn.LoadData(sql);
    }
    //Truy van cac dong du lieu trong Table LoaiSP theo Maloai
    public ResultSet ShowNguoidung(int ml) throws SQLException{
        String sql = "SELECT * FROM NGUOIDUNG where IDNGUOIDUNG='" + ml +"' AND XT = 0";
        return cn.LoadData(sql);
    }
    //Theo moi 1 dong du lieu vao table
    public void InsertData(String tnd, String tdn,String mk,int admin) throws SQLException{
        String sql = "INSERT INTO NGUOIDUNG values(N'" + tnd +"','" + tdn +"','" + mk +"','" + admin +"')";
        cn.UpdateData(sql);
    }
    
    //Dieu chinh 1 dong du lieu vao table LoaiSP
    public void EditData(int id,String tnd, String tdn,String mk,int admin) throws SQLException{
        String sql = "Update NGUOIDUNG set TENNGUOIDUNG=N'" + tnd
                + " MATKHAU='" + mk +"' ADMIN='" + admin +"' TENDANGNHAP='" + tdn + "' where IDNGUOIDUNG='" + id +"'";;

        cn.UpdateData(sql);
    }
    //Xoa 1 dong du lieu vao table LoaiSP
        public void DeleteData(int id) throws SQLException{
        String sql = "Delete from NGUOIDUNG where IDNGUOIDUNG='" + id +"' ";
        cn.UpdateData(sql);
    }
}
