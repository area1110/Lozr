<%-- 
    Document   : ForumThreadView
    Created on : Sep 22, 2021, 4:17:52 PM
    Author     : Khanh
--%>

<%@page import="model.FThread"%>
<%@page import="controller.TranslateURLPath"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Topic Name Hoder</title>
        <link
            rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
            integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
            crossorigin="anonymous"
            />
        <!-- Custom src -->
        <link rel="stylesheet" href="../srcTestView/style.css" />
        <link rel="stylesheet" href="../srcTestView/threadstyle.css" />

        <%
            ArrayList<FThread> fThreads = (ArrayList<FThread>) request.getAttribute("forumThreads");
            TranslateURLPath trans = new TranslateURLPath();
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
                        <li><a href="#">Đăng Ký</a></li>
                        <li><a href="#">Đăng Nhập</a></li>
                    </ul>
                </div>
            </div>
        </header>
        <main>
            <div class="container">
                <div class="row">

                    <% if (fThreads.isEmpty()) {%>
                    <h3>This thread is empty</h3>
                    <p>Please create something</p>
                    <%} else for (FThread f : fThreads) {%>
                    <div class="col-12 thread-card">
                        <div class="thread-avatar-user">
                            <img src="https://via.placeholder.com/150" />
                        </div>

                        <div class="thread-content">
                            <div class="thread-name"><a href="
                                                        <%= trans.translateObjectToPath(request.getContextPath(), "thread", "", f.getThreadID())%>"><%= f.getSubject()%></a></div>
                            <div class="thread-user-name"><a href="">
                                    <%= f.getStartedBy().getLoginName()%></a></div>
                        </div>
                    </div>
                    <%}%>

                </div>
            </div>
        </main>
        <footer>
            <div class="footer-inner"><p>Place holder</p></div>
        </footer>
    </body>
</html>

