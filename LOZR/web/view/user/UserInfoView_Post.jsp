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
        <title>${user.loginName} | LOZR</title>
        <link rel="icon" href="${contextPath}/images/doge-nonbg.png">

        <link rel="stylesheet" href="https://area1110.github.io/JSBegin/CustomCDN/nicepage.css" />
        <link rel="stylesheet" href="${contextPath}/src/style/index.css" />
        <link rel="stylesheet" href="${contextPath}/src/style/Forum.css" />
        <link rel="stylesheet" href="${contextPath}/src/style/Post.css" />
        <link rel="stylesheet" href="${contextPath}/src/style/User.css" />

        <script src="${contextPath}/src/script/script.js" defer></script>
        <script src="${contextPath}/src/script/paging.js" ></script>

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

        <div class="main-zone">

            <div class="" id="user">
                <div class="user-card">
                    <div class="user-avatar user-cell">
                        <img src="${user.avatar}" />
                    </div>
                    <div class="user-cell user-info">
                        <div class="user-loginname">
                            <h2 ${user.active? "" : "class=\" deactive\""}>${user.loginName}</h2>
                            <div class="user-detail">
                                <table class="user-detail-name">
                                    <tr class="user-joineddate">
                                        <td><span>Joined:</span></td>
                                        <td>  <time>
                                                <fmt:formatDate value="${user.timeJoined}" type="date"  dateStyle="short"/>
                                            </time></td>
                                    </tr>
                                    <tr>
                                        <td><span>Email:</span></td>
                                        <td>  <span>${user.emailAddress}</span></td>

                                    </tr>
                                    <tr class="user-firstname">
                                        <td><span>FirstName:</span></td>
                                        <td><span id="firstname">${user.firstName}</span></td>
                                    </tr>
                                    <tr class="user-lastname">
                                        <td><span>LastName:</span></td>
                                        <td><span id="lastname">${user.lastName}</span></td>
                                    </tr>
                                </table>

                                <table class="user-total-numbers">
                                    <tr >
                                        <td> <span>Posts:</span></td>
                                        <td> <span>${user.totalPosts}</span></td>
                                        <td> <span>Threads:</span></td>
                                        <td> <span>${user.totalThreads}</span></td>
                                    </tr>
                                </table>

                            </div>
                        </div>
                    </div>
                    <div class="user-cell user-cell-report dropdown">
                        <c:if test="${your.userID != user.userID and !empty your}">
                            <button onclick="showDropdownMenu('user-${user.userID}')" class="dropbtn">Option</button>
                            <div  id="myDropdown-user-${user.userID}" class="dropdown-content" onclick="showDropdownMenu('user-${user.userID}')">
                                <a  onclick="doReport('${contextPath}', '${user.userID}', 'user')" >Report</a>
                                <c:if test="${your.moderator}">
                                    <form target="dummyframe" action="${contextPath}/update/user/permission" method="POST" id="changePermissionForm-${user.userID}">
                                        <input type="hidden" value="${user.userID}" name="userID" />
                                        <input id="moderator-tickbox-${user.userID}" name="isAdmin" onchange ="changePermission('${user.userID}');" 
                                               ${user.moderator? "checked" : ""} type="checkbox">
                                        <label for="moderator-tickbox-${user.userID}">Moderator permission</label>
                                    </form>
                                    <c:if test="${user.active}">
                                        <a onclick="doDelete('${contextPath}', ${user.userID}, 'user')" href="javascript:void(0)">Ban</a>
                                    </c:if>
                                    <c:if test="${!user.active}">
                                        <a onclick="reloadDelay()" href="${contextPath}/delete/user?id=${user.userID}&activate=true" target="dummyframe">Unban</a>
                                    </c:if>
                                </c:if>
                            </div>
                        </c:if>
                        <div class="user-permisson">
                            <c:if test="${user.moderator}">
                                <div class="user-isadmin">
                                    <label>Mod</label>
                                </div>
                            </c:if>
                        </div>
                    </div>
                </div>
                <div class="content-select">            
                    <a
                        href="?postselect=0"
                        class="button button-change-content" >
                        LAST THREADS
                    </a>
                    <a href="#post"
                       class="button button-change-content active" >
                        LAST POSTS
                    </a>
                </div>
            </div>
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
                            <ul class="post-attribute-list">
                                <li>
                                    <a
                                        href="${transToPath.compressObjectToPath(contextPath, "thread", "", post.threadId)}"
                                        >
                                        Go to Thread
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
                            <div id="postsubject-${post.postID}" name="${post.postID}">${post.subject}</div>
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
        </div>

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
        <script>
            createPager('pagerBottom', ${pageIndex}, ${totalPage});
        </script>
    </body>
</html>

