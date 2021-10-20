/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.authentication;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author area1
 */
public abstract class BaseAuthorization extends BaseRequiredAuthentication {

    private boolean isModerator(HttpServletRequest request) {
        User currentUser = (User) request.getSession().getAttribute("currentUser");
        return currentUser.isModerator();
    }

    protected void actionGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void actionPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (isModerator(request)) {
            actionGet(request, response);
        } else {
            warningError(request, response);
        }
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (isModerator(request)) {
            actionPost(request, response);
        } else {
            warningError(request, response);
        }
    }

    private void warningError(HttpServletRequest request, HttpServletResponse response) {
        try {
            String errorMessage = "You do not have permission to do this action";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("/view/ErrorView.jsp").forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(BaseAuthorization.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BaseAuthorization.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
