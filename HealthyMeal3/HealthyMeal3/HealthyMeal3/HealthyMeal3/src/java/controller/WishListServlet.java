/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DishesDAO;
import dto.Dishes;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mylib.WishlistUtils;

/**
 *
 * @author PC
 */
public class WishListServlet extends HttpServlet {
        private static final String WISHLIST_PAGE = "customeMenu.jsp";
        private static final String MAINPAGE_STRING = "GetDishServlet";
        
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
        DishesDAO d = new DishesDAO();
            WishlistUtils wUtil = new WishlistUtils();
            String url = MAINPAGE_STRING;
            List<Dishes> wishList = null;
            HashMap<Integer, Dishes> listitem = null;
        try  {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession();
            String action = request.getParameter("action");
            if(action==null){
                url=WISHLIST_PAGE;
            }else{
                String dishID=request.getParameter("did");
                Dishes dish = d.getDishesById(Integer.parseInt(dishID));
                if("add".equals(action)){
                    wishList = (List<Dishes>) session.getAttribute("WISHLIST");
                    if (wishList==null) {
                        listitem=wUtil.createWishlist(dish);
                    }else{
                        listitem=wUtil.addItemToWishlist(dish);
                    }
                }else if("delete".equals(action)){
                    url=WISHLIST_PAGE;
                    listitem=wUtil.removeItem(dish);
                }
            }
            // save to banh quy
            wishList=new ArrayList<>(listitem.values());
            session.setAttribute("WISHLIST", wishList);
            
            String strItemWish = wUtil.convertToString();
            wUtil.saveWishlistToCookie(request, response, strItemWish);
        }catch (Exception ex){
            log("WishlistServlet error:" + ex.getMessage());
        }finally{
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
