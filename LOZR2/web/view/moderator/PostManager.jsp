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
        <title>Post Management| LOZR</title>
          <link rel="icon" href="${contextPath}/images/doge-nonbg.png">

        <link rel="stylesheet" href="https://area1110.github.io/JSBegin/CustomCDN/nicepage.css" />
        <link rel="stylesheet" href="${contextPath}/src/style/index.css" />
        <link rel="stylesheet" href="${contextPath}/src/style/Post.css" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js" defer></script>
        <script type="text/javascript" src="${contextPath}/src/script/script.js" defer></script>
        <script type="text/javascript" src="${contextPath}/src/script/paging.js" ></script>
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
            <form id="hidden-form" onsubmit="reloadDelay(500)" target="dummyframe" action="${contextPath}/update/post" method="POST" class="form-container">
                <h2>Edit Thread</h2>
                <input type="hidden" id="elementeID"  name="postID"/> 
                <label  for="postContent">Edit Your Reply</label>
                <textarea class="post-subject-textarea text-insert" id="postContent"  name="postContent"></textarea>
                <button type="submit" class="btn">Save</button>
                <button type="button" class="btn" onclick="closeForm()">Close</button>
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
                            <a href="${contextPath}/search/user" class="u-button-style u-nav-link">Find User</a>
                            <a href="${contextPath}/update/user/info" class="u-button-style u-nav-link">Change Info</a>
                            <a href="${contextPath}/logout" class="u-button-style u-nav-link">Log Out</a>
                        </div>
                        <button class="openbtn" onclick="openNav()"><i class="fa fa-bars"></i></button>
                    </nav>              
                </div>
            </div>
        </header>

        <div class="main-zone">
            <div class="content-select">       
                <a href="thread"
                   class="button button-change-content" >
                    THREADS MANAGEMENT
                </a>
                <a href="post"
                   class="button button-change-content active" >
                    POSTS MANAGEMENT
                </a>            
                <a href="user"
                   class="button button-change-content" >
                    USER MANAGEMENT
                </a>
            </div>
            <div class="body-header">

                <div class="post-title">
                    <h1>POSTS MANAGEMENT</h1>
                </div>                      
            </div>
            <c:if test="${empty requestScope.reports}">
                <div class="u-container-layout u-valign-top-lg u-valign-top-md u-valign-top-sm u-valign-top-xl u-container-layout-1">
                    <h1 class="u-align-center-xs  u-font-playfair-display u-text u-text-1">Done! Everything is clear.</h1>
                </div>
            </c:if>
            <c:forEach var="report" items="${requestScope.reports}">
                <c:set var="post" value="${report.post}"/>
                <!--Body post-->
                <div class="post">
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
                            <span>Reason: </span>
                            <span>${report.reason}</span>
                        </header>
                        <header class="post-attribute">
                            <time class="post-attribute-time">
                                <fmt:formatDate type="both" dateStyle="short"
                                                timeStyle="short" value="${post.timeCreated}"/>
                            </time>
                            <ul class="post-attribute-list">
                                <li>
                                    <a href="${transToPath.compressObjectToPath(contextPath, "thread", "", post.threadId)}">Go to thread</a>
                                </li>
                            </ul>
                        </header>

                        <div class="post-main">
                            <c:if test="${!empty post.replyPost}">
                                <blockquote class="post-block-reply">
                                    <div class="post-reply-user">
                                        <a href="${transToPath.compressObjectToPath(contextPath, "user", post.replyPost.user.loginName, post.replyPost.user.userID)}">
                                            ${post.replyPost.user.loginName} said:
                                        </a>
                                    </div>
                                    <div class="post-reply-content">
                                        <div class="">
                                            <pre>${post.replyPost.subject}</pre>
                                        </div>
                                    </div>
                                </blockquote>
                            </c:if>
                            <pre id="postsubject-${post.postID}" name="${post.postID}">${post.subject}</pre>
                        </div>
                        <footer class="post-footer">
                            <div class="post-action">
                                <div class="post-action-bar">
                                    <c:if test="${your.userID==post.user.userID}">
                                        <a href="javascript:void(0)" onclick="openForm(${post.postID}, 'postsubject')" class="post-reply-button">Edit</a>
                                    </c:if>
                                    <c:if test="${your.moderator || your.userID==post.user.userID}">
                                        <a href="javascript:void(0)" onclick="doDelete('${contextPath}', ${post.postID}, 'post')" class="post-reply-button">Delete</a>
                                    </c:if>
                                </div>
                                <div class="">
                                    <a target="dummyframe" onclick="reloadDelay()" href="${contextPath}/admin/report/post?id=${post.postID}"
                                       >Remove From List</a
                                    >
                                </div>
                            </div>
                        </footer>
                    </div>
                </div>
                <!--/Body post-->
            </c:forEach>
            <div class="align-right">
                <div id="pagerBottom" class="pagination" ></div>
            </div>
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

        <script>
            createPager('pagerBottom', ${pageIndex}, ${totalPage});
        </script>
    </body>
</html>

