/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

import controller.authentication.BaseRequiredAuthentication;
import dal.UserInfoDBContext;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

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
        User user = (User) request.getSession().getAttribute("currentUser");
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

        User currentUser = (User) request.getSession().getAttribute("currentUser");

        String loginName = request.getParameter("loginName");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String emailAddress = request.getParameter("email");
        String avatarurl = request.getParameter("avatar");

        User userInfo = new User();
        userInfo.setUserID(currentUser.getUserID());
        userInfo.setLoginName(loginName.isEmpty() ? null : loginName);
        userInfo.setPassword(password.isEmpty() ? null : password);
        userInfo.setFirstName(firstName.isEmpty() ? null : firstName);
        userInfo.setLastName(lastName.isEmpty() ? null : lastName);
        userInfo.setEmailAddress(emailAddress.isEmpty() ? null : emailAddress);
        userInfo.setAvatar(avatarurl.isEmpty() ? null : avatarurl);

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
                User refressCurrent = userDBC.getUser(userInfo.getUserID());
                request.getSession().setAttribute("currentUser", refressCurrent);
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
