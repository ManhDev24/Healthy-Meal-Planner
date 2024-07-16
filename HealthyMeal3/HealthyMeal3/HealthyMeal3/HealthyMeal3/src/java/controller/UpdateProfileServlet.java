package controller;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import dao.AccountDAO;
import dto.Account;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@WebServlet(name = "UpdateProfileServlet", urlPatterns = {"/UpdateProfileServlet"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50)   // 50MB
public class UpdateProfileServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            String action = request.getParameter("action");
            // Retrieve logged-in user account from session
            Account acc = (Account) session.getAttribute("LoggedInUser");
            if (acc == null) {
                throw new IllegalArgumentException("User not found in session");
            }

            // Retrieve updated profile information from request parameters or use existing values
            String email = request.getParameter("txtemail");
            if (email == null || email.isEmpty()) {
                email = acc.getEmail();
            }
            String fullName = request.getParameter("txtfullname");
            if (fullName == null || fullName.isEmpty()) {
                fullName = acc.getFullname();
            }
            String phone = request.getParameter("txtphone");
            if (phone == null || phone.isEmpty()) {
                phone = acc.getPhone();
            }
            String address = request.getParameter("txtaddress");
            if (address == null || address.isEmpty()) {
                address = acc.getAddress();
            }

            int id = acc.getId(); // Now it's safe to access acc.getId() after null check
            // Check if a file was uploaded

            // Update account information in the database
            AccountDAO dao = new AccountDAO();
            boolean updateStatus = dao.updateAccount(email, fullName, phone, address, id);
            Account updatedAccount = dao.getAccount(id); // Retrieve updated account details

            // Update session attributes with updated account and update status
            session.setAttribute("updateStatus", updateStatus);
            session.setAttribute("LoggedInUser", updatedAccount);

            // Redirect to profile.jsp after updating profile
            if (action.equals("profile")) {
                response.sendRedirect("profile.jsp");
            } else if (action.equals("checkout")) {
                response.sendRedirect("checkout.jsp");

            }
        } catch (IOException | IllegalArgumentException e) {
            // Handle any exceptions that might occur during processing
            // For simplicity, you might want to log the exception
            e.printStackTrace(); // Replace with appropriate logging mechanism
            // Optionally, redirect to an error page or handle differently based on your application's requirements
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while updating profile.");
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
        return "Update Profile Servlet";
    }

}
