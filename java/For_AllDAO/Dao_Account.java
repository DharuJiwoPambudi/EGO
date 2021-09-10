/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package For_AllDAO;

import For_AllBean.Bean_Account001;
import For_DbConnection.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACER
 */
public class Dao_Account {

    

    public int login(String user, String pass) {

        Connection conn = null;
        DbConnection dbCon = new DbConnection();
        conn = dbCon.getConnection();
        Statement st;
        ResultSet rs;

        int result = 0;
        try {
            st = conn.createStatement();
            String sql = "select * from admin where username='" + user + "' and password='" + pass + "'";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Bean_Account001 bean = new Bean_Account001();
                bean.setUsername(rs.getString("username"));
                bean.setPassword(rs.getString("password"));
                bean.setJenis(pass);
                result = st.executeUpdate(sql);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dao_Account.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbCon.closeConnection(conn);
        }
        return result;
    }

    public List LoginUser(String user, String password) {
        Connection conn = null;
        DbConnection dbConn = new DbConnection();
        conn = dbConn.getConnection();
        List data = new ArrayList();
        ResultSet rs;
        Statement st;
        try {
            String sql = "SELECT * FROM ACCOUNT where username='" + user + "' and password='" + password + "'";
//            rs = conn.getDataResult(sql);
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                Bean_Account001 am = new Bean_Account001();
                am.setUsername(rs.getString("username"));
                am.setJenis(rs.getString("jenis"));
                am.setPassword(rs.getString("password"));
                am.setAlamat(rs.getString("alamat"));
                am.setNomorhp(rs.getString("nomorhp"));
                data.add(am);
            }
//            dbConn.getDisconnection(rs);
        } catch (Exception a) {
            System.out.println("Terjadi kesalahaan cari login user, pada :\n" + a);
        }
        return data;
    }

    public int insert(Bean_Account001 acc) {
       Connection conn = null;
        DbConnection dbConn = new DbConnection();
        conn = dbConn.getConnection();
        int result = 0;

        try {
            String sql = "insert into account values(?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, acc.getUsername());
            ps.setString(2, acc.getPassword());
            ps.setString(3, acc.getNama());
            ps.setString(4, acc.getAlamat());
            ps.setString(5, acc.getNomorhp());
            ps.setString(6, acc.getJenis());
            result = ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Dao_Account.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConn.closeConnection(conn);
        }
        return result;
    }
}
