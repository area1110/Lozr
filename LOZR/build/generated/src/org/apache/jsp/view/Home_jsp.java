package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html style=\"font-size: 16px\">\n");
      out.write("  <head>\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n");
      out.write("    <meta charset=\"utf-8\" />\n");
      out.write("    <title>Home</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"src/style/nicepage.css\" />\n");
      out.write("    <link rel=\"stylesheet\" href=\"src/style/index.css\" />\n");
      out.write("    <link rel=\"stylesheet\" href=\"src/style/Home.css\" />\n");
      out.write("    <script type=\"text/javascript\" src=\"src/script/jquery.js\" defer=\"\"></script>\n");
      out.write("    <script\n");
      out.write("      type=\"text/javascript\"\n");
      out.write("      src=\"src/script/nicepage.js\"\n");
      out.write("      defer=\"\"\n");
      out.write("    ></script>\n");
      out.write("    <link\n");
      out.write("      rel=\"stylesheet\"\n");
      out.write("      href=\"https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i\"\n");
      out.write("    />\n");
      out.write("    <link\n");
      out.write("      rel=\"stylesheet\"\n");
      out.write("      href=\"https://fonts.googleapis.com/css?family=Playfair+Display:400,400i,500,500i,600,600i,700,700i,800,800i,900,900i|Montserrat:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i\"\n");
      out.write("    />\n");
      out.write("    <!-- font-awesome -->\n");
      out.write("    <link\n");
      out.write("      rel=\"stylesheet\"\n");
      out.write("      href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\"\n");
      out.write("    />\n");
      out.write("  </head>\n");
      out.write("  <body>\n");
      out.write("    <header class=\"u-clearfix u-header u-sticky u-sticky-1ec8 u-white u-header\">\n");
      out.write("      <div class=\"u-clearfix u-sheet u-sheet-1\">\n");
      out.write("        <a\n");
      out.write("          href=\"#main\"\n");
      out.write("          class=\"u-hidden-sm u-hidden-xs u-image u-logo u-image-1\"\n");
      out.write("          data-image-width=\"590\"\n");
      out.write("          data-image-height=\"90\"\n");
      out.write("        >\n");
      out.write("          <img src=\"images/lozr4rum1.png\" class=\"u-logo-image u-logo-image-1\" />\n");
      out.write("        </a>\n");
      out.write("        <a href=\"#\">\n");
      out.write("          <div class=\"u-align-left u-container-style u-group u-group-1\">\n");
      out.write("            <div class=\"u-container-layout u-container-layout-1\">\n");
      out.write("              <p\n");
      out.write("                class=\"\n");
      out.write("                  u-align-right u-custom-font u-font-montserrat u-text u-text-1\n");
      out.write("                \"\n");
      out.write("              >\n");
      out.write("                Kakakaku\n");
      out.write("              </p>\n");
      out.write("              <img\n");
      out.write("                class=\"u-expanded-height-xl u-image u-image-circle u-image-2\"\n");
      out.write("                src=\"images/82761229_p17_master1200.jpg\"\n");
      out.write("              />\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("        </a>\n");
      out.write("\n");
      out.write("        <nav\n");
      out.write("          class=\"\n");
      out.write("            u-align-left\n");
      out.write("            u-menu\n");
      out.write("            u-menu-dropdown\n");
      out.write("            u-menu-open-right\n");
      out.write("            u-nav-spacing-25\n");
      out.write("            u-offcanvas\n");
      out.write("            u-menu-1\n");
      out.write("          \"\n");
      out.write("          data-responsive-from=\"XL\"\n");
      out.write("        >\n");
      out.write("          <div class=\"menu-collapse\">\n");
      out.write("            <a class=\"menu-button\" href=\"#\">\n");
      out.write("              <i class=\"fa fa-bars\"></i>\n");
      out.write("            </a>\n");
      out.write("          </div>\n");
      out.write("          <div class=\"u-custom-menu u-nav-container-collapse\">\n");
      out.write("            <div\n");
      out.write("              class=\"\n");
      out.write("                u-align-center\n");
      out.write("                u-black\n");
      out.write("                u-container-style\n");
      out.write("                u-inner-container-layout\n");
      out.write("                u-sidenav\n");
      out.write("                u-sidenav-1\n");
      out.write("              \"\n");
      out.write("              data-offcanvas-width=\"341.5626\"\n");
      out.write("            >\n");
      out.write("              <div class=\"u-inner-container-layout u-sidenav-overflow\">\n");
      out.write("                <div class=\"u-menu-close\"></div>\n");
      out.write("                <ul\n");
      out.write("                  class=\"\n");
      out.write("                    u-align-center\n");
      out.write("                    u-custom-font\n");
      out.write("                    u-font-montserrat\n");
      out.write("                    u-nav\n");
      out.write("                    u-popupmenu-items\n");
      out.write("                    u-spacing-16\n");
      out.write("                    u-text-active-palette-1-dark-1\n");
      out.write("                    u-text-hover-palette-4-base\n");
      out.write("                    u-unstyled\n");
      out.write("                    u-nav-2\n");
      out.write("                  \"\n");
      out.write("                >\n");
      out.write("                  <li class=\"u-nav-item\">\n");
      out.write("                    <a class=\"u-button-style u-nav-link\" href=\"Page-1.html\"\n");
      out.write("                      >Kakakaku</a\n");
      out.write("                    >\n");
      out.write("                  </li>\n");
      out.write("                  <li class=\"u-nav-item\">\n");
      out.write("                    <a class=\"u-button-style u-nav-link\">Log Out</a>\n");
      out.write("                  </li>\n");
      out.write("                </ul>\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("            <div\n");
      out.write("              class=\"u-custom-color-4 u-menu-overlay u-opacity u-opacity-65\"\n");
      out.write("            ></div>\n");
      out.write("          </div>\n");
      out.write("        </nav>\n");
      out.write("      </div>\n");
      out.write("    </header>\n");
      out.write("\n");
      out.write("    <section class=\"u-align-center u-clearfix u-grey-5 u-section-1\" id=\"main\">\n");
      out.write("      <div class=\"u-clearfix u-sheet u-sheet-1\">\n");
      out.write("        <h1\n");
      out.write("          class=\"\n");
      out.write("            u-align-center-xs\n");
      out.write("            u-custom-font\n");
      out.write("            u-font-playfair-display\n");
      out.write("            u-text\n");
      out.write("            u-text-1\n");
      out.write("          \"\n");
      out.write("        >\n");
      out.write("          What on your mind today?\n");
      out.write("        </h1>\n");
      out.write("        <!--blog--><!--blog_options_json--><!--{\"type\":\"Recent\",\"source\":\"\",\"tags\":\"\",\"count\":\"\"}--><!--/blog_options_json-->\n");
      out.write("        <div class=\"u-blog u-expanded-width u-blog-1\">\n");
      out.write("          <div class=\"u-repeater u-repeater-1\">\n");
      out.write("            <!--blog_post-->\n");
      out.write("            <div\n");
      out.write("              class=\"\n");
      out.write("                u-blog-post\n");
      out.write("                u-container-style\n");
      out.write("                u-repeater-item\n");
      out.write("                u-shape-rectangle\n");
      out.write("                u-white\n");
      out.write("                u-repeater-item-1\n");
      out.write("              \"\n");
      out.write("            >\n");
      out.write("              <div\n");
      out.write("                class=\"\n");
      out.write("                  u-container-layout u-similar-container u-container-layout-1\n");
      out.write("                \"\n");
      out.write("              >\n");
      out.write("                <a class=\"u-post-header-link\" href=\"blog/post-5.html\"\n");
      out.write("                  ><!--blog_post_image-->\n");
      out.write("                  <img\n");
      out.write("                    alt=\"\"\n");
      out.write("                    class=\"\n");
      out.write("                      u-blog-control\n");
      out.write("                      u-expanded-width\n");
      out.write("                      u-image\n");
      out.write("                      u-image-default\n");
      out.write("                      u-image-1\n");
      out.write("                    \"\n");
      out.write("                    src=\"images/2.jpeg\"\n");
      out.write("                    data-image-width=\"1065\"\n");
      out.write("                    data-image-height=\"800\"\n");
      out.write("                  /><!--/blog_post_image-->\n");
      out.write("                </a>\n");
      out.write("                <div\n");
      out.write("                  class=\"\n");
      out.write("                    u-align-center\n");
      out.write("                    u-container-style\n");
      out.write("                    u-group\n");
      out.write("                    u-palette-4-base\n");
      out.write("                    u-group-1\n");
      out.write("                  \"\n");
      out.write("                >\n");
      out.write("                  <div class=\"u-container-layout u-container-layout-2\">\n");
      out.write("                    <p class=\"u-text u-text-2\">CAR</p>\n");
      out.write("                  </div>\n");
      out.write("                </div>\n");
      out.write("                <p class=\"u-align-center u-text u-text-3\">\n");
      out.write("                  75 new posts today<br />37 new thread today\n");
      out.write("                </p>\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("            <!--/blog_post--><!--blog_post-->\n");
      out.write("            <div\n");
      out.write("              class=\"\n");
      out.write("                u-align-center\n");
      out.write("                u-blog-post\n");
      out.write("                u-container-style\n");
      out.write("                u-repeater-item\n");
      out.write("                u-shape-rectangle\n");
      out.write("                u-video-cover\n");
      out.write("                u-white\n");
      out.write("                u-repeater-item-2\n");
      out.write("              \"\n");
      out.write("            >\n");
      out.write("              <div\n");
      out.write("                class=\"\n");
      out.write("                  u-container-layout u-similar-container u-container-layout-3\n");
      out.write("                \"\n");
      out.write("              >\n");
      out.write("                <a class=\"u-post-header-link\" href=\"blog/post-4.html\"\n");
      out.write("                  ><!--blog_post_image-->\n");
      out.write("                  <img\n");
      out.write("                    alt=\"\"\n");
      out.write("                    class=\"\n");
      out.write("                      u-blog-control\n");
      out.write("                      u-expanded-width\n");
      out.write("                      u-image\n");
      out.write("                      u-image-default\n");
      out.write("                      u-image-2\n");
      out.write("                    \"\n");
      out.write("                    src=\"images/3.jpeg\"\n");
      out.write("                    data-image-width=\"1024\"\n");
      out.write("                    data-image-height=\"576\"\n");
      out.write("                  /><!--/blog_post_image-->\n");
      out.write("                </a>\n");
      out.write("                <div\n");
      out.write("                  class=\"\n");
      out.write("                    u-align-center\n");
      out.write("                    u-container-style\n");
      out.write("                    u-group\n");
      out.write("                    u-palette-4-base\n");
      out.write("                    u-video-cover\n");
      out.write("                    u-group-2\n");
      out.write("                  \"\n");
      out.write("                >\n");
      out.write("                  <div class=\"u-container-layout u-container-layout-4\">\n");
      out.write("                    <p class=\"u-text u-text-4\">KNOWLEDG</p>\n");
      out.write("                  </div>\n");
      out.write("                </div>\n");
      out.write("                <p class=\"u-align-center u-text u-text-5\">\n");
      out.write("                  65 new post today<br />35 new thread today\n");
      out.write("                </p>\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("            <!--/blog_post--><!--blog_post-->\n");
      out.write("            <div\n");
      out.write("              class=\"\n");
      out.write("                u-align-center\n");
      out.write("                u-blog-post\n");
      out.write("                u-container-style\n");
      out.write("                u-repeater-item\n");
      out.write("                u-shape-rectangle\n");
      out.write("                u-video-cover\n");
      out.write("                u-white\n");
      out.write("                u-repeater-item-3\n");
      out.write("              \"\n");
      out.write("            >\n");
      out.write("              <div\n");
      out.write("                class=\"\n");
      out.write("                  u-container-layout u-similar-container u-container-layout-5\n");
      out.write("                \"\n");
      out.write("              >\n");
      out.write("                <a class=\"u-post-header-link\" href=\"blog/post-3.html\"\n");
      out.write("                  ><!--blog_post_image-->\n");
      out.write("                  <img\n");
      out.write("                    alt=\"\"\n");
      out.write("                    class=\"\n");
      out.write("                      u-blog-control\n");
      out.write("                      u-expanded-width\n");
      out.write("                      u-image\n");
      out.write("                      u-image-default\n");
      out.write("                      u-image-3\n");
      out.write("                    \"\n");
      out.write("                    src=\"images/4.jpeg\"\n");
      out.write("                    data-image-width=\"640\"\n");
      out.write("                    data-image-height=\"1138\"\n");
      out.write("                  /><!--/blog_post_image-->\n");
      out.write("                </a>\n");
      out.write("                <div\n");
      out.write("                  class=\"\n");
      out.write("                    u-align-center\n");
      out.write("                    u-container-style\n");
      out.write("                    u-group\n");
      out.write("                    u-palette-4-base\n");
      out.write("                    u-video-cover\n");
      out.write("                    u-group-3\n");
      out.write("                  \"\n");
      out.write("                >\n");
      out.write("                  <div class=\"u-container-layout u-container-layout-6\">\n");
      out.write("                    <p class=\"u-text u-text-6\">MORE...</p>\n");
      out.write("                  </div>\n");
      out.write("                </div>\n");
      out.write("                <p class=\"u-align-center u-text u-text-7\">\n");
      out.write("                  explore somthing new today!<br />\n");
      out.write("                  <br />\n");
      out.write("                </p>\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("            <!--/blog_post-->\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("        <!--/blog-->\n");
      out.write("      </div>\n");
      out.write("    </section>\n");
      out.write("\n");
      out.write("    <footer\n");
      out.write("      class=\"u-align-center u-clearfix u-footer u-grey-80 u-footer\"\n");
      out.write("      id=\"sec-4768\"\n");
      out.write("    >\n");
      out.write("      <div class=\"u-clearfix u-sheet u-sheet-1\">\n");
      out.write("        <p class=\"u-small-text u-text u-text-variant u-text-1\">\n");
      out.write("          Sample text. Click to select the text box. Click again or double click\n");
      out.write("          to start editing the text.\n");
      out.write("        </p>\n");
      out.write("      </div>\n");
      out.write("    </footer>\n");
      out.write("    <section class=\"u-backlink u-clearfix u-grey-80\">\n");
      out.write("      <a class=\"u-link\" href=\"https://nicepage.com/templates\" target=\"_blank\">\n");
      out.write("        <span>Template</span>\n");
      out.write("      </a>\n");
      out.write("      <p class=\"u-text\">\n");
      out.write("        <span>created with</span>\n");
      out.write("      </p>\n");
      out.write("      <a class=\"u-link\" href=\"https://nicepage.com/\" target=\"_blank\">\n");
      out.write("        <span>Offline Website Builder</span> </a\n");
      out.write("      >.\n");
      out.write("    </section>\n");
      out.write("  </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
