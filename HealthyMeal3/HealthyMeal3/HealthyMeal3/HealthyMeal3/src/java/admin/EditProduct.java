package admin;

import dao.CategoryDAO;
import dao.DishesDAO;
import dto.Category;
import dto.Dishes;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditProduct extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final String EDIT_PAGE = "/admin/admin_edit_product.jsp";
    private static final String MANAGE_PRODUCT_CONTROLLER = "ManageProduct"; // Assuming this is your controller for managing products

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = "";
        try {
            String action = request.getParameter("action");
            if (action == null) {
                // Display edit form
                DishesDAO dishesDAO = new DishesDAO();
                CategoryDAO cDao = new CategoryDAO();
                int did = Integer.parseInt(request.getParameter("did"));
                Dishes dish = dishesDAO.getDishById2(did); // Fetch dish by ID

                // Set attributes to be used in the JSP
                request.setAttribute("pid", dish.getId());
                request.setAttribute("pname", dish.getName());
                request.setAttribute("pstock", dish.getNumber()); // Updated to getNumber()
                request.setAttribute("pprice", dish.getPrice());
                request.setAttribute("pdescription", dish.getDecreption());
                request.setAttribute("pimage", dish.getImgurl());
                request.setAttribute("preleasedate", dish.getDate());
                request.setAttribute("pcategoryid", dish.getCategoryId());
                request.setAttribute("did", did);

                // Get list of categories from DAO
                List<Category> categories = cDao.getListDishCategory();
                request.setAttribute("LIST_CATEGORIES", categories);

                url = EDIT_PAGE;
            } else if (action.equals("Update")) {
                // Handle update action
                url = MANAGE_PRODUCT_CONTROLLER;

                int pid = Integer.parseInt(request.getParameter("did"));
                String pname = request.getParameter("product_name");
                int pstock = Integer.parseInt(request.getParameter("product_stock")); // Changed to int for stock
                float pprice = Float.parseFloat(request.getParameter("product_price"));
                String pdescription = request.getParameter("product_description");
                String pimage = request.getParameter("product_image");
                int pcategoryid = Integer.parseInt(request.getParameter("category_id"));
                String dateString = request.getParameter("date");
                Date date = Date.valueOf(dateString);

             

                // Update dish using DishesDAO
                DishesDAO dishesDAO = new DishesDAO();
                Dishes dish = new Dishes(pid, pname, pprice, pdescription, pimage, date, pcategoryid, pstock);
                boolean result = dishesDAO.updateDish(dish);

                if (result) {
                    request.setAttribute("mess", "Edit successfully!");
                } else {
                    request.setAttribute("mess", "Edit failed!");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Forward request to appropriate JSP or servlet
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
        return "Short description";
    }
}
