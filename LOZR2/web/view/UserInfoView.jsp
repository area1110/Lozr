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
        <c:set var="defaultImage" value="${contextPath}/images/82761229_p17_master1200.jpg"/>
        <c:set var="userAvatar" value="data:image/jpg;base64,${user.base64ImageAvatar}"/>
        <c:set var="yourAvatar" value="data:image/jpg;base64,${your.base64ImageAvatar}"/>


        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta charset="utf-8" />
        <title>${forum.name} | L0ZR</title>

        <link rel="stylesheet" href="${contextPath}/src/style/nicepage.css" />
        <link rel="stylesheet" href="${contextPath}/src/style/index.css" />
        <link rel="stylesheet" href="${contextPath}/src/style/Forum.css" />
        <link rel="stylesheet" href="${contextPath}/src/style/Post.css" />
        <link rel="stylesheet" href="${contextPath}/src/style/User.css" />

        <script
            type="text/javascript"
            src="${contextPath}/src/script/jquery.js"
            defer=""
        ></script>
        <script
            type="text/javascript"
            src="${contextPath}/src/script/nicepage.js"
            defer=""
        ></script>
        <script src="${contextPath}/src/script/script.js" defer></script>
        <!-- <meta name="generator" content="Nicepage 3.26.0, nicepage.com" /> -->
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
                <a
                    href="#main"
                    class="u-hidden-sm u-hidden-xs u-image u-logo u-image-1"
                    data-image-width="590"
                    data-image-height="90"
                    >
                    <img src="${contextPath}/images/lozr4rum1.png" class="u-logo-image u-logo-image-1" />
                </a>
                <a href="${transToPath.compressObjectToPath(contextPath, "user", "", user.userID)}">
                    <div class="u-align-left u-container-style u-group u-group-1">
                        <div class="u-container-layout u-container-layout-1">
                            <p
                                class="
                                u-align-right u-custom-font u-font-montserrat u-text u-text-1
                                "
                                >
                                ${(empty your)? "Account" : your.loginName}
                            </p>
                            <img
                                class="u-expanded-height-xl u-image u-image-circle u-image-2"
                                src= "${(empty your.base64ImageAvatar)?  defaultImage : yourAvatar}"
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
                                        <a class="u-button-style u-nav-link" href="${transToPath.compressObjectToPath(contextPath, "user", "", your.userID)}"
                                           >${(empty your)? "Account" : your.loginName}</a
                                        >
                                    </li>
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

        <div class="main-zone">

            <div class="" id="user">
                <div class="user-card user-card">
                    <div class="user-avatar user-cell">
                        <img src="${(empty user.base64ImageAvatar)?  defaultImage : userAvatar}" />
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
                            <c:if test="${!your.admin && user.admin}">
                                <div class="user-isadmin">
                                    <label>Admin</label>
                                </div>
                            </c:if>
                            <c:if test="${your.admin}">
                                <form action="../update/user/permission" method="POST" id="changePermissionForm">
                                    <input type="hidden" value="${user.userID}" name="userID" />
                                    <input id="admin-tickbox" name="isAdmin" onchange ="changePermission('${user.userID}');" 
                                           ${user.admin? "checked" : ""} type="checkbox">
                                    <label>Admin permission</label>
                                </form>
                            </c:if>
                        </div>
                    </div>
                </div>
<!--                <div class="content-select">
                    <a
                        href="${transToPath.compressObjectToPath(contextPath, "user", user.loginName, user.userID)}?postselect=1"
                        class="button button-change-content"
                        >
                        LAST POSTS
                    </a>
                    <button
                        href="https://nicepage.com/k/consulting-website-templates"
                        class="button button-change-content active"
                        >
                        LAST THREADS
                    </button>
                </div>-->
            </div>

            <div class="body-header">    
                <div  class="post-title" >
                    <h1>Last Threads</h1>
                </div>
            </div>
            <!--ThreadZone-->


            <c:forEach items="${threads}" var="thread">
                <c:set var="threadByAvatar" value="data:image/jpg;base64,${thread.startedBy.base64ImageAvatar}"/>
                <a href="#ádfa">
                    <div class="thread-table thread-card">

                        <div class="thread-cell thread-cell-author">
                            <div class="">
                                <a href="#">
                                    <img src="${(empty thread.startedBy.base64ImageAvatar)?defaultImage :  threadByAvatar }" />
                                </a>
                            </div>
                        </div>

                        <div class="thread-cell">
                            <div class="thread-subject">
                                <a
                                    href="${transToPath.compressObjectToPath(contextPath, "thread", "", thread.threadID)}"
                                    >${thread.subject}</a
                                >
                            </div>

                            <div class="">
                                <ul class="thread-item-part">
                                    <li>
                                        <a href="#" class="username"
                                           >${thread.startedBy.loginName}</a
                                        >
                                    </li>
                                    <li class="">
                                        <a href="/t/tai-chinh-20m-tro-xuong-can-tu-van-cau-hinh-pc-phuc-vu-cho-edit-video-pts-ai-tren-adobe-co-the-choi-fifa-online-4.399690/">
                                            <time class="thread-latestDate">
                                                <fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${thread.timeCreated}"/>
                                            </time>
                                        </a>
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
                                <c:if test="${your.admin || your.userID == thread.startedBy.userID}">
                                    <a onclick="doDelete(${thread.threadID}, 'thread');">Delete</a>
                                </c:if>
                            </div>
                        </div>
                    </div>

                </a>

            </c:forEach>

            <c:forEach var="post" items="${requestScope.posts}">
                <c:set var="postByAvatar" value="data:image/jpg;base64,${post.user.base64ImageAvatar}"/>

                <!--Body post-->
                <div class="post">
                    <div class="post-user-cell">
                        <section itemtype="https://schema.org/Person" class="post-user">
                            <div class="">
                                <div class="post-user-avatar">
                                    <a href="https://f95zone.to/members/molvaeth.2791234/" class="">
                                        <img
                                            class="post-user-img"
                                            src="${(empty post.user.base64ImageAvatar)?  defaultImage : postByAvatar}"
                                            />
                                    </a>
                                </div>
                            </div>
                            <div class="post-user-detail">
                                <h4 class="post-user-name">
                                    <a
                                        name="${post.postID}"
                                        href="https://f95zone.to/members/molvaeth.2791234/"
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
                                        href="https://f95zone.to/threads/boxing-fantasy-final-pinclude-studio.95408/post-6647695"
                                        >
                                        #7
                                    </a>
                                </li>
                            </ul>
                        </header>

                        <div class="post-main">
                            <c:if test="${!empty post.replyPost}">
                                <blockquote class="post-block-reply">
                                    <div class="post-reply-user">
                                        <a href="https://f95zone.to/goto/post?id=6647317" class=""
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
                                    <a href="https://f95zone.to/posts/6647695/report" class=""
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

