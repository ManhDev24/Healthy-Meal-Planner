package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <title>Title</title>\n");
      out.write("        <!-- Required meta tags -->\n");
      out.write("        <meta charset=\"utf-8\" />\n");
      out.write("        <meta\n");
      out.write("            name=\"viewport\"\n");
      out.write("            content=\"width=device-width, initial-scale=1, shrink-to-fit=no\"\n");
      out.write("            />\n");
      out.write("\n");
      out.write("        <!-- font-aewsome -->\n");
      out.write("        <link\n");
      out.write("            rel=\"stylesheet\"\n");
      out.write("            href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css\"\n");
      out.write("            integrity=\"sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==\"\n");
      out.write("            crossorigin=\"anonymous\"\n");
      out.write("            referrerpolicy=\"no-referrer\"\n");
      out.write("            />\n");
      out.write("        <!-- Bootstrap CSS v5.2.1 -->\n");
      out.write("        <link\n");
      out.write("            href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css\"\n");
      out.write("            rel=\"stylesheet\"\n");
      out.write("            integrity=\"sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN\"\n");
      out.write("            crossorigin=\"anonymous\"\n");
      out.write("            />\n");
      out.write("        <!-- my css -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"./asset/header.css\" />\n");
      out.write("        <!-- Bootstrap CSS -->\n");
      out.write("        <link href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <!-- Bootstrap CSS -->\n");
      out.write("        <link href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <style>\n");
      out.write("\n");
      out.write("            .container {\n");
      out.write("                max-width: 1300px !important;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <!-- Remove the container if you want to extend the Footer to full width. -->\n");
      out.write("            <div class=\"container my-5\">\n");
      out.write("                <!-- Footer -->\n");
      out.write("                <footer\n");
      out.write("                    class=\"text-center text-lg-start text-dark\"\n");
      out.write("                    style=\"background-color: #ECEFF1\"\n");
      out.write("                    >\n");
      out.write("                    <!-- Section: Social media -->\n");
      out.write("                    <section\n");
      out.write("                        class=\"d-flex justify-content-between p-4 text-white\"\n");
      out.write("                        style=\"background-color: #21D192\"\n");
      out.write("                        >\n");
      out.write("                        <!-- Left -->\n");
      out.write("                        <div class=\"me-5\">\n");
      out.write("                            <span>Get connected with us on social networks:</span>\n");
      out.write("                        </div>\n");
      out.write("                        <!-- Left -->\n");
      out.write("\n");
      out.write("                        <!-- Right -->\n");
      out.write("                        <div>\n");
      out.write("                            <a href=\"\" class=\"text-white me-4\">\n");
      out.write("                                <i class=\"fab fa-facebook-f\"></i>\n");
      out.write("                            </a>\n");
      out.write("                            <a href=\"\" class=\"text-white me-4\">\n");
      out.write("                                <i class=\"fab fa-twitter\"></i>\n");
      out.write("                            </a>\n");
      out.write("                            <a href=\"\" class=\"text-white me-4\">\n");
      out.write("                                <i class=\"fab fa-google\"></i>\n");
      out.write("                            </a>\n");
      out.write("                            <a href=\"\" class=\"text-white me-4\">\n");
      out.write("                                <i class=\"fab fa-instagram\"></i>\n");
      out.write("                            </a>\n");
      out.write("                            <a href=\"\" class=\"text-white me-4\">\n");
      out.write("                                <i class=\"fab fa-linkedin\"></i>\n");
      out.write("                            </a>\n");
      out.write("                            <a href=\"\" class=\"text-white me-4\">\n");
      out.write("                                <i class=\"fab fa-github\"></i>\n");
      out.write("                            </a>\n");
      out.write("                        </div>\n");
      out.write("                        <!-- Right -->\n");
      out.write("                    </section>\n");
      out.write("                    <!-- Section: Social media -->\n");
      out.write("\n");
      out.write("                    <!-- Section: Links  -->\n");
      out.write("                    <section class=\"\">\n");
      out.write("                        <div class=\"container text-center text-md-start mt-5\">\n");
      out.write("                            <!-- Grid row -->\n");
      out.write("                            <div class=\"row mt-3\">\n");
      out.write("                                <!-- Grid column -->\n");
      out.write("                                <div class=\"col-md-3 col-lg-4 col-xl-3 mx-auto mb-4\">\n");
      out.write("                                    <!-- Content -->\n");
      out.write("                                    <h6 class=\"text-uppercase fw-bold\">Company name</h6>\n");
      out.write("                                    <hr\n");
      out.write("                                        class=\"mb-4 mt-0 d-inline-block mx-auto\"\n");
      out.write("                                        style=\"width: 60px; background-color: #7c4dff; height: 2px\"\n");
      out.write("                                        />\n");
      out.write("                                    <p>\n");
      out.write("                                        Here you can use rows and columns to organize your footer\n");
      out.write("                                        content. Lorem ipsum dolor sit amet, consectetur adipisicing\n");
      out.write("                                        elit.\n");
      out.write("                                    </p>\n");
      out.write("                                </div>\n");
      out.write("                                <!-- Grid column -->\n");
      out.write("\n");
      out.write("                                <!-- Grid column -->\n");
      out.write("                                <div class=\"col-md-2 col-lg-2 col-xl-2 mx-auto mb-4\">\n");
      out.write("                                    <!-- Links -->\n");
      out.write("                                    <h6 class=\"text-uppercase fw-bold\">Products</h6>\n");
      out.write("                                    <hr\n");
      out.write("                                        class=\"mb-4 mt-0 d-inline-block mx-auto\"\n");
      out.write("                                        style=\"width: 60px; background-color: #7c4dff; height: 2px\"\n");
      out.write("                                        />\n");
      out.write("                                    <p>\n");
      out.write("                                        <a href=\"#!\" class=\"text-dark\">MDBootstrap</a>\n");
      out.write("                                    </p>\n");
      out.write("                                    <p>\n");
      out.write("                                        <a href=\"#!\" class=\"text-dark\">MDWordPress</a>\n");
      out.write("                                    </p>\n");
      out.write("                                    <p>\n");
      out.write("                                        <a href=\"#!\" class=\"text-dark\">BrandFlow</a>\n");
      out.write("                                    </p>\n");
      out.write("                                    <p>\n");
      out.write("                                        <a href=\"#!\" class=\"text-dark\">Bootstrap Angular</a>\n");
      out.write("                                    </p>\n");
      out.write("                                </div>\n");
      out.write("                                <!-- Grid column -->\n");
      out.write("\n");
      out.write("                                <!-- Grid column -->\n");
      out.write("                                <div class=\"col-md-3 col-lg-2 col-xl-2 mx-auto mb-4\">\n");
      out.write("                                    <!-- Links -->\n");
      out.write("                                    <h6 class=\"text-uppercase fw-bold\">Useful links</h6>\n");
      out.write("                                    <hr\n");
      out.write("                                        class=\"mb-4 mt-0 d-inline-block mx-auto\"\n");
      out.write("                                        style=\"width: 60px; background-color: #7c4dff; height: 2px\"\n");
      out.write("                                        />\n");
      out.write("                                    <p>\n");
      out.write("                                        <a href=\"#!\" class=\"text-dark\">Your Account</a>\n");
      out.write("                                    </p>\n");
      out.write("                                    <p>\n");
      out.write("                                        <a href=\"#!\" class=\"text-dark\">Become an Affiliate</a>\n");
      out.write("                                    </p>\n");
      out.write("                                    <p>\n");
      out.write("                                        <a href=\"#!\" class=\"text-dark\">Shipping Rates</a>\n");
      out.write("                                    </p>\n");
      out.write("                                    <p>\n");
      out.write("                                        <a href=\"#!\" class=\"text-dark\">Help</a>\n");
      out.write("                                    </p>\n");
      out.write("                                </div>\n");
      out.write("                                <!-- Grid column -->\n");
      out.write("\n");
      out.write("                                <!-- Grid column -->\n");
      out.write("                                <div class=\"col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4\">\n");
      out.write("                                    <!-- Links -->\n");
      out.write("                                    <h6 class=\"text-uppercase fw-bold\">Contact</h6>\n");
      out.write("                                    <hr\n");
      out.write("                                        class=\"mb-4 mt-0 d-inline-block mx-auto\"\n");
      out.write("                                        style=\"width: 60px; background-color: #7c4dff; height: 2px\"\n");
      out.write("                                        />\n");
      out.write("                                    <p><i class=\"fas fa-home mr-3\"></i> New York, NY 10012, US</p>\n");
      out.write("                                    <p><i class=\"fas fa-envelope mr-3\"></i> info@example.com</p>\n");
      out.write("                                    <p><i class=\"fas fa-phone mr-3\"></i> + 01 234 567 88</p>\n");
      out.write("                                    <p><i class=\"fas fa-print mr-3\"></i> + 01 234 567 89</p>\n");
      out.write("                                </div>\n");
      out.write("                                <!-- Grid column -->\n");
      out.write("                            </div>\n");
      out.write("                            <!-- Grid row -->\n");
      out.write("                        </div>\n");
      out.write("                    </section>\n");
      out.write("                    <!-- Section: Links  -->\n");
      out.write("\n");
      out.write("                    <!-- Copyright -->\n");
      out.write("                    <div\n");
      out.write("                        class=\"text-center p-3\"\n");
      out.write("                        style=\"background-color: rgba(0, 0, 0, 0.2)\"\n");
      out.write("                        >\n");
      out.write("                        © 2020 Copyright:\n");
      out.write("                        <a class=\"text-dark\" href=\"https://mdbootstrap.com/\"\n");
      out.write("                           >MDBootstrap.com</a\n");
      out.write("                        >\n");
      out.write("                    </div>\n");
      out.write("                    <!-- Copyright -->\n");
      out.write("                </footer>\n");
      out.write("                <!-- Footer -->\n");
      out.write("            </div>\n");
      out.write("            <!-- End of .container -->\n");
      out.write("        </div>\n");
      out.write("        <script\n");
      out.write("            src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js\"\n");
      out.write("            integrity=\"sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r\"\n");
      out.write("            crossorigin=\"anonymous\"\n");
      out.write("        ></script>\n");
      out.write("\n");
      out.write("        <script\n");
      out.write("            src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js\"\n");
      out.write("            integrity=\"sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+\"\n");
      out.write("            crossorigin=\"anonymous\"\n");
      out.write("        ></script>\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\"></script>\n");
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
