package TryItYourSelf;

import For_AllBean.Bean_JasaFish;
import For_AllDAO.Dao_JasaFish;
import For_DbConnection.DbConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "For_RegistAccount002", urlPatterns = {"/For_RegistAccount002"})
public class For_RegistAccount002 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        String idjs = request.getParameter("idjasa");
        String name = request.getParameter("nama");
        String user = request.getParameter("timeo");
        String loct = request.getParameter("lokasi");
        String desc = request.getParameter("keterangan");
        Double prce = Double.parseDouble(request.getParameter("harga"));
        String gnre = request.getParameter("jenis");

        Bean_JasaFish fish = new Bean_JasaFish();
        fish.setNama(name);
        fish.setTimeo(user);
        fish.setLokasi(loct);
        fish.setKeterangan(desc);
        fish.setHarga(prce);
        fish.setJenis(gnre);
        fish.setIdjasa(idjs);

        Dao_JasaFish jasaFish = new Dao_JasaFish();
        int resilt = jasaFish.getInsert(fish);

        String forwardJsp = "";
        if (resilt > 0) {
            forwardJsp = "/guiEO.jsp";
        } else {
            forwardJsp = "/formMasukkanJasa.html";
        }
        RequestDispatcher rd = request.getRequestDispatcher(forwardJsp);
        rd.forward(request, response);

//        String time = request.getParameter("timeo");
//        String gnre = request.getParameter("jenis");
//        Double prce = Double.parseDouble(request.getParameter("harga"));
//        String loct = request.getParameter("lokasi");
//
//        Statement st = null;
//        DbConnection conn = new DbConnection();
//
//        String sql = "insert into jasa values "
//                + "('" + time + "','" + gnre + "','" + prce + "','" + loct + "')";
//        String sql1 = "select * from jasa where timeo = '" + time + "'";
//
//        try {
//            if (time.equals("") || gnre.equals("") || prce.isNaN() || loct.equals("")) {
//                st = conn.getConnection().createStatement();
//                st.executeUpdate(sql1);
//                response.sendRedirect("formMasukkanJasa.html");
//            } else {
//                st = conn.getConnection().createStatement();
//                st.executeUpdate(sql);
////                response.sendRedirect("guiEO.html");
//                out.print("<script>"
//                        + "alert('Jasa berhasil ditambahkan');"
//                        + "document.location='guiEO.html';"
//                        + "</script>");
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(For_RegistAccount002.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println("error query");
//        } finally {
//            try {
//                st.close();
//            } catch (SQLException ex) {
//                Logger.getLogger(For_RegistAccount002.class.getName()).log(Level.SEVERE, null, ex);
//                System.out.println("error semua");
//            }
//
//        }
    }

}
