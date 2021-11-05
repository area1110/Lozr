/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.main;

import controller.authentication.BaseRequiredAuthentication;
import controller.module.ExtractURLPath;
import controller.module.PagingModule;
import dal.ThreadDBContext;
import dal.PostDBContext;
import dal.UserDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.FThread;
import model.Post;
import model.User;

/**
 *
 * @author area1
 */
public class UserPageController extends BaseRequiredAuthentication {

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
        int userID = ExtractURLPath.extractPathToID(request.getPathInfo());;
        UserDBContext userinfoDBC = new UserDBContext();
        User user = userinfoDBC.getUser(userID);
        request.setAttribute("user", user);
        if (user == null) {
            String errorMessage = "User Not Found!";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("/view/ErrorView.jsp").forward(request, response);
        } else {
            String raw_postselect = request.getParameter("postselect");
            if (raw_postselect == null || raw_postselect.isEmpty()) {
                raw_postselect = "0";
            }
            String raw_pageIndex = request.getParameter("page");
            if (raw_pageIndex == null || raw_pageIndex.isEmpty()) {
                raw_pageIndex = "1";
            }
            int pageIndex = Integer.parseInt(raw_pageIndex);
            request.setAttribute("pageIndex", pageIndex);
            if (raw_postselect.equals("1")) {
                PostDBContext postDBC = new PostDBContext();
                int totalRecord = postDBC.getTotalPostsByUser(userID);
                int totalPage = PagingModule.calcTotalPage(totalRecord);
                request.setAttribute("totalPage", totalPage);
                ArrayList<Post> posts = postDBC.getPostsByUser(userID, pageIndex);
                request.setAttribute("posts", posts);
                request.getRequestDispatcher("/view/user/UserInfoView_Post.jsp").forward(request, response);

            } else {
                ThreadDBContext threadDBC = new ThreadDBContext();
                int totalRecord = threadDBC.getTotalThreadsByUser(userID);
                int totalPage = PagingModule.calcTotalPage(totalRecord);
                request.setAttribute("totalPage", totalPage);
                ArrayList<FThread> fthreads = threadDBC.getFThreadsByUser(userID, pageIndex);
                request.setAttribute("threads", fthreads);
                request.getRequestDispatcher("/view/user/UserInfoView_Thread.jsp").forward(request, response);
            }
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
