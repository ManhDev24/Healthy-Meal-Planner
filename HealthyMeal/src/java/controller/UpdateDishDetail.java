/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DishesDAO;
import dao.RecipeDAO;
import dto.Dishes;
import dto.Recipe;
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
public class UpdateDishDetail extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String dishIdParam = request.getParameter("did");
            String quantityParam = request.getParameter("quantity");

            int dishId = Integer.parseInt(dishIdParam);
            int quantity = Integer.parseInt(quantityParam);

            // Tính tổng calories mới dựa trên dishId và quantity
            RecipeDAO recipeDAO = new RecipeDAO();
            int totalCalories = recipeDAO.getTotalCaloriesForDish(dishId, quantity);

            // Lưu các thông tin cần thiết vào request để hiển thị trên JSP
            Dishes nd = new DishesDAO().getDishesById(dishId);
            Recipe recipe = new Recipe(dishId, totalCalories);
            request.setAttribute("nd", nd);
            request.setAttribute("calo", recipe);
            request.setAttribute("quantity", quantity); // Đặt lại thuộc tính quantity

            // Forward đến trang hiển thị chi tiết món ăn
            request.getRequestDispatcher("DishDetail.jsp").forward(request, response);

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
