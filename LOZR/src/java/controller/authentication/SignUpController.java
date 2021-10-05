/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.authentication;

import controller.module.Encode;
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
import model.Account;
import model.UserInfo;

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
//        processRequest(request, response);
        request.getRequestDispatcher("view/authentication/SignupView.jsp").forward(request, response);
//        UserInfo u = (UserInfo) request.getSession().getAttribute("currentUser");
//        response.getWriter().print(u.getLoginName());
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private int doSignUp(Account account, UserInfo userInfo) {
        UserInfoDBContext userDBC = new UserInfoDBContext();
        return userDBC.createNewUser(userInfo, account);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        Account account = new Account();
        UserInfo userInfo = new UserInfo();
        String loginName = request.getParameter("loginName").trim();

        userInfo.setLoginName(loginName);
        account.setPassword(request.getParameter("password").trim());
        userInfo.setFirstName(request.getParameter("firstName").trim());
        userInfo.setLastName(request.getParameter("lastName").trim());
        userInfo.setEmailAddress(request.getParameter("email").trim());
        
        
        InputStream is = request.getPart("avatar").getInputStream();
        Encode encode = new Encode();
        userInfo.setBase64ImageAvatar(encode.EncodeToBase64(is));
        
        int statusUpdate = doSignUp(account, userInfo);
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
                response.getWriter().print("<h1>Loi Khong xac dinh</h1>");
                break;
            case 1:
                UserInfoDBContext userInfoDBC = new UserInfoDBContext();
                UserInfo user = userInfoDBC.getUser(loginName);
                request.getSession().setAttribute("currentUser", user);
                request.getRequestDispatcher("/test/SessionUserInfoViewTest.jsp").forward(request, response);
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
