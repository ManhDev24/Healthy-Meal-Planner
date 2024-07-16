package controller;

import dao.AccountDAO;
import dto.Account;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("txtemail");
        String password = request.getParameter("txtpassword");

        if (email != null && password != null) {
            AccountDAO dao = new AccountDAO();
            Account acc = dao.getAccount(email, password);

            if (acc != null && acc.isStatus()) {
               
                HttpSession session = request.getSession();
                session.setAttribute("LoggedInUser", acc);   

                if (acc.isRole()) {
                    response.sendRedirect(request.getContextPath() + "/MainController?action=showmainpage");
                } else {
                    request.getRequestDispatcher("ViewAdmin").forward(request, response);
                }
            } else {
                // Invalid credentials
                String errorMsg = "Invalid email or password. Please try again.";
                
            
                response.sendRedirect(request.getContextPath() + "/MainController?action=loginpage&error=" + errorMsg);
            }
        } else {
            // Missing email or password parameters
            String errorMsg = "Please provide both email and password.";
            request.setAttribute("mess", "Invalid email or password. Please try again.");
//            request.getRequestDispatcher("MainController?action=loginpage");
            response.sendRedirect(request.getContextPath() + "/MainController?action=loginpage&error=" + errorMsg);
        }
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
        return "LoginServlet";
    }
}
