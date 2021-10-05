<%-- 
    Document   : SignupView
    Created on : Oct 2, 2021, 3:57:34 PM
    Author     : Khanh
--%>

<%@page import="model.UserInfo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="font-size: 16px">

    <%
        UserInfo user = (UserInfo) request.getAttribute("user");

    %>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta charset="utf-8" />

        <meta name="page_type" content="np-template-header-footer-from-plugin" />
        <title>SignUp | L0ZR</title>
        <link rel="stylesheet" href="src/style/nicepage.css" />
        <link rel="stylesheet" href="src/style/index.css" />
        <link rel="stylesheet" href="src/style/SignUp.css" />

        <meta name="generator" content="Nicepage 3.26.0, nicepage.com" />
        <link
            id="u-theme-google-font"
            rel="stylesheet"
            href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i"
            />
        <link
            id="u-page-google-font"
            rel="stylesheet"
            href="https://fonts.googleapis.com/css?family=Montserrat:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i|Aldrich:400"
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
            class="skrollable u-clearfix u-image u-section-1"
            id="sec-a288"
            data-image-width="612"
            data-image-height="612"
            >
            <div class="u-clearfix u-sheet u-sheet-1">
                <h1
                    class="
                    u-align-center u-custom-font u-text u-text-palette-1-dark-1 u-text-1
                    "
                    >
                    WELCOME TO LOZR
                </h1>
                <div class="u-expanded-width-sm u-expanded-width-xs u-form u-form-1">
                    <form
                        action="signup"
                        method="POST"
                        class="u-clearfix u-form-spacing-19 u-form-vertical u-inner-form"
                        style="padding: 10px"
                        enctype="multipart/form-data"
                        >
                        <div class="u-form-group u-form-name u-form-group-1">
                            <label id="error"
                                   for="loginName"
                                   class="u-custom-font u-label u-text-custom-color-1 u-label-1"
                                   >${errorLoginName}</label
                            >
                            <input
                                type="text"
                                placeholder="Username"
                                id="loginName"
                                name="loginName"
                                oninput="display_error()"
                                class="
                                u-border-1
                                u-border-grey-30
                                u-input
                                u-input-rectangle
                                u-radius-7
                                u-white
                                u-input-1
                                "
                                value="<%= (user != null) ? user.getLoginName() : ""%>"
                                required
                                />
                        </div>
                        <div class="u-form-group u-form-name u-form-group-2">
                            <input
                                type="password"
                                placeholder="Password"
                                id="password"
                                name="password"
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
                                required
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
                                required
                                />
                        </div>
                        <div class="u-form-email u-form-group u-form-group-4">
                            <input
                                type="text"
                                placeholder="Email"
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

                                value="<%= (user != null) ? user.getEmailAddress() : ""%>"
                                required
                                />
                        </div>
                        <div class="u-form-group u-form-name u-form-group-5">
                            <input
                                type="text"
                                placeholder="Your first name"
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
                                value="<%= (user != null) ? user.getFirstName() : ""%>"
                                required
                                />
                        </div>
                        <div class="u-form-group u-form-name u-form-group-6">
                            <input
                                type="text"
                                placeholder="Your last name"
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
                                value="<%= (user != null) ? user.getLastName() : ""%>"
                                required=""
                                />
                        </div>
                        <div class="u-form-group u-form-group-7">
                            <label
                                for="avatar"
                                class="u-custom-font u-label u-text-custom-color-1 u-label-7"
                                >Please choose Avatar</label
                            >
                            <input
                                type="file"
                                id="avatar"
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
                                disabled
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


    </body>
</html>
