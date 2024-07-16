package resetPassword;

import dao.DAOTokenForget;
import dao.AccountDAO;
import dto.Account;
import dto.TokenForgetPassword;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class requestPassword
 */
@WebServlet(name="requestPassword", urlPatterns={"/requestPassword"})
public class requestPassword extends HttpServlet {

    private static final long serialVersionUID = 1L;
   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public requestPassword() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("requestPassword.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        AccountDAO dao = new AccountDAO();
        String email = request.getParameter("email");

        // Check if email exists in the database
        Account acc = dao.getAccountForgot(email);
        if (acc == null) {
            request.setAttribute("mess", "Email không tồn tại");
            request.getRequestDispatcher("requestPassword.jsp").forward(request, response);
            return;
        }

        resetService service = new resetService();
        String token = service.generateToken();
        String linkReset = "http://localhost:8084/HealthyMeal/resetPassword?token=" + token;

        TokenForgetPassword newTokenForget = new TokenForgetPassword(
                acc.getId(), false, token, service.expireDateTime());
        System.out.println(newTokenForget + "testttttttt");
        // Ensure DAO Token Forget is properly instantiated
        DAOTokenForget daoToken = new DAOTokenForget();

        // Check if token was inserted successfully
        boolean isInsert = daoToken.insertTokenForget(newTokenForget);
        if (!isInsert) {
            request.setAttribute("mess", "Server error occurred while inserting token");
            request.getRequestDispatcher("requestPassword.jsp").forward(request, response);
            return;
        }

        // Send reset link to the email
        boolean isSend = service.sendEmail(email, linkReset, acc.getFullname());
        if (!isSend) {
            request.setAttribute("mess", "Unable to send reset request");
            request.getRequestDispatcher("requestPassword.jsp").forward(request, response);
            return;
        }

        request.setAttribute("mess", "Reset request sent successfully");
        request.getRequestDispatcher("requestPassword.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#getServletInfo()
     */
    public String getServletInfo() {
        return "Short description";
    }

}
