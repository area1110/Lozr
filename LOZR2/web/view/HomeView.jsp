<%-- 
    Document   : Home
    Created on : Oct 3, 2021, 12:51:28 PM
    Author     : Khanh
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="controller.module.ExtractURLPath"%>
<%@page import="model.UserInfo"%>
<%@page import="model.Forum"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html style="font-size: 16px">
    <head>
        <jsp:useBean id="transToPath" class="controller.module.ExtractURLPath"/>

        <c:set var="contextPath" value="${pageContext.request.contextPath}"/>   
        <c:set var="your" value="${sessionScope.currentUser}"/>
        <c:set var="forums" value="${requestScope.forumsList}"/>
        <c:set var="defaultImage" value="${contextPath}/images/82761229_p17_master1200.jpg"/>
        <c:set var="yourAvatar" value="data:image/jpg;base64,${your.base64ImageAvatar}"/>

        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta charset="utf-8" />
        <title>L0ZR</title>


        <link rel="stylesheet" href="${contextPath}/src/style/index.css" />
        <link rel="stylesheet" href="${contextPath}/src/style/Home.css" />
        <link rel="stylesheet" href="${contextPath}/src/style/nicepage.css" />

        <script type="text/javascript" src="${contextPath}/src/script/jquery.js" defer></script>
        <script type="text/javascript" src="${contextPath}/src/script/nicepage.js" defer></script>
        <script type="text/javascript" src="${contextPath}/src/script/script.js" defer></script>
        <script type="text/javascript" src="${contextPath}/src/script/homeScript.js" defer></script>
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
        <div class="form-popup" id="formEditForum">
            <form action="update/forum" method="POST"  enctype="multipart/form-data" class="form-container">
                <h1>Edit Forum</h1>
                <input type="hidden" id="submitForumID"  name="forumID"/> 
                <label  for="forumName">New Forum Title</label>
                <input type="text" placeholder="New Name" name="forumName">
                <label for="photo">New Cover</label>
                <input   type="file"  name="photo">
                <button type="submit" class="btn">Save</button>
                <button type="button" class="btn" onclick="closeForm()">Close</button>
            </form>
        </div>
        <header class="u-clearfix u-header u-sticky u-sticky-1ec8 u-white u-header">
            <div class="u-clearfix u-sheet u-sheet-1">
                <a
                    href="#main"
                    class="u-hidden-sm u-hidden-xs u-image u-logo u-image-1"
                    data-image-width="590"
                    data-image-height="90"
                    >
                    <img src="images/lozr4rum1.png" class="u-logo-image u-logo-image-1" />
                </a>
                <a href="${transToPath.compressObjectToPath(contextPath, "user", "", your.userID)}">
                    <div class="u-align-left u-container-style u-group u-group-1">
                        <div class="u-container-layout u-container-layout-1">
                            <p
                                class="
                                u-align-right u-custom-font u-font-montserrat u-text u-text-1
                                "
                                >
                                ${(empty your.loginName)? "Account": your.loginName}
                            </p>
                            <img
                                class="u-expanded-height-xl u-image u-image-circle u-image-2"

                                src="${(empty your.base64ImageAvatar)? defaultImage: yourAvatar}"
                                />
                        </div>
                    </div>
                </a>

                <nav
                    class="
                    u-align-left
                    u-menu
                    u-menu-dropdown
                    u-menu-open-right
                    u-nav-spacing-25
                    u-offcanvas
                    u-menu-1
                    "
                    data-responsive-from="XL"
                    >
                    <div class="menu-collapse">
                        <a class="menu-button" href="#">
                            <i class="fa fa-bars"></i>
                        </a>
                    </div>
                    <div class="u-custom-menu u-nav-container-collapse">
                        <div
                            class="
                            u-align-center
                            u-black
                            u-container-style
                            u-inner-container-layout
                            u-sidenav
                            u-sidenav-1
                            "
                            data-offcanvas-width="341.5626"
                            >
                            <div class="u-inner-container-layout u-sidenav-overflow">
                                <div class="u-menu-close"></div>
                                <ul
                                    class="
                                    u-align-center
                                    u-custom-font
                                    u-font-montserrat
                                    u-nav
                                    u-popupmenu-items
                                    u-spacing-16
                                    u-text-active-palette-1-dark-1
                                    u-text-hover-palette-4-base
                                    u-unstyled
                                    u-nav-2
                                    "
                                    >
                                    <li class="u-nav-item">
                                        <a class="u-button-style u-nav-link" href="${transToPath.compressObjectToPath(contextPath, "user", "", your.userID)}">
                                            ${(empty your.loginName)? "Account": your.loginName}
                                        </a>
                                    </li>
                                    <c:if test="${your.admin}" >
                                        <li class="u-nav-item">
                                            <a href="test/CreateNewForum.jsp" class="u-button-style u-nav-link">New Forum</a>
                                        </li>
                                        <li class="u-nav-item">
                                            <a href="test/CreateNewForum.jsp" class="u-button-style u-nav-link">Report Manager</a>
                                        </li>
                                    </c:if>
                                    <li class="u-nav-item">
                                        <a href="${contextPath}/logout" class="u-button-style u-nav-link">Log Out</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div
                            class="u-custom-color-4 u-menu-overlay u-opacity u-opacity-65"
                            ></div>
                    </div>
                </nav>
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
                    <div class="u-repeater u-repeater-1">

                        <c:forEach items="${forums}" var="forum">
                            <c:set var="forumImage" value="data:image/jpg;base64,${forum.base64Image}"/>
                            <!--blog_post-->
                            <div id="forum-${forum.forumID}" class="u-align-center u-blog-post u-container-style u-repeater-item u-video-cover u-white u-repeater-item-2">
                                <div class="u-container-layout u-similar-container u-container-layout-4">
                                    <a href="${transToPath.compressObjectToPath(contextPath, "forum", "", forum.forumID)}">

                                        <span class="u-post-header-link">
                                            <img alt="Forum cover" class="u-blog-control u-expanded-width u-image u-image-default u-image-2" 
                                                 src="${(empty forum.base64Image)? defaultImage: forumImage}"<!--/blog_post_image-->
                                        </span>
                                        <div class="u-align-center u-container-style u-group u-palette-4-base u-video-cover u-group-3">
                                            <div class="u-container-layout u-valign-middle u-container-layout-5">
                                                <p class="u-custom-font u-font-arial u-text u-text-5">${forum.name}</p>
                                            </div>
                                        </div>
                                        <p class="u-align-center u-text u-text-grey-50 u-text-6"> ${forum.newPosts} New Post Today</p>

                                        <p class="u-align-center u-custom-font u-font-montserrat u-text u-text-grey-50 u-text-7">${forum.newThreads} New Threads Today</p>
                                    </a>
                                    <c:if test="${your.admin}">
                                        <div class="dropdown">
                                            <button onclick="showDropdownMenu(${forum.forumID})" class="dropbtn">Edit</button>
                                            <div id="myDropdown-${forum.forumID}" class="dropdown-content">
                                                <a   onclick="openForm(${forum.forumID})">Change Title & Cover</a>

                                                <a onclick="doDeleteForum(${forum.forumID}, '${forum.name}');">Delete Forum</a>
                                            </div>
                                        </div>
                                    </c:if>
                                </div>
                            </div>
                            <!--/blog_post-->
                        </c:forEach>
                    </div>
                </c:if>
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

