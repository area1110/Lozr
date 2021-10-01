/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.authentication.BaseRequiredAuthentication;
import controller.module.Encode;
import controller.module.ExtractURLPath;
import dal.FThreadDBContext;
import dal.ForumDBContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.FThread;
import model.Forum;

/**
 *
 * @author Khanh
 */
public class ForumController extends BaseRequiredAuthentication {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        FThreadDBContext fThreadDBC = new FThreadDBContext();
        int forumID = ExtractURLPath.extractPathToID(request.getPathInfo());
        if (forumID == 0) {
            String errorMsg = "The requested forum could not be found.";
            request.setAttribute("errorMsg", errorMsg);
            request.getRequestDispatcher("").forward(request, response);
        } else if (getForum(forumID) == null) {
            String errorMsg = "The requested thread could not be found.";
            request.setAttribute("errorMsg", errorMsg);
            request.getRequestDispatcher("").forward(request, response);
        }
        ArrayList<FThread> fThreads = fThreadDBC.getFThreads(forumID);
        
        request.setAttribute("fThreads", fThreads);
        request.getRequestDispatcher("/view/ForumThreadView.jsp").forward(request, response);
    }
    
    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
        String forumName = request.getParameter("forumName");
        
        InputStream image = request.getPart("image").getInputStream();
        Encode encode = new Encode();
        String forumB64Image = encode.EncodeToBase64(image);
                    
        if (setForum(forumName, forumB64Image)) {
//            response.getWriter().print("<h1>Success Checkout DB</h1>");
            response.sendRedirect(request.getContextPath());
//            request.getRequestDispatcher(request.getContextPath()).forward(request, response);
        } else {            
            response.getWriter().print("<h1>Error Try Again</h1>");
//            String errMsg = "Oops! Something wrong<br/>Please try again!";
//            request.setAttribute("forumName", forumName);
//            request.setAttribute("errorMsg", errMsg);
//            request.getRequestDispatcher("/post/ForumPost.jsp").forward(request, response);
        }
        
    }

    //
    private Forum getForum(int forumID) {
        ForumDBContext forumDBC = new ForumDBContext();
        return forumDBC.getForum(forumID);
    }
    
    private boolean setForum(String forumName, String base64Image) {
        ForumDBContext forumDBC = new ForumDBContext();
        Forum forum = new Forum();
        forum.setName(forumName);
        forum.setBase64Image(base64Image);
        return forumDBC.setForum(forum);
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}