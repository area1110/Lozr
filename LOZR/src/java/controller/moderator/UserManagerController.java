/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.moderator;

import controller.authentication.BaseRequiredAuthentication;
import controller.module.PagingModule;
import dal.ReportThreadDBContext;
import dal.ReportUserDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ReportThread;
import model.ReportUser;

/**
 *
 * @author area1
 */
public class UserManagerController extends BaseRequiredAuthentication {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UserManagerController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserManagerController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);

        ReportUserDBContext reportUserDBC = new ReportUserDBContext();
        String raw_id = request.getParameter("id");

        if (raw_id == null || raw_id.isEmpty()) {
            String raw_pageIndex = request.getParameter("page");
            if (raw_pageIndex == null || raw_pageIndex.isEmpty()) {
                raw_pageIndex = "1";
            }
            int pageIndex = Integer.parseInt(raw_pageIndex);
            int totalRecord = reportUserDBC.getTotalUser();
            int totalPage = PagingModule.calcTotalPage(totalRecord);
            ArrayList<ReportUser> reportUsers= reportUserDBC.getUsers(pageIndex);
            request.setAttribute("totalPage", totalPage);
            request.setAttribute("reports", reportUsers);
            request.setAttribute("pageIndex", pageIndex);
            request.getRequestDispatcher("/view/moderator/UserManager.jsp").forward(request, response);
        } else {
            reportUserDBC.remove(Integer.parseInt(raw_id));
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
    protected void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
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
