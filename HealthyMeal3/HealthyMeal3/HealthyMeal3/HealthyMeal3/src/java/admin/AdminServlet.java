/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import dao.AccountDAO;
import dao.DishesDAO;
import dao.OrderDAO;
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
 * @author NC
 */
public class AdminServlet extends HttpServlet {

    private static final String ADMIN = "admin/admin-homepage.jsp";
    private final static String ORDER_DETAIL_PAGE = "admin/admin_order_detail.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AdminServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        AccountDAO acc = new AccountDAO();
        DishesDAO ds = new DishesDAO();
        OrderDAO od = new OrderDAO();
        String url = ADMIN;
        try {
            int totalUsers = acc.getTotalUsers();
            int totalDishes = ds.gettotalOfDishes();
            int totalOrders = od.getTotalOrder();
            ArrayList<Orders> lastRencentOrder = od.getRecentOrders();
            System.out.println("lastRencentOrder" + lastRencentOrder);
            int lowQuantityDishes = ds.getDishLowQuantity();
            request.setAttribute("DISHESLOW", lowQuantityDishes);
            request.setAttribute("TOTALUSERS", totalUsers);
            request.setAttribute("TOTALDISHES", totalDishes);
            request.setAttribute("TOTALORDERS", totalOrders);
            request.setAttribute("LAST_RECENT_ORDER", lastRencentOrder);
            String action = request.getParameter("showdetail");
            if ("showdetail".equals(action)) {
                url = ORDER_DETAIL_PAGE;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            request.getRequestDispatcher(ADMIN).forward(request, response);
        }

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
