package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.UserInfo;
import model.Account;

public final class SignupFormView_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <title>LOZR</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"src/style.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"src/login.css\">\n");
      out.write("        ");

            String signUpErr = (String) request.getAttribute("errorSignupName");
            UserInfo user = user = (UserInfo) request.getAttribute("user");
        
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form action=\"signup\" method=\"post\">\n");
      out.write("            <div>\n");
      out.write("                <label for=\"loginName\">Tên đăng nhập:</label>\n");
      out.write("                <input type=\"text\" name=\"loginName\"\n");
      out.write("                       ");
 if (user != null) {
      out.write(" \n");
      out.write("                       value=\"");
      out.print( user.getLoginName());
      out.write("\"\n");
      out.write("                       ");
}
      out.write("/>                             \n");
      out.write("                ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${errorSignupName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("            \n");
      out.write("            </div>\n");
      out.write("            <div>\n");
      out.write("                <label for=\"password\">Mật Khẩu:</label>\n");
      out.write("                <input type=\"text\" name=\"password\"/>\n");
      out.write("            </div>\n");
      out.write("            <div>\n");
      out.write("                <label for=\"email\">Email:</label>\n");
      out.write("                <input type=\"email\" name=\"email\"\n");
      out.write("                       ");
if (user != null) {
      out.write("\n");
      out.write("                       value=\"");
      out.print( user.getEmailAddress());
      out.write("\"\n");
      out.write("                        ");
}
      out.write("\n");
      out.write("                       />\n");
      out.write("            </div>\n");
      out.write("            <div>\n");
      out.write("                <label for=\"name\">Tên:</label>\n");
      out.write("                <input type=\"text\" name=\"firstName\" placeholder=\"FirstName\"\n");
      out.write("                       ");
if (user != null) {
      out.write("\n");
      out.write("                       value=\"");
      out.print( user.getFirstName());
      out.write("\"\n");
      out.write("                       ");
}
      out.write("/>\n");
      out.write("                <input type=\"text\" name=\"lastName\" placeholder=\"LastName\"\n");
      out.write("                       ");
if (user != null) {
      out.write("\n");
      out.write("                       value=\"");
      out.print( user.getLastName());
      out.write("\"\n");
      out.write("                       ");
}
      out.write("/>\n");
      out.write("            </div>  \n");
      out.write("            <div>\n");
      out.write("                <label type=\"avatar\">Upload Image Avatar:</label>\n");
      out.write("                <input type=\"file\" name=\"avatar\"/>\n");
      out.write("            </div>\n");
      out.write("            <input type=\"submit\" value=\"Đăng Ký\"/>\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("    </body>\n");
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
