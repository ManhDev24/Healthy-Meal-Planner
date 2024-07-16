/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.OrderDAO;
import dto.Account;
import dto.Cart;
import dto.Payment;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author NC
 */
public class PurchaseOrderServlet extends HttpServlet {

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
            Account acc = (Account) request.getSession().getAttribute("LoggedInUser");
            Cart cart = (Cart) request.getSession().getAttribute("cart");
            int paymentId = Integer.parseInt(request.getParameter("paymentId")); // Đảm bảo rằng tên biến là paymentId

            System.out.println("Logged in Account: " + acc);
            System.out.println("Cart: " + cart);
            System.out.println("Payment ID: " + paymentId);

            if (acc == null || cart == null) {
                response.sendRedirect("error.jsp"); // Xử lý khi thiếu dữ liệu trong session
                return;
            }
            boolean isSuccess = false;
            try {
                OrderDAO orderDAO = new OrderDAO();
                orderDAO.saveOrder(acc, cart, paymentId);
                // Nếu lưu đơn hàng thành công, tiến hành các bước sau đó
                cart.clearCart();
                request.getSession().setAttribute("cart", cart); // Cập nhật session với giỏ hàng đã xóa
                isSuccess = true;
                request.setAttribute("isSuccess", isSuccess);
                request.getRequestDispatcher("purchase.jsp").forward(request, response);
            } catch (Exception e) {
                // Xử lý khi có lỗi xảy ra trong quá trình lưu đơn hàng
                e.printStackTrace(); // In lỗi ra console để debug

                request.setAttribute("errorMessage", "Có lỗi xảy ra trong quá trình xử lý đơn hàng.");
                request.getRequestDispatcher("error.jsp").forward(request, response);
                request.setAttribute("isSuccess", isSuccess);
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
