<%-- 
    Document   : ThreadView
    Created on : Oct 4, 2021, 5:18:21 PM
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

        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta charset="utf-8" />
        <title>${requestScope.query} | L0ZR</title>

        <link rel="stylesheet" href="${contextPath}/src/style/nicepage.css" />
        <link rel="stylesheet" href="${contextPath}/src/style/index.css" />
        <link rel="stylesheet" href="${contextPath}/src/style/User.css" />
        <link rel="stylesheet" href="${contextPath}/src/style/UsersManager.css" />

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js" defer></script>
        <script src="${contextPath}/src/script/script.js" defer></script>

        <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i"
            />
        <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css?family=Montserrat:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i|Aldrich:400"
            />
        <!-- font-awesome -->
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
            />
    </head>
    <body class="u-body">
        <header class="u-clearfix u-header u-sticky u-sticky-1ec8 u-white u-header">
            <div class="header">
                <div  class="header-logo">
                    <a href="${contextPath}">
                        <img  src="${contextPath}/images/lozr4rum1.png" class="logo-header" />
                    </a>
                </div>
                <div class="header-action">
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
                                <a href="${contextPath}/admin/report/thread" class="u-button-style u-nav-link">Report Manager</a>
                            </c:if>
                            <a href="${contextPath}/update/user/info" class="u-button-style u-nav-link">Change Info</a>
                            <a href="${contextPath}/logout" class="u-button-style u-nav-link">Log Out</a>
                        </div>
                        <button class="openbtn" onclick="openNav()"><i class="fa fa-bars"></i></button>
                    </nav>              
                </div>
            </div>
        </header>

        <div class="main-zone">
            <div class="body-header">       
                <div  class="post-title" >
                    <h1>Search user: ${requestScope.query}</h1>
                </div>              
            </div>

            <div class="searchbar">
                <form id="form-search" action="${contextPath}/search/user" method="GET">
                    <input id="insert-query" class="search-input search-texttype" name="q" placeholder="Provide Username" value="${requestScope.query}"/>
                    <button class="search-input search-button" onclick="checkSubmit(event, 'form-search', 'insert-query');"><i class="fa fa-search"></i></button>
                </form>
            </div>

            <c:if test="${empty requestScope.users}">
                <div class="u-container-layout u-valign-top-lg u-valign-top-md u-valign-top-sm u-valign-top-xl u-container-layout-1">
                    <h1 class="u-align-center-xs  u-font-playfair-display u-text u-text-1">Oops, There is nothing here?!</h1>
                </div>
            </c:if>

            <c:forEach items="${requestScope.users}" var="user">
                <!--<EachUser>-->
                <div class="" id="user">
                    <div class="user-card">
                        <a class="user-link"  href="${transToPath.compressObjectToPath(contextPath, "user", user.loginName, user.userID)}">
                            <div class="user-avatar user-cell">
                                <img src="${user.avatar}" />
                            </div>
                            <div class="user-cell user-info">
                                <div class="user-loginname">
                                    <h2>${user.loginName}</h2>
                                    <div class="user-detail">
                                        <div class="user-total-numbers">
                                            <div class="user-joineddate">
                                                <span>Joined:</span>
                                                <time>
                                                    <fmt:formatDate value="${user.timeJoined}" type="date"  dateStyle="short"/>
                                                </time>
                                            </div>
                                            <div>
                                                <span>Email:</span>
                                                <span>${user.emailAddress}</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </a>
                        <div class="user-cell user-cell-report dropdown">
                            <button onclick="showDropdownMenu(${user.userID})" class="dropbtn">Option</button>
                            <div  id="myDropdown-${user.userID}" class="dropdown-content">
                                <a onclick="alert('This thread has been reported to moderator');" target="dummyframe" href="${contextPath}/report/thread?id=${thread.threadID}">Report</a>
                                <c:if test="${your.moderator}">
                                    <form target="dummyframe" action="${contextPath}/update/user/permission" method="POST" id="changePermissionForm-${user.userID}">
                                        <input type="hidden" value="${user.userID}" name="userID" />
                                        <input id="moderator-tickbox-${user.userID}" name="isAdmin" onchange ="changePermission('${user.userID}');" 
                                               ${user.moderator? "checked" : ""} type="checkbox">
                                        <label for="moderator-tickbox-${user.userID}">Moderator permission</label>
                                    </form>
                                    <a>Ban</a>
                                </c:if>
                            </div>

                            <div class="user-permisson">
                                <c:if test="${user.moderator}">
                                    <div class="user-isadmin">
                                        <label>Mod</label>
                                    </div>
                                </c:if>                              
                            </div>
                        </div>
                    </div>
                </div>
                <!--</EachUser>-->                  
            </c:forEach>

        </div>

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
        <iframe name="dummyframe" id="dummyframe" style="display: none;"></iframe>
    </body>
</html>
