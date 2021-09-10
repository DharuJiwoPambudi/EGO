/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TryItYourSelf;

import For_AllBean.Bean_RegistJasaFish;
import For_AllBean.Bean_RegistLaporan;
import For_AllDAO.Dao_JasaFish;
import For_AllDAO.Dao_Laporan;
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
@WebServlet(name = "For_ViewLaporan", urlPatterns = {"/For_ViewLaporan"})
public class For_ViewLaporan extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Dao_Laporan pDao = new Dao_Laporan();
        Bean_RegistLaporan dp = new Bean_RegistLaporan();
        dp.setDaftar(pDao.getAllregist());
        request.setAttribute("bean_RegistLaporan", dp);

        RequestDispatcher rd = request.getRequestDispatcher("/formLihatLaporan.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
