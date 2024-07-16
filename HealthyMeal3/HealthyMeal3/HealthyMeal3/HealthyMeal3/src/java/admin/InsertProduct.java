package admin;

import dao.DishesDAO;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertProduct extends HttpServlet {

    private static final String INSERT_PAGE = "admin/admin_products_insert.jsp";
    private static final String MANAGE_PRODUCT_CONTROLLER = "ManageProduct";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        DishesDAO dDao = new DishesDAO();
        String action = request.getParameter("action");
        String url = INSERT_PAGE;
        try {
            if (action.isEmpty()) {
                String name = request.getParameter("product_name"); //
                String price_raw = request.getParameter("price");
                double price = Double.valueOf(price_raw); // 
                String description = request.getParameter("description"); //
                String cid_raw = request.getParameter("category_id");
                int categoryId = Integer.valueOf(cid_raw); // 
                String stock = request.getParameter("stock");
                int number = Integer.valueOf(stock); //
                String imageUrl = request.getParameter("product_image");//
                String releaseDate = request.getParameter("date");
                Date date = Date.valueOf(releaseDate);//

                dDao.insertDish(name, price, description, imageUrl, date, categoryId, number);
                request.setAttribute("mess", "Insert successfully!");
                url = MANAGE_PRODUCT_CONTROLLER;

            }

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
        return "Insert Product Servlet";
    }
}
