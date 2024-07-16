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
public class EditUser extends HttpServlet {

    private static final String EDIT_PAGE = "/admin/admin_edit_user.jsp";
    private static final String MANAGE_USER_CONTROLLER = "ManageUser";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        AccountDAO aDao = new AccountDAO();
        String url = "";
        try {
            String action = request.getParameter("action");
            if (action == null) {
                int acid = Integer.valueOf(request.getParameter("acid"));
                Account acc = aDao.getAccount(acid);
                request.setAttribute("acid", acid);  // Set acid attribute
                request.setAttribute("email", acc.getEmail());
                request.setAttribute("fullname", acc.getFullname());
                request.setAttribute("phone", acc.getPhone());
                request.setAttribute("roleid", acc.isRole());
                request.setAttribute("address", acc.getAddress());
                request.setAttribute("avatar", acc.getAvatar());
                url = EDIT_PAGE;
            } else if (action.equals("Update")) {
                url = MANAGE_USER_CONTROLLER;

                String email = request.getParameter("email");
                String fullname = request.getParameter("fullname");
                String phone = request.getParameter("phone");
                String address = request.getParameter("address");
                String avatar = request.getParameter("avatar");
                String permission = request.getParameter("permission");

                boolean role = (permission.equals("True") ? false : true);
                String acidStr = request.getParameter("acid");
                int acid = Integer.parseInt(acidStr);
                if (avatar == null || avatar.isEmpty()) {
                    avatar = "https://d29fhpw069ctt2.cloudfront.net/icon/image/84587/preview.svg";
                }
                if (acidStr != null && !acidStr.isEmpty()) {
                    boolean result = aDao.updateAccountByAdmin(email, fullname, phone, address, role, avatar, acid);

                    if (result) {
                        request.setAttribute("mess", "Edit successfully!");
                    } else {
                        request.setAttribute("mess", "Edit failed!");
                    }
                } else {
                    request.setAttribute("mess", "Invalid account ID!");
                }
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
