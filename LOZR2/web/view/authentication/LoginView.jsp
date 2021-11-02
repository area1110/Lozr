<%-- 
    Document   : LoginView
    Created on : Oct 2, 2021, 2:43:15 PM
    Author     : Khanh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="font-size: 16px">
    <c:set value="${pageContext.request.contextPath}" var="contextPath"/>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta charset="utf-8" />
        <title>LogIn | LOZR</title>
        <link rel="icon" href="${contextPath}/images/doge-nonbg.png">
        <link rel="stylesheet" href="https://area1110.github.io/JSBegin/CustomCDN/nicepage.css" />
        <link rel="stylesheet" href="${contextPath}/src/style/index.css" />
        <link rel="stylesheet" href="${contextPath}/src/style/LogIn.css" />
        <link
            id="u-theme-google-font"
            rel="stylesheet"
            href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i"
            />
        <link
            id="u-page-google-font"
            rel="stylesheet"
            href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i|Montserrat:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i"
            />
        <script src="${contextPath}/src/script/script.js" defer></script>

    </head>
    <body class="u-body">
        <div class="form-popup" id="formEdit">
            <form id="hidden-form" action="${contextPath}/auth/resetpassword" method="POST" class="form-container">
                <h2>Reset Your Password</h2>
                <label  for="threadSubject">User LoginName</label>
                <input type="text" placeholder="Your loginName" name="loginName">
                <button type="submit" class="btn">Send</button>
                <button type="button" class="btn" onclick="closeForm()">Close</button>
            </form>
        </div>
        <header class="u-clearfix u-header u-sticky u-sticky-1ec8 u-white u-header">
            <div class="header">
                <div  class="header-logo">
                    <a>
                        <img  src="${contextPath}/images/lozr4rum1.png" class="logo-header" />
                    </a>
                </div>
                <div class="header-action">
                    <div class="header-action-item">
                        <a href="${contextPath}/signup">
                            <div class="header-user">                
                                <span  class="header-user-name header-action-item"  >
                                    Signup
                                </span>
                            </div>
                        </a>
                    </div>

                </div>
            </div>
        </header>
        <section
            class="u-clearfix u-image u-section-1">
            <div class="u-clearfix u-sheet u-sheet-1">
                <div class="u-container-style u-expanded-width-xs u-group u-group-1">
                    <div class="u-container-layout">
                        <h1 class=" u-custom-font u-font-ubuntu  u-text  u-text-default  u-text-palette-1-base u-text-1 ">
                            Welcome back
                        </h1>
                        <div class="u-expanded-width u-form u-form-1">
                            <form
                                action="login"
                                method="POST"
                                class="
                                u-clearfix u-form-spacing-15 u-form-vertical u-inner-form
                                "
                                style="padding: 15px"
                                >
                                <div class="u-form-group u-form-name">
                                    <input
                                        value="${loginName}"
                                        type="text"
                                        placeholder="User name"
                                        id="loginName"
                                        name="loginName"
                                        class="
                                        u-border-1
                                        u-border-grey-30
                                        u-input
                                        u-input-rectangle
                                        u-radius-10
                                        u-white
                                        u-input-1
                                        "
                                        required=""
                                        />
                                </div>
                                <div class="u-form-email u-form-group">

                                    <label
                                        for="password"
                                        class="u-label u-text-custom-color-1 u-label-2"
                                        >${loginError}
                                    </label>
                                    <input
                                        type="password"
                                        placeholder="Password"
                                        id="password"
                                        name="password"
                                        class="
                                        u-border-1
                                        u-border-grey-30
                                        u-input
                                        u-input-rectangle
                                        u-radius-10
                                        u-white
                                        u-input-2
                                        "
                                        required=""
                                        />
                                </div>
                                <div class="u-align-left u-form-group u-form-submit">                                 
                                    <input
                                        type="submit"
                                        value="submit"
                                        onclick="removeSpace();"
                                        class="u-btn
                                        u-btn-round
                                        u-btn-submit
                                        u-button-style
                                        u-hover-palette-1-dark-1
                                        u-palette-1-base
                                        u-radius-10
                                        u-text-active-palette-1-dark-1
                                        u-btn-1"
                                        />
                                </div>                              
                            </form>
                        </div>
                        <p
                            class="u-text u-text-default u-text-palette-1-base u-text-2"
                            data-animation-name="fadeIn"
                            data-animation-duration="1000"
                            data-animation-delay="0"
                            >
                            Forgot your<span style="font-style: italic">
                                <span style="text-decoration: underline !important"
                                      > <a href="javascript:void(0)" onclick="openForm()"
                                      style="
                                      font-style: italic;
                                      text-decoration: underline !important;
                                      "
                                      >Password</a
                                    ></span
                                >
                            </span>
                            </span>
                        </p>
                        <p class="u-text u-text-default u-text-palette-1-base u-text-3">
                            New to<span style="font-weight: 700">
                                LOZR<span style="font-weight: 400">
                                    ? Click
                                    <a href="signup"
                                       style="
                                       font-style: italic;
                                       text-decoration: underline !important;
                                       "
                                       >here</a
                                    >
                                </span>
                            </span>
                        </p>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>

