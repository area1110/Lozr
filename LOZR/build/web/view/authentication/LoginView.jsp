<%-- 
    Document   : LoginView
    Created on : Oct 2, 2021, 2:43:15 PM
    Author     : Khanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="font-size: 16px">

    <%
        String loginErrorMessage = (String) request.getAttribute("loginError");
    %>

    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta charset="utf-8" />
        <title>LogIn</title>
        <link rel="stylesheet" href="src/style/nicepage.css" />
        <link rel="stylesheet" href="src/style/index.css" />
        <link rel="stylesheet" href="src/style/LogIn.css" />
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
        <script src="src/script/script.js" defer></script>

    </head>
    <body class="u-body">
        <header
            class="u-clearfix u-header u-sticky u-sticky-1ec8 u-white u-header"
            id="sec-2137"
            >
            <div class="u-clearfix u-sheet u-sheet-1">
                <a
                    href="https://nicepage.com"
                    class="u-hidden-sm u-hidden-xs u-image u-logo u-image-1"
                    data-image-width="590"
                    data-image-height="90"
                    >
                    <img src="images/lozr4rum1.png" class="u-logo-image u-logo-image-1" />
                </a>    
            </div>
        </header>
        <section
            class="u-clearfix u-image u-section-1"
            id="sec-7598"
            data-image-width="1200"
            data-image-height="836"
            >
            <div class="u-clearfix u-sheet u-sheet-1">
                <div class="u-container-style u-expanded-width-xs u-group u-group-1">
                    <div class="u-container-layout">
                        <h1
                            class="
                            u-custom-font
                            u-font-ubuntu
                            u-text
                            u-text-default
                            u-text-palette-1-base
                            u-text-1
                            "
                            >
                            Welcome back<span style="font-weight: 700">
                                <span style="font-weight: 400"></span>
                            </span>
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
                                    <% if (loginErrorMessage != null) {%>
                                    <label
                                        for="password"
                                        class="u-label u-text-custom-color-1 u-label-2"
                                        ><%= loginErrorMessage%></label
                                    >
                                    <%}%>
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
                        <!--                        <p
                                                    class="u-text u-text-default u-text-palette-1-base u-text-2"
                                                    data-animation-name="fadeIn"
                                                    data-animation-duration="1000"
                                                    data-animation-delay="0"
                                                    >
                                                    Forgot your<span style="font-style: italic">
                                                        <span style="text-decoration: underline !important"
                                                              >User name</span
                                                        ><span style="font-style: normal">
                                                            or<span style="font-weight: 700">
                                                                <span style="font-weight: 400; font-style: italic"></span>
                                                                <span style="font-weight: 400; font-style: italic"></span>
                                                                <span style="font-style: italic">
                                                                    <span style="font-weight: 400">
                                                                        <span style="text-decoration: underline !important">
                                                                            Password</span
                                                                        >
                                                                    </span>
                                                                    <span style="font-weight: 400"></span>
                                                                </span>
                                                            </span>
                                                        </span>
                                                    </span>
                                                </p>-->
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

