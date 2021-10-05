<%-- 
    Document   : ThreadView
    Created on : Oct 4, 2021, 5:18:21 PM
    Author     : Khanh
--%>

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
        <title>${forum.name} | L0ZR</title>

        <link rel="stylesheet" href="${contextPath}/src/style/nicepage.css" />
        <link rel="stylesheet" href="${contextPath}/src/style/index.css" />
        <link rel="stylesheet" href="${contextPath}/src/style/Forum.css" />
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
                    <img src="/images/lozr4rum1.png" class="u-logo-image u-logo-image-1" />
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
                <div class="post-title"><h1>${forum.name}</h1></div>
            </div>
            <!--ThreadZone-->

            <div class="thread-card">
                <div class="thread-cell thread-cell-author">
                    <div class="">
                        <a href="/u/minhnhanbin.1768054/">
                            <img src="${(empty your.base64ImageAvatar)?  defaultImage : yourAvatar}" />
                        </a>
                    </div>
                </div>
                <div class="thread-cell thread-create">
                    <form action="#" method="POST">
                        <div class="thread-create-insert">
                            <input
                                id="insert-title"
                                class="text-insert"               
                                type="text"
                                name="threadName"
                                placeholder="Thread title"
                                onchange="checkSubmit();"
                                />
                        </div>
                        <div class="thread-create-submit">
                            <input id="submit-title" class="submit-button" type="submit" value="Create" disabled="true"/>
                        </div>
                    </form>
                </div>
            </div>

            <div class="thread-card">
                <div class="thread-cell thread-cell-author">
                    <div class="">
                        <a href="/u/minhnhanbin.1768054/">
                            <img src="images/istockphoto-1136956450-612x612.jpg" />
                        </a>
                    </div>
                </div>

                <div class="thread-cell">
                    <div class="thread-subject">
                        <a
                            href="/t/tai-chinh-20m-tro-xuong-can-tu-van-cau-hinh-pc-phuc-vu-cho-edit-video-pts-ai-tren-adobe-co-the-choi-fifa-online-4.399690/"
                            >Tài chính 20m trở xuống. Cần tư vấn cấu hình pc phục vụ cho edit
                            video, pts, AI trên Adobe. Có thể chơi Fifa online 4.</a
                        >
                    </div>

                    <div class="">
                        <ul class="thread-item-part">
                            <li>
                                <a href="/u/minhnhanbin.1768054/" class="username"
                                   >minhnhanbin</a
                                >
                            </li>
                            <li class="">
                                <a
                                    href="/t/tai-chinh-20m-tro-xuong-can-tu-van-cau-hinh-pc-phuc-vu-cho-edit-video-pts-ai-tren-adobe-co-the-choi-fifa-online-4.399690/"
                                    rel="nofollow"
                                    ><time class="thread-latestDate">Today at 12:22 PM</time></a
                                >
                            </li>
                        </ul>
                    </div>
                </div>

                <div class="thread-cell thread-status">
                    <dl class="thread-status-pair">
                        <dt>Replies</dt>
                        <dd>2</dd>
                    </dl>
                    <!-- <dl class="thread-status-pair">
                      <dt>Views</dt>
                      <dd>88</dd>
                    </dl> -->
                </div>

                <div class="thread-cell thread-lastest-active">
                    <a
                        href="/t/tai-chinh-20m-tro-xuong-can-tu-van-cau-hinh-pc-phuc-vu-cho-edit-video-pts-ai-tren-adobe-co-the-choi-fifa-online-4.399690/latest"
                        rel="nofollow"
                        ><time class="thread-latestDate">Today at 3:02 PM</time></a
                    >
                    <div class="">
                        <a href="/u/congtubotgag.1034303/" class="username">congtubotgag</a>
                    </div>
                </div>

                <div class="thread-cell thread-latest-user">
                    <a href="/u/congtubotgag.1034303/" class="avatar avatar--xxs">
                        <img src="images/82761229_p17_master1200.jpg" />
                    </a>
                </div>
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

    </body>
</html>
