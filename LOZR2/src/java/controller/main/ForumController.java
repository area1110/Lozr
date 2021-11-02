package controller.main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import controller.authentication.BaseRequiredAuthentication;
import controller.module.PagingModule;
import controller.module.ExtractURLPath;
import dal.ThreadDBContext;
import dal.ForumDBContext;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.FThread;
import model.Forum;
import model.User;

/**
 *
 * @author Khanh
 */
public class ForumController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ThreadDBContext fThreadDBC = new ThreadDBContext();
        int forumID = ExtractURLPath.extractPathToID(request.getPathInfo());

        if (forumID == 0) {
            String errorMsg = "The requested forum could not be found.";
            request.setAttribute("errorMsg", errorMsg);
            request.getRequestDispatcher("").forward(request, response);
        } else {
            Forum forum = getForum(forumID);
            if (forum == null) {
                String errorMsg = "The requested thread could not be found.";
                request.setAttribute("errorMsg", errorMsg);
                request.getRequestDispatcher("").forward(request, response);
            } else {
                String raw_pageIndex = request.getParameter("page");
                if (raw_pageIndex == null || raw_pageIndex.isEmpty()) {
                    raw_pageIndex = "1";
                }
                int pageIndex = Integer.parseInt(raw_pageIndex);
                request.setAttribute("forum", forum);
                int totalRecord = fThreadDBC.getTotalThreads(forumID);
                int totalPage = PagingModule.calcTotalPage(totalRecord);
                if (totalPage < pageIndex) {
                    pageIndex = totalPage;
                }
                if(pageIndex<1){
                    pageIndex = 1;
                }
                ArrayList<FThread> fThreads = fThreadDBC.getFThreads(forumID, pageIndex);

                request.setAttribute("totalPage", totalPage);
                request.setAttribute("pageIndex", pageIndex);
                request.setAttribute("threads", fThreads);
                request.getRequestDispatcher("/view/ForumView.jsp").forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//         request.setCharacterEncoding("UTF-8");
//        processRequest(request, response);
        User currentUser = (User) request.getSession().getAttribute("currentUser");
        if (currentUser.isModerator()) {
            String forumName = request.getParameter("forumName");
            String urlcover = request.getParameter("photo");
            if (urlcover == null || urlcover.isEmpty()) {
                urlcover = "https://i.ibb.co/gDD8MtZ/82761229-p17-master1200.jpg";
            }

            if (setForum(forumName, urlcover)) {
//            response.getWriter().print("<h1>Success Checkout DB</h1>");
//                response.sendRedirect(request.getContextPath());
//            request.getRequestDispatcher(request.getContextPath()).forward(request, response);
            } else {
                response.getWriter().print("<h1>Error Try Again</h1>");
//            String errMsg = "Oops! Something wrong<br/>Please try again!";
//            request.setAttribute("forumName", forumName);
//            request.setAttribute("errorMsg", errMsg);
//            request.getRequestDispatcher("/post/ForumPost.jsp").forward(request, response);
            }
        } else {
            String errorMessage = "Oops, threre are something wrong?!";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("/view/ErrorView.jsp").forward(request, response);
        }
    }

    //
    private Forum getForum(int forumID) {
        ForumDBContext forumDBC = new ForumDBContext();
        return forumDBC.getForum(forumID);
    }

    private boolean setForum(String forumName, String urlcover) {
        ForumDBContext forumDBC = new ForumDBContext();
        Forum forum = new Forum();
        forum.setName(forumName);
        forum.setCover(urlcover);
        return forumDBC.setForum(forum);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
