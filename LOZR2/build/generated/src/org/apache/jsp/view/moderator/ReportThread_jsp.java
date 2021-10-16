package org.apache.jsp.view.moderator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ReportThread_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_set_var_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_fmt_formatDate_value_type_timeStyle_dateStyle_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_set_var_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_fmt_formatDate_value_type_timeStyle_dateStyle_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_c_set_var_value_nobody.release();
    _jspx_tagPool_fmt_formatDate_value_type_timeStyle_dateStyle_nobody.release();
    _jspx_tagPool_c_if_test.release();
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html style=\"font-size: 16px\">\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        ");
      controller.module.ExtractURLPath transToPath = null;
      synchronized (_jspx_page_context) {
        transToPath = (controller.module.ExtractURLPath) _jspx_page_context.getAttribute("transToPath", PageContext.PAGE_SCOPE);
        if (transToPath == null){
          transToPath = new controller.module.ExtractURLPath();
          _jspx_page_context.setAttribute("transToPath", transToPath, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\n");
      out.write("\n");
      out.write("        ");
      if (_jspx_meth_c_set_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("        ");
      if (_jspx_meth_c_set_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("        ");
      if (_jspx_meth_c_set_2(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("        ");
      if (_jspx_meth_c_set_3(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n");
      out.write("        <meta charset=\"utf-8\" />\n");
      out.write("        <title>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${forum.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" | L0ZR</title>\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/src/style/nicepage.css\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/src/style/index.css\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/src/style/Forum.css\" />\n");
      out.write("        <script\n");
      out.write("            type=\"text/javascript\"\n");
      out.write("            src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/src/script/jquery.js\"\n");
      out.write("            defer=\"\"\n");
      out.write("        ></script>\n");
      out.write("        <script\n");
      out.write("            type=\"text/javascript\"\n");
      out.write("            src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/src/script/nicepage.js\"\n");
      out.write("            defer=\"\"\n");
      out.write("        ></script>\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/src/script/script.js\" defer></script>\n");
      out.write("        <!-- <meta name=\"generator\" content=\"Nicepage 3.26.0, nicepage.com\" /> -->\n");
      out.write("        <link\n");
      out.write("            rel=\"stylesheet\"\n");
      out.write("            href=\"https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i\"\n");
      out.write("            />\n");
      out.write("        <link\n");
      out.write("            rel=\"stylesheet\"\n");
      out.write("            href=\"https://fonts.googleapis.com/css?family=Montserrat:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i|Aldrich:400\"\n");
      out.write("            />\n");
      out.write("        <!-- font-awesome -->\n");
      out.write("        <link\n");
      out.write("            rel=\"stylesheet\"\n");
      out.write("            href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\"\n");
      out.write("            />\n");
      out.write("    </head>\n");
      out.write("    <body class=\"u-body\">\n");
      out.write("        <div class=\"form-popup\" id=\"formEdit\">\n");
      out.write("            <form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/update/thread\" method=\"POST\" class=\"form-container\">\n");
      out.write("                <h2>Edit Thread</h2>\n");
      out.write("                <input type=\"hidden\" id=\"elementeID\"  name=\"threadID\"/> \n");
      out.write("                <label  for=\"threadSubject\">New Thread Title</label>\n");
      out.write("                <input type=\"text\" placeholder=\"New Name\" name=\"threadSubject\">\n");
      out.write("                <button type=\"submit\" class=\"btn\">Save</button>\n");
      out.write("                <button type=\"button\" class=\"btn\" onclick=\"closeForm()\">Close</button>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <header class=\"u-clearfix u-header u-sticky u-sticky-1ec8 u-white u-header\">\n");
      out.write("            <div class=\"u-clearfix u-sheet u-sheet-1\">\n");
      out.write("                <a\n");
      out.write("                    href=\"#main\"\n");
      out.write("                    class=\"u-hidden-sm u-hidden-xs u-image u-logo u-image-1\"\n");
      out.write("                    data-image-width=\"590\"\n");
      out.write("                    data-image-height=\"90\"\n");
      out.write("                    >\n");
      out.write("                    <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/images/lozr4rum1.png\" class=\"u-logo-image u-logo-image-1\" />\n");
      out.write("                </a>\n");
      out.write("                <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${transToPath.compressObjectToPath(contextPath, \"user\", your.loginName, your.userID)}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                    <div class=\"u-align-left u-container-style u-group u-group-1\">\n");
      out.write("                        <div class=\"u-container-layout u-container-layout-1\">\n");
      out.write("                            <p\n");
      out.write("                                class=\"\n");
      out.write("                                u-align-right u-custom-font u-font-montserrat u-text u-text-1\n");
      out.write("                                \"\n");
      out.write("                                >\n");
      out.write("                                ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${(empty your)? \"Account\" : your.loginName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                            </p>\n");
      out.write("                            <img\n");
      out.write("                                class=\"u-expanded-height-xl u-image u-image-circle u-image-2\"\n");
      out.write("                                src= \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${(empty your.base64ImageAvatar)?  defaultImage : yourAvatar}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"\n");
      out.write("                                />\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </a>\n");
      out.write("\n");
      out.write("                <nav\n");
      out.write("                    class=\"\n");
      out.write("                    u-align-left\n");
      out.write("                    u-menu\n");
      out.write("                    u-menu-dropdown\n");
      out.write("                    u-menu-open-right\n");
      out.write("                    u-nav-spacing-25\n");
      out.write("                    u-offcanvas\n");
      out.write("                    u-menu-1\n");
      out.write("                    \"\n");
      out.write("                    data-responsive-from=\"XL\"\n");
      out.write("                    >\n");
      out.write("                    <div class=\"menu-collapse\">\n");
      out.write("                        <a class=\"menu-button\" href=\"#\">\n");
      out.write("                            <i class=\"fa fa-bars\"></i>\n");
      out.write("                        </a>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"u-custom-menu u-nav-container-collapse\">\n");
      out.write("                        <div\n");
      out.write("                            class=\"\n");
      out.write("                            u-align-center\n");
      out.write("                            u-black\n");
      out.write("                            u-container-style\n");
      out.write("                            u-inner-container-layout\n");
      out.write("                            u-sidenav\n");
      out.write("                            u-sidenav-1\n");
      out.write("                            \"\n");
      out.write("                            data-offcanvas-width=\"341.5626\"\n");
      out.write("                            >\n");
      out.write("                            <div class=\"u-inner-container-layout u-sidenav-overflow\">\n");
      out.write("                                <div class=\"u-menu-close\"></div>\n");
      out.write("                                <ul\n");
      out.write("                                    class=\"\n");
      out.write("                                    u-align-center\n");
      out.write("                                    u-custom-font\n");
      out.write("                                    u-font-montserrat\n");
      out.write("                                    u-nav\n");
      out.write("                                    u-popupmenu-items\n");
      out.write("                                    u-spacing-16\n");
      out.write("                                    u-text-active-palette-1-dark-1\n");
      out.write("                                    u-text-hover-palette-4-base\n");
      out.write("                                    u-unstyled\n");
      out.write("                                    u-nav-2\n");
      out.write("                                    \"\n");
      out.write("                                    >\n");
      out.write("                                    <li class=\"u-nav-item\">\n");
      out.write("                                        <a class=\"u-button-style u-nav-link\"\n");
      out.write("                                           href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${transToPath.compressObjectToPath(contextPath, \"user\", your.loginName, your.userID)}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"\n");
      out.write("                                           >");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${(empty your)? \"Account\" : your.loginName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</a\n");
      out.write("                                        >\n");
      out.write("                                    </li>\n");
      out.write("                                    <li class=\"u-nav-item\">\n");
      out.write("                                        <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/logout\" class=\"u-button-style u-nav-link\">Log Out</a>\n");
      out.write("                                    </li>\n");
      out.write("                                </ul>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div\n");
      out.write("                            class=\"u-custom-color-4 u-menu-overlay u-opacity u-opacity-65\"\n");
      out.write("                            ></div>\n");
      out.write("                    </div>\n");
      out.write("                </nav>\n");
      out.write("            </div>\n");
      out.write("        </header>\n");
      out.write("\n");
      out.write("        <div class=\"main-zone\">\n");
      out.write("            <div class=\"body-header\">\n");
      out.write("\n");
      out.write("                <div  class=\"post-title\" >\n");
      out.write("                    <h1>THREAD MANAGEMENT</h1>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <!--ThreadZone-->\n");
      out.write("            ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("            ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <footer\n");
      out.write("            class=\"u-align-center u-clearfix u-footer u-grey-80 u-footer\"\n");
      out.write("            id=\"sec-4768\"\n");
      out.write("            >\n");
      out.write("            <div class=\"u-clearfix u-sheet u-sheet-1\">\n");
      out.write("                <p class=\"u-small-text u-text u-text-variant u-text-1\">\n");
      out.write("                    Sample text. Click to select the text box. Click again or double click\n");
      out.write("                    to start editing the text.\n");
      out.write("                </p>\n");
      out.write("            </div>\n");
      out.write("        </footer>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
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

  private boolean _jspx_meth_c_set_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_1 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_1.setPageContext(_jspx_page_context);
    _jspx_th_c_set_1.setParent(null);
    _jspx_th_c_set_1.setVar("your");
    _jspx_th_c_set_1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.currentUser}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_1 = _jspx_th_c_set_1.doStartTag();
    if (_jspx_th_c_set_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_1);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_1);
    return false;
  }

  private boolean _jspx_meth_c_set_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_2 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_2.setPageContext(_jspx_page_context);
    _jspx_th_c_set_2.setParent(null);
    _jspx_th_c_set_2.setVar("defaultImage");
    _jspx_th_c_set_2.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contextPath}/images/82761229_p17_master1200.jpg", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_2 = _jspx_th_c_set_2.doStartTag();
    if (_jspx_th_c_set_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_2);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_2);
    return false;
  }

  private boolean _jspx_meth_c_set_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_3 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_3.setPageContext(_jspx_page_context);
    _jspx_th_c_set_3.setParent(null);
    _jspx_th_c_set_3.setVar("yourAvatar");
    _jspx_th_c_set_3.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("data:image/jpg;base64,${your.base64ImageAvatar}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_3 = _jspx_th_c_set_3.doStartTag();
    if (_jspx_th_c_set_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_3);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_3);
    return false;
  }

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${empty requestScope.threads}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                <div class=\"u-container-layout u-valign-top-lg u-valign-top-md u-valign-top-sm u-valign-top-xl u-container-layout-1\">\n");
        out.write("                    <h1 class=\"u-align-center-xs  u-font-playfair-display u-text u-text-1\">Oops, There is nothing here?!</h1>\n");
        out.write("                </div>\n");
        out.write("            ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${reportthreads}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("reportthread");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                ");
          if (_jspx_meth_c_set_4((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("\n");
          out.write("                ");
          if (_jspx_meth_c_set_5((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("\n");
          out.write("                <a href=\"#ádfa\">\n");
          out.write("                    <div class=\"thread-table thread-card\">\n");
          out.write("\n");
          out.write("                        <div class=\"thread-cell thread-cell-author\">\n");
          out.write("                            <div class=\"\">\n");
          out.write("                                <a href=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${transToPath.compressObjectToPath(contextPath, \"user\", thread.startedBy.loginName, thread.startedBy.userID)}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\n");
          out.write("                                    <img src=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${(empty thread.startedBy.base64ImageAvatar)?  defaultImage : threadByAvatar}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" />\n");
          out.write("                                </a>\n");
          out.write("                            </div>\n");
          out.write("                        </div>\n");
          out.write("\n");
          out.write("                        <div class=\"thread-cell\">\n");
          out.write("                            <div class=\"thread-subject\">\n");
          out.write("                                <a\n");
          out.write("                                    href=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${transToPath.compressObjectToPath(contextPath, \"thread\", thread.subject, thread.threadID)}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"\n");
          out.write("                                    >");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${thread.subject}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</a\n");
          out.write("                                >\n");
          out.write("                            </div>\n");
          out.write("\n");
          out.write("                            <div class=\"\">\n");
          out.write("                                <ul class=\"thread-item-part\">\n");
          out.write("                                    <li>\n");
          out.write("                                        <a href=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${transToPath.compressObjectToPath(contextPath, \"user\", thread.startedBy.loginName, thread.startedBy.userID)}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" class=\"username\"\n");
          out.write("                                           >");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${thread.startedBy.loginName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</a\n");
          out.write("                                        >\n");
          out.write("                                    </li>\n");
          out.write("                                    <li class=\"\">\n");
          out.write("                                        <a href=\"/t/tai-chinh-20m-tro-xuong-can-tu-van-cau-hinh-pc-phuc-vu-cho-edit-video-pts-ai-tren-adobe-co-the-choi-fifa-online-4.399690/\">\n");
          out.write("                                            <time class=\"thread-latestDate\">\n");
          out.write("                                                ");
          if (_jspx_meth_fmt_formatDate_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("\n");
          out.write("                                            </time>\n");
          out.write("                                        </a>\n");
          out.write("                                    </li>\n");
          out.write("                                </ul>\n");
          out.write("                            </div>\n");
          out.write("                        </div>\n");
          out.write("\n");
          out.write("                        <div class=\"thread-cell thread-status\">\n");
          out.write("                            <dl class=\"thread-status-pair\">\n");
          out.write("                                <dt>Replies</dt>\n");
          out.write("                                <dd>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${thread.numPosts}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</dd>\n");
          out.write("                            </dl>\n");
          out.write("                            <!-- <dl class=\"thread-status-pair\">\n");
          out.write("                              <dt>Views</dt>\n");
          out.write("                              <dd>88</dd>\n");
          out.write("                            </dl> -->\n");
          out.write("                        </div>\n");
          out.write("\n");
          out.write("                        <!--                        <div class=\"thread-table thread-cell thread-lastest-active\">\n");
          out.write("                                                    <div class=\"thread-cell thread-cell-unborder\">\n");
          out.write("                                                        <a\n");
          out.write("                                                            href=\"/t/tai-chinh-20m-tro-xuong-can-tu-van-cau-hinh-pc-phuc-vu-cho-edit-video-pts-ai-tren-adobe-co-the-choi-fifa-online-4.399690/latest\"\n");
          out.write("                                                            rel=\"nofollow\"\n");
          out.write("                                                            ><time class=\"thread-latestDate\">11:13 05/10/2021</time></a\n");
          out.write("                                                        >\n");
          out.write("                                                        <div class=\"\">\n");
          out.write("                                                            <a href=\"/u/congtubotgag.1034303/\" class=\"username\">congtubotgag</a>\n");
          out.write("                                                        </div>\n");
          out.write("                                                    </div>\n");
          out.write("                                                    <div class=\"thread-cell thread-latest-user thread-cell-unborder\">\n");
          out.write("                                                        <a href=\"/u/congtubotgag.1034303/\" class=\"avatar avatar--xxs\">\n");
          out.write("                                                            <img src=\"images/82761229_p17_master1200.jpg\" />\n");
          out.write("                                                        </a>\n");
          out.write("                        \n");
          out.write("                                                    </div>\n");
          out.write("                                                </div>-->\n");
          out.write("\n");
          out.write("                        <!--                        <div class=\"thread-cell thread-latest-user\">\n");
          out.write("                                                    <a href=\"/u/congtubotgag.1034303/\" class=\"avatar avatar--xxs\">\n");
          out.write("                                                        <img src=\"images/82761229_p17_master1200.jpg\" />\n");
          out.write("                                                    </a>\n");
          out.write("                        \n");
          out.write("                                                </div>-->\n");
          out.write("                        <div class=\"thread-cell thread-cell-option  dropdown\">\n");
          out.write("                            <button onclick=\"showDropdownMenu(");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${thread.threadID}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(")\" class=\"dropbtn\">Option</button>\n");
          out.write("                            <div id=\"myDropdown-");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${thread.threadID}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" class=\"dropdown-content\">\n");
          out.write("                                <a href=\"#\">Bookmark</a>\n");
          out.write("                                <a href=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("/report/thread?id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${thread.threadID}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">Report</a>\n");
          out.write("                                ");
          if (_jspx_meth_c_if_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("\n");
          out.write("\n");
          out.write("                                ");
          if (_jspx_meth_c_if_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("\n");
          out.write("                            </div>\n");
          out.write("                        </div>\n");
          out.write("                    </div>\n");
          out.write("\n");
          out.write("                </a>\n");
          out.write("\n");
          out.write("            ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_set_4(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_4 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_4.setPageContext(_jspx_page_context);
    _jspx_th_c_set_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_set_4.setVar("thread");
    _jspx_th_c_set_4.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${reportthread.thread}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_4 = _jspx_th_c_set_4.doStartTag();
    if (_jspx_th_c_set_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_4);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_4);
    return false;
  }

  private boolean _jspx_meth_c_set_5(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_5 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_5.setPageContext(_jspx_page_context);
    _jspx_th_c_set_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_set_5.setVar("threadByAvatar");
    _jspx_th_c_set_5.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("data:image/jpg;base64,${thread.startedBy.base64ImageAvatar}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_5 = _jspx_th_c_set_5.doStartTag();
    if (_jspx_th_c_set_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_5);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_5);
    return false;
  }

  private boolean _jspx_meth_fmt_formatDate_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:formatDate
    org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag _jspx_th_fmt_formatDate_0 = (org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag) _jspx_tagPool_fmt_formatDate_value_type_timeStyle_dateStyle_nobody.get(org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag.class);
    _jspx_th_fmt_formatDate_0.setPageContext(_jspx_page_context);
    _jspx_th_fmt_formatDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_fmt_formatDate_0.setType("both");
    _jspx_th_fmt_formatDate_0.setDateStyle("short");
    _jspx_th_fmt_formatDate_0.setTimeStyle("short");
    _jspx_th_fmt_formatDate_0.setValue((java.util.Date) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${thread.timeCreated}", java.util.Date.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_fmt_formatDate_0 = _jspx_th_fmt_formatDate_0.doStartTag();
    if (_jspx_th_fmt_formatDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_formatDate_value_type_timeStyle_dateStyle_nobody.reuse(_jspx_th_fmt_formatDate_0);
      return true;
    }
    _jspx_tagPool_fmt_formatDate_value_type_timeStyle_dateStyle_nobody.reuse(_jspx_th_fmt_formatDate_0);
    return false;
  }

  private boolean _jspx_meth_c_if_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${your.userID == thread.startedBy.userID}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                    <a onclick=\"openForm(");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${thread.threadID}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write(");\">Change Title</a>\n");
        out.write("                                ");
        int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
    return false;
  }

  private boolean _jspx_meth_c_if_2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_2.setPageContext(_jspx_page_context);
    _jspx_th_c_if_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_if_2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${your.admin || your.userID == thread.startedBy.userID}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_2 = _jspx_th_c_if_2.doStartTag();
    if (_jspx_eval_c_if_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                    <a onclick=\"doDelete(");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${thread.threadID}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write(", 'thread');\">Delete</a>\n");
        out.write("                                ");
        int evalDoAfterBody = _jspx_th_c_if_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
    return false;
  }
}
