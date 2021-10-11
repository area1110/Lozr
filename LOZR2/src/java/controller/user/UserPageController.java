/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

import controller.authentication.BaseRequiredAuthentication;
import controller.module.ExtractURLPath;
import dal.FThreadDBContext;
import dal.UserInfoDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.FThread;
import model.UserInfo;

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
    protected void  processGet (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        int userID =  ExtractURLPath.extractPathToID(request.getPathInfo());;    
        UserInfoDBContext userinfoDBC = new UserInfoDBContext();
        UserInfo user = userinfoDBC.getUser(userID);
        if(user==null) {
            String errorMessage = "User Not Found!";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("/view/ErrorView.jsp").forward(request, response);
        }
        FThreadDBContext fthreadDBC = new FThreadDBContext();
        ArrayList<FThread> fthreads = fthreadDBC.getFThreadsByUser(userID);
        request.setAttribute("threads", fthreads);
        request.setAttribute("user", user);
        request.getRequestDispatcher("/view/UserInfoView.jsp").forward(request, response);
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