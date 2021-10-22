/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.authentication;

import controller.module.PagingModule;
import dal.UserInfoDBContext;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import javafx.util.converter.LocalDateTimeStringConverter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author Khanh
 */
public class SignUpController extends HttpServlet {

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
        request.getRequestDispatcher("/view/authentication/SignupView.jsp").forward(request, response);

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
        processRequest(request, response);
        User userInfo = new User();
        String loginName = request.getParameter("loginName").trim();

        userInfo.setLoginName(loginName);
        userInfo.setPassword(request.getParameter("password").trim());
        userInfo.setFirstName(request.getParameter("firstName").trim());
        userInfo.setLastName(request.getParameter("lastName").trim());
        userInfo.setEmailAddress(request.getParameter("email").trim());
        String raw_urlavatar = request.getParameter("avatar");
        if(raw_urlavatar==null || raw_urlavatar.isEmpty()){
            raw_urlavatar = "https://i.ibb.co/cYVc6t4/blank-avatar.png";
        }
        userInfo.setAvatar(raw_urlavatar);
//        InputStream is = request.getPart("avatar").getInputStream();
//        Encode encode = new Encode();
//        userInfo.setBase64ImageAvatar(encode.EncodeToBase64(is));
        UserInfoDBContext userDBC = new UserInfoDBContext();

        int statusUpdate = userDBC.createNewUser(userInfo);
        switch (statusUpdate) {
            case -1: // missing field error
                response.getWriter().print("<h1>Some fields are missing</h1>");
                break;
            case -2: //duplicate username error
                String err = "Username was already used!";
                request.setAttribute("errorLoginName", err);
                request.setAttribute("user", userInfo);
                request.getRequestDispatcher("/view/authentication/SignupView.jsp").forward(request, response);
                break;
            case 0: // un caught error
                String errorMessage = "Oops, there are something wrong?!";
                request.setAttribute("errorMessage", errorMessage);
                request.getRequestDispatcher("/view/ErrorView.jsp").forward(request, response);
                break;
            case 1:
                UserInfoDBContext userInfoDBC = new UserInfoDBContext();
                User user = userInfoDBC.getUser(loginName);
                request.getSession().setAttribute("currentUser", user);
                response.sendRedirect(request.getContextPath());
                break;
            default:
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
