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

        <link rel="stylesheet" href="https://area1110.github.io/JSBegin/CustomCDN/nicepage.css" />
        <link rel="stylesheet" href="${contextPath}/src/style/index.css" />
        <link rel="stylesheet" href="${contextPath}/src/style/Forum.css" />
        <link rel="stylesheet" href="${contextPath}/src/style/Post.css" />
        <link rel="stylesheet" href="${contextPath}/src/style/User.css" />

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js" defer></script>
        <script src="${contextPath}/src/script/script.js" defer></script>
        <script src="${contextPath}/src/script/paging.js" ></script>


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
            <form onsubmit="location.reload();" target="dummyframe" action="${contextPath}/update/thread" method="POST" class="form-container">
                <h2>Edit Thread</h2>
                <input type="hidden" id="elementeID"  name="threadID"/> 
                <label  for="threadSubject">New Thread Title</label>
                <input type="text" placeholder="New Name" name="threadSubject">
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

            <div class="" id="user">
                <div class="user-card">
                    <div class="user-avatar user-cell">
                        <img src="${user.avatar}" />
                    </div>
                    <div class="user-cell user-info">
                        <div class="user-loginname">
                            <h2>${user.loginName}</h2>
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
                        <c:if test="${your.userID != user.userID}">
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
                                    <a href="${contextPath}/delete/user?id=${user.userID}" target="dummyframe">Ban</a>
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
                        href="#lastthreads"
                        class="button button-change-content active" >
                        LAST THREADS
                    </a>
                    <a href="?postselect=1"
                       class="button button-change-content" >
                        LAST POSTS
                    </a>
                </div>
            </div>
            <c:forEach items="${threads}" var="thread">

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
                    </div>
                    <div class="thread-cell thread-cell-option  dropdown">
                        <button onclick="showDropdownMenu('thread-${thread.threadID}')" class="dropbtn">Option</button>
                        <div onclick="showDropdownMenu('thread-${thread.threadID}')" id="myDropdown-thread-${thread.threadID}" class="dropdown-content">
                            <a href="${contextPath}/follow/thread?id=${thread.threadID}" target="dummyframe">Bookmark</a>
                            <a   href="javascript:void(0)" onclick="alert('This thread has been reported to moderator');" target="dummyframe" href="${contextPath}/report/thread?id=${thread.threadID}">Report</a>
                            <c:if test="${your.userID == thread.startedBy.userID}">
                                <a onclick="openForm(${thread.threadID});">Change Title</a>
                            </c:if>
                            <c:if test="${your.moderator || your.userID == thread.startedBy.userID}">
                                <a href="javascript:void(0)"  onclick="doDelete(${thread.threadID}, 'thread');">Delete</a>
                            </c:if>
                        </div>
                    </div>
                </div>

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

