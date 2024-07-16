package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("action");
        String url = "error.jsp"; // Default error page

        if (action == null || action.isEmpty()) {
            action = "welcome"; // Default action
        }

        switch (action) {
            case "welcome":
            case "Home":
                url = "GetDishesByCidHomePage";
                break;
            case "loginpage":
                url = "login.jsp";
                break;
            case "registerpage":
                url = "register.jsp";
                break;
            case "register":
                url = "RegisterServlet";
                break;
            case "testfail":
                url = "testfail.jsp";
                break;
            case "testsc":
                url = "testsc.jsp";
                break;
            case "login":
                url = "LoginServlet";
                break;
            case "logout":
                url = "LogoutServlet";
                break;
            case "showmainpage":
            case "foodct":
                url = "GetDishServlet";
                break;
            case "Cart":
                url = "cart.jsp";
                break;
            case "deleteCartItem":
                url = "DeleteCartItem";
                break;
            case "addDish":
                String did = request.getParameter("did");
                String quantity = request.getParameter("quantity");
                url = "AddToCart?did=" + did + "&quantity=" + quantity;
                break;
            case "viewCart":
                url = "ViewCart";
                break;
            case "aboutUs":
                url = "aboutUs.jsp";
                break;
            case "dishDetail":
                String dishId = request.getParameter("did");
                url = "GetDishDetail?did=" + dishId;
                break;
            case "adminHome":
                url = "AdminServlet";
                break;
            default:
                url = "error.jsp"; // Handle unknown actions
                break;
        }

        request.getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Main Controller Servlet";
    }
}
