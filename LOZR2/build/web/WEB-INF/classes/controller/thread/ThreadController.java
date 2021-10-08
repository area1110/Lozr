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
import model.UserInfo;

/**
 *
 * @author Khanh
 */
public class ThreadController extends BaseRequiredAuthentication {

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
            out.println("<title>Servlet ThreadController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ThreadController at " + request.getContextPath() + "</h1>");
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
        UserInfo currentUser = (UserInfo) request.getSession().getAttribute("currentUser");

        fthread.setSubject(threadName);
        fthread.setStartedBy(currentUser);

        Forum forum = new Forum();
        forum.setForumID(forumID);
        fthread.setForum(forum);

        fthreadDBC.setFThread(fthread);
        String parrentURL = ExtractURLPath.compressObjectToPath(request.getContextPath(), "forum", "", forumID);

//        response.getWriter().print(request.getContextPath());
        response.sendRedirect(parrentURL);
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
