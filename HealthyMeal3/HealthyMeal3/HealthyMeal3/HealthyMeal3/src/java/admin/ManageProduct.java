/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import dao.CategoryDAO;
import dao.DishesDAO;
import dto.Category;
import dto.Dishes;
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
public class ManageProduct extends HttpServlet {
    
    private final String PRODUCT_PAGE = "admin/admin_products.jsp";
    private final String INSERT_PRODUCT_PAGE = "admin/admin_products_insert.jsp";
    private final String INSERT = "Insert";
    private final String DELETE_PRODUCT_CONTROLLER = "DeleteProduct";
    private final String INSERT_PRODUCT_CONTROLLER = "InsertProduct";
    private final String Delete = "Delete";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String url = PRODUCT_PAGE;
        String search = request.getParameter("search") == null ? "" : request.getParameter("search");
        String currentPage = request.getParameter("index") == null ? "1" : request.getParameter("index");
        int index = Integer.valueOf(currentPage);
        int pageSize = 10;
        int totalRows = new DishesDAO().getCountFilterDisheses("", "", "", "", "");
        int totalPage = 0;
        if (totalRows % pageSize == 0) {
            totalPage = totalRows / pageSize;
        } else {
            totalPage = totalRows / pageSize + 1;
        }
        try {
            String action = request.getParameter("action");
            DishesDAO dDao = new DishesDAO();
            ArrayList<Category> c = new CategoryDAO().getListDishCategory();
            request.setAttribute("LIST_CATEGORIES", c);
            ArrayList<Dishes> listDishes = dDao.getAllDishesFilter(search, index, pageSize);
            if (action == null) {
                request.setAttribute("LIST_PRODUCTS", listDishes);
                request.setAttribute("index", index);
                request.setAttribute("toTalPage", totalPage);
            } else if (action.equals("Insert")) {
                url = INSERT_PRODUCT_PAGE;
            } else if (action.equals("Update")) {
                request.setAttribute("LIST_PRODUCTS", listDishes);
                request.setAttribute("CURRENTSERVLET", "User");
                url = PRODUCT_PAGE;
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
