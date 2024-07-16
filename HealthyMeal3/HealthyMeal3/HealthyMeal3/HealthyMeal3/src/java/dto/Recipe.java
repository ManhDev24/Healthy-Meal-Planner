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
public class Recipe {

    private int dishId;
    private int totalCalories;

    public Recipe() {
    }

    public Recipe(int dishId, int totalCalories) {
        this.dishId = dishId;
        this.totalCalories = totalCalories;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public int getTotalCalories() {
        return totalCalories;
    }

    public void setTotalCalories(int totalCalories) {
        this.totalCalories = totalCalories;
    }

}
