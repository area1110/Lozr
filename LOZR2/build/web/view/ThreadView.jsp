<%-- 
    Document   : ThreadView
    Created on : Oct 5, 2021, 8:06:05 PM
    Author     : Khanh
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="font-size: 16px">
    <head>
        <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
        <c:set var="your" value="${sessionScope.currentUser}"/>
        <c:set var="defaultImage" value="${contextPath}/images/82761229_p17_master1200.jpg"/>
        <c:set var="yourAvatar" value="data:image/jpg;base64,${your.base64ImageAvatar}"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta charset="utf-8" />
        <title>${thread.subject} | L0ZR</title>

        <link rel="stylesheet" href="${contextPath}/src/style/nicepage.css" />
        <link rel="stylesheet" href="${contextPath}/src/style/index.css" />
        <link rel="stylesheet" href="${contextPath}/src/style/Post.css" />
        <script type="text/javascript" src="${contextPath}/src/script/jquery.js" defer></script>
        <script type="text/javascript" src="${contextPath}/src/script/nicepage.js" defer></script>
        <script type="text/javascript" src="${contextPath}/src/script/script.js" defer></script>
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
                <a href="#">
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
                                src="${(empty your.base64ImageAvatar)?  defaultImage : yourAvatar}"
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
                                        <a class="u-button-style u-nav-link" href="Page-1.html"
                                           >${(empty your)? "Account" : your.loginName}</a
                                        >
                                    </li>
                                    <li class="u-nav-item">
                                        <a class="u-button-style u-nav-link">Log Out</a>
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
            <div class="body-header">
                <c:if test="${thread.active}">
                    <div class="post-title">
                        <h1>${thread.subject}</h1>
                    </div>
                </c:if>
                <c:if test="${!thread.active}">
                    <div class="post-title">
                        <h1 class="deactive">${thread.subject}</h1>
                        <h2>- Deactive -</h2>
                    </div>
                </c:if>
                <div class="post-title-description">
                    <ul>
                        <li>${thread.startedBy.loginName}</li>
                        <li><time><fmt:formatDate type="both" dateStyle="short"
                                        timeStyle="short" value="${thread.timeCreated}"/></time></li>
                    </ul>
                </div>
            </div>
            <c:if test="${empty requestScope.posts}">
                <div class="u-container-layout u-valign-top-lg u-valign-top-md u-valign-top-sm u-valign-top-xl u-container-layout-1">
                    <h1 class="u-align-center-xs  u-font-playfair-display u-text u-text-1">Publish Your Mind?!</h1>
                </div>
            </c:if>
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
            <c:if test="${thread.active}">
                <div class="post">
                    <div class="post-user-cell">
                        <section itemtype="https://schema.org/Person" class="post-user">
                            <div class="">
                                <div class="post-user-avatar">
                                    <a href="https://f95zone.to/members/molvaeth.2791234/" class="">
                                        <img
                                            class="post-user-img"
                                            src="${(empty your.base64ImageAvatar)?  defaultImage : yourAvatar}"
                                            />
                                    </a>
                                </div>
                            </div>
                            <div class="post-user-detail">
                                <h4 class="post-user-name">
                                    <a href="https://f95zone.to/members/molvaeth.2791234/" class=""
                                       >You</a
                                    >
                                </h4>
                            </div>
                        </section>
                    </div>
                    <div class="post-main-cell">
                        <div class="post-main">
                            <blockquote class="post-block-reply" id="blockreply">
                                <div class="post-reply-user">
                                    <a id="replyUser" class=""></a> said:
                                </div>
                                <div class="post-reply-content">
                                    <div id="replySubject" class=""></div>
                                </div>
                                <div class="cancel-reply">
                                    <a href="#post-create" onclick="doCancel()">Cancel reply</a>
                                </div>
                            </blockquote>

                            <div class="post-create" id="post-create">
                                <form action="../post" method="POST" class="post-create-form">
                                    <input type="hidden" name="replyID" id="replyID" value="" />
                                    <input type="hidden" name="threadID" value="${thread.threadID}"/>
                                    <div>
                                        <label for="postSubject"></label>
                                        <textarea
                                            class="post-subject-textarea text-insert"
                                            name="postSubject"
                                            placeholder="What is your thinking?"
                                            ></textarea>
                                    </div>
                                    <div class="post-create-submit">
                                        <input class="submit-button" type="submit" value="Post" />
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </c:if>

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

