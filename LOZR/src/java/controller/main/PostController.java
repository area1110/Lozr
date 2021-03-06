/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.main;

import controller.authentication.BaseRequiredAuthentication;
import controller.module.ExtractURLPath;
import dal.PostDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Post;
import model.User;

/**
 *
 * @author Khanh
 */
public class PostController extends HttpServlet {

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
        String postSubject = request.getParameter("postSubject");
        int threadID = Integer.parseInt(request.getParameter("threadID"));

        User currentUser = (User) request.getSession().getAttribute("currentUser");

        Post post = new Post();
        post.setSubject(postSubject);
        post.setThreadId(threadID);
        post.setUser(currentUser);

        String raw_replyID = request.getParameter("replyID");
        if (!(raw_replyID == null || raw_replyID.isEmpty())) {
            int replyID = Integer.parseInt(raw_replyID);
            Post reply = new Post();
            reply.setPostID(replyID);
            post.setReplyPost(reply);
        }

        PostDBContext postDBC = new PostDBContext();
        postDBC.setPost(post);
        response.sendRedirect(request.getHeader("referer").split("[?]")[0]);
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
