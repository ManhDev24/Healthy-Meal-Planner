/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylib;

import dao.DishesDAO;
import dto.Dishes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PC
 */
public class WishlistUtils {
    private static HashMap<Integer, Dishes> listItemsInWishlist = new HashMap<>();
    
    public HashMap<Integer, Dishes> createWishlist(Dishes item) {
        listItemsInWishlist = new HashMap<>();
        listItemsInWishlist.put(item.getId(), item);
        return listItemsInWishlist;
    }
    public HashMap<Integer, Dishes> addItemToWishlist(Dishes item) {
        if (!checkItemExist(item)) {
            listItemsInWishlist.put(item.getId(), item);
        }
        return listItemsInWishlist;
    }
    public boolean checkItemExist(Dishes product) {
        for (Integer id : listItemsInWishlist.keySet()) {
            if (product.getId() == id) {
                return true;
            }
        }
        return false;
    }
     public HashMap<Integer, Dishes> removeItem(Dishes product) {
        if (listItemsInWishlist.containsKey(product.getId())) {
            listItemsInWishlist.remove(product.getId());
        }
        return listItemsInWishlist;
    }
     public Cookie getCookieByName(HttpServletRequest request, String cookieName) {
        Cookie[] arrCookies = request.getCookies();
        if (arrCookies != null) {
            for (Cookie cookie : arrCookies) {
                if (cookie.getName().equals(cookieName)) {
                    return cookie;
                }
            }
        }
        return null;
    }
     public void saveWishlistToCookie(HttpServletRequest request,
            HttpServletResponse response, String strItemsInWishList) {
        String cookieName = "Wishlist";

        Cookie cookieCart = getCookieByName(request, cookieName);

        if (cookieCart != null) {

            cookieCart.setValue(strItemsInWishList);

        } else {

            cookieCart = new Cookie(cookieName, strItemsInWishList);

        }

        cookieCart.setMaxAge(60 * 60 * 24 * 30 * 3);

        response.addCookie(cookieCart);

    }
     
     public String convertToString() {
        List<Dishes> list = new ArrayList<>(listItemsInWishlist.values());
        String result = "";
        for (Dishes productDTO : list) {
            result += productDTO.getId() + ",";
        }
        return result;

    }
     
     public List<Dishes> getWishlistFromCookie(Cookie cookieWishlist) {
        DishesDAO pDao = new DishesDAO();
        List<Dishes> listItemsCart = new ArrayList<>();
        String inputString = cookieWishlist.getValue();
        if (inputString.endsWith(",")) {
            inputString = inputString.substring(0, inputString.length() - 1);
        }

        if (inputString.length() > 0) {
            // Chia chuỗi thành các phần tử
            String[] elements = inputString.split(",");
  
            for (int i = 0; i < elements.length; i++) {
                Dishes product = pDao.getDishesById(Integer.parseInt(elements[i].trim()));
                listItemsCart.add(product);
            }
        }
        // add to util
        for (Dishes productDTO : listItemsCart) {
            addItemToWishlist(productDTO);
        }

        return listItemsCart;
    }
}
