<%-- 
    Document   : ThreadPostView
    Created on : Sep 22, 2021, 5:19:09 PM
    Author     : Khanh
--%>

<%@page import="controller.TranslateURLPath"%>
<%@page import="model.Post"%>
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
        <link rel="stylesheet" href="../srcTestView/poststyle.css" />
        <% ArrayList<Post> posts = (ArrayList<Post>) request.getAttribute("Posts");
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
                        <li><a href="">Đăng Ký</a></li>
                        <li><a href="">Đăng Nhập</a></li>
                    </ul>
                </div>
            </div>
        </header>
        <main>
            <div class="container">
                <div class="row">

                    <% for (Post post : posts) { %>

                    <% 
                        Post reply = post.getReplyPost();
                    %>

                    <div class="col-12 post-card">   
                        <table>
                            <tr>
                                <td>
                                    <div class="post-userinfo">
                                        <img src="https://via.placeholder.com/150" alt="" />
                                        <div class="post-userinfo-name"><%= post.getUser().getFirstName() 
                                                + " " + post.getUser().getLastName() %></div>
                                    </div>
                                </td>
                                <td>
                                    <div class="post-content">
                                        <div class="post-reply">
                                            <div class="post-reply-account"><%= reply.getUser().getFirstName()
                                            + " " + reply.getUser().getLastName() %>:</div>
                                            <div class="post-reply-said">
                                                <%= reply.getPostContent() %>
                                            </div>
                                        </div>
                                        <div class="post-maintext">
                                            <%= post.getPostContent() %>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                        </table>
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

