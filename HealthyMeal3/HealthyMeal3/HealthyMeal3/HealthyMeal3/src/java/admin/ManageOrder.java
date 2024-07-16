package admin;

import dao.OrderDAO;
import dao.OrderDetailDAO;
import dto.OrderDetail;
import dto.Orders;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ManageOrder extends HttpServlet {

    private static final String ORDER_DETAIL_PAGE = "admin/admin_order_detail.jsp";
    private static final String ERROR_PAGE = "/error.jsp";
    private final static String CHANGE_STATUS = "changeStatus";
    private final static String ORDER_PAGE = "admin/admin_order.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ORDER_PAGE;
        try {
            OrderDAO oDao = new OrderDAO();
            OrderDetailDAO odDao = new OrderDetailDAO();
            String action = request.getParameter("action");
            String search = request.getParameter("search") == null ? "" : request.getParameter("search");
            String currentPage = request.getParameter("index") == null ? "1" : request.getParameter("index");
            int index = Integer.valueOf(currentPage);
            int pageSize = 10;
            int totalRows = oDao.getCountOrderFilter();
            int totalPage = 0;
            if (totalRows % pageSize == 0) {
                totalPage = totalRows / pageSize;
            } else {
                totalPage = totalRows / pageSize + 1;
            }
            ArrayList<Orders> listOrders = oDao.getAllOrdersFilter(search, index, pageSize);
            if ("showdetail".equals(action)) {
                url = ORDER_DETAIL_PAGE;
                String bill_id_raw = request.getParameter("bill_id");
                System.out.println("Bill ID raw: " + bill_id_raw);
                int bill_id = Integer.valueOf(bill_id_raw);
                System.out.println("Bill ID: " + bill_id);
                Orders order = oDao.getOrdersById(bill_id);
                System.out.println("Order: " + order);
                int id = order.getId();
                System.out.println("Order ID from order: " + id);
                ArrayList<OrderDetail> list = odDao.getOrderItemByOrderId(id);
                System.out.println("This is list in showdetail: " + list);
                request.setAttribute("LIST_PRODUCTS_IN_ORDER", list);
            } else if (CHANGE_STATUS.equals(action)) {
                int id = Integer.valueOf(request.getParameter("id"));
                System.out.println("-----------");
                System.out.println("THis is change id :" + id);
                System.out.println("-----------");
                oDao.toggleOrderStatus(id);
            }
            request.setAttribute("CURRENTSERVLET", "Order");
            request.setAttribute("LIST_ORDERS", listOrders);
            request.setAttribute("index", index);
            request.setAttribute("toTalPage", totalPage);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            request.getRequestDispatcher(url).forward(request, response);

        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Manage Order Servlet";
    }
}
