/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NC
 */
public class Cart {

    private List<CartItem> items;
    private float toTal;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public Cart(List<CartItem> items) {
        this.items = items;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    public float getToTal() {
        return toTal;
    }

    public void setToTal(float toTal) {
        this.toTal = toTal;
    }

    private CartItem getItemById(int id) {
        for (CartItem item : items) {
            if (item.getDishes().getId() == id) {
                return item;
            }
        }
        return null;
    }

    private boolean checkExist(int id) {
        for (CartItem item : items) {
            if (item.getDishes().getId() == id) {
                return true;
            }
        }
        return false;
    }

    public void addItem(CartItem item) {
        if (checkExist(item.getDishes().getId())) {
            CartItem oldItem = getItemById(item.getDishes().getId());
            oldItem.setQuantity(oldItem.getQuantity() + item.getQuantity());
        } else {
            items.add(item);
        }
    }

    public void removeItem(int id) {
        if (getItemById(id) != null) {
            items.remove(getItemById(id));
        }
    }

    public void updateItem(CartItem item) {
        if (checkExist(item.getDishes().getId())) {
            if (item.getQuantity() == 0) {
                items.remove(getItemById(item.getDishes().getId()));
            } else {
                CartItem oldItem = getItemById(item.getDishes().getId());
                oldItem.setQuantity(item.getQuantity());
            }
        }

    }

    public float getTotalPrice() {
        float totalPrice = 0;
        for (CartItem item : items) {
            totalPrice += item.getQuantity() * item.getDishes().getPrice();
        }
        return (float) (Math.round(totalPrice * 100.0) / 100.0); // Làm tròn đến 2 chữ số thập phân

    }
}
