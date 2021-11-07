

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
        <title>${requestScope.query} | LOZR</title>
        <link rel="icon" href="${contextPath}/images/doge-nonbg.png">

        <link rel="stylesheet" href="https://area1110.github.io/JSBegin/CustomCDN/nicepage.css" />
        <link rel="stylesheet" href="${contextPath}/src/style/index.css" />
        <link rel="stylesheet" href="${contextPath}/src/style/Forum.css" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js" defer></script>

        <script src="${contextPath}/src/script/script.js" defer></script>
        <script src="${contextPath}/src/script/thread.js" defer></script>
        <script src="${contextPath}/src/script/paging.js"></script>
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
                <button type="submit" class="mybtn" onclick="removeSpace()">Save</button>
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

            <div class="body-header">       
                <div  class="post-title" >
                    <h1>Search: ${requestScope.query}</h1>
                </div>              
            </div>

            <div class="searchbar">
                <form id="form-search" action="${contextPath}/search/thread" method="GET">
                    <input id="insert-query" class="search-input search-texttype" name="q" placeholder="Find your interesting" value="${requestScope.query}"/>
                    <button class="search-input search-button" onclick="checkSubmit(event, 'form-search', 'insert-query');"><i class="fa fa-search"></i></button>
                </form>
            </div>
            <!--ThreadZone-->

            <c:if test="${empty requestScope.threads}">
                <div class="u-container-layout u-valign-top-lg u-valign-top-md u-valign-top-sm u-valign-top-xl u-container-layout-1">
                    <h1 class="u-align-center-xs  u-font-playfair-display u-text u-text-1">Oops, There is nothing here?!</h1>
                </div>
            </c:if>

            <c:forEach items="${threads}" var="thread">

                <div class="thread-table thread-card">

                    <div class="thread-cell thread-cell-author">
                        <div class="">
                            <a href="${transToPath.compressObjectToPath(contextPath, "user", thread.startedBy.loginName, thread.startedBy.userID)}">
                                <img src="${thread.startedBy.avatar}" />
                            </a>
                        </div>
                    </div>

                    <div class="thread-cell">
                        <div class="thread-subject">
                            <a
                                href="${transToPath.compressObjectToPath(contextPath, "thread", thread.subject, thread.threadID)}"
                                >${thread.subject}</a
                            >
                        </div>

                        <div class="">
                            <ul class="thread-item-part">
                                <li>
                                    <a href="${transToPath.compressObjectToPath(contextPath, "user", thread.startedBy.loginName, thread.startedBy.userID)}" class="username"
                                       >${thread.startedBy.loginName}</a
                                    >
                                </li>
                                <li class="">

                                    <time class="thread-latestDate">
                                        <fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${thread.timeCreated}"/>
                                    </time>

                                </li>
                            </ul>
                        </div>
                    </div>

                    <div class="thread-cell thread-status">
                        <table class="thread-status-pair">                            
                            <tr><td>Replies</td></tr>
                            <tr><td>${thread.numPosts}</td></tr>                              
                        </table>
                    </div>

                    <div class="thread-cell thread-cell-option  dropdown">
                        <button onclick="showDropdownMenu(${thread.threadID})" class="dropbtn">Option</button>
                        <div onclick="showDropdownMenu(${thread.threadID})" id="myDropdown-${thread.threadID}" class="dropdown-content">
                            <a href="${contextPath}/follow/thread?id=${thread.threadID}" target="dummyframe">Bookmark</a>
                            <a   href="javascript:void(0)"  onclick="doReport('${contextPath}', '${thread.threadID}', 'thread')" >Report</a>
                            <c:if test="${your.userID == thread.startedBy.userID}">
                                <a   href="javascript:void(0)" onclick="openForm(${thread.threadID});">Change Title</a>
                            </c:if>

                            <c:if test="${your.moderator || your.userID == thread.startedBy.userID}">
                                <a  href="javascript:void(0)" onclick="doDelete('${contexPath}', ${thread.threadID}, 'thread');">Delete</a>
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

