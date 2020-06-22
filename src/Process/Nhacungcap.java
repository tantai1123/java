/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Process;

import java.sql.*;
import Database.Connect;

public class Nhacungcap {
    public Connect cn= new Connect();
    //Truy van tat ca du lieu trong Table LoaiSP
    public ResultSet ShowNhacungcap() throws SQLException{
        cn.connectSQL();
        String sql = "SELECT * FROM NHACUNGCAP WHERE XT = 0";
        return cn.LoadData(sql);
    }
    //Truy van cac dong du lieu trong Table LoaiSP theo Maloai
    public ResultSet ShowNhacungcap(int ml) throws SQLException{
        String sql = "SELECT * FROM NHACUNGCAP where IDNHACUNGCAP='" + ml +"' AND XT = 0";
        return cn.LoadData(sql);
    }
    //Theo moi 1 dong du lieu vao table
    public void InsertData(String tncc, String dc,String sdt) throws SQLException{
        String sql = "INSERT INTO NHACUNGCAP values(N'" + tncc +"',N'" + dc +"','" + sdt +"')";
        cn.UpdateData(sql);
    }
    
    //Dieu chinh 1 dong du lieu vao table LoaiSP
    public void EditData(int id,String tncc, String dc,String sdt) throws SQLException{
        String sql = "Update NHACUNGCAP set TENNHACUNGCAP=N'" + tncc
                + " DIACHI='" + dc +"' SDT='" + sdt +"'where IDNHACUNGCAP='" + id +"'";;

        cn.UpdateData(sql);
    }
    //Xoa 1 dong du lieu vao table LoaiSP
        public void DeleteData(int id) throws SQLException{
        String sql = "Delete from NHACUNGCAP where IDNHACUNGCAP='" + id +"' ";
        cn.UpdateData(sql);
    }
}
