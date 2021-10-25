/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.thread;

import controller.authentication.BaseRequiredAuthentication;
import controller.module.ExtractURLPath;
import controller.module.PagingModule;
import dal.FThreadDBContext;
import dal.PostDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javafx.scene.control.Pagination;
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
public class ThreadController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        System.out.println("Path" +request.getPathInfo());
        int threadID = ExtractURLPath.extractPathToID(request.getPathInfo());
        FThreadDBContext fthreadDBC = new FThreadDBContext();
        FThread fthread = fthreadDBC.getFThread(threadID);
        if (fthread == null) {
            String errorMessage = "Oops, threre are something wrong?!";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("/view/ErrorView.jsp").forward(request, response);
        } else {
            PostDBContext postDBC = new PostDBContext();
            int totalRecord = postDBC.getTotalPosts(threadID);
            int totalPage = PagingModule.calcTotalPage(totalRecord);
            String raw_pageIndex = request.getParameter("page");
            if (raw_pageIndex == null || raw_pageIndex.isEmpty()) {
                raw_pageIndex = "" + totalPage;
            }
            int pageIndex = Integer.parseInt(raw_pageIndex);
            ArrayList< Post> posts = postDBC.getPosts(threadID, pageIndex);
            request.setAttribute("totalPage", totalPage);
            request.setAttribute("pageIndex", pageIndex);
            request.setAttribute("thread", fthread);
            request.setAttribute("posts", posts);
            request.getRequestDispatcher("../view/ThreadView.jsp").forward(request, response);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
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
