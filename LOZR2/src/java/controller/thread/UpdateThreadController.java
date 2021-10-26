/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.thread;

import controller.authentication.BaseRequiredAuthentication;
import dal.ThreadDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.FThread;
import model.User;

/**
 *
 * @author area1
 */
public class UpdateThreadController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
//        processRequest(request, response);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
        int threadID = Integer.parseInt(request.getParameter("threadID"));
        String threadSubject = request.getParameter("threadSubject");
//        UserInfo currentUser = (UserInfo) request.getSession().getAttribute("currenUser");

        if (!threadSubject.isEmpty()) {
            FThread fthread = new FThread();
            fthread.setThreadID(threadID);
            fthread.setSubject(threadSubject);

            ThreadDBContext fthreadDBC = new ThreadDBContext();
            fthreadDBC.updateThread(fthread);
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
