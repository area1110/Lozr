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
        <jsp:useBean id="transToPath" class="controller.module.ExtractURLPath"/>

        <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
        <c:set var="your" value="${sessionScope.currentUser}"/>

        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta charset="utf-8" />
        <title>${thread.subject} | L0ZR</title>

        <link rel="stylesheet" href="${contextPath}/src/style/nicepage.css" />
        <link rel="stylesheet" href="${contextPath}/src/style/index.css" />
        <link rel="stylesheet" href="${contextPath}/src/style/Post.css" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js" defer></script>
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
                <!--Body post-->
                <div class="post" id="${post.postID}">
                    <div class="post-user-cell">
                        <section  class="post-user">
                            <div class="">
                                <div class="post-user-avatar">
                                    <a href="${transToPath.compressObjectToPath(contextPath, "user", post.user.loginName , post.user.userID)}" class="">
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
                                        href="${transToPath.compressObjectToPath(contextPath, "user", post.user.loginName, post.user.userID)}"
                                        class=""
                                        >${post.user.loginName}</a
                                    >
                                </h4>
                                <h5 class="post-user-title">${post.user.moderator? "Moderator" : ""}</h5>
                            </div>
                        </section>
                    </div>
                    <div class="post-main-cell">
                        <header class="post-attribute">
                            <time class="post-attribute-time">
                                <fmt:formatDate type="both" dateStyle="short"
                                                timeStyle="short" value="${post.timeCreated}"/>
                            </time>
                            <!--                            <ul class="post-attribute-list">
                                                            <li>
                                                               
                                                            </li>
                                                        </ul>-->
                        </header>

                        <div class="post-main">
                            <c:if test="${!empty post.replyPost}">
                                <blockquote class="post-block-reply">
                                    <div class="post-reply-user">
                                        <a href="${transToPath.compressObjectToPath(contextPath, "user", post.replyPost.user.loginName, post.replyPost.user.userID)}" class=""
                                           >${post.replyPost.user.loginName} said:</a
                                        >
                                    </div>
                                    <div class="post-reply-content">
                                        <div class="">
                                            <pre>${post.replyPost.subject}</pre>
                                        </div>
                                    </div>
                                </blockquote>
                            </c:if>
                            <pre name="${post.postID}">${post.subject}</pre>
                        </div>
                        <footer class="post-footer">
                            <div class="post-action">
                                <div class="post-action-bar">
                                    <c:if test="${your.moderator || your.userID==post.user.userID}">
                                        <a href="javascript:void(0)" onclick="doDelete(${post.postID}, 'post')" class="post-reply-button">Delete</a>
                                    </c:if>
                                    <a
                                        href="#post-create"
                                        class="post-reply-button"
                                        onclick="doReply(${post.postID})"
                                        >Reply</a
                                    >
                                </div>
                                <div class="">
                                    <a onclick="alert('This post has been reported to moderator');" target="dummyframe" href="${contextPath}/report/post?id=${post.postID}"
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
                        <section class="post-user">
                            <div class="">
                                <div class="post-user-avatar">
                                    <a href="${transToPath.compressObjectToPath(contextPath, "user", your.loginName, your.userID)}" class="">
                                        <img
                                            class="post-user-img"
                                            src="${your.avatar}"
                                            />
                                    </a>
                                </div>
                            </div>
                            <div class="post-user-detail">
                                <h4 class="post-user-name">
                                    <a href="${transToPath.compressObjectToPath(contextPath, "user", your.loginName, your.userID)}" class=""
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
                                    <pre id="replySubject" class=""></pre>
                                </div>
                                <div class="cancel-reply">
                                    <a href="#post-create" onclick="doCancel()">Cancel reply</a>
                                </div>
                            </blockquote>

                            <div class="post-create" id="post-create">
                                <form onsubmit="reloadDelay();" target="dummyframe" action="../post" method="POST" class="post-create-form">
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
        <iframe name="dummyframe" id="dummyframe" style="display: none;"></iframe>

    </body>
</html>

