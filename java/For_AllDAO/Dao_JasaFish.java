package For_AllDAO;

import For_AllBean.Bean_JasaFish;
import For_DbConnection.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class Dao_JasaFish {

    public int getInsert(Bean_JasaFish jasaFish) {
        Connection conn = null;
        DbConnection dbConn = new DbConnection();
        conn = dbConn.getConnection();
        int result = 0;

        try {
            String sql = "insert into jasa values(?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, jasaFish.getIdjasa());
            ps.setString(2, jasaFish.getNama());
            ps.setDouble(3, jasaFish.getHarga());
            ps.setString(4, jasaFish.getJenis());
            ps.setString(5, jasaFish.getKeterangan());
            ps.setString(6, jasaFish.getTimeo());
            ps.setString(7, jasaFish.getLokasi());
            result = ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Dao_JasaFish.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConn.closeConnection(conn);
        }

        return result;
    }

    public LinkedList<Bean_JasaFish> getAllregist() {
        LinkedList<Bean_JasaFish> dp = new LinkedList();
        DbConnection dbConn = new DbConnection();
        Connection conn = dbConn.getConnection();

        String sql = "select * from jasa";

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Bean_JasaFish fish = new Bean_JasaFish();
                fish.setIdjasa(rs.getString(1));
                fish.setNama(rs.getString(2));
                fish.setHarga(rs.getDouble(3));
                fish.setJenis(rs.getString(4));
                fish.setKeterangan(rs.getString(5));
                fish.setTimeo(rs.getString(6));
                fish.setLokasi(rs.getString(7));

                dp.add(fish);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dao_JasaFish.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConn.closeConnection(conn);
        }

        return dp;
    }

    public LinkedList<Bean_JasaFish> getAllLocJkt() {

        LinkedList<Bean_JasaFish> dp = new LinkedList();
        DbConnection dbConn = new DbConnection();
        Connection conn = dbConn.getConnection();

        String sql = "select * from jasa where lokasi = 'Jakarta'";

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Bean_JasaFish fish = new Bean_JasaFish();
                fish.setIdjasa(rs.getString(1));
                fish.setNama(rs.getString(2));
                fish.setHarga(rs.getDouble(3));
                fish.setJenis(rs.getString(4));
                fish.setKeterangan(rs.getString(5));
                fish.setTimeo(rs.getString(6));
                fish.setLokasi(rs.getString(7));
                dp.add(fish);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dao_JasaFish.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConn.closeConnection(conn);
        }

        return dp;
    }

    public LinkedList<Bean_JasaFish> getAllLocYgy() {
        LinkedList<Bean_JasaFish> dp = new LinkedList();
        DbConnection dbConn = new DbConnection();
        Connection conn = dbConn.getConnection();

        String sql = "select * from jasa where lokasi = 'Yogyakarta'";

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Bean_JasaFish fish = new Bean_JasaFish();
                fish.setIdjasa(rs.getString(1));
                fish.setNama(rs.getString(2));
                fish.setHarga(rs.getDouble(3));
                fish.setJenis(rs.getString(4));
                fish.setKeterangan(rs.getString(5));
                fish.setTimeo(rs.getString(6));
                fish.setLokasi(rs.getString(7));
                dp.add(fish);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dao_JasaFish.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConn.closeConnection(conn);
        }

        return dp;
    }
        public LinkedList<Bean_JasaFish> getAllLocSby() {

        LinkedList<Bean_JasaFish> dp = new LinkedList();
        DbConnection dbConn = new DbConnection();
        Connection conn = dbConn.getConnection();

        String sql = "select * from jasa where lokasi = 'Surabaya'";

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Bean_JasaFish fish = new Bean_JasaFish();
                fish.setIdjasa(rs.getString(1));
                fish.setNama(rs.getString(2));
                fish.setHarga(rs.getDouble(3));
                fish.setJenis(rs.getString(4));
                fish.setKeterangan(rs.getString(5));
                fish.setTimeo(rs.getString(6));
                fish.setLokasi(rs.getString(7));
                dp.add(fish);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dao_JasaFish.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConn.closeConnection(conn);
        }

        return dp;
    }

    public LinkedList<Bean_JasaFish> getAllLocPpa() {
        LinkedList<Bean_JasaFish> dp = new LinkedList();
        DbConnection dbConn = new DbConnection();
        Connection conn = dbConn.getConnection();

        String sql = "select * from jasa where lokasi = 'Papua'";

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Bean_JasaFish fish = new Bean_JasaFish();
                fish.setIdjasa(rs.getString(1));
                fish.setNama(rs.getString(2));
                fish.setHarga(rs.getDouble(3));
                fish.setJenis(rs.getString(4));
                fish.setKeterangan(rs.getString(5));
                fish.setTimeo(rs.getString(6));
                fish.setLokasi(rs.getString(7));
                dp.add(fish);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dao_JasaFish.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConn.closeConnection(conn);
        }

        return dp;
    }

    public LinkedList<Bean_JasaFish> getAllPrc1_5() {
        LinkedList<Bean_JasaFish> dp = new LinkedList();
        DbConnection dbConn = new DbConnection();
        Connection conn = dbConn.getConnection();

        String sql = "select * from jasa  where harga between 1000000 and 5000000";

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Bean_JasaFish fish = new Bean_JasaFish();
                fish.setIdjasa(rs.getString(1));
                fish.setNama(rs.getString(2));
                fish.setHarga(rs.getDouble(3));
                fish.setJenis(rs.getString(4));
                fish.setKeterangan(rs.getString(5));
                fish.setTimeo(rs.getString(6));
                fish.setLokasi(rs.getString(7));
                dp.add(fish);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dao_JasaFish.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConn.closeConnection(conn);
        }

        return dp;
    }

    public LinkedList<Bean_JasaFish> getAllPrc5_10() {
        LinkedList<Bean_JasaFish> dp = new LinkedList();
        DbConnection dbConn = new DbConnection();
        Connection conn = dbConn.getConnection();

        String sql = "select * from jasa  where harga between 5000000 and 10000000";

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Bean_JasaFish fish = new Bean_JasaFish();
                fish.setIdjasa(rs.getString(1));
                fish.setNama(rs.getString(2));
                fish.setHarga(rs.getDouble(3));
                fish.setJenis(rs.getString(4));
                fish.setKeterangan(rs.getString(5));
                fish.setTimeo(rs.getString(6));
                fish.setLokasi(rs.getString(7));
                dp.add(fish);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dao_JasaFish.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConn.closeConnection(conn);
        }

        return dp;
    }

    public LinkedList<Bean_JasaFish> getAllPrc10() {
        LinkedList<Bean_JasaFish> dp = new LinkedList();
        DbConnection dbConn = new DbConnection();
        Connection conn = dbConn.getConnection();

        String sql = "select * from jasa  where harga > 1000000";

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Bean_JasaFish fish = new Bean_JasaFish();
                fish.setIdjasa(rs.getString(1));
                fish.setNama(rs.getString(2));
                fish.setHarga(rs.getDouble(3));
                fish.setJenis(rs.getString(4));
                fish.setKeterangan(rs.getString(5));
                fish.setTimeo(rs.getString(6));
                fish.setLokasi(rs.getString(7));
                dp.add(fish);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dao_JasaFish.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConn.closeConnection(conn);
        }

        return dp;
    }

    public LinkedList<Bean_JasaFish> getAllGnrWddg() {
        LinkedList<Bean_JasaFish> dp = new LinkedList();
        DbConnection dbConn = new DbConnection();
        Connection conn = dbConn.getConnection();

        String sql = "select * from jasa  where jenis like 'Pernikahan'";

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Bean_JasaFish fish = new Bean_JasaFish();
                fish.setIdjasa(rs.getString(1));
                fish.setNama(rs.getString(2));
                fish.setHarga(rs.getDouble(3));
                fish.setJenis(rs.getString(4));
                fish.setKeterangan(rs.getString(5));
                fish.setTimeo(rs.getString(6));
                fish.setLokasi(rs.getString(7));
                dp.add(fish);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dao_JasaFish.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConn.closeConnection(conn);
        }

        return dp;
    }

    public LinkedList<Bean_JasaFish> getAllGnrMice() {
        LinkedList<Bean_JasaFish> dp = new LinkedList();
        DbConnection dbConn = new DbConnection();
        Connection conn = dbConn.getConnection();

        String sql = "select * from jasa  where jenis like 'Mice'";

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Bean_JasaFish fish = new Bean_JasaFish();
                fish.setIdjasa(rs.getString(1));
                fish.setNama(rs.getString(2));
                fish.setHarga(rs.getDouble(3));
                fish.setJenis(rs.getString(4));
                fish.setKeterangan(rs.getString(5));
                fish.setTimeo(rs.getString(6));
                fish.setLokasi(rs.getString(7));
                dp.add(fish);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dao_JasaFish.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConn.closeConnection(conn);
        }

        return dp;
    }

    public LinkedList<Bean_JasaFish> getAllEvent() {
        LinkedList<Bean_JasaFish> dp = new LinkedList();
        DbConnection dbConn = new DbConnection();
        Connection conn = dbConn.getConnection();

        String sql = "select * from jasa  where jenis like 'Acara'";

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Bean_JasaFish fish = new Bean_JasaFish();
                fish.setIdjasa(rs.getString(1));
                fish.setNama(rs.getString(2));
                fish.setHarga(rs.getDouble(3));
                fish.setJenis(rs.getString(4));
                fish.setKeterangan(rs.getString(5));
                fish.setTimeo(rs.getString(6));
                fish.setLokasi(rs.getString(7));
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
