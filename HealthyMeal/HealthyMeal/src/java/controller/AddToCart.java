/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DishesDAO;
import dto.Cart;
import dto.CartItem;
import dto.Dishes;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author NC
 */
public class AddToCart extends HttpServlet {

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
            HttpSession session = request.getSession();
            Object object = session.getAttribute("cart");
            Cart cart;
            if (object != null) {
                cart = (Cart) object;
            } else {
                cart = new Cart();
            }

            int dishesId = Integer.parseInt(request.getParameter("did"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));

            Dishes dish = new DishesDAO().getDishesById(dishesId);
            CartItem item = new CartItem(dish, quantity);
            cart.addItem(item);

            session.setAttribute("cart", cart);
            response.sendRedirect("MainController?action=foodct");

        }

//        try {
//            // Log the received parameters
//            System.out.println("Received parameters: did=" + request.getParameter("did") + ", quantity=" + request.getParameter("quantity"));
//
//            int dishesId = Integer.parseInt(request.getParameter("did"));
//            int quantity = Integer.parseInt(request.getParameter("quantity"));
//
//            // Log the parsed values
//            System.out.println("Parsed parameters: did=" + dishesId + ", quantity=" + quantity);
//
//            HttpSession session = request.getSession();
//            List<CartItem> items = new ArrayList<>();
//            Cart cart = (Cart) session.getAttribute("cart");
//            if (cart == null) {
//                cart = new Cart();
//            }
//
//            Dishes dish = new DishesDAO().getDishesById(dishesId);
//            if (dish != null) {
//                CartItem item = new CartItem(dish, quantity);
//                cart.addItem(item);
//                session.setAttribute("cart", cart);
//            }
//
//            response.sendRedirect("MainController?action=foodct");
//
//        } catch (NumberFormatException | NullPointerException e) {
//            e.printStackTrace(); // Log the exception for debugging
//            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid dish ID or quantity");
//        } catch (Exception e) {
//            e.printStackTrace(); // Log the exception for debugging
//            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while adding to cart");
//        }
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
