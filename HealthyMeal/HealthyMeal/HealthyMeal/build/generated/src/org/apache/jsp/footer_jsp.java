package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class footer_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"./asset/dishDetail.css\">\n");
      out.write("\n");
      out.write("        <style>\n");
      out.write("            .container{\n");
      out.write("                max-width: 1300px;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <!-- Remove the container if you want to extend the Footer to full width. -->\n");
      out.write("        <div class=\"container my-5\">\n");
      out.write("\n");
      out.write("            <footer class=\"text-center text-white\" style=\"background-color: #f1f1f1;\">\n");
      out.write("                <!-- Grid container -->\n");
      out.write("                <div class=\"container pt-4\">\n");
      out.write("                    <!-- Section: Social media -->\n");
      out.write("                    <section class=\"mb-4\">\n");
      out.write("                        <!-- Facebook -->\n");
      out.write("                        <a\n");
      out.write("                            class=\"btn btn-link btn-floating btn-lg text-dark m-1\"\n");
      out.write("                            href=\"#!\"\n");
      out.write("                            role=\"button\"\n");
      out.write("                            data-mdb-ripple-color=\"dark\"\n");
      out.write("                            ><i class=\"fab fa-facebook-f\"></i\n");
      out.write("                            ></a>\n");
      out.write("\n");
      out.write("                        <!-- Twitter -->\n");
      out.write("                        <a\n");
      out.write("                            class=\"btn btn-link btn-floating btn-lg text-dark m-1\"\n");
      out.write("                            href=\"#!\"\n");
      out.write("                            role=\"button\"\n");
      out.write("                            data-mdb-ripple-color=\"dark\"\n");
      out.write("                            ><i class=\"fab fa-twitter\"></i\n");
      out.write("                            ></a>\n");
      out.write("\n");
      out.write("                        <!-- Google -->\n");
      out.write("                        <a\n");
      out.write("                            class=\"btn btn-link btn-floating btn-lg text-dark m-1\"\n");
      out.write("                            href=\"#!\"\n");
      out.write("                            role=\"button\"\n");
      out.write("                            data-mdb-ripple-color=\"dark\"\n");
      out.write("                            ><i class=\"fab fa-google\"></i\n");
      out.write("                            ></a>\n");
      out.write("\n");
      out.write("                        <!-- Instagram -->\n");
      out.write("                        <a\n");
      out.write("                            class=\"btn btn-link btn-floating btn-lg text-dark m-1\"\n");
      out.write("                            href=\"#!\"\n");
      out.write("                            role=\"button\"\n");
      out.write("                            data-mdb-ripple-color=\"dark\"\n");
      out.write("                            ><i class=\"fab fa-instagram\"></i\n");
      out.write("                            ></a>\n");
      out.write("\n");
      out.write("                        <!-- Linkedin -->\n");
      out.write("                        <a\n");
      out.write("                            class=\"btn btn-link btn-floating btn-lg text-dark m-1\"\n");
      out.write("                            href=\"#!\"\n");
      out.write("                            role=\"button\"\n");
      out.write("                            data-mdb-ripple-color=\"dark\"\n");
      out.write("                            ><i class=\"fab fa-linkedin\"></i\n");
      out.write("                            ></a>\n");
      out.write("                        <!-- Github -->\n");
      out.write("                        <a\n");
      out.write("                            class=\"btn btn-link btn-floating btn-lg text-dark m-1\"\n");
      out.write("                            href=\"#!\"\n");
      out.write("                            role=\"button\"\n");
      out.write("                            data-mdb-ripple-color=\"dark\"\n");
      out.write("                            ><i class=\"fab fa-github\"></i\n");
      out.write("                            ></a>\n");
      out.write("                    </section>\n");
      out.write("                    <!-- Section: Social media -->\n");
      out.write("                </div>\n");
      out.write("                <!-- Grid container -->\n");
      out.write("\n");
      out.write("                <!-- Copyright -->\n");
      out.write("                <div class=\"text-center text-dark p-3\" style=\"background-color: rgba(0, 0, 0, 0.2);\">\n");
      out.write("                    © 2020 Copyright:\n");
      out.write("                    <a class=\"text-dark\" href=\"https://mdbootstrap.com/\">MDBootstrap.com</a>\n");
      out.write("                </div>\n");
      out.write("                <!-- Copyright -->\n");
      out.write("            </footer>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <!-- End of .container -->\n");
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
