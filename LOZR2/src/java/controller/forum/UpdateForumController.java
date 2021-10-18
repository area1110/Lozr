/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.forum;

import controller.authentication.BaseRequiredAuthentication;
import controller.module.Encode;
import dal.ForumDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.Forum;
import model.UserInfo;

/**
 *
 * @author area1
 */
public class UpdateForumController extends BaseRequiredAuthentication {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String errorMessage = "Oops, threre are something wrong?!";
        request.setAttribute("errorMessage", errorMessage);
        request.getRequestDispatcher("/view/ErrorView.jsp").forward(request, response);
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
        UserInfo currentUser = (UserInfo) request.getSession().getAttribute("currentUser");
        if (currentUser.isModerator()) {
            String forumName = request.getParameter("forumName");
            ForumDBContext forumDBC = new ForumDBContext();
            int forumID = Integer.parseInt(request.getParameter("forumID"));
               String urlcover = request.getParameter("photo");
            if(urlcover==null || urlcover.isEmpty()){
                urlcover= "https://i.ibb.co/gDD8MtZ/82761229-p17-master1200.jpg";
            }
            forumName = forumName.isEmpty()? null : forumName;      
            Forum forumUpdate = new Forum();
            forumUpdate.setForumID(forumID);
            forumUpdate.setName(forumName);
            forumUpdate.setCover(urlcover);
            forumDBC.updateNameNCover(forumUpdate);
            response.sendRedirect(request.getHeader("referer"));

//            request.getRequestDispatcher(request.getHeader("referer")).forward(request, response);
        } else {
            String errorMessage = "You do not have permission";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("/view/ErrorView.jsp").forward(request, response);
        }

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
