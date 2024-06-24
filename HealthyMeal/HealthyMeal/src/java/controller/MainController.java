/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PC
 */
public class MainController extends HttpServlet {

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
            String ac = request.getParameter("action");
            if (ac == null) {
                ac = "welcome";
            }
            String url = "";
            switch (ac) {
                case "welcome":
                    url = "header.jsp";
                    break;
                case "Home":
                    url = "header.jsp";
                    break;
                case "loginpage":
                    url = "login.jsp";
                    break;
                case "registerpage":
                    url = "register.jsp";
                    break;
                case "register":
                    url = "RegisterServlet";
                    break;
                case "testfail":
                    url = "testfail.jsp";
                    break;
                case "testsc":
                    url = "testsc.jsp";
                    break;
                case "login":
                    url = "LoginServlet";
                    break;
                case "showmainpage":
                    url = "GetDishServlet";
                    break;
                case "foodct":
                    url = "GetDishServlet";
                    break;
                case "Cart":
                    url = "cart.jsp";
                    break;
                case "deleteCartItem":
                    url = "DeleteCartItem";
                    break;
                case "addToCart" :
                    url="AddToCart";
                     break;
                case "ViewCart":
                    url="ViewCart";
                    break;
            }
            request.getRequestDispatcher(url).forward(request, response);
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
