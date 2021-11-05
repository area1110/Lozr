/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.follow;

import controller.module.PagingModule;
import dal.ThreadDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.FThread;
import model.User;

/**
 *
 * @author area1
 */
public class ThreadFollowedManager extends HttpServlet {

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
            out.println("<title>Servlet ThreadFollowController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ThreadFollowController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
//        processRequest(request, response);
        ThreadDBContext threadDBC = new ThreadDBContext();
        User currentUser = (User) request.getSession().getAttribute("currentUser");
        String raw_page = request.getParameter("page");
        if (raw_page == null || raw_page.isEmpty()) {
            raw_page = "1";
        }
        int pageIndex = Integer.parseInt(raw_page);
        request.setAttribute("pageIndex", pageIndex);
        int totalRecord = threadDBC.getTotalFollowedThreads(currentUser.getUserID());
        int totalPage = PagingModule.calcTotalPage(totalRecord);
        request.setAttribute("totalPage", totalPage);
        ArrayList<FThread> threads = threadDBC.getFollowedThreads(currentUser.getUserID(), pageIndex);
        request.setAttribute("threads", threads);
        request.getRequestDispatcher("/view/follow/FollowedThreadView.jsp").forward(request, response);
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
