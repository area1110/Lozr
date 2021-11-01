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

        <link rel="stylesheet" href="https://area1110.github.io/JSBegin/CustomCDN/nicepage.css" />
        <link rel="stylesheet" href="${contextPath}/src/style/index.css" />
        <link rel="stylesheet" href="${contextPath}/src/style/Forum.css" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js" defer></script>

        <script src="${contextPath}/src/script/script.js" defer></script>
        <script src="${contextPath}/src/script/paging.js"></script>
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
        <div class="form-popup" id="formEdit">
            <form id="hidden-form" onsubmit="reloadDelay(500)" target="dummyframe" action="${contextPath}/update/thread" method="POST" class="form-container">
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
            <div class="content-select">      
                <a href="thread"
                   class="button button-change-content active" >
                    THREADS MANAGEMENT
                </a>
                <a href="post"
                   class="button button-change-content" >
                    POSTS MANAGEMENT
                </a>            
                <a href="user"
                   class="button button-change-content" >
                    USER MANAGEMENT
                </a>
            </div>
            <div class="body-header">
                <div  class="post-title" >
                    <h1>THREAD MANAGEMENT</h1>
                </div>
            </div>
            <!--ThreadZone-->
            <c:if test="${empty requestScope.reports}">
                <div class="u-container-layout u-valign-top-lg u-valign-top-md u-valign-top-sm u-valign-top-xl u-container-layout-1">
                    <h1 class="u-align-center-xs  u-font-playfair-display u-text u-text-1">Done! Everything is clear.</h1>
                </div>
            </c:if>

            <c:forEach items="${reports}" var="report">
                <c:set var="thread" value="${report.thread}"/>
          
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
                                <a id="threadsubject-${thread.threadID}"
                                    href="${transToPath.compressObjectToPath(contextPath, "thread", thread.subject, thread.threadID)}"
                                    >${thread.subject}</a>
                            </div>
                            <div >
                                <ul class="thread-item-part">
                                    <li>
                                        <a href="${transToPath.compressObjectToPath(contextPath, "user", thread.startedBy.loginName, thread.startedBy.userID)}" class="username"
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
                            <table class="thread-status-pair">
                                <tr>
                                    <td>Replies</td>
                                    <td>${thread.numPosts}</td>
                                </tr>
                            </table>
                        </div>
                        <div class=" thread-cell thread-report">                
                            <span>Reason: </span>                        
                            <span>${report.reason}</span>                        
                        </div>                
                        <div class="thread-cell thread-cell-option  dropdown">
                            <button onclick="showDropdownMenu(${thread.threadID})" class="dropbtn">Option</button>
                             <div onclick="showDropdownMenu(${thread.threadID})" id="myDropdown-${thread.threadID}" class="dropdown-content">
                                <a href="${contextPath}/follow/thread?id=${thread.threadID}" target="dummyframe">Bookmark</a>
                                <c:if test="${your.userID == thread.startedBy.userID}">
                                      <a   href="javascript:void(0)" onclick="openForm(${thread.threadID}, 'threadsubject');">Change Title</a>
                                </c:if>
                                <a  href="javascript:void(0)" onclick="doDelete('${contexPath}', ${thread.threadID}, 'thread');">Delete</a>
                                <a onclick="reloadDelay()" target="dummyframe" href="${contextPath}/admin/report/thread?id=${thread.threadID}">Remove From List</a>
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

