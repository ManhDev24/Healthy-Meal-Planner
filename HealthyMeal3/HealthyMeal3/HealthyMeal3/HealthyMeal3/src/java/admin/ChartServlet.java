package admin;

import dao.OrderDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChartServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private OrderDAO orderDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        // Initialize DAO or any necessary resources
        orderDAO = new OrderDAO();
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

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            // Fetching revenue data by year
            double year2018 = orderDAO.getTotalMoneyByYear(2018);
            double year2019 = orderDAO.getTotalMoneyByYear(2019);
            double year2020 = orderDAO.getTotalMoneyByYear(2020);
            double year2021 = orderDAO.getTotalMoneyByYear(2021);
            double year2022 = orderDAO.getTotalMoneyByYear(2022);
            double year2023 = orderDAO.getTotalMoneyByYear(2023);
            double year2024 = orderDAO.getTotalMoneyByYear(2024);

            // Fetching revenue data by month
            double month1 = orderDAO.getTotalMoneyByMonth(1);
            double month2 = orderDAO.getTotalMoneyByMonth(2);
            double month3 = orderDAO.getTotalMoneyByMonth(3);
            double month4 = orderDAO.getTotalMoneyByMonth(4);
            double month5 = orderDAO.getTotalMoneyByMonth(5);
            double month6 = orderDAO.getTotalMoneyByMonth(6);
            double month7 = orderDAO.getTotalMoneyByMonth(7);
            double month8 = orderDAO.getTotalMoneyByMonth(8);
            double month9 = orderDAO.getTotalMoneyByMonth(9);
            double month10 = orderDAO.getTotalMoneyByMonth(10);
            double month11 = orderDAO.getTotalMoneyByMonth(11);
            double month12 = orderDAO.getTotalMoneyByMonth(12);

            // Setting attributes in request scope
            request.setAttribute("YEAR18", year2018);
            request.setAttribute("YEAR19", year2019);
            request.setAttribute("YEAR20", year2020);
            request.setAttribute("YEAR21", year2021);
            request.setAttribute("YEAR22", year2022);
            request.setAttribute("YEAR23", year2023);
            request.setAttribute("YEAR24", year2024);

            request.setAttribute("MONTH1", month1);
            request.setAttribute("MONTH2", month2);
            request.setAttribute("MONTH3", month3);
            request.setAttribute("MONTH4", month4);
            request.setAttribute("MONTH5", month5);
            request.setAttribute("MONTH6", month6);
            request.setAttribute("MONTH7", month7);
            request.setAttribute("MONTH8", month8);
            request.setAttribute("MONTH9", month9);
            request.setAttribute("MONTH10", month10);
            request.setAttribute("MONTH11", month11);
            request.setAttribute("MONTH12", month12);

            // Forwarding request to JSP
            request.setAttribute("CURRENTSERVLET", "Chart");
            request.getRequestDispatcher("/admin/admin_chart.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            // Properly handle exceptions (log or send error response)
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error fetching chart data");
        }
    }

    @Override
    public String getServletInfo() {
        return "Chart Servlet";
    }

    @Override
    public void destroy() {
        // Cleanup resources if necessary
        orderDAO = null;
        super.destroy();
    }
}
