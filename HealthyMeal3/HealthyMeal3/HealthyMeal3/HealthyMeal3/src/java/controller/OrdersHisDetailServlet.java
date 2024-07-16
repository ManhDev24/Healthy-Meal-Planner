/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.OrderDAO;
import dao.OrderDetailDAO;
import dto.OrderDetail;
import dto.Orders;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PC
 */
public class OrdersHisDetailServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
    private static final String ORDER_DETAIL_PAGE = "/admin/admin_order_detail.jsp";
    private static final String ERROR_PAGE = "/error.jsp";
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
                   response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("action");
        if ("showdetail".equals(action)) {
            int billId = Integer.valueOf(request.getParameter("bill_id"));
            try {
                // Retrieve order details
                System.out.println("bill id is: " + billId);
                Orders order = new OrderDAO().getOrdersById(billId);
                if (order != null) {
                    int orderId = order.getId();
                    ArrayList<OrderDetail> orderDetails = new OrderDetailDAO().getOrderItemByOrderId(orderId);
                    request.setAttribute("LIST_PRODUCTS_IN_ORDER", orderDetails);
                    request.getRequestDispatcher("orderdetailhis.jsp").forward(request, response);
                } else {
                    // Handle case where order is not found
                    request.setAttribute("error_message", "Order not found");
                    request.getRequestDispatcher(ERROR_PAGE).forward(request, response);
                }
            } catch (Exception e) {
                // Handle any exceptions
                e.printStackTrace();
                request.setAttribute("error_message", "Error retrieving order details");
                request.getRequestDispatcher(ERROR_PAGE).forward(request, response);
            }
        } else {
            // Handle unknown action parameter
            request.setAttribute("error_message", "Unknown action");
            request.getRequestDispatcher(ERROR_PAGE).forward(request, response);
        }
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
