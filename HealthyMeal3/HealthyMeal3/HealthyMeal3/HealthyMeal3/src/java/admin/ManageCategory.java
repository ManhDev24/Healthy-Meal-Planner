/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import dao.CategoryDAO;
import dto.Category;
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
public class ManageCategory extends HttpServlet {

    private static final String MANAGE_CATEGORY_PAGE = "admin/admin_categories.jsp";
    private static final String INSERT_CATEGORY_PAGE = "admin/admin_categories_insert.jsp";
    private static final String UPDATE_CATEGORY_SERVLET = "EditCategory";
    private static final String INSERT = "Insert";
    private static final String UPDATE = "Update";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = MANAGE_CATEGORY_PAGE;
        try {
            CategoryDAO cDao = new CategoryDAO();
            String action = request.getParameter("action");
            if (INSERT.equals(action)) {
                url = INSERT_CATEGORY_PAGE;
            }
            String search = request.getParameter("search") == null ? "" : request.getParameter("search");
            String currentPage = request.getParameter("index") == null ? "1" : request.getParameter("index");
            int index = Integer.valueOf(currentPage);
            int pageSize = 10;
            int totalRows = cDao.getCountFilterCategory();
            int totalPage = 0;
            if (totalRows % pageSize == 0) {
                totalPage = totalRows / pageSize;
            } else {
                totalPage = totalRows / pageSize + 1;
            }

            ArrayList<Category> list = cDao.getCategoryFilter(search, index, pageSize);
            System.out.println("list" + list);
            request.setAttribute("LIST_CATEGORIES", list);
            request.setAttribute("index", index);
            request.setAttribute("toTalPage", totalPage);
            request.setAttribute("CURRENTSERVLET", "Category");

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
