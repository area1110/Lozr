/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.thread;

import controller.authentication.BaseRequiredAuthentication;
import controller.module.ExtractURLPath;
import dal.FThreadDBContext;
import dal.PostDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.FThread;
import model.Forum;
import model.Post;
import model.User;

/**
 *
 * @author Khanh
 */
public class ThreadController extends BaseRequiredAuthentication {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        System.out.println("Path" +request.getPathInfo());
        int threadID = ExtractURLPath.extractPathToID(request.getPathInfo());
        if (threadID == 0) {
            response.getWriter().print("0");
        } else {
            FThreadDBContext fthreadDBC = new FThreadDBContext();
            FThread fthread = fthreadDBC.getFThread(threadID);
            if (fthread == null) {
                response.getWriter().print("null");
            } else {
                PostDBContext postDBC = new PostDBContext();
                ArrayList<Post> posts = postDBC.getPosts(threadID);
                request.setAttribute("thread", fthread);
                request.setAttribute("posts", posts);
                request.getRequestDispatcher("../view/ThreadView.jsp").forward(request, response);
            }
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
        String threadName = request.getParameter("threadName");
        int forumID = Integer.parseInt(request.getParameter("forumID"));
        FThreadDBContext fthreadDBC = new FThreadDBContext();
        FThread fthread = new FThread();
        User currentUser = (User) request.getSession().getAttribute("currentUser");

        fthread.setSubject(threadName);
        fthread.setStartedBy(currentUser);

        Forum forum = new Forum();
        forum.setForumID(forumID);
        fthread.setForum(forum);
        fthreadDBC.setFThread(fthread);
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
