/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package For_AllDAO;

import For_AllBean.Bean_JasaFish;
import For_AllBean.Bean_Laporan;
import For_DbConnection.DbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACER
 */
public class Dao_Laporan {

    public LinkedList<Bean_Laporan> getAllregist() {
        LinkedList<Bean_Laporan> dp = new LinkedList();
        DbConnection dbConn = new DbConnection();
        Connection conn = dbConn.getConnection();

        String sql = "select o.nama, a.username, a.alamat, o.calender, o.metode from order_jasa o join account a on (o.username=a.username)";

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Bean_Laporan fish = new Bean_Laporan();
                fish.setIdjasa(rs.getString("nama"));
                fish.setKonsumen(rs.getString("username"));
                fish.setAlamat(rs.getString("alamat"));
                fish.setTanggal(rs.getString("calender"));
                fish.setPembayaran(rs.getString("metode"));

                dp.add(fish);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dao_JasaFish.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConn.closeConnection(conn);
        }

        return dp;
    }

}
