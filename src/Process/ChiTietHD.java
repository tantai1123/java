/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Process;

import Database.Connect;
import java.sql.*;

/**
 *
 * @author TanTai
 */
public class ChiTietHD {
    public Connect cn= new Connect();
    //Truy van tat ca du lieu trong Table LoaiSP
    public ResultSet ShowChiTietHD() throws SQLException{
        cn.connectSQL();
        String sql = "SELECT * FROM ChiTietHD";
        return cn.LoadData(sql);
    }
    
    //Truy van cac dong du lieu trong Table LoaiSP theo Maloai
    public ResultSet ShowChiTietHD(int ml) throws SQLException{
        String sql = "SELECT * FROM ChiTietHD where IDHOADON='" + ml;
        return cn.LoadData(sql);
    }
    
    //Theo moi 1 dong du lieu vao table
    public void InsertData(int idban,Date ngaylap, Date giovao,Date giothanhtoan,String ca,String tenkh,int idnv) throws SQLException{
        String sql = "INSERT INTO HOADON values('" + idban +"','" + ngaylap +"','" + giovao +"','" + giothanhtoan +"',N'" + ca +"',N'" + tenkh +"','" + idnv +"')";
        cn.UpdateData(sql);
    }
    
    //Dieu chinh 1 dong du lieu vao table LoaiSP
    public void EditData(int id,int idban,Date ngaylap, Date giovao,Date giothanhtoan,String ca,String tenkh, int idnv) throws SQLException{
        String sql = "Update HOADON set IDBAN='" + idban
                + " NGAYLAP='" + ngaylap +"' GIOVAO='" + giovao +"' GIOTHANHTOAN='" + giothanhtoan + "'CA='" + ca + "'TENKHACHHANG='" + tenkh +"'IDNGUOIDUNG='" + idnv + "' where IDHOADON='" + id +"'";;

        cn.UpdateData(sql);
    }
    //Xoa 1 dong du lieu vao table LoaiSP
        public void DeleteData(int id) throws SQLException{
        String sql = "Delete from HOADON where IDHOADON='" + id +"' ";
        cn.UpdateData(sql);
    }
}
