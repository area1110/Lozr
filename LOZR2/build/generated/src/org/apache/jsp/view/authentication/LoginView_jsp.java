package org.apache.jsp.view.authentication;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class LoginView_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html style=\"font-size: 16px\">\r\n");
      out.write("    ");

        String loginErrorMessage = (String) request.getAttribute("loginError");
    
      out.write("\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\r\n");
      out.write("        <meta charset=\"utf-8\" />\r\n");
      out.write("        <title>LogIn</title>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/src/style/nicepage.css\" />\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/src/style/index.css\" />\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/src/style/LogIn.css\" />\r\n");
      out.write("        <link\r\n");
      out.write("            id=\"u-theme-google-font\"\r\n");
      out.write("            rel=\"stylesheet\"\r\n");
      out.write("            href=\"https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i\"\r\n");
      out.write("            />\r\n");
      out.write("        <link\r\n");
      out.write("            id=\"u-page-google-font\"\r\n");
      out.write("            rel=\"stylesheet\"\r\n");
      out.write("            href=\"https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i|Montserrat:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i\"\r\n");
      out.write("            />\r\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/src/script/script.js\" defer></script>\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("    <body class=\"u-body\">\r\n");
      out.write("        <header\r\n");
      out.write("            class=\"u-clearfix u-header u-sticky u-sticky-1ec8 u-white u-header\"\r\n");
      out.write("            id=\"sec-2137\"\r\n");
      out.write("            >\r\n");
      out.write("            <div class=\"u-clearfix u-sheet u-sheet-1\">\r\n");
      out.write("                <a\r\n");
      out.write("                    href=\"https://nicepage.com\"\r\n");
      out.write("                    class=\"u-hidden-sm u-hidden-xs u-image u-logo u-image-1\"\r\n");
      out.write("                    data-image-width=\"590\"\r\n");
      out.write("                    data-image-height=\"90\"\r\n");
      out.write("                    >\r\n");
      out.write("                    <img src=\"images/lozr4rum1.png\" class=\"u-logo-image u-logo-image-1\" />\r\n");
      out.write("                </a>    \r\n");
      out.write("            </div>\r\n");
      out.write("        </header>\r\n");
      out.write("        <section\r\n");
      out.write("            class=\"u-clearfix u-image u-section-1\"\r\n");
      out.write("            id=\"sec-7598\"\r\n");
      out.write("            data-image-width=\"1200\"\r\n");
      out.write("            data-image-height=\"836\"\r\n");
      out.write("            >\r\n");
      out.write("            <div class=\"u-clearfix u-sheet u-sheet-1\">\r\n");
      out.write("                <div class=\"u-container-style u-expanded-width-xs u-group u-group-1\">\r\n");
      out.write("                    <div class=\"u-container-layout\">\r\n");
      out.write("                        <h1\r\n");
      out.write("                            class=\"\r\n");
      out.write("                            u-custom-font\r\n");
      out.write("                            u-font-ubuntu\r\n");
      out.write("                            u-text\r\n");
      out.write("                            u-text-default\r\n");
      out.write("                            u-text-palette-1-base\r\n");
      out.write("                            u-text-1\r\n");
      out.write("                            \"\r\n");
      out.write("                            >\r\n");
      out.write("                            Welcome back<span style=\"font-weight: 700\">\r\n");
      out.write("                                <span style=\"font-weight: 400\"></span>\r\n");
      out.write("                            </span>\r\n");
      out.write("                        </h1>\r\n");
      out.write("                        <div class=\"u-expanded-width u-form u-form-1\">\r\n");
      out.write("                            <form\r\n");
      out.write("                                action=\"login\"\r\n");
      out.write("                                method=\"POST\"\r\n");
      out.write("                                class=\"\r\n");
      out.write("                                u-clearfix u-form-spacing-15 u-form-vertical u-inner-form\r\n");
      out.write("                                \"\r\n");
      out.write("                                style=\"padding: 15px\"\r\n");
      out.write("                                >\r\n");
      out.write("                                <div class=\"u-form-group u-form-name\">\r\n");
      out.write("                                    <input\r\n");
      out.write("                                        value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${loginName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"\r\n");
      out.write("                                        type=\"text\"\r\n");
      out.write("                                        placeholder=\"User name\"\r\n");
      out.write("                                        id=\"loginName\"\r\n");
      out.write("                                        name=\"loginName\"\r\n");
      out.write("                                        class=\"\r\n");
      out.write("                                        u-border-1\r\n");
      out.write("                                        u-border-grey-30\r\n");
      out.write("                                        u-input\r\n");
      out.write("                                        u-input-rectangle\r\n");
      out.write("                                        u-radius-10\r\n");
      out.write("                                        u-white\r\n");
      out.write("                                        u-input-1\r\n");
      out.write("                                        \"\r\n");
      out.write("                                        required=\"\"\r\n");
      out.write("                                        />\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"u-form-email u-form-group\">\r\n");
      out.write("                                    ");
 if (loginErrorMessage != null) {
      out.write("\r\n");
      out.write("                                    <label\r\n");
      out.write("                                        for=\"password\"\r\n");
      out.write("                                        class=\"u-label u-text-custom-color-1 u-label-2\"\r\n");
      out.write("                                        >");
      out.print( loginErrorMessage);
      out.write("</label\r\n");
      out.write("                                    >\r\n");
      out.write("                                    ");
}
      out.write("\r\n");
      out.write("                                    <input\r\n");
      out.write("                                        type=\"password\"\r\n");
      out.write("                                        placeholder=\"Password\"\r\n");
      out.write("                                        id=\"password\"\r\n");
      out.write("                                        name=\"password\"\r\n");
      out.write("                                        class=\"\r\n");
      out.write("                                        u-border-1\r\n");
      out.write("                                        u-border-grey-30\r\n");
      out.write("                                        u-input\r\n");
      out.write("                                        u-input-rectangle\r\n");
      out.write("                                        u-radius-10\r\n");
      out.write("                                        u-white\r\n");
      out.write("                                        u-input-2\r\n");
      out.write("                                        \"\r\n");
      out.write("                                        required=\"\"\r\n");
      out.write("                                        />\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"u-align-left u-form-group u-form-submit\">                                 \r\n");
      out.write("                                    <input\r\n");
      out.write("                                        type=\"submit\"\r\n");
      out.write("                                        value=\"submit\"\r\n");
      out.write("                                        onclick=\"removeSpace();\"\r\n");
      out.write("                                        class=\"u-btn\r\n");
      out.write("                                        u-btn-round\r\n");
      out.write("                                        u-btn-submit\r\n");
      out.write("                                        u-button-style\r\n");
      out.write("                                        u-hover-palette-1-dark-1\r\n");
      out.write("                                        u-palette-1-base\r\n");
      out.write("                                        u-radius-10\r\n");
      out.write("                                        u-text-active-palette-1-dark-1\r\n");
      out.write("                                        u-btn-1\"\r\n");
      out.write("                                        />\r\n");
      out.write("                                </div>                              \r\n");
      out.write("                            </form>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <!--                        <p\r\n");
      out.write("                                                    class=\"u-text u-text-default u-text-palette-1-base u-text-2\"\r\n");
      out.write("                                                    data-animation-name=\"fadeIn\"\r\n");
      out.write("                                                    data-animation-duration=\"1000\"\r\n");
      out.write("                                                    data-animation-delay=\"0\"\r\n");
      out.write("                                                    >\r\n");
      out.write("                                                    Forgot your<span style=\"font-style: italic\">\r\n");
      out.write("                                                        <span style=\"text-decoration: underline !important\"\r\n");
      out.write("                                                              >User name</span\r\n");
      out.write("                                                        ><span style=\"font-style: normal\">\r\n");
      out.write("                                                            or<span style=\"font-weight: 700\">\r\n");
      out.write("                                                                <span style=\"font-weight: 400; font-style: italic\"></span>\r\n");
      out.write("                                                                <span style=\"font-weight: 400; font-style: italic\"></span>\r\n");
      out.write("                                                                <span style=\"font-style: italic\">\r\n");
      out.write("                                                                    <span style=\"font-weight: 400\">\r\n");
      out.write("                                                                        <span style=\"text-decoration: underline !important\">\r\n");
      out.write("                                                                            Password</span\r\n");
      out.write("                                                                        >\r\n");
      out.write("                                                                    </span>\r\n");
      out.write("                                                                    <span style=\"font-weight: 400\"></span>\r\n");
      out.write("                                                                </span>\r\n");
      out.write("                                                            </span>\r\n");
      out.write("                                                        </span>\r\n");
      out.write("                                                    </span>\r\n");
      out.write("                                                </p>-->\r\n");
      out.write("                        <p class=\"u-text u-text-default u-text-palette-1-base u-text-3\">\r\n");
      out.write("                            New to<span style=\"font-weight: 700\">\r\n");
      out.write("                                LOZR<span style=\"font-weight: 400\">\r\n");
      out.write("                                    ? Click\r\n");
      out.write("                                    <a href=\"signup\"\r\n");
      out.write("                                       style=\"\r\n");
      out.write("                                       font-style: italic;\r\n");
      out.write("                                       text-decoration: underline !important;\r\n");
      out.write("                                       \"\r\n");
      out.write("                                       >here</a\r\n");
      out.write("                                    >\r\n");
      out.write("                                </span>\r\n");
      out.write("                            </span>\r\n");
      out.write("                        </p>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </section>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
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
