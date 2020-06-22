/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Process;

import java.sql.*;
import Database.Connect;

/**
 *
 * @author TanTai
 */
public class Ban {

    public Connect cn = new Connect();

    public ResultSet ShowDanhSachBan() throws SQLException {
        cn.connectSQL();
        String sql = "SELECT * FROM BAN";
        return cn.LoadData(sql);
    }

    public ResultSet ShowDanhSachBan(int id) throws SQLException {
        String sql = "SELECT * FROM BAN where IDBAN='" + id + "'";
        return cn.LoadData(sql);
    }

    public void InsertData(int sg) throws SQLException {
        String sql = "INSERT INTO BAN values(" + sg + ")";
        cn.UpdateData(sql);
    }

    public void DeleteData(int id) throws SQLException {
        String sql = "Delete from BAN where IDBAN='" + id + "' ";
        cn.UpdateData(sql);
    }

    public void EditData(int id, int sg) throws SQLException {
        String sql = "Update BAN set SOGHE=" + sg + "where IDBAN='" + id + "'";
        cn.UpdateData(sql);
    }
}
