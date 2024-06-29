/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CategoryDAO;
import dao.DishesDAO;
import dto.Category;
import dto.Dishes;
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
public class GetDishServlet extends HttpServlet {

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
        String search = request.getParameter("search") == null ? "" : request.getParameter("search");
        String cid = request.getParameter("cid") == null ? "" : request.getParameter("cid");
        String min = request.getParameter("min") == null ? "" : request.getParameter("min");
        String max = request.getParameter("max") == null ? "" : request.getParameter("max");
        String sortType = request.getParameter("sortType") == null ? "" : request.getParameter("sortType");
        String date = request.getParameter("date") == null ? "" : request.getParameter("date");
        String currentPage = request.getParameter("index") == null ? "1" : request.getParameter("index");
        System.out.println("CurrentPage:" + currentPage);
        String status = request.getParameter("status") == null ? "" : request.getParameter("status");
        int index = Integer.valueOf(currentPage);
        System.out.println("index:" + index);
        int pageSize = 8;
        int totalRows = new DishesDAO().getCountFilterDisheses("", "", "", "", "");
        int totalPage = 0;
        if (totalRows % pageSize == 0) {
            totalPage = totalRows / pageSize;
        } else {
            totalPage = totalRows / pageSize + 1;
        }
        ArrayList<Category> cl = new CategoryDAO().getListDishCategory();
        ArrayList<Dishes> dl = new DishesDAO().getFilterDisheses(search, cid, min, max, status, sortType, date, index, pageSize);
        request.setAttribute("cl", cl);
        request.setAttribute("ListItems", dl);
        request.setAttribute("index", index);
        request.setAttribute("toTalPage", totalPage);
        request.getRequestDispatcher("foodShow.jsp?dishname=").forward(request, response);

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
