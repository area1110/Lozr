/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

import controller.authentication.BaseRequiredAuthentication;
import controller.module.Encode;
import dal.UserInfoDBContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.Account;
import model.UserInfo;

/**
 *
 * @author area1
 */
public class UpdateUserInfoController extends BaseRequiredAuthentication {

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
            out.println("<title>Servlet UpdateUserInfo</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateUserInfo at " + request.getContextPath() + "</h1>");
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
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserInfo user = (UserInfo) request.getSession().getAttribute("currentUser");
         request.setAttribute("user", user);
        request.getRequestDispatcher("/view/UpdateUserInfo.jsp").forward(request, response);
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

        String loginName = request.getParameter("loginName");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String emailAddress = request.getParameter("email");
        Part avatarRawPart = request.getPart("avatar");

        UserInfo userInfo = new UserInfo();
        userInfo.setUserID(currentUser.getUserID());
        userInfo.setLoginName(loginName.isEmpty() ? null : loginName);
        userInfo.setPassword(password.isEmpty() ? null : password);
        userInfo.setFirstName(firstName.isEmpty() ? null : firstName);
        userInfo.setLastName(lastName.isEmpty() ? null : lastName);
        userInfo.setEmailAddress(emailAddress.isEmpty() ? null : emailAddress);

        if (avatarRawPart.getSubmittedFileName().isEmpty()) {
            userInfo.setBase64ImageAvatar(null);
        } else {
            InputStream is = avatarRawPart.getInputStream();
            Encode encode = new Encode();
            userInfo.setBase64ImageAvatar(encode.EncodeToBase64(is));
        }
        UserInfoDBContext userDBC = new UserInfoDBContext();
        int statusUpdate = userDBC.updateUserInfo(userInfo);
        switch (statusUpdate) {
            case -2: //duplicate username error
                String err = "Username was already used!";
                request.setAttribute("errorLoginName", err);
                request.setAttribute("user", userInfo);
                request.getRequestDispatcher("/view/UpdateUserInfo.jsp").forward(request, response);
                break;
            case 0: // un caught error
                String errorMessage = "Oops, there are something wrong?!";
                request.setAttribute("errorMessage", errorMessage);
                request.getRequestDispatcher("/view/ErrorView.jsp").forward(request, response);
                break;
            case 1:
               UserInfo refressCurrent = userDBC.getUser(userInfo.getUserID());
               request.getSession().setAttribute("currentUser", refressCurrent);
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
