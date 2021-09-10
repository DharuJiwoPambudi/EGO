/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package For_DbConnection;

import For_AllBean.Bean_Account001;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACER
 */
public class DbConnection {

    Statement st = null;
    ResultSet rs = null;
    Connection conn = null;

    public Connection getConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            String host = "localhost";
            String username = "hr";
            String password = "dharujp1";
            String port = "1521";
            String sid = "orcl";

            String url = "jdbc:oracle:thin:@" + host + ":" + port + ":" + sid;

            conn = DriverManager.getConnection(url, username, password);

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (conn != null) {
            System.out.println("Berhasil Terkoneksi");
        } else {
            System.out.println("Gagal Terkoneksi");
        }
        return conn;
    }

    public Connection closeConnection(Connection conn) {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    public void getRegistData(Bean_Account001 account) {
        try {
            st.getConnection().createStatement();
            st.executeUpdate("insert into account values "
                    + "('" + account.getUsername() + "','" + account.getPassword() + "','" + account.getAlamat() + "','" + account.getNomorhp() + "','" + account.getJenis() + "')");
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getDisconnection(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            st.close();
            conn.close();
        } catch (Exception x) {
            System.out.println("Terjadi kesalahan diskoneksi : " + x);
        }
    }

    public ResultSet getDataResult(String sql) {
        ResultSet rs = null;
        try {
            getConnection();
            rs = st.executeQuery(sql);
        } catch (Exception x) {
            System.out.println("Terjadi kesalahan ambil data : " + x);
        }
        return rs;
    }

    public ResultSet ambilData(String sql) {
        ResultSet rs = null;
        try {
            getConnection();
            rs = st.executeQuery(sql);
        } catch (Exception x) {
            System.out.println("Terjadi kesalahan ambil data : " + x);
        }
        return rs;
    }
}
