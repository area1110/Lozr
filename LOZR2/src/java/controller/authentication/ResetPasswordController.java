/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.authentication;

import controller.module.GenerateRandomString;
import controller.module.MailSending;
import dal.UserDBContext;
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
public class ResetPasswordController extends HttpServlet {

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
            out.println("<title>Servlet ResetPasswordController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ResetPasswordController at " + request.getContextPath() + "</h1>");
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
//        processRequest(request, response);
        String raw_userloginName = request.getParameter("loginName");

        UserDBContext userDBC = new UserDBContext();
        User user = userDBC.getUserEmail(raw_userloginName);
        if (user != null) {
            user.getEmailAddress();
            GenerateRandomString gen = new GenerateRandomString();
            String newPass = gen.GenerateRandomString();
            userDBC.updateUserPassword(user.getUserID(), newPass);
            MailSending mail = new MailSending();
//            mail.sendNewPassToMail(user, newPass);

            request.setAttribute("user", user);
            String error = "An email had been send to \"" + user.getEmailAddress() + "\"<br/>"
                    + "Please check your inbox or spam to take New Password";
            String message = "If you don't see the email. Please check your spam box or try again!";
            request.setAttribute("errorMessage", error);
            request.setAttribute("message", message);
            request.getRequestDispatcher("/view/ErrorView.jsp").forward(request, response);
            mail.sendNewPassToMail(user, newPass);
        } else {
            String error = "Can not find \"" + raw_userloginName + "\"?!";
            String message = "This account does not exist or you had been banned by moderator<br/>"
                    + "(you must contact one of the mods to get unban)";
            request.setAttribute("errorMessage", error);
            request.setAttribute("message", message);
        }
        request.getRequestDispatcher("/view/ErrorView.jsp").forward(request, response);
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
