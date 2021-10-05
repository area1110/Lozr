<%-- 
    Document   : CreateNewForrm
    Created on : Oct 3, 2021, 7:53:29 PM
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
        <h1>Create new forum!</h1>
        <form action="<%= request.getContextPath() %>/forum/" method="POST" enctype="multipart/form-data">
            Forum Title:<input type="text" name="forumName"/>
            <br/>
            Forum Cover:<input type="file" name="image"/>
            <br/>
            <input type="submit"/>
        </form>
    </body>
</html>
