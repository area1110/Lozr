/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.search;


import controller.module.PagingModule;
import dal.UserDBContext;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author area1
 */
public class SearchUserController extends HttpServlet {

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
        User currentUser = (User) request.getSession().getAttribute("currentUser");
        UserDBContext userDBC = new UserDBContext();
        String query = request.getParameter("q");

        String raw_pageIndex = request.getParameter("page");
        if (raw_pageIndex == null || raw_pageIndex.isEmpty()) {
            raw_pageIndex = "1";
        }
        int pageIndex = Integer.parseInt(raw_pageIndex);
        int totalRecord = userDBC.getTotalUsersByName(query, currentUser.getUserID());
        int totalPage = PagingModule.calcTotalPage(totalRecord);
        if (totalPage < pageIndex) {
            pageIndex = totalPage;
        }
        if (pageIndex < 1) {
            pageIndex = 1;
        }
        ArrayList<User> users = userDBC.getUsersByName(query, currentUser.getUserID() , pageIndex);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("pageIndex", pageIndex);
        request.setAttribute("query", query);
        request.setAttribute("users", users);
        request.getRequestDispatcher("/view/search/SearchUserView.jsp").forward(request, response);
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
