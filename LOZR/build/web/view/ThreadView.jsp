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
        <title>${thread.subject} | LOZR</title>
        <link rel="icon" href="${contextPath}/images/doge-nonbg.png">
        
        <link rel="stylesheet" href="https://area1110.github.io/JSBegin/CustomCDN/nicepage.css" />
        <link rel="stylesheet" href="${contextPath}/src/style/index.css" />
        <link rel="stylesheet" href="${contextPath}/src/style/Post.css" />

        <script type="text/javascript" src="${contextPath}/src/script/script.js" defer></script>
        <script type="text/javascript" src="${contextPath}/src/script/paging.js"></script>

        <!-- include libraries(jQuery, bootstrap) -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

        <!-- include summernote css/js -->
        <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
        <script src="${contextPath}/src/script/summernote.js"></script>
        <!--/summernote-->

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

        <div class="form-popup" id="formEdit">
            <form id="hidden-form" onsubmit="location.reload();" target="dummyframe" action="${contextPath}/update/post" method="POST" class="form-container">
                <input type="hidden" id="elementeID"  name="postID"/> 
                <label  for="postContent">Edit Your Reply</label>
                <textarea class="summernote" id="postContent" name="postContent"></textarea>
                <button type="submit" class="mybtn">Save</button>
                <button type="button" class="mybtn" onclick="closeForm()">Close</button>
            </form>
        </div>

        <header class="u-clearfix u-header u-sticky u-sticky-1ec8 u-white u-header">
            <div class="header">
                <div  class="header-logo">
                    <a href="${contextPath}">
                        <img  src="${contextPath}/images/lozr4rum1.png" class="logo-header" />
                    </a>
                </div>
                <div class="header-action">
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
                    </c:if>
                    <nav class="header-action-item">
                        <div id="mySidepanel" class="sidepanel">
                            <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
                            <c:if test="${empty your}">
                                <a class="u-button-style u-nav-link" href="${contextPath}/signup">
                                    Sign Up
                                </a>
                                <a class="u-button-style u-nav-link" href="${contextPath}/login">
                                    Log In
                                </a>
                            </c:if>
                            <c:if test="${!empty your}">
                                <a class="menu-user-name" href="${transToPath.compressObjectToPath(contextPath, "user", your.loginName, your.userID)}">${(empty your.loginName)? "Account": your.loginName}</a>
                                <a  href="${contextPath}/follow/manage/thread" class="u-button-style u-nav-link">Bookmark</a>
                                <c:if test="${your.moderator}" >
                                    <a  href="${contextPath}/admin/report/thread" class="u-button-style u-nav-link">Report Manager</a>
                                </c:if>
                                <a href="${contextPath}/search/user" class="u-button-style u-nav-link">Find User</a>
                                <a href="${contextPath}/update/user/info" class="u-button-style u-nav-link">Change Info</a>
                                <a href="${contextPath}/logout" class="u-button-style u-nav-link">Log Out</a>
                            </c:if>
                        </div>
                        <button class="openbtn" onclick="openNav()"><i class="fa fa-bars"></i></button>
                    </nav>     

                </div>
            </div>
        </header>

        <div class="main-zone">
            <ul class="breadcrumb">
                <li><a href="../home">Forums</a></li>
                <li><a href="${transToPath.compressObjectToPath(contextPath, "forum",thread.forum.name  , thread.forum.forumID)}">${thread.forum.name}</a></li>
                <li>${thread.subject}</li>
            </ul>
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
                <div class="post" id="post-${post.postID}">
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
                                            <div>${post.replyPost.subject}</div>
                                        </div>
                                    </div>
                                </blockquote>
                            </c:if>
                            <div  id="postsubject-${post.postID}" name="${post.postID}">${post.subject}</div>
                        </div>
                        <footer class="post-footer">
                            <div class="post-action">
                                <c:if test="${!empty your}">
                                    <div class="post-action-bar">
                                        <c:if test="${your.userID==post.user.userID}">
                                            <a href="javascript:void(0)" onclick="openForm(${post.postID}, 'postsubject')" class="post-reply-button">Edit</a>
                                        </c:if>
                                        <c:if test="${your.moderator || your.userID==post.user.userID}">
                                            <a href="javascript:void(0)" onclick="doDelete('${contextPath}',${post.postID}, 'post')" class="post-reply-button">Delete</a>
                                        </c:if>
                                        <a
                                            href="#post-create"
                                            class="post-reply-button"
                                            onclick="doReply(${post.postID})"
                                            >Reply</a
                                        >
                                    </div>
                                    <div class="">
                                        <a href="javascript:void(0)" onclick="doReport('${contextPath}',${post.postID}, 'post')"
                                           >Report</a
                                        >
                                    </div>
                                </c:if>
                            </div>
                        </footer>
                    </div>
                </div>
                <!--/Body post-->
            </c:forEach>
            <div class="align-right">
                <div id="pagerBottom" class="pagination" ></div>
            </div>
            <c:if test="${!(empty your) and thread.active}">
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
                                    <div id="replySubject" class=""></div>
                                </div>
                                <div class="cancel-reply">
                                    <a href="#post-create" onclick="doCancel()">Cancel reply</a>
                                </div>
                            </blockquote>

                            <div class="post-create" id="post-create">
                                <form action="${contextPath}/post" method="POST" class="post-create-form">
                                    <input type="hidden" name="replyID" id="replyID" value="" />
                                    <input type="hidden" name="threadID" value="${thread.threadID}"/>
                                    <div>
                                        <label for="postSubject"></label>
                                        <!--                                        <textarea
                                                                                    class="post-subject-textarea text-insert"
                                                                                    name="postSubject"
                                                                                    placeholder="What is your thinking?"
                                                                                    ></textarea>-->
                                        <textarea class="summernote" name="postSubject"></textarea>
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
            >
            <div class="u-clearfix u-sheet u-sheet-1">
                <p class="u-small-text u-text u-text-variant u-text-1">
                   ?? 2021 Copyright: Area1110. All rights reserved
                </p>
            </div>
        </footer>
        <iframe name="dummyframe" id="dummyframe" style="display: none;"></iframe>
        <script>
            createPager('pagerBottom', ${pageIndex}, ${totalPage});
        </script>
    </body>
</html>

