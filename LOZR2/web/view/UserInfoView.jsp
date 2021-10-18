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
        <title>${forum.name} | L0ZR</title>

        <link rel="stylesheet" href="${contextPath}/src/style/nicepage.css" />
        <link rel="stylesheet" href="${contextPath}/src/style/index.css" />
        <link rel="stylesheet" href="${contextPath}/src/style/Forum.css" />
        <link rel="stylesheet" href="${contextPath}/src/style/Post.css" />
        <link rel="stylesheet" href="${contextPath}/src/style/User.css" />

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js" defer></script>
        <script src="${contextPath}/src/script/nicepage.js"   defer="" ></script>
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
            <div class="u-clearfix u-sheet u-sheet-1">
                <a href="${contextPath}" class="u-hidden-sm u-hidden-xs u-image u-logo u-image-1" >
                    <img src="${contextPath}/images/lozr4rum1.png" class="u-logo-image u-logo-image-1" />
                </a>
                <div class="u-align-left u-container-style u-group u-group-1">
                    <div class="u-container-layout u-container-layout-1">
                        <a href="${transToPath.compressObjectToPath(contextPath, "user", your.loginName, your.userID)}">

                            <p class="u-align-right u-custom-font u-font-montserrat u-text u-text-1">
                                ${(empty your.loginName)? "Account": your.loginName}
                            </p>
                        </a>

                        <img
                            class="u-expanded-height-xl u-image u-image-circle u-image-2"

                            src="${your.avatar}"
                            />
                    </div>
                </div>

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
                                        <a class="u-button-style u-nav-link" href="${transToPath.compressObjectToPath(contextPath, "user", your.loginName, your.userID)}">
                                            ${(empty your.loginName)? "Account": your.loginName}
                                        </a>
                                    </li>
                                    <c:if test="${your.moderator}" >
                                        <li class="u-nav-item">
                                            <a onclick="openCreateForum()" class="u-button-style u-nav-link">New Forum</a>
                                        </li>
                                        <li class="u-nav-item">
                                            <a href="${contextPath}/admin/report/thread" class="u-button-style u-nav-link">Report Manager</a>
                                        </li>
                                    </c:if>
                                    <li class="u-nav-item">
                                        <a href="${contextPath}/update/user/info" class="u-button-style u-nav-link">Change Info</a>
                                    </li>
                                    <li class="u-nav-item">
                                        <a href="${contextPath}/logout" class="u-button-style u-nav-link">Log Out</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div class="u-custom-color-4 u-menu-overlay u-opacity u-opacity-65" ></div>
                    </div>
                </nav>
            </div>
        </header>

        <div class="main-zone">

            <div class="" id="user">
                <div class="user-card user-card">
                    <div class="user-avatar user-cell">
                        <img src="${user.avatar}" />
                    </div>
                    <div class="user-cell">
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
                                    <div class="">
                                        <span>Posts:</span>
                                        <span>Threads:</span>
                                    </div>
                                </div>
                                <div class="user-detail-name">
                                    <div class="user-firstname">
                                        <span>FirstName:</span>
                                        <span id="firstname">${user.firstName}</span>
                                    </div>
                                    <div class="user-lastname">
                                        <span>LastName:</span>
                                        <span id="lastname">${user.lastName}</span>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                    <div class="user-cell user-cell-report">
                        <button class="button report-button">REPORT</button>

                        <div class="user-permisson">
                            <c:if test="${!your.moderator && user.moderator}">
                                <div class="user-isadmin">
                                    <label>Moderator</label>
                                </div>
                            </c:if>
                            <c:if test="${your.moderator}">
                                <form action="../update/user/permission" method="POST" id="changePermissionForm">
                                    <input type="hidden" value="${user.userID}" name="userID" />
                                    <input id="moderator-tickbox" name="isAdmin" onchange ="changePermission('${user.userID}');" 
                                           ${user.moderator? "checked" : ""} type="checkbox">
                                    <label>Moderator permission</label>
                                </form>
                            </c:if>
                        </div>
                    </div>
                </div>
                <div class="content-select">            
                    <a href="${transToPath.compressObjectToPath(contextPath, "user", user.loginName, user.userID)}?postselect=1"
                       class="button button-change-content" >
                        LAST POSTS
                    </a>
                    <a
                        href="${transToPath.compressObjectToPath(contextPath, "user", user.loginName, user.userID)}"
                        class="button button-change-content" >
                        LAST THREADS
                    </a>
                </div>
            </div>
            <!--        <div class="body-header">    
                        <div  class="post-title" >
                            <h1>Last Threads</h1>
                        </div>
                    </div>-->
            <!--ThreadZone-->


            <c:forEach items="${threads}" var="thread">
                <a href="#ádfa">
                    <div class="thread-table thread-card">

                        <div class="thread-cell thread-cell-author">
                            <div class="">
                                <a href="${transToPath.compressObjectToPath(contextPath, "user", "", thread.startedBy.userID)}">
                                    <img src="${thread.startedBy.avatar}" />
                                </a>
                            </div>
                        </div>

                        <div class="thread-cell">
                            <div class="thread-subject">
                                <a href="${transToPath.compressObjectToPath(contextPath, "thread", "", thread.threadID)}">
                                    ${thread.subject}
                                </a>
                            </div>
                            <div>
                                <ul class="thread-item-part">
                                    <li>
                                        <a href="${transToPath.compressObjectToPath(contextPath, "user", "", thread.startedBy.userID)}" class="username"
                                           >${thread.startedBy.loginName}</a
                                        >
                                    </li>
                                    <li>
                                        <time class="thread-latestDate">
                                            <fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${thread.timeCreated}"/>
                                        </time>

                                    </li>
                                </ul>
                            </div>
                        </div>

                        <div class="thread-cell thread-status">
                            <dl class="thread-status-pair">
                                <dt>Replies</dt>
                                <dd>${thread.numPosts}</dd>
                            </dl>
                            <!-- <dl class="thread-status-pair">
                              <dt>Views</dt>
                              <dd>88</dd>
                            </dl> -->
                        </div>

                        <!--                        <div class="thread-table thread-cell thread-lastest-active">
                                                    <div class="thread-cell thread-cell-unborder">
                                                        <a
                                                            href="/t/tai-chinh-20m-tro-xuong-can-tu-van-cau-hinh-pc-phuc-vu-cho-edit-video-pts-ai-tren-adobe-co-the-choi-fifa-online-4.399690/latest"
                                                            rel="nofollow"
                                                            ><time class="thread-latestDate">11:13 05/10/2021</time></a
                                                        >
                                                        <div class="">
                                                            <a href="/u/congtubotgag.1034303/" class="username">congtubotgag</a>
                                                        </div>
                                                    </div>
                                                    <div class="thread-cell thread-latest-user thread-cell-unborder">
                                                        <a href="/u/congtubotgag.1034303/" class="avatar avatar--xxs">
                                                            <img src="images/82761229_p17_master1200.jpg" />
                                                        </a>
                        
                                                    </div>
                                                </div>-->

                        <!--                        <div class="thread-cell thread-latest-user">
                                                    <a href="/u/congtubotgag.1034303/" class="avatar avatar--xxs">
                                                        <img src="images/82761229_p17_master1200.jpg" />
                                                    </a>
                        
                                                </div>-->
                        <div class="thread-cell thread-cell-option  dropdown">
                            <button onclick="showDropdownMenu(${thread.threadID})" class="dropbtn">Option</button>
                            <div id="myDropdown-${thread.threadID}" class="dropdown-content">
                                <a href="#">Bookmark</a>

                                <a href="#">Change Title</a>
                                <c:if test="${your.moderator || your.userID == thread.startedBy.userID}">
                                    <a onclick="doDelete(${thread.threadID}, 'thread');">Delete</a>
                                </c:if>
                            </div>
                        </div>
                    </div>

                </a>

            </c:forEach>

            <c:forEach var="post" items="${requestScope.posts}">

                <!--Body post-->
                <div class="post">
                    <div class="post-user-cell">
                        <section class="post-user">
                            <div class="">
                                <div class="post-user-avatar">
                                    <a href="${transToPath.compressObjectToPath(contextPath, "user", "", user.userID)}" class="">
                                        <img
                                            class="post-user-img"
                                            src="${post.user.avatar}"
                                            />
                                    </a>
                                </div>
                            </div>
                            <div class="post-user-detail">
                                <h4 class="post-user-name">
                                    <a
                                        name="${post.postID}"
                                        href="${transToPath.compressObjectToPath(contextPath, "user", "", user.userID)}"
                                        class=""
                                        >${post.user.loginName}</a
                                    >
                                </h4>
                                <h5 class="post-user-title">New Member</h5>
                            </div>
                        </section>
                    </div>
                    <div class="post-main-cell">
                        <header class="post-attribute">
                            <time class="post-attribute-time">
                                <fmt:formatDate type="both" dateStyle="short"
                                                timeStyle="short" value="${post.timeCreated}"/>
                            </time>
                            <ul class="post-attribute-list">
                                <li>
                                    <a
                                        href="${transToPath.compressObjectToPath(contextPath, "thread", "", post.threadId)}"
                                        >
                                        Go to Thread
                                    </a>
                                </li>
                                <li>
                                    <a
                                        href="#go-to-bookmark-servlet"
                                        >
                                        Bookmark
                                    </a>
                                </li>                              
                            </ul>
                        </header>

                        <div class="post-main">
                            <c:if test="${!empty post.replyPost}">
                                <blockquote class="post-block-reply">
                                    <div class="post-reply-user">
                                        <a href="${transToPath.compressObjectToPath(contextPath, "user", "", post.replyPost.user.userID)}" class=""
                                           >${post.replyPost.user.loginName} said:</a
                                        >
                                    </div>
                                    <div class="post-reply-content">
                                        <div class="">
                                            ${post.replyPost.subject}
                                        </div>
                                    </div>
                                </blockquote>
                            </c:if>
                            <p name="${post.postID}">${post.subject}</p>
                        </div>
                        <footer class="post-footer">
                            <div class="post-action">
                                <div class="post-action-bar">
                                    <a href="#" class="post-reply-button">Delete</a>
                                    <a
                                        href="#post-create"
                                        class="post-reply-button"
                                        onclick="doReply(${post.postID})"
                                        >Reply</a
                                    >
                                </div>
                                <div class="">
                                    <a href="#go-to-report-servlet" class=""
                                       >Report</a
                                    >
                                </div>
                            </div>
                        </footer>
                    </div>
                </div>
                <!--/Body post-->
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

    </body>
</html>

