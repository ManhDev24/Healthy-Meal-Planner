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
public class GetDishDetail extends HttpServlet {

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
        try {
            String didParam = request.getParameter("did");
            int did = Integer.parseInt(didParam);

            // Fetch dish details
            Dishes nd = new DishesDAO().getDishesById(did);

            // Calculate calories based on quantity (default to 1 if not provided)
            String quantityParam = request.getParameter("quantity");

            // Check if quantityParam is not null and not empty
            int quantity = 1; // Default value
            if (quantityParam != null && !quantityParam.isEmpty()) {
                try {
                    quantity = Integer.parseInt(quantityParam);
                } catch (NumberFormatException e) {
                    // Handle the exception (e.g., log it, set a default value, etc.)
                    // Here we set a default value of 1 if parsing fails
                    quantity = 1;
                }
            }
            request.setAttribute("quantity", quantity);

            // Calculate calories
            int calories = new RecipeDAO().getTotalCaloriesForDish(did, quantity);

            // Set attributes for JSP
            System.out.println("Dish ID: " + did);
            System.out.println("Dish Name: " + nd.getName());
            System.out.println("Calories: " + calories);
            request.setAttribute("calo", calories);
            request.setAttribute("nd", nd);

            // Forward to JSP
            request.getRequestDispatcher("DishDetail.jsp").forward(request, response);
        } catch (NumberFormatException | ServletException | IOException e) {
            // Handle exceptions
            e.printStackTrace();
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
