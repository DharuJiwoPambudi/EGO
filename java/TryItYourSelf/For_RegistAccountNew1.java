/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TryItYourSelf;

import For_AllBean.Bean_Account001;
import For_AllDAO.Dao_Account;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ACER
 */
@WebServlet(name = "For_RegistAccountNew1", urlPatterns = {"/For_RegistAccountNew1"})
public class For_RegistAccountNew1 extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        String addr = request.getParameter("alamat");
        String nohp = request.getParameter("nomorhp");
        String gnre = "Konsumen";

        Bean_Account001 acc = new Bean_Account001();
        acc.setUsername(user);
        acc.setPassword(pass);
        acc.setNomorhp(nohp);
        acc.setAlamat(addr);
        acc.setJenis(gnre);

        Dao_Account account = new Dao_Account();
        int resilt = account.insert(acc);

        String forwardJsp = "";
        if (resilt > 0) {
            forwardJsp = "/guiKonsumen.jsp";
        } else {
            out.print("<script>"
                    + "alert('Gagal Mendaftar, username yang dimasukkan telah terdaftar di dalam sistem!');"
                    + "</script>");
            forwardJsp = "/daftarKosumen.html";
        }
        RequestDispatcher rd = request.getRequestDispatcher(forwardJsp);
        rd.forward(request, response);
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
