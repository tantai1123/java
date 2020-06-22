/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Process;

import java.sql.*;
import Database.Connect;

public class Mon {
    public Connect cn= new Connect();
    //Truy van tat ca du lieu trong Table LoaiSP
    public ResultSet ShowMon() throws SQLException{
        cn.connectSQL();
        String sql = "SELECT * FROM MON WHERE XT = 0";
        return cn.LoadData(sql);
    }
    //Truy van cac dong du lieu trong Table LoaiSP theo Maloai
    public ResultSet ShowMon(int ml) throws SQLException{
        String sql = "SELECT * FROM MON where IDMON='" + ml +"' AND XT = 0";
        return cn.LoadData(sql);
    }
    //Theo moi 1 dong du lieu vao table
    public void InsertData(String tenmon, float gia) throws SQLException{
        String sql = "INSERT INTO MON values(N'" + tenmon +"','" + gia +"')";
        cn.UpdateData(sql);
    }
    
    //Dieu chinh 1 dong du lieu vao table LoaiSP
    public void EditData(int id,String tenmon, float gia) throws SQLException{
        String sql = "Update MON set TENMON=N'" + tenmon
                + " GIA='" + gia +"' where IDMON='" + id +"'";;

        cn.UpdateData(sql);
    }
    //Xoa 1 dong du lieu vao table LoaiSP
        public void DeleteData(int id) throws SQLException{
        String sql = "Delete from MON where IDMON='" + id +"' ";
        cn.UpdateData(sql);
    }
}
