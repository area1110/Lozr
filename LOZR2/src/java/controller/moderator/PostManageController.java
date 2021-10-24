/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.moderator;

import controller.authentication.BaseAuthorization;
import controller.authentication.BaseRequiredAuthentication;
import controller.module.PagingModule;
import dal.ReportPostDBContext;
import dal.ReportThreadDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.FThread;
import model.Post;
import model.ReportPost;
import model.ReportThread;

/**
 *
 * @author area1
 */
public class PostManageController extends BaseAuthorization {

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
        ReportPostDBContext reportPostDBC = new ReportPostDBContext();
        String raw_id = request.getParameter("id");
        if (raw_id == null) {
               String raw_pageIndex = request.getParameter("page");
            if (raw_pageIndex == null || raw_pageIndex.isEmpty()) {
                raw_pageIndex = "1";
            }
            int pageIndex = Integer.parseInt(raw_pageIndex);
            int totalRecord = reportPostDBC.getTotalPostReport();
            int totalPage = PagingModule.calcTotalPage(totalRecord);
            ArrayList<ReportPost> reportPosts = reportPostDBC.getPosts(pageIndex);
            request.setAttribute("totalPage", totalPage);
            request.setAttribute("reports", reportPosts);
            request.setAttribute("pageIndex", pageIndex);
            request.setAttribute("posts", reportPosts);
            request.getRequestDispatcher("/view/moderator/PostManager.jsp").forward(request, response);
        } else {
            reportPostDBC.remove(Integer.parseInt(raw_id));
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
    protected void actionGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

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
