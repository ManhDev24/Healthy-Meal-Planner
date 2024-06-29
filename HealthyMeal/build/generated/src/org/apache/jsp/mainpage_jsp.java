package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class mainpage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("  <head>\n");
      out.write("    <title>Title</title>\n");
      out.write("    <!-- Required meta tags -->\n");
      out.write("    <meta charset=\"utf-8\" />\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\" />\n");
      out.write("\n");
      out.write("    <!-- Font Awesome -->\n");
      out.write("    <link\n");
      out.write("      rel=\"stylesheet\"\n");
      out.write("      href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css\"\n");
      out.write("      integrity=\"sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==\"\n");
      out.write("      crossorigin=\"anonymous\"\n");
      out.write("      referrerpolicy=\"no-referrer\"\n");
      out.write("    />\n");
      out.write("\n");
      out.write("    <!-- Bootstrap CSS -->\n");
      out.write("    <link\n");
      out.write("      href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css\"\n");
      out.write("      rel=\"stylesheet\"\n");
      out.write("      integrity=\"sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN\"\n");
      out.write("      crossorigin=\"anonymous\"\n");
      out.write("    />\n");
      out.write("\n");
      out.write("    <!-- Custom CSS -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"./asset/header.css\" />\n");
      out.write("\n");
      out.write("    <!-- Owl Carousel CSS -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css\" />\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.theme.default.min.css\" />\n");
      out.write("\n");
      out.write("    <style>\n");
      out.write("      .container {\n");
      out.write("        max-width: 1300px;\n");
      out.write("      }\n");
      out.write("    </style>\n");
      out.write("  </head>\n");
      out.write("\n");
      out.write("  <body>\n");
      out.write("    <div class=\"container\">\n");
      out.write("      <div id=\"carouselExampleIndicators\" class=\"carousel slide\" data-bs-ride=\"carousel\" data-bs-interval=\"3000\">\n");
      out.write("        <div class=\"carousel-indicators\">\n");
      out.write("          <button type=\"button\" data-bs-target=\"#carouselExampleIndicators\" data-bs-slide-to=\"0\" class=\"active\" aria-current=\"true\" aria-label=\"Slide 1\"></button>\n");
      out.write("          <button type=\"button\" data-bs-target=\"#carouselExampleIndicators\" data-bs-slide-to=\"1\" aria-label=\"Slide 2\"></button>\n");
      out.write("          <button type=\"button\" data-bs-target=\"#carouselExampleIndicators\" data-bs-slide-to=\"2\" aria-label=\"Slide 3\"></button>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"carousel-inner\">\n");
      out.write("          <div class=\"carousel-item active\">\n");
      out.write("            <a href=\"#\"> <img src=\"https://veganessentials.com/cdn/shop/files/ve-pre-4th-sale-d.webp?v=1719565610\" class=\"d-block w-100\" alt=\"...\" /></a>\n");
      out.write("          </div>\n");
      out.write("          <div class=\"carousel-item\">\n");
      out.write("            <a href=\"#\"><img src=\"https://veganessentials.com/cdn/shop/files/d-national-bbq-month.webp?v=1714580718\" class=\"d-block w-100\" alt=\"...\" /></a>\n");
      out.write("          </div>\n");
      out.write("          <div class=\"carousel-item\">\n");
      out.write("            <a href=\"#\"><img src=\"https://veganessentials.com/cdn/shop/files/rare-vegan-finds-d.webp?v=1708712202\" class=\"d-block w-100\" alt=\"...\" /></a>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("        <button class=\"carousel-control-prev\" type=\"button\" data-bs-target=\"#carouselExampleIndicators\" data-bs-slide=\"prev\">\n");
      out.write("          <span class=\"carousel-control-prev-icon\" aria-hidden=\"true\"></span>\n");
      out.write("          <span class=\"visually-hidden\">Previous</span>\n");
      out.write("        </button>\n");
      out.write("        <button class=\"carousel-control-next\" type=\"button\" data-bs-target=\"#carouselExampleIndicators\" data-bs-slide=\"next\">\n");
      out.write("          <span class=\"carousel-control-next-icon\" aria-hidden=\"true\"></span>\n");
      out.write("          <span class=\"visually-hidden\">Next</span>\n");
      out.write("        </button>\n");
      out.write("      </div>\n");
      out.write("\n");
      out.write("      <div>\n");
      out.write("        <h3>Dinner</h3>\n");
      out.write("        <div class=\"dish mt-4\">\n");
      out.write("          <div class=\"owl-carousel owl-theme\">\n");
      out.write("            <div class=\"item\">\n");
      out.write("              <div class=\"card\" style=\"width: 18rem\">\n");
      out.write("                <img style=\"height: 286px\" src=\"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT-coO6G2IuI734BMaQkhQk0NrYguFtEhJ8dw&s\" class=\"card-img-top\" alt=\"...\" />\n");
      out.write("                <div class=\"card-body\">\n");
      out.write("                  <h5 class=\"card-title\">Pancake</h5>\n");
      out.write("                  <div style=\"height: 100px\"><p class=\"card-text\">Lorem ipsum dolor sit amet consectetur, adipisicing elit. Iste, reprehenderit.</p></div>\n");
      out.write("\n");
      out.write("                  <div class=\"d-flex justify-content-between align-items-center\">\n");
      out.write("                    <div style=\"font-size: 26px; font-weight: 600; line-height: 20px; color: #e30019\">100$</div>\n");
      out.write("\n");
      out.write("                    <div class=\"text-center rounded-circle bg-danger\" style=\"margin-right: 20px; padding: 7px; height: 36px; width: 36px; cursor: pointer\">\n");
      out.write("                      <a style=\"color: white; width: 100%\" href=\"AddToCart?did=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${dish.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("&quantity=1\">\n");
      out.write("                        <i class=\"fa fa-shopping-cart\"></i>\n");
      out.write("                      </a>\n");
      out.write("                    </div>\n");
      out.write("                  </div>\n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"item\">\n");
      out.write("              <div class=\"card\" style=\"width: 18rem\">\n");
      out.write("                <img style=\"height: 286px\" src=\"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT-coO6G2IuI734BMaQkhQk0NrYguFtEhJ8dw&s\" class=\"card-img-top\" alt=\"...\" />\n");
      out.write("                <div class=\"card-body\">\n");
      out.write("                  <h5 class=\"card-title\">Pancake</h5>\n");
      out.write("                  <div style=\"height: 100px\"><p class=\"card-text\">Lorem ipsum dolor sit amet consectetur, adipisicing elit. Iste, reprehenderit.</p></div>\n");
      out.write("\n");
      out.write("                  <div class=\"d-flex justify-content-between align-items-center\">\n");
      out.write("                    <div style=\"font-size: 26px; font-weight: 600; line-height: 20px; color: #e30019\">100$</div>\n");
      out.write("\n");
      out.write("                    <div class=\"text-center rounded-circle bg-danger\" style=\"margin-right: 20px; padding: 7px; height: 36px; width: 36px; cursor: pointer\">\n");
      out.write("                      <a style=\"color: white; width: 100%\" href=\"AddToCart?did=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${dish.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("&quantity=1\">\n");
      out.write("                        <i class=\"fa fa-shopping-cart\"></i>\n");
      out.write("                      </a>\n");
      out.write("                    </div>\n");
      out.write("                  </div>\n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"item\">\n");
      out.write("              <div class=\"card\" style=\"width: 18rem\">\n");
      out.write("                <img style=\"height: 286px\" src=\"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT-coO6G2IuI734BMaQkhQk0NrYguFtEhJ8dw&s\" class=\"card-img-top\" alt=\"...\" />\n");
      out.write("                <div class=\"card-body\">\n");
      out.write("                  <h5 class=\"card-title\">Pancake</h5>\n");
      out.write("                  <div style=\"height: 100px\"><p class=\"card-text\">Lorem ipsum dolor sit amet consectetur, adipisicing elit. Iste, reprehenderit.</p></div>\n");
      out.write("\n");
      out.write("                  <div class=\"d-flex justify-content-between align-items-center\">\n");
      out.write("                    <div style=\"font-size: 26px; font-weight: 600; line-height: 20px; color: #e30019\">100$</div>\n");
      out.write("\n");
      out.write("                    <div class=\"text-center rounded-circle bg-danger\" style=\"margin-right: 20px; padding: 7px; height: 36px; width: 36px; cursor: pointer\">\n");
      out.write("                      <a style=\"color: white; width: 100%\" href=\"AddToCart?did=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${dish.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("&quantity=1\">\n");
      out.write("                        <i class=\"fa fa-shopping-cart\"></i>\n");
      out.write("                      </a>\n");
      out.write("                    </div>\n");
      out.write("                  </div>\n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"item\">\n");
      out.write("              <div class=\"card\" style=\"width: 18rem\">\n");
      out.write("                <img style=\"height: 286px\" src=\"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT-coO6G2IuI734BMaQkhQk0NrYguFtEhJ8dw&s\" class=\"card-img-top\" alt=\"...\" />\n");
      out.write("                <div class=\"card-body\">\n");
      out.write("                  <h5 class=\"card-title\">Pancake</h5>\n");
      out.write("                  <div style=\"height: 100px\"><p class=\"card-text\">Lorem ipsum dolor sit amet consectetur, adipisicing elit. Iste, reprehenderit.</p></div>\n");
      out.write("\n");
      out.write("                  <div class=\"d-flex justify-content-between align-items-center\">\n");
      out.write("                    <div style=\"font-size: 26px; font-weight: 600; line-height: 20px; color: #e30019\">100$</div>\n");
      out.write("\n");
      out.write("                    <div class=\"text-center rounded-circle bg-danger\" style=\"margin-right: 20px; padding: 7px; height: 36px; width: 36px; cursor: pointer\">\n");
      out.write("                      <a style=\"color: white; width: 100%\" href=\"AddToCart?did=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${dish.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("&quantity=1\">\n");
      out.write("                        <i class=\"fa fa-shopping-cart\"></i>\n");
      out.write("                      </a>\n");
      out.write("                    </div>\n");
      out.write("                  </div>\n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <!-- Bootstrap and Popper.js JavaScript -->\n");
      out.write("    <script\n");
      out.write("      src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js\"\n");
      out.write("      integrity=\"sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r\"\n");
      out.write("      crossorigin=\"anonymous\"\n");
      out.write("    ></script>\n");
      out.write("    <script\n");
      out.write("      src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js\"\n");
      out.write("      integrity=\"sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+\"\n");
      out.write("      crossorigin=\"anonymous\"\n");
      out.write("    ></script>\n");
      out.write("\n");
      out.write("    <!-- Owl Carousel JavaScript -->\n");
      out.write("    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js\"></script>\n");
      out.write("    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js\"></script>\n");
      out.write("    <script>\n");
      out.write("      $('.owl-carousel').owlCarousel({\n");
      out.write("        loop: true,\n");
      out.write("        margin: 10,\n");
      out.write("        nav: true,\n");
      out.write("        autoplay: false,\n");
      out.write("        autoplayTimeout: 1000,\n");
      out.write("        autoplayHoverPause: true,\n");
      out.write("        responsive: {\n");
      out.write("          0: {\n");
      out.write("            items: 1,\n");
      out.write("          },\n");
      out.write("          600: {\n");
      out.write("            items: 3,\n");
      out.write("          },\n");
      out.write("          1000: {\n");
      out.write("            items: 5,\n");
      out.write("          },\n");
      out.write("        },\n");
      out.write("      })\n");
      out.write("    </script>\n");
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
