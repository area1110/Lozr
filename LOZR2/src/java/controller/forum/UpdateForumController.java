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
import model.UserInfo;

/**
 *
 * @author area1
 */
public class UpdateForumController extends BaseRequiredAuthentication {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String errorMessage = "You do not have permission";
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
        if (currentUser.isAdmin()) {
            String forumName = request.getParameter("forumName");
            Part coverImg = request.getPart("photo");
            ForumDBContext forumDBC = new ForumDBContext();
            int forumID = Integer.parseInt(request.getParameter("forumID"));
            String b64CoverImg = null;
            if (!(coverImg == null || coverImg.getSubmittedFileName().isEmpty())) {
                Encode encode = new Encode();
                b64CoverImg = encode.EncodeToBase64(request.getPart("photo").getInputStream());
            }         
            forumName = forumName.isEmpty()? null : forumName;      
            forumDBC.updateNameNCover(forumID, forumName, b64CoverImg);
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
