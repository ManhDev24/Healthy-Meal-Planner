/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author NC
 */
public class CartItem {

    private Dishes dishes;
    private int quantity;

    public CartItem() {
    }

    public CartItem(Dishes dishes, int quantity) {
        this.dishes = dishes;
        this.quantity = quantity;
    }

    public Dishes getDishes() {
        return dishes;
    }

    public void setDishes(Dishes dishes) {
        this.dishes = dishes;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartItem{" + "dishes=" + dishes + ", quantity=" + quantity + '}';
    }
    

}
