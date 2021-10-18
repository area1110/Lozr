package org.apache.jsp.view.authentication;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.UserInfo;

public final class SignupView_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_set_var_value_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_set_var_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_set_var_value_nobody.release();
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html style=\"font-size: 16px\">\r\n");
      out.write("    ");
      if (_jspx_meth_c_set_0(_jspx_page_context))
        return;
      out.write("   \r\n");
      out.write("    <head>\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\r\n");
      out.write("        <meta charset=\"utf-8\" />\r\n");
      out.write("\r\n");
      out.write("        <title>SignUp | L0ZR</title>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/src/style/nicepage.css\" />\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/src/style/index.css\" />\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/src/style/SignUp.css\" />\r\n");
      out.write("\r\n");
      out.write("        <link\r\n");
      out.write("            rel=\"stylesheet\"\r\n");
      out.write("            href=\"https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i\"\r\n");
      out.write("            />\r\n");
      out.write("        <link\r\n");
      out.write("            rel=\"stylesheet\"\r\n");
      out.write("            href=\"https://fonts.googleapis.com/css?family=Montserrat:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i|Aldrich:400\"\r\n");
      out.write("            />\r\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js\" defer></script>\r\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/src/script/script.js\" defer></script>\r\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/src/script/imgurupload.js\" defer></script>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body class=\"u-body\">\r\n");
      out.write("        <header\r\n");
      out.write("            class=\"u-clearfix u-header u-sticky u-sticky-1ec8 u-white u-header\"\r\n");
      out.write("            id=\"sec-2137\"\r\n");
      out.write("            >\r\n");
      out.write("            <div class=\"u-clearfix u-sheet u-sheet-1\">\r\n");
      out.write("                <a\r\n");
      out.write("                    href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"\r\n");
      out.write("                    class=\"u-hidden-sm u-hidden-xs u-image u-logo u-image-1\"\r\n");
      out.write("                    data-image-width=\"590\"\r\n");
      out.write("                    data-image-height=\"90\"\r\n");
      out.write("                    >\r\n");
      out.write("                    <img src=\"images/lozr4rum1.png\" class=\"u-logo-image u-logo-image-1\" />\r\n");
      out.write("                </a>\r\n");
      out.write("            </div>\r\n");
      out.write("        </header>\r\n");
      out.write("        <section\r\n");
      out.write("            class=\"skrollable u-clearfix u-image u-section-1\"\r\n");
      out.write("            id=\"sec-a288\"\r\n");
      out.write("            data-image-width=\"612\"\r\n");
      out.write("            data-image-height=\"612\"\r\n");
      out.write("            >\r\n");
      out.write("            <div class=\"u-clearfix u-sheet u-sheet-1\">\r\n");
      out.write("                <h1\r\n");
      out.write("                    class=\"\r\n");
      out.write("                    u-align-center u-custom-font u-text u-text-palette-1-dark-1 u-text-1\r\n");
      out.write("                    \"\r\n");
      out.write("                    >\r\n");
      out.write("                    WELCOME TO LOZR\r\n");
      out.write("                </h1>\r\n");
      out.write("                <div class=\"u-expanded-width-sm u-expanded-width-xs u-form u-form-1\">\r\n");
      out.write("\r\n");
      out.write("                    <div>\r\n");
      out.write("                        <div>\r\n");
      out.write("                            <input type='file' onchange=\"doImgUpload(this, 'output-img')\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div>\r\n");
      out.write("                            <img src=\"https://via.placeholder.com/150\" id=\"output-img\"/>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <form\r\n");
      out.write("                        action=\"signup\"\r\n");
      out.write("                        method=\"POST\"\r\n");
      out.write("                        class=\"u-clearfix u-form-spacing-19 u-form-vertical u-inner-form\"\r\n");
      out.write("                        >\r\n");
      out.write("                        <div class=\"u-form-group u-form-name u-form-group-1\">\r\n");
      out.write("                            <label id=\"error\"\r\n");
      out.write("                                   for=\"loginName\"\r\n");
      out.write("                                   class=\"u-custom-font u-label u-text-custom-color-1 u-label-1\"\r\n");
      out.write("                                   >");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${errorLoginName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</label\r\n");
      out.write("                            >\r\n");
      out.write("                            <input\r\n");
      out.write("                                type=\"text\"\r\n");
      out.write("                                placeholder=\"Username\"\r\n");
      out.write("                                id=\"loginName\"\r\n");
      out.write("                                name=\"loginName\"\r\n");
      out.write("                                oninput=\"display_error()\"\r\n");
      out.write("                                class=\"\r\n");
      out.write("                                u-border-1\r\n");
      out.write("                                u-border-grey-30\r\n");
      out.write("                                u-input\r\n");
      out.write("                                u-input-rectangle\r\n");
      out.write("                                u-radius-7\r\n");
      out.write("                                u-white\r\n");
      out.write("                                u-input-1\r\n");
      out.write("                                \"\r\n");
      out.write("                                value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user.loginName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"\r\n");
      out.write("                                required\r\n");
      out.write("                                />\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"u-form-group u-form-name u-form-group-2\">\r\n");
      out.write("                            <input\r\n");
      out.write("                                type=\"password\"\r\n");
      out.write("                                placeholder=\"Password\"\r\n");
      out.write("                                id=\"password\"\r\n");
      out.write("                                name=\"password\"\r\n");
      out.write("                                oninput=\"check_pass();\"\r\n");
      out.write("                                class=\"\r\n");
      out.write("                                u-border-1\r\n");
      out.write("                                u-border-grey-30\r\n");
      out.write("                                u-input\r\n");
      out.write("                                u-input-rectangle\r\n");
      out.write("                                u-radius-7\r\n");
      out.write("                                u-white\r\n");
      out.write("                                u-input-2\r\n");
      out.write("                                \"\r\n");
      out.write("                                required\r\n");
      out.write("                                />\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"u-form-group u-form-name u-form-group-3\">\r\n");
      out.write("                            <label id=\"repassErr\"\r\n");
      out.write("                                   for=\"password\"\r\n");
      out.write("                                   class=\"u-custom-font u-label u-text-custom-color-1 u-label-2\"\r\n");
      out.write("                                   >Re-Password dose not match</label\r\n");
      out.write("                            >\r\n");
      out.write("                            <input\r\n");
      out.write("                                type=\"password\"\r\n");
      out.write("                                placeholder=\"Re-enter your password\"\r\n");
      out.write("                                id=\"repassword\"\r\n");
      out.write("                                name=\"repassword\"\r\n");
      out.write("                                oninput=\"check_pass();\"\r\n");
      out.write("                                class=\"\r\n");
      out.write("                                u-border-1\r\n");
      out.write("                                u-border-grey-30\r\n");
      out.write("                                u-input\r\n");
      out.write("                                u-input-rectangle\r\n");
      out.write("                                u-radius-7\r\n");
      out.write("                                u-white\r\n");
      out.write("                                u-input-3\r\n");
      out.write("                                \"\r\n");
      out.write("                                required\r\n");
      out.write("                                />\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"u-form-email u-form-group u-form-group-4\">\r\n");
      out.write("                            <input\r\n");
      out.write("                                type=\"text\"\r\n");
      out.write("                                placeholder=\"Email\"\r\n");
      out.write("                                id=\"email\"\r\n");
      out.write("                                name=\"email\"\r\n");
      out.write("                                class=\"\r\n");
      out.write("                                u-border-1\r\n");
      out.write("                                u-border-grey-30\r\n");
      out.write("                                u-input\r\n");
      out.write("                                u-input-rectangle\r\n");
      out.write("                                u-radius-7\r\n");
      out.write("                                u-white\r\n");
      out.write("                                u-input-4\r\n");
      out.write("                                \"\r\n");
      out.write("\r\n");
      out.write("                                value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user.emailAddress}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"\r\n");
      out.write("                                required\r\n");
      out.write("                                />\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"u-form-group u-form-name u-form-group-5\">\r\n");
      out.write("                            <input\r\n");
      out.write("                                type=\"text\"\r\n");
      out.write("                                placeholder=\"Your first name\"\r\n");
      out.write("                                id=\"firstName\"\r\n");
      out.write("                                name=\"firstName\"\r\n");
      out.write("                                class=\"\r\n");
      out.write("                                u-border-1\r\n");
      out.write("                                u-border-grey-30\r\n");
      out.write("                                u-input\r\n");
      out.write("                                u-input-rectangle\r\n");
      out.write("                                u-radius-7\r\n");
      out.write("                                u-white\r\n");
      out.write("                                u-input-5\r\n");
      out.write("                                \"\r\n");
      out.write("                                value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user.firstName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"\r\n");
      out.write("                                required\r\n");
      out.write("                                />\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"u-form-group u-form-name u-form-group-6\">\r\n");
      out.write("                            <input\r\n");
      out.write("                                type=\"text\"\r\n");
      out.write("                                placeholder=\"Your last name\"\r\n");
      out.write("                                id=\"lastName\"\r\n");
      out.write("                                name=\"lastName\"\r\n");
      out.write("                                class=\"\r\n");
      out.write("                                u-border-1\r\n");
      out.write("                                u-border-grey-30\r\n");
      out.write("                                u-input\r\n");
      out.write("                                u-input-rectangle\r\n");
      out.write("                                u-radius-7\r\n");
      out.write("                                u-white\r\n");
      out.write("                                u-input-6\r\n");
      out.write("                                \"\r\n");
      out.write("                                value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user.lastName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"\r\n");
      out.write("                                required=\"\"\r\n");
      out.write("                                />\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"u-form-group u-form-group-7\">\r\n");
      out.write("                            <label\r\n");
      out.write("                                for=\"avatar\"\r\n");
      out.write("                                class=\"u-custom-font u-label u-text-custom-color-1 u-label-7\"\r\n");
      out.write("                                >Please choose Avatar</label\r\n");
      out.write("                            >\r\n");
      out.write("                            <input\r\n");
      out.write("                                type=\"file\"\r\n");
      out.write("                                id=\"avatar\"\r\n");
      out.write("                                name=\"avatar\"\r\n");
      out.write("                                class=\"\r\n");
      out.write("                                u-border-1\r\n");
      out.write("                                u-border-grey-30\r\n");
      out.write("                                u-input\r\n");
      out.write("                                u-input-rectangle\r\n");
      out.write("                                u-radius-7\r\n");
      out.write("                                u-white\r\n");
      out.write("                                u-input-7\r\n");
      out.write("                                \"\r\n");
      out.write("                                onchange=\"doImgUpload('avatar', 'urlout')\"\r\n");
      out.write("                                />\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div id=\"urlout\"></div>\r\n");
      out.write("                        <div class=\"u-align-left u-form-group u-form-submit\">\r\n");
      out.write("                            <input\r\n");
      out.write("                                id=\"submit\"\r\n");
      out.write("                                type=\"submit\"\r\n");
      out.write("                                value=\"submit\"\r\n");
      out.write("                                onclick=\"removeSpace();\"\r\n");
      out.write("                                class=\"u-btn\r\n");
      out.write("                                u-btn-round\r\n");
      out.write("                                u-btn-submit\r\n");
      out.write("                                u-button-style\r\n");
      out.write("                                u-hover-palette-1-dark-1\r\n");
      out.write("                                u-palette-1-base\r\n");
      out.write("                                u-radius-10\r\n");
      out.write("                                u-text-active-palette-1-dark-1\r\n");
      out.write("                                u-btn-1\"\r\n");
      out.write("                                disabled\r\n");
      out.write("                                />\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </form>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </section>\r\n");
      out.write("\r\n");
      out.write("        <footer\r\n");
      out.write("            class=\"u-align-center u-clearfix u-footer u-grey-80 u-footer\"\r\n");
      out.write("            id=\"sec-4768\"\r\n");
      out.write("            >\r\n");
      out.write("            <div class=\"u-clearfix u-sheet u-sheet-1\">\r\n");
      out.write("                <p class=\"u-small-text u-text u-text-variant u-text-1\">\r\n");
      out.write("                    Sample text. Click to select the text box. Click again or double click\r\n");
      out.write("                    to start editing the text.\r\n");
      out.write("                </p>\r\n");
      out.write("            </div>\r\n");
      out.write("        </footer>\r\n");
      out.write("\r\n");
      out.write("\r\n");
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

  private boolean _jspx_meth_c_set_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_0.setPageContext(_jspx_page_context);
    _jspx_th_c_set_0.setParent(null);
    _jspx_th_c_set_0.setVar("contextPath");
    _jspx_th_c_set_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_0 = _jspx_th_c_set_0.doStartTag();
    if (_jspx_th_c_set_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
    return false;
  }
}
