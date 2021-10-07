<%-- 
    Document   : LoginFormView
    Created on : Sep 23, 2021, 10:55:13 AM
    Author     : Khanh
--%>

<%@page import="model.UserInfo"%>
<%@page import="model.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>LOZR</title>
        <link rel="stylesheet" href="src/style.css">
        <link rel="stylesheet" href="src/login.css">
        <%
            String signUpErr = (String) request.getAttribute("errorSignupName");
            UserInfo user = user = (UserInfo) request.getAttribute("user");
        %>
    </head>
    <body>
        <form action="signup" method="post" enctype="multipart/form-data">
            <div>
                <label for="loginName">Tên đăng nhập:</label>
                <input type="text" name="loginName"
                       <% if (user != null) {%> 
                       value="<%= user.getLoginName()%>"
                       <%}%>/>                             
                ${errorSignupName}            
            </div>
            <div>
                <label for="password">Mật Khẩu:</label>
                <input type="password" name="password"/>
            </div>
            <div>
                <label for="email">Email:</label>
                <input type="email" name="email"
                       <%if (user != null) {%>
                       value="<%= user.getEmailAddress()%>"
                        <%}%>
                       />
            </div>
            <div>
                <label for="name">Tên:</label>
                <input type="text" name="firstName" placeholder="FirstName"
                       <%if (user != null) {%>
                       value="<%= user.getFirstName()%>"
                       <%}%>/>
                <input type="text" name="lastName" placeholder="LastName"
                       <%if (user != null) {%>
                       value="<%= user.getLastName()%>"
                       <%}%>/>
            </div>  
            <div>
                <label type="avatar">Upload Image Avatar:</label>
                <input type="file" name="avatar"/>
            </div>
            <input type="submit" value="Đăng Ký"/>
        </form>

    </body>
</html>
