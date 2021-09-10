/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TryItYourSelf;

import For_DbConnection.DbConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "For_GetAccount001", urlPatterns = {"/For_GetAccount001"})
public class For_GetAccount001 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            String proses = request.getParameter("proses");
            if (proses.equalsIgnoreCase("logout")) {
                HttpSession session = request.getSession();
                session.invalidate();
                out.print("<script>"
                        + "confirm('Anda berhasil logout');"
                        + "document.location='guiAwal.html';"
                        + "</script>");
            }
        } catch (Exception e) {
            out.close();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        DbConnection conn = new DbConnection();
        try {
            String proses = request.getParameter("proses");
            if (proses.equalsIgnoreCase("login")) {
                String user = request.getParameter("username");
                String pass = request.getParameter("password");
                String cek = request.getParameter("cek");

//                String addr = request.getParameter("alamat");
//                String nohp = request.getParameter("nomorhp");
//                String gnre = request.getParameter("jenis");
                if (pass.equals("") || user.equals("")) {
                    out.print("<script>"
                            + "alert('Data username atau password tidak boleh kosong');"
                            + "document.location='loginEGO.html';"
                            + "</script>");
                } else {
//                    Bean_Account001 acc = new Bean_Account001();
//                    List<Bean_Account001> dataLogin = new ArrayList<Bean_Account001>();
//                    dataLogin = acc.LoginUser(user, pass);

                    String sql = "select * from account where username='" + user + "' and password='" + pass + "'";
                    Statement st = conn.getConnection().createStatement();
                    ResultSet rs = st.executeQuery(sql);

                    if (rs.next()) {

                        HttpSession session = request.getSession();
                        session.setAttribute("username", rs.getString(1));
                        session.setAttribute("jenis", rs.getString(5));
                        if (rs.getString(5).equalsIgnoreCase("konsumen")) {
                            response.sendRedirect("guiKonsumen.html");
                        } else {
                            response.sendRedirect("guiEO.html");
                        }
                    } else {
                        response.sendRedirect("daftarKonsumen.html");
                    }
                    if (cek.equals("checked")) {
                        Cookie cookieuser = new Cookie("user", user);
                        Cookie cookiepass = new Cookie("pass", pass);
                        response.addCookie(cookieuser);
                        response.addCookie(cookiepass);
                        Cookie[] cookies = request.getCookies();
                        boolean remember = false;
                        if (cookies != null) {
                            for (Cookie cooky : cookies) {
                                if (cooky.getName().equals("user")) {
                                    user = cooky.getValue();
                                    remember = true;
                                }
                            }
                        }
                        if (cookies != null) {
                            for (Cookie cooky : cookies) {
                                if (cooky.getName().equals("pass")) {
                                    pass = cooky.getValue();
                                    remember = true;
                                }
                            }
                        }
                        rs.close();
                        st.close();

                    }

//                    if (dataLogin.isEmpty()) {
//                        response.sendRedirect("daftarKonsumen.html");
//                    } else {
//                        HttpSession session = request.getSession(true);
//                        session.setAttribute("username", dataLogin.get(0).getUsername());
//                        session.setAttribute("jenis", dataLogin.get(0).getJenis());
//                        if (dataLogin.get(0).getJenis().equalsIgnoreCase("konsumen")) {
//                            response.sendRedirect("guiKonsumen.html");
//                        } else {
//                            response.sendRedirect("guiEO.html");
//                        }
//                    }
                }

            }
        } catch (Exception e) {
            out.close();
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
