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
        <c:set var="forums" value="${requestScope.forumsList}"/>

        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta charset="utf-8" />
        <title>LOZR</title>
        <link rel="icon" href="${contextPath}/images/doge-nonbg.png">


        <link rel="stylesheet" href="https://area1110.github.io/JSBegin/CustomCDN/nicepage.css" />
        <link rel="stylesheet" href="${contextPath}/src/style/index.css" />
        <link rel="stylesheet" href="${contextPath}/src/style/Home.css" />

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js" defer></script>
        <script type="text/javascript" src="${contextPath}/src/script/script.js" defer></script>
        <script type="text/javascript" src="${contextPath}/src/script/homeScript.js" defer></script>
        <script type="text/javascript" src="${contextPath}/src/script/imgupload.js" defer></script>

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
    <body class="u-body">

        <div class="form-popup" id="formEdit">
            <div class="form-container">
                <h2>Edit Forum</h2>
                <div class="cover-create">
                    <label for="photo">New Cover<br>(Waiting until you see the image changes)</label>
                    <div class="cover-view">
                        <img src="https://via.placeholder.com/200x130" id="output-cover-img"/>
                    </div>
                    <div class="cover-input">
                        <input class="cover-openfile" id="choose-img" type='file' onchange="doImgUpload(this, 'cover-url', 'output-cover-img')">
                    </div>
                </div>
                <form id="hidden-form" onsubmit="reloadDelay()" action="update/forum" target="dummyframe" method="POST" >  
                    <input type="hidden" id="elementeID"  name="forumID"/> 
                    <label  for="forumName">New Forum Title</label>
                    <input type="text" placeholder="New Name" name="forumName">
                    <button type="submit" class="mybtn">Save</button>
                    <button type="button" class="mybtn" onclick="closeForm()">Close</button>
                    <input   type="hidden" id="cover-url"  name="photo">
                </form>
            </div>
        </div>

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
                                <a  href="${contextPath}/follow/manage/thread" class="u-button-style u-nav-link">Bookmark</a>
                                <c:if test="${your.moderator}" >
                                    <a href="javascript:void(0)" onclick="openCreateForum()" class="u-button-style u-nav-link">New Forum</a>
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
            <c:if test="${empty forums}">

                <div class="u-align-center-lg u-align-center-md u-align-center-sm u-align-center-xl u-container-style u-custom-color-4 u-expanded-width u-group u-group-1">
                    <div class="u-container-layout u-valign-top-lg u-valign-top-md u-valign-top-sm u-valign-top-xl u-container-layout-1">
                        <h1 class="u-align-center-xs u-custom-font u-font-playfair-display u-text u-text-1">Oops, There is nothing here?!</h1>
                    </div>
                </div>
            </c:if>

            <c:if test="${!empty forums}">

                <div class="u-align-center-lg u-align-center-md u-align-center-sm u-align-center-xl u-container-style u-custom-color-4 u-expanded-width u-group u-group-1">
                    <div class="u-container-layout u-valign-top-lg u-valign-top-md u-valign-top-sm u-valign-top-xl u-container-layout-1">
                        <h1 class="u-align-center-xs u-custom-font u-font-playfair-display u-text u-text-1">What on your mind today?</h1>
                    </div>
                </div>

                <div class="u-blog u-blog-1">
                    <div class="searchbar">
                        <form id="form-search"  action="search/thread" method="GET">
                            <input id="insert-query" class="search-input search-texttype" name="q" placeholder="Find your interesting"/>
                            <button class="search-input search-button" onclick="checkSubmit(event, 'form-search', 'insert-query')"><i class="fa fa-search"></i></button>
                        </form>
                    </div>
                    <div class="u-repeater u-repeater-1">

                        <c:forEach items="${forums}" var="forum">
                            <c:set var="forumImage" value="data:image/jpg;base64,${forum.cover}"/>
                            <!--blog_post-->
                            <div id="forum-${forum.forumID}" class="u-align-center u-blog-post u-container-style u-repeater-item u-video-cover u-white u-repeater-item-2">
                                <div class="u-container-layout u-similar-container u-container-layout-4">
                                    <a href="${transToPath.compressObjectToPath(contextPath, "forum", forum.name, forum.forumID)}">

                                        <span class="u-post-header-link">
                                            <img alt="Forum cover" class="u-blog-control u-expanded-width u-image u-image-default u-image-2" 
                                                 src="${forum.cover}"<!--/blog_post_image-->
                                        </span>
                                        <div class="u-align-center u-container-style u-group u-palette-4-base u-video-cover u-group-3">
                                            <div class="u-container-layout u-valign-middle u-container-layout-5">
                                                <p id="forumname-${forum.forumID}" class="u-custom-font u-font-arial u-text u-text-5">${forum.name}</p>
                                            </div>
                                        </div>
                                        <p class="u-align-center u-text u-text-grey-50 u-text-6"> ${forum.newPosts} New Post Today</p>

                                        <p class="u-align-center u-custom-font u-font-montserrat u-text u-text-grey-50 u-text-7">${forum.newThreads} New Threads Today</p>
                                    </a>
                                    <c:if test="${your.moderator}">
                                        <div class="dropdown">
                                            <button onclick="showDropdownMenu(${forum.forumID})"  class="dropbtn">Edit</button>
                                            <div onclick="showDropdownMenu(${forum.forumID})" id="myDropdown-${forum.forumID}" class="dropdown-content">
                                                <a   onclick="openForm(${forum.forumID}, 'forumname')">Change Title</a>
                                                <a onclick="doDeleteForum(${forum.forumID}, '${forum.name}');">Delete Forum</a>
                                            </div>
                                        </div>
                                    </c:if>
                                </div>
                            </div>
                            <!--/blog_post-->
                        </c:forEach>
                    </div>
                </div>
            </c:if>
        </section>

        <footer
            class="u-align-center u-clearfix u-footer u-grey-80 u-footer"
            id="sec-4768"
            >
            <div class="u-clearfix u-sheet u-sheet-1">
                <p class="u-small-text u-text u-text-variant u-text-1">
                    © 2021 Copyright: Area1110. All rights reserved
                </p>
            </div>
        </footer>

        <iframe name="dummyframe" id="dummyframe" style="display: none;"></iframe>
    </body>

</html>

