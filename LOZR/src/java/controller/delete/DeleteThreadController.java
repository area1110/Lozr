/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.delete;

import controller.authentication.BaseRequiredAuthentication;
import dal.ThreadDBContext;
import dal.ForumDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author area1
 */
public class DeleteThreadController extends HttpServlet {

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
        String raw_id = request.getParameter("id");
        if (raw_id == null || raw_id.isEmpty()) {
            String errorMessage = "Wrong Action!";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("/view/ErrorView.jsp").forward(request, response);
        }
        String raw_activate = request.getParameter("activate");
        if (raw_activate == null || raw_activate.isEmpty()) {
            raw_activate = "false";
        }
        boolean active = Boolean.valueOf(raw_activate);
        int threadID = Integer.parseInt(raw_id);
        ThreadDBContext fthreadDBC = new ThreadDBContext();
        User currentUser = (User) request.getSession().getAttribute("currentUser");
        User userCreated = fthreadDBC.getFThread(threadID).getStartedBy();
        if (currentUser.isModerator() || currentUser.getUserID() == userCreated.getUserID()) {
            fthreadDBC.updateStatus(threadID, active);
        } else {
            String errorMessage = "You do not have permission";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("/view/ErrorView.jsp").forward(request, response);
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
