<%-- 
    Document   : ForumPost
    Created on : Sep 26, 2021, 8:08:04 PM
    Author     : Khanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="../forum" method="POST" enctype="multipart/form-data">
            <label for="forumName">Forum Name:</label>
            <br/>
            <textarea name="forumName" required></textarea>
            <br/>
            <input type="file" name="image">
            <input type="submit" value="Save"/>
        </form>
    </body>
</html>
