/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TryItYourSelf;

import For_DbConnection.DbConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
@WebServlet(name = "For_UpdateAccount001", urlPatterns = {"/For_UpdateAccount001"})
public class For_UpdateAccount001 extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        
        DbConnection conn = new DbConnection();
        Statement st;
        ResultSet rs;
        PreparedStatement ps;
        
        try {
            HttpSession session = request.getSession();
            String user = request.getParameter("username");
            session.setAttribute("user", user);
            String usnm = (String) session.getAttribute("user");
            
            String sql = " select * from account where username = '" + usnm + "'";
            st = conn.getConnection().createStatement();
            rs = st.executeQuery(sql);
            st = conn.getConnection().prepareStatement(sql);
            rs = st.executeQuery(sql);
            
            String unem = rs.getString(1);
            String addr = rs.getString(3);
            String nohp = rs.getString(4);
            
            String query = "update account set alamat = ?, nomorhp = ? where username = '" + unem + "'";
            ps = conn.getConnection().prepareStatement(query);
            ps.setString(3, addr);
            ps.setString(4, nohp);
            ps.executeUpdate();
            response.sendRedirect("guiKonsumen.html");
        } catch (Exception e) {
            
        }
        
    }
}
