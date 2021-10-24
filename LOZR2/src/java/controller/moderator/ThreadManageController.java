/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.moderator;

import controller.authentication.BaseAuthorization;
import controller.authentication.BaseRequiredAuthentication;
import controller.module.PagingModule;
import dal.ReportThreadDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.FThread;
import model.ReportThread;

/**
 *
 * @author area1
 */
public class ThreadManageController extends BaseAuthorization {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
    protected void actionGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ReportThreadDBContext reportThreadDBC = new ReportThreadDBContext();
        String raw_id = request.getParameter("id");

        if (raw_id == null || raw_id.isEmpty()) {
            String raw_pageIndex = request.getParameter("page");
            if (raw_pageIndex == null || raw_pageIndex.isEmpty()) {
                raw_pageIndex = "1";
            }
            int pageIndex = Integer.parseInt(raw_pageIndex);
            int totalRecord = reportThreadDBC.getTotalReportThreads();
            int totalPage = PagingModule.calcTotalPage(totalRecord);
            ArrayList<ReportThread> reportThreads = reportThreadDBC.getReportThreads(pageIndex);
            request.setAttribute("totalPage", totalPage);
            request.setAttribute("reports", reportThreads);
            request.setAttribute("pageIndex", pageIndex);
            request.getRequestDispatcher("/view/moderator/ThreadManager.jsp").forward(request, response);
        } else {
            reportThreadDBC.remove(Integer.parseInt(raw_id));
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
    protected void actionPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ReportThreadDBContext reportThreadDBC = new ReportThreadDBContext();
        String raw_id = request.getParameter("id");
        if (!(raw_id == null || raw_id.isEmpty())) {
            reportThreadDBC.updateStatusByReport(Integer.parseInt(raw_id), false);
        }
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
