package org.apache.jsp.test;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.UserInfo;

public final class SessionUserInfoViewTest_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        ");
 UserInfo user = (UserInfo) request.getAttribute("user"); 
      out.write("\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>");
      out.print( user.getLoginName() );
      out.write(" | Test</title>\n");
      out.write("        \n");
      out.write("         \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Hello World!</h1>\n");
      out.write("        <p> \n");
      out.write("            <IMG height=99 src=\"data:image/jpg;base64,");
      out.print( user.getBase64ImageAvatar() );
      out.write("\" width=136>\n");
      out.write("            <br/>\n");
      out.write("            ID: ");
      out.print( user.getUserID()  );
      out.write("\n");
      out.write("            <br/>\n");
      out.write("            Username: ");
      out.print( user.getLoginName() );
      out.write("\n");
      out.write("            <br/>\n");
      out.write("            FirstName: ");
      out.print( user.getFirstName() );
      out.write("\n");
      out.write("            <br/>\n");
      out.write("            LastName: ");
      out.print( user.getLastName() );
      out.write("\n");
      out.write("            <br/>\n");
      out.write("            DateJoined: ");
      out.print( user.getDateJoined() );
      out.write("\n");
      out.write("            <br/>\n");
      out.write("            Email: ");
      out.print( user.getEmailAddress() );
      out.write("\n");
      out.write("            <br/>\n");
      out.write("            Admin: ");
      out.print( user.isAdmin()? "true": "false" );
      out.write("\n");
      out.write("        </p>\n");
      out.write("                     \n");
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
