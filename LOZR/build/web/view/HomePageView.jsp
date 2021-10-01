<%-- 
    Document   : homepage.jsp
    Created on : Sep 21, 2021, 6:58:35 PM
    Author     : Khanh
--%>

<%@page import="controller.module.ExtractURLPath"%>
<%@page import="model.Forum"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>LOZR</title>
        <link
            rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
            integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
            crossorigin="anonymous"
            />
        <!-- Custom src -->
        <link rel="stylesheet" href="src/style.css"/>

        <!--Prepare Servlet-->
        <%
            ArrayList<Forum> forums = (ArrayList<Forum>) request.getAttribute("forumsList");
            String currentPath = request.getContextPath();
        %>
    </head>
    <body>
        <header>
            <div class="header-inner-content">
                <div class="header-logo">
                    <h1>LOZR</h1>
                </div>

                <div id="account-manager">
                    <ul>
                        <li><a href="">Đăng Ký</a></li>
                        <li><a href="">Đăng Nhập</a></li>
                    </ul>
                </div>
            </div>
        </header>
        <main>
            <div class="container">
                <div class="row">

                    <% if (forums.isEmpty()) { %>
                    <h3 class="empty">Nothing to browse, Please create new forums</h3>
                    <%} else
                        for (Forum f : forums) {
                            if (f.isActive()) {%>
                    <div class="col-12 topic-card">
                        <div class="topic-content">
                            <div class="topic-name"><a href="<%= ExtractURLPath.compressObjectToPath(currentPath, "forum", "", f.getForumID())%>">
                                    <%=f.getName()%></a>
                            </div>
                        </div>
                    </div>

                    <%}
                        }%>
                </div>
            </div>
        </main>
        <footer>
            <div class="footer-inner"><p>Place holder</p></div>
        </footer>
    </body>
</html>
