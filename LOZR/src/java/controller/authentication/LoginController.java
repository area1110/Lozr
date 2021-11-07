/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.authentication;

import dal.UserDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;

/**
 *
 * @author Khanh
 */
public class LoginController extends HttpServlet {

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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/view/authentication/LoginView.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String loginName = request.getParameter("loginName").trim();
        String password = request.getParameter("password").trim();
        UserDBContext userDBC = new UserDBContext();
        User user = userDBC.getUserLogin(loginName, password);

        HttpSession session = request.getSession();
        if (user != null) { //login sucesss

            session.setAttribute("currentUser", user);
            Cookie cookie = new Cookie("userId", "" + user.getUserID());
            cookie.setMaxAge(24*60*60);
            response.addCookie(cookie);
            response.sendRedirect("home");
        } else { //login failed
            session.setAttribute("currentUser", null);

            String loginError = "Oops! USER NAME or PASSWORD is incorrect.";
            request.setAttribute("loginError", loginError);
            request.setAttribute("loginName", loginName); //send loginName again to saving it
            request.getRequestDispatcher("/view/authentication/LoginView.jsp").forward(request, response);
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
