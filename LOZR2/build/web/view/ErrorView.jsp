<%-- 
    Document   : Home
    Created on : Oct 3, 2021, 12:51:28 PM
    Author     : Khanh
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html style="font-size: 16px">
    <head>
        <jsp:useBean id="transToPath" class="controller.module.ExtractURLPath"/>

        <c:set var="contextPath" value="${pageContext.request.contextPath}"/>   
        <c:set var="your" value="${sessionScope.currentUser}"/>
        <c:set var="defaultImage" value="${contextPath}/images/82761229_p17_master1200.jpg"/>

        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta charset="utf-8" />
        <title>Error | LOZR</title>
          <link rel="icon" href="${contextPath}/images/doge-nonbg.png">

       <link rel="stylesheet" href="https://area1110.github.io/JSBegin/CustomCDN/nicepage.css" />
        <link rel="stylesheet" href="${contextPath}/src/style/index.css" />
        <link rel="stylesheet" href="${contextPath}/src/style/Home.css" />

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js" defer></script>
        <script type="text/javascript" src="${contextPath}/src/script/script.js" defer></script>
        <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i"
            />
        <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css?family=Playfair+Display:400,400i,500,500i,600,600i,700,700i,800,800i,900,900i|Montserrat:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i"
            />
        <!-- font-awesome -->
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
            />
    </head>
    <body>
          <header class="u-clearfix u-header u-sticky u-sticky-1ec8 u-white u-header">
            <div class="header">
                <div  class="header-logo">
                    <a href="${contextPath}">
                        <img  src="${contextPath}/images/lozr4rum1.png" class="logo-header" />
                    </a>
                </div>
                <div class="header-action">
                    <c:if test="${!empty your}">
                        <div class="header-action-item">
                            <a href="${transToPath.compressObjectToPath(contextPath, "user", your.loginName, your.userID)}">
                                <div class="header-user">                
                                    <span  class="header-user-name header-action-item"  >
                                        ${(empty your.loginName)? "Account": your.loginName}
                                    </span>
                                    <img  class="header-avatar header-action-item" src="${your.avatar}" />    
                                </div>
                            </a>
                        </div>
                        <nav class="header-action-item">
                            <div id="mySidepanel" class="sidepanel">
                                <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
                                <a class="menu-user-name" href="${transToPath.compressObjectToPath(contextPath, "user", your.loginName, your.userID)}">${(empty your.loginName)? "Account": your.loginName}</a>
                                <c:if test="${your.moderator}" >
                                    <a  href="${contextPath}/admin/report/thread" class="u-button-style u-nav-link">Report Manager</a>
                                </c:if>
                                <a href="${contextPath}/search/user" class="u-button-style u-nav-link">Find User</a>
                                <a href="${contextPath}/update/user/info" class="u-button-style u-nav-link">Change Info</a>
                                <a href="${contextPath}/logout" class="u-button-style u-nav-link">Log Out</a>
                            </div>
                            <button class="openbtn" onclick="openNav()"><i class="fa fa-bars"></i></button>
                        </nav>     
                    </c:if>
                    <c:if test="${empty your}">
                        <div class="header-action-item">
                            <div class="header-user">                
                                <a href="${contextPath}/signup">
                                    <span  class="header-user-name header-action-item"  >
                                        Sign Up
                                    </span>
                                </a>
                                <a href="${contextPath}/login">
                                    <span    class="header-user-name header-action-item"  >
                                        Log In
                                    </span>
                                </a>
                            </div>
                        </div>
                    </c:if>
                </div>
            </div>
        </header>


        <section class="u-align-center u-clearfix u-grey-5 u-section-1" id="main">

            <div class="u-align-center-lg u-align-center-md u-align-center-sm u-align-center-xl u-container-style u-custom-color-4 u-expanded-width u-group u-group-1">
                <div class="u-container-layout u-valign-top-lg u-valign-top-md u-valign-top-sm u-valign-top-xl u-container-layout-1">
                    <h1 class="u-align-center-xs u-custom-font u-font-playfair-display u-text u-text-1">${errorMessage}</h1>
                </div>
            </div>



        </section>

        <footer
            class="u-align-center u-clearfix u-footer u-grey-80 u-footer"
            id="sec-4768"
            >
            <div class="u-clearfix u-sheet u-sheet-1">
                <p class="u-small-text u-text u-text-variant u-text-1">
                    Sample text. Click to select the text box. Click again or double click
                    to start editing the text.
                </p>
            </div>
        </footer>
    </body>
</html>

