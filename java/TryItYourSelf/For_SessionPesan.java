/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TryItYourSelf;

import For_DbConnection.DbConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ACER
 */
@WebServlet(name = "For_SessionPesan", urlPatterns = {"/For_SessionPesan"})
public class For_SessionPesan extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("username");
        String idjs = request.getParameter("namaJasa");
        String cldr = request.getParameter("cldr");
        String byr = request.getParameter("pembayaran");

        DbConnection conn = new DbConnection();
        Statement st = null;

        String sql = "insert into order_jasa values ('" + user + "','" + idjs + "','" + cldr + "','" + byr + "')";
        try {
            st = conn.getConnection().createStatement();
            st.executeUpdate(sql);
            
        } catch (SQLException ex) {
            Logger.getLogger(For_SessionPesan.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                st.close();
                out.print("<script>"
                        + "confirm('Pesanan anda segera diproses silahkan hubungi tim penyelenggara');"
                        + "document.location='gui_Konsumen.jsp';"
                        + "</script>");
            } catch (SQLException ex) {
                Logger.getLogger(For_SessionPesan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
