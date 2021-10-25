/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.search;

import controller.authentication.BaseRequiredAuthentication;
import controller.module.PagingModule;
import dal.FThreadDBContext;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.FThread;

/**
 *
 * @author area1
 */
public class SearchThreadController extends HttpServlet {

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
        FThreadDBContext threadDBC = new FThreadDBContext();

        String query = request.getParameter("q");
        String raw_pageIndex = request.getParameter("page");
        if (raw_pageIndex == null || raw_pageIndex.isEmpty()) {
            raw_pageIndex = "1";
        }
        int pageIndex = Integer.parseInt(raw_pageIndex);
        int totalRecord = threadDBC.getTotalThread(query);
        int totalPage = PagingModule.calcTotalPage(totalRecord);
        if (totalPage < pageIndex) {
            pageIndex = totalPage;
        }
        if (pageIndex < 1) {
            pageIndex = 1;
        }
        ArrayList<FThread> threads = threadDBC.getFThreads(query, pageIndex);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("pageIndex", pageIndex);
        request.setAttribute("query", query);
        request.setAttribute("threads", threads);
        request.getRequestDispatcher("/view/SearchThreadView.jsp").forward(request, response);
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
