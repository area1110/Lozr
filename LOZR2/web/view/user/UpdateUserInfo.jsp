<%-- 
    Document   : SignupView
    Created on : Oct 2, 2021, 3:57:34 PM
    Author     : Khanh
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="font-size: 16px">

    <jsp:useBean id="transToPath" class="controller.module.ExtractURLPath"/>

    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>   
    <c:set var="your" value="${sessionScope.currentUser}"/>
    <c:set var="forums" value="${requestScope.forumsList}"/>

    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta charset="utf-8" />

        <title>Change Info | LOZR</title>
        <link rel="icon" href="${contextPath}/images/doge-nonbg.png">
        <link rel="stylesheet" href="https://area1110.github.io/JSBegin/CustomCDN/nicepage.css" />
        <link rel="stylesheet" href="${contextPath}/src/style/index.css" />
        <link rel="stylesheet" href="${contextPath}/src/style/SignUp.css" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js" defer></script>
        <script type="text/javascript" src="${contextPath}/src/script/imgupload.js" defer></script>
        <script src="${contextPath}/src/script/script.js" defer></script>


        <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i"
            />
        <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css?family=Montserrat:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i|Aldrich:400"
            />
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
        <section
            class="skrollable u-clearfix u-image u-section-1"
            id="sec-a288"
            >
            <div class="u-clearfix u-sheet u-sheet-1">
                <h1
                    class="
                    u-align-center u-custom-font u-text u-text-palette-1-dark-1 u-text-1
                    "
                    >
                    CHANGE YOUR INFORMATION
                </h1>
                <p class="
                   u-align-center u-custom-font u-label-1">(Leave the field empty if you don't want to change)</p>
                <div class="u-expanded-width-sm u-expanded-width-xs u-form u-form-1">          
                    <div class="avatar-create">
                        <div class="avatar-input">
                            <label class="u-custom-font u-label u-text-custom-color-1 u-label-7">
                                Please choose Avatar
                            </label >
                            <input class="avatar-openfile" type='file' onchange="doImgUpload(this, 'avatar-url', 'output-img')">
                        </div>
                        <div class="avatar-view">
                            <img src="${your.avatar}" id="output-img"/>
                        </div>
                    </div>
                    <form
                        action="${contextPath}/update/user/info"
                        method="POST"
                        class="u-clearfix u-form-spacing-19 u-form-vertical u-inner-form"
                        onsubmit="reloadDelay();"
                        >
                        <div class="u-form-group u-form-name u-form-group-1">
                            <label id="error"
                                   for="loginName"
                                   class="u-custom-font u-label u-text-custom-color-1 u-label-1"
                                   >${errorLoginName}</label
                            >
                            <input
                                type="text"
                                placeholder="${your.loginName}"
                                id="loginName"
                                name="loginName"
                                class="
                                u-border-1
                                u-border-grey-30
                                u-input
                                u-input-rectangle
                                u-radius-7
                                u-white
                                u-input-1
                                "
                                />
                        </div>
                        <div class="u-form-group u-form-name u-form-group-2">
                            <input
                                type="password"
                                placeholder="NEW Password (8-20 characters)"
                                id="password"
                                name="password"
                                minlength="8"
                                maxlength="20"
                                oninput="check_pass();"
                                class="
                                u-border-1
                                u-border-grey-30
                                u-input
                                u-input-rectangle
                                u-radius-7
                                u-white
                                u-input-2
                                "
                                />
                        </div>
                        <div class="u-form-group u-form-name u-form-group-3">
                            <label id="repassErr"
                                   for="password"
                                   class="u-custom-font u-label u-text-custom-color-1 u-label-2"
                                   >Re-Password dose not match</label
                            >
                            <input
                                type="password"
                                placeholder="Re-enter your password"
                                id="repassword"
                                name="repassword"
                                oninput="check_pass();"
                                class="
                                u-border-1
                                u-border-grey-30
                                u-input
                                u-input-rectangle
                                u-radius-7
                                u-white
                                u-input-3
                                "
                                />
                        </div>
                        <div class="u-form-email u-form-group u-form-group-4">
                            <input
                                type="email"
                                placeholder="${your.emailAddress}"
                                id="email"
                                name="email"
                                class="
                                u-border-1
                                u-border-grey-30
                                u-input
                                u-input-rectangle
                                u-radius-7
                                u-white
                                u-input-4
                                "
                                />
                        </div>
                        <div class="u-form-group u-form-name u-form-group-5">
                            <input
                                type="text"
                                placeholder="${your.firstName}"
                                id="firstName"
                                name="firstName"
                                class="
                                u-border-1
                                u-border-grey-30
                                u-input
                                u-input-rectangle
                                u-radius-7
                                u-white
                                u-input-5
                                "
                                />
                        </div>
                        <div class="u-form-group u-form-name u-form-group-6">
                            <input
                                type="text"
                                placeholder="${your.lastName}"
                                id="lastName"
                                name="lastName"
                                class="
                                u-border-1
                                u-border-grey-30
                                u-input
                                u-input-rectangle
                                u-radius-7
                                u-white
                                u-input-6
                                "
                                />
                        </div>
                        <div class="u-form-group u-form-group-7">                    
                            <input
                                type="hidden"
                                id="avatar-url"
                                name="avatar"
                                class="
                                u-border-1
                                u-border-grey-30
                                u-input
                                u-input-rectangle
                                u-radius-7
                                u-white
                                u-input-7
                                "
                                />
                        </div>
                        <div class="u-align-left u-form-group u-form-submit">
                            <input
                                id="submit"
                                type="submit"
                                value="Save"
                                class="u-btn
                                u-btn-round
                                u-btn-submit
                                u-button-style
                                u-hover-palette-1-dark-1
                                u-palette-1-base
                                u-radius-10
                                u-text-active-palette-1-dark-1
                                u-btn-1"
                                onclick="removeSpace();"
                                />
                        </div>
                    </form>
                </div>
            </div>
        </section>

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

