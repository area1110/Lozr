<%-- 
    Document   : SessionUserInfoViewTest
    Created on : Sep 27, 2021, 8:28:20 PM
    Author     : Khanh
--%>

<%@page import="model.UserInfo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <% UserInfo user = (UserInfo) request.getSession().getAttribute("currentUser"); %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%= user.getLoginName() %> | Test</title>
        
         
    </head>
    <body>
        <h1>Hello World!</h1>
        <p> 
            <IMG height=99 src="data:image/jpg;base64,<%= user.getBase64ImageAvatar() %>" width=136>
            <br/>
            ID: <%= user.getUserID()  %>
            <br/>
            Username: <%= user.getLoginName() %>
            <br/>
            FirstName: <%= user.getFirstName() %>
            <br/>
            LastName: <%= user.getLastName() %>
            <br/>
            DateJoined: <%= user.getDateJoined() %>
            <br/>
            Email: <%= user.getEmailAddress() %>
            <br/>
            Admin: <%= user.isAdmin()? "true": "false" %>
        </p>
                     
    </body>
</html>
