<%-- 
    Document   : LoginView
    Created on : Sep 24, 2021, 4:34:21 PM
    Author     : Khanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login | LOZR</title>
    </head>
    <body>
        <h1>Hello Loser!</h1>
        <form action="login" method="POST">
            UserName: <input type="text" name="loginName">
            <br>
            Password: <input type="password" name="password">
            <br>
            <input type="submit" value="Login"/>
        </form>
    </body>
</html>
