
package TryItYourSelf;

import For_AllBean.Bean_Account001;
import For_DbConnection.DbConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ACER
 */
@WebServlet(name = "For_GetAccount002", urlPatterns = {"/For_GetAccount002"})
public class For_GetAccount002 extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        DbConnection conn = new DbConnection();
        try {
            String user = request.getParameter("username");
            String pass = request.getParameter("password");
            String addr = request.getParameter("alamat");
            String nohp = request.getParameter("nomorhp");
            String gnre = "TimEO";

            Bean_Account001 acc = new Bean_Account001();
            acc.setUsername(user);
            acc.setPassword(pass);
            acc.setAlamat(addr);
            acc.setNomorhp(nohp);
            acc.setJenis(gnre);

            Statement st = conn.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from account where username = '" + user + "'");
            if (user.equals("") || pass.equals("") || nohp.equals("")) {
                out.print("<script>"
                        + "alert('Data username, password, dan nomor telepon tidak boleh kosong');"
                        + "document.location='daftarKonsumen.html';"
                        + "</script>");
            }
            String result = "";
            while (rs.next()) {
                result = rs.getString(1);
            }
            if (result.equals("")) {

                st.getConnection().createStatement();
                st.executeUpdate("insert into account values "
                        + "('" + user + "','" + pass + "','" + addr + "','" + nohp + "','" + gnre + "')");

                out.print("<script>"
                        + "confirm('Data berhasil dibuat');"
                        + "document.location='loginEGO.html';"
                        + "</script>");

            } else {
                out.print("<script>"
                        + "alert('Gagal Mendaftar, username yang dimasukkan telah terdaftar di dalam sistem!');"
                        + "document.location='daftarKonsumen.html';"
                        + "</script>");
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            out.close();
        }

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
