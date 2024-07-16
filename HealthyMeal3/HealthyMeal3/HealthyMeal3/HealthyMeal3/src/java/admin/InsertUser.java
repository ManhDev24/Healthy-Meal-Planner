/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import dao.AccountDAO;
import dto.Account;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author NC
 */
public class InsertUser extends HttpServlet {

    private static final String MANAGE_USER_CONTROLLER = "ManageUser";
    private static final String INSERT_USER_PAGE = "admin/admin_user_insert.jsp";
    String url = MANAGE_USER_CONTROLLER;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            /* TODO output your page here. You may use following sample code. */
            AccountDAO aDao = new AccountDAO();
            String fullname = request.getParameter("fullname").trim();
            String email = request.getParameter("email").trim();
            String password = request.getParameter("password").trim();
            String address = request.getParameter("address").trim();
            String phone = request.getParameter("phone").trim();
            String avatar = request.getParameter("avatar").trim();
            boolean role = "admin".equals(request.getParameter("role")) ? false : true;
            if (aDao.checkAccountDuplicate(email)) {
                request.setAttribute("error", "Email is dupicated !");
                url = INSERT_USER_PAGE;

            } else {
                if (avatar == null || avatar.isEmpty()) {
                    avatar = "https://d29fhpw069ctt2.cloudfront.net/icon/image/84587/preview.svg";
                }
                Account acc = new Account(0, email, password, fullname, phone, address, role, avatar);
                aDao.registerAccount(acc);
                request.setAttribute("mess", "Insert successfully!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            request.getRequestDispatcher(url).forward(request, response);

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
