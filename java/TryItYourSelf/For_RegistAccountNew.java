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
@WebServlet(name = "For_RegistAccountNew", urlPatterns = {"/For_RegistAccountNew"})
public class For_RegistAccountNew extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        String addr = request.getParameter("alamat");
        String nohp = request.getParameter("nomorhp");
        String gnre = "TimEO";
        String nama = request.getParameter("nama");
        
        Bean_Account001 acc = new Bean_Account001();
        acc.setUsername(user);
        acc.setPassword(pass);
        acc.setNomorhp(nohp);
        acc.setAlamat(addr);
        acc.setJenis(gnre);
        acc.setNama(nama);
        
        Dao_Account account = new Dao_Account();
        int resilt = account.insert(acc);
        
        String forwardJsp = "";
        if (resilt > 0) {
            forwardJsp = "/loginEGO.html";
            
        } else {
            out.print("<script>"
                    + "alert('Gagal Mendaftar, username yang dimasukkan telah terdaftar di dalam sistem!');"
                    + "</script>");
            forwardJsp = "/daftarEO.jsp";
            
        }
        RequestDispatcher rd = request.getRequestDispatcher(forwardJsp);
        rd.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        String addr = request.getParameter("alamat");
        String nohp = request.getParameter("nomorhp");
        String gnre = "Konsumen";
        String nama = request.getParameter("nama");
        
        Bean_Account001 acc = new Bean_Account001();
        acc.setUsername(user);
        acc.setPassword(pass);
        acc.setNomorhp(nohp);
        acc.setAlamat(addr);
        acc.setJenis(gnre);
        acc.setNama(nama);
        
        Dao_Account account = new Dao_Account();
        int resilt = account.insert(acc);
//        account.insert(acc);

        String forwardJsp = "";
        if (resilt > 0) {
            forwardJsp = "/loginEGO.html";
            
        } else {
            out.print("<script>"
                    + "alert('Gagal Mendaftar, username yang dimasukkan telah terdaftar di dalam sistem!');"
                    + "</script>");
            forwardJsp = "/daftarKosumen.jsp";
            
        }
        RequestDispatcher rd = request.getRequestDispatcher(forwardJsp);
        rd.forward(request, response);
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
