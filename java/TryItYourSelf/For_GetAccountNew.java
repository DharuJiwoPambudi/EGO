package TryItYourSelf;

import For_AllBean.Bean_Account001;
import For_AllDAO.Dao_Account;
import For_DbConnection.DbConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "For_GetAccountNew", urlPatterns = {"/For_GetAccountNew"})
public class For_GetAccountNew extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String proses = request.getParameter("proses");
        if (proses.equals("logout")) {
            HttpSession sesi = request.getSession();
            sesi.invalidate();
            out.print("<script>"
                    + "confirm('Anda berhasil logout');"
                    + "document.location='loginEGO.html';"
                    + "</script>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String proses = request.getParameter("proses");

        if (proses.equals("login")) {
            String user = request.getParameter("username");
            String pass = request.getParameter("password");
//            String jenis = request.getParameter("jenis");
//            String nomorhp = request.getParameter("nomorhp");
            if (pass == null || pass.equals("")) {   //validasi apabila field belum diisi
                response.sendRedirect("loginEGO.html");
            } else {
                Bean_Account001 pm = new Bean_Account001();
                Dao_Account acc = new Dao_Account();
                List<Bean_Account001> datalogin = new ArrayList<Bean_Account001>();

                datalogin = acc.LoginUser(user, pass);
                if (datalogin.isEmpty()) { //validasi apabila username dan password salah
                    response.sendRedirect("daftarKonsumen.jsp");
                } else {
                    HttpSession session = request.getSession(true);
                    session.setAttribute("username", datalogin.get(0).getUsername());
                    session.setAttribute("jenis", datalogin.get(0).getJenis());
                    session.setAttribute("alamat", datalogin.get(0).getAlamat());
                    session.setAttribute("nomorhp", datalogin.get(0).getAlamat());
                    if (datalogin.get(0).getJenis().equalsIgnoreCase("Konsumen")) {
                        response.sendRedirect("konsumen.jsp");
                    }
                    if (datalogin.get(0).getJenis().equalsIgnoreCase("TimEO")) {
                        response.sendRedirect("timEo.jsp");
                    }
                }
            }
        }
    }

}
