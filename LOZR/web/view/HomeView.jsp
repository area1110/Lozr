<%-- 
    Document   : Home
    Created on : Oct 3, 2021, 12:51:28 PM
    Author     : Khanh
--%>

<%@page import="model.UserInfo"%>
<%@page import="model.Forum"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    UserInfo currentUser = (UserInfo) request.getSession().getAttribute("currentUser");
    ArrayList<Forum> forums = (ArrayList<Forum>) request.getAttribute("forumsList");
%>
<!DOCTYPE html>
<html style="font-size: 16px">
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta charset="utf-8" />
        <title>Home</title>
        <link rel="stylesheet" href="src/style/nicepage.css" />
        <link rel="stylesheet" href="src/style/index.css" />
        <link rel="stylesheet" href="src/style/Home.css" />
        <script type="text/javascript" src="src/script/jquery.js" defer=""></script>
        <script
            type="text/javascript"
            src="src/script/nicepage.js"
            defer=""
        ></script>
        <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i"
            />
        <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css?family=Playfair+Display:400,400i,500,500i,600,600i,700,700i,800,800i,900,900i|Montserrat:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i"
            />
        <!-- font-awesome -->
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
            />
    </head>
    <body>
        <header class="u-clearfix u-header u-sticky u-sticky-1ec8 u-white u-header">
            <div class="u-clearfix u-sheet u-sheet-1">
                <a
                    href="#main"
                    class="u-hidden-sm u-hidden-xs u-image u-logo u-image-1"
                    data-image-width="590"
                    data-image-height="90"
                    >
                    <img src="images/lozr4rum1.png" class="u-logo-image u-logo-image-1" />
                </a>
                <a href="#go-to-user-page">
                    <div class="u-align-left u-container-style u-group u-group-1">
                        <div class="u-container-layout u-container-layout-1">
                            <p
                                class="
                                u-align-right u-custom-font u-font-montserrat u-text u-text-1
                                "
                                >
                                <%= (currentUser != null) ? currentUser.getLoginName() : "Account"%>
                            </p>
                            <img
                                class="u-expanded-height-xl u-image u-image-circle u-image-2"

                                <% if (currentUser == null || currentUser.getBase64ImageAvatar() == null) { %>
                                src= "images/82761229_p17_master1200.jpg"
                                <%} else {%>
                                src="data:image/jpg;base64, <%= currentUser.getBase64ImageAvatar()%>"
                                <%}%>
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
                                           > <%= (currentUser != null) ? currentUser.getLoginName() : "Account"%></a
                                        >
                                    </li>
                                    <li class="u-nav-item">
                                        <a href="#do-logout-action" class="u-button-style u-nav-link">Log Out</a>
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
        <section class="u-align-center u-clearfix u-grey-5 u-section-1" id="main">
            
            <%if (forums.isEmpty()) {%>
            
             <div class="u-align-center-lg u-align-center-md u-align-center-sm u-align-center-xl u-container-style u-custom-color-4 u-expanded-width u-group u-group-1">
                <div class="u-container-layout u-valign-top-lg u-valign-top-md u-valign-top-sm u-valign-top-xl u-container-layout-1">
                    <h1 class="u-align-center-xs u-custom-font u-font-playfair-display u-text u-text-1">Oops, There is nothing here?!</h1>
                </div>
            </div>
            
             <%} else {%>
            
            <div class="u-align-center-lg u-align-center-md u-align-center-sm u-align-center-xl u-container-style u-custom-color-4 u-expanded-width u-group u-group-1">
                <div class="u-container-layout u-valign-top-lg u-valign-top-md u-valign-top-sm u-valign-top-xl u-container-layout-1">
                    <h1 class="u-align-center-xs u-custom-font u-font-playfair-display u-text u-text-1">What on your mind today?</h1>
                </div>
            </div>
            
            <div class="u-blog u-blog-1">
                
           
                        
                    
              
                
                <div class="u-repeater u-repeater-1"><!--blog_post-->
                    <div class="u-blog-post u-container-style u-repeater-item u-white u-repeater-item-1">
                        <div class="u-container-layout u-similar-container u-container-layout-2">
                            <a class="u-post-header-link" href="blog/post-5.html"><!--blog_post_image-->
                                <img alt="" class="u-blog-control u-expanded-width u-image u-image-default u-image-1" src="images/2.jpeg" data-image-width="1065" data-image-height="800"><!--/blog_post_image-->
                            </a>
                            <div class="u-align-center u-container-style u-group u-palette-4-base u-group-2">
                                <div class="u-container-layout u-valign-middle u-container-layout-3">
                                    <p class="u-custom-font u-font-arial u-text u-text-2">CAR</p>
                                </div>
                            </div>
                            <p class="u-align-center u-text u-text-grey-50 u-text-3">75 New Threads Today</p>
                            <p class="u-align-center u-custom-font u-font-montserrat u-text u-text-grey-50 u-text-4">75 New Posts Today</p>
                        </div>
                    </div>
                    
                    
                    
                         <%for (Forum forum : forums) {%>
                         
                    <!--/blog_post--><!--blog_post-->
                    <div class="u-align-center u-blog-post u-container-style u-repeater-item u-video-cover u-white u-repeater-item-2">
                        <div class="u-container-layout u-similar-container u-container-layout-4">
                            <a class="u-post-header-link" href="blog/post-4.html"><!--blog_post_image-->
                                <img alt="Forum cover" class="u-blog-control u-expanded-width u-image u-image-default u-image-2" 
<!--                                     Đang làm ở đây-->
                                     src="images/3.jpeg" data-image-width="1024" data-image-height="576"><!--/blog_post_image-->
                            </a>
                            <div class="u-align-center u-container-style u-group u-palette-4-base u-video-cover u-group-3">
                                <div class="u-container-layout u-valign-middle u-container-layout-5">
                                    <p class="u-custom-font u-font-arial u-text u-text-5">KNOWLEDG</p>
                                </div>
                            </div>
                            <p class="u-align-center u-text u-text-grey-50 u-text-6"> 75 New Post Today</p>
                            <p class="u-align-center u-custom-font u-font-montserrat u-text u-text-grey-50 u-text-7">75 New Threads Today</p>
                        </div>
                    </div>
                    
                      <%}%>
                    
                    <!--/blog_post--><!--blog_post-->
                    <div class="u-align-center u-blog-post u-container-style u-repeater-item u-video-cover u-white u-repeater-item-3">
                        <div class="u-container-layout u-similar-container u-container-layout-6">
                            <a class="u-post-header-link" href="blog/post-3.html"><!--blog_post_image-->
                                <img alt="" class="u-blog-control u-expanded-width u-image u-image-default u-image-3" src="images/4.jpeg" data-image-width="640" data-image-height="1138"><!--/blog_post_image-->
                            </a>
                            <div class="u-align-center u-container-style u-group u-palette-4-base u-video-cover u-group-4">
                                <div class="u-container-layout u-valign-middle u-container-layout-7">
                                    <p class="u-custom-font u-font-arial u-text u-text-8">MORE...</p>
                                </div>
                            </div>
                            <p class="u-align-center u-text u-text-grey-50 u-text-9"> 75 New Post Today<br>
                            </p>
                            <p class="u-align-center u-custom-font u-font-montserrat u-text u-text-grey-50 u-text-10">75 New Threads Today</p>
                        </div>
                    </div><!--/blog_post-->
                </div>
            </div><!--/blog-->
            
             <%}%>
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
        <section class="u-backlink u-clearfix u-grey-80">
            <a class="u-link" href="https://nicepage.com/templates" target="_blank">
                <span>Template</span>
            </a>
            <p class="u-text">
                <span>created with</span>
            </p>
            <a class="u-link" href="https://nicepage.com/" target="_blank">
                <span>Offline Website Builder</span> </a
            >.
        </section>
    </body>
</html>

