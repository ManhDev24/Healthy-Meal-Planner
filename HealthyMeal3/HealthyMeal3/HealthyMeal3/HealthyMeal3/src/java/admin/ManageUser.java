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
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author NC
 */
public class ManageUser extends HttpServlet {

    private final String MANAGE_USER_PAGE = "admin/admin_users.jsp";
    private final String INSERT_USER_PAGE = "admin/admin_user_insert.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = MANAGE_USER_PAGE;
        try {
            String action = request.getParameter("action");
            String search = request.getParameter("search") == null ? "" : request.getParameter("search");
            AccountDAO aDao = new AccountDAO();
            String currentPage = request.getParameter("index") == null ? "1" : request.getParameter("index");
            int index = Integer.valueOf(currentPage);
            int pageSize = 10;
            int totalRows = aDao.getCountFilterAccount("");
            int totalPage = 0;
            if (totalRows % pageSize == 0) {
                totalPage = totalRows / pageSize;
            } else {
                totalPage = totalRows / pageSize + 1;
            }
            if (action == null) {
                ArrayList<Account> list = aDao.FilterAccount(search, index, pageSize);
                request.setAttribute("index", index);
                request.setAttribute("toTalPage", totalPage);
                request.setAttribute("LISTUSERS", list);
                request.setAttribute("CURRENTSERVLET", "User");
            } else if (action.equals("Insert")) {
                url = INSERT_USER_PAGE;
            } else if (action.equals("Update")) {
                ArrayList<Account> list = aDao.getAllAccounts();
                request.setAttribute("CURRENTSERVLET", "User");
                request.setAttribute("LISTUSERS", list);
                url = MANAGE_USER_PAGE;
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
