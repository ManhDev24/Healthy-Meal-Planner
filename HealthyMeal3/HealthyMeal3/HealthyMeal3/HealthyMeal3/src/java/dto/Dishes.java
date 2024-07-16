/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.Date;

/**
 *
 * @author PC
 */
public class Dishes {

    private int id;
    private String name;
    private float price;
    private String decreption;
    private boolean status;
    private String imgurl;
    private Category category;
    private Date date;
    private int categoryId;
    private int number;

    public Dishes(int id, String name, float price, String decreption, boolean status, String imgurl) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.decreption = decreption;
        this.status = status;
        this.imgurl = imgurl;
    }

    public Dishes(int id, String name, float price, String decreption, boolean status, String imgurl, Category category, Date date, int categoryId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.decreption = decreption;
        this.status = status;
        this.imgurl = imgurl;
        this.category = category;
        this.date = date;
        this.categoryId = categoryId;
    }

    public Dishes(int id, String name, float price, String decreption, String imgurl, Date date, int categoryId, int number) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.decreption = decreption;
        this.imgurl = imgurl;
        this.date = date;
        this.categoryId = categoryId;
        this.number = number;
    }

    public Dishes(int id, String name, float price, String decreption, boolean status, String imgurl, Category category, Date date, int categoryId, int number) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.decreption = decreption;
        this.status = status;
        this.imgurl = imgurl;
        this.category = category;
        this.date = date;
        this.categoryId = categoryId;
        this.number = number;
    }

    public Dishes() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDecreption() {
        return decreption;
    }

    public void setDecreption(String decreption) {
        this.decreption = decreption;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    @Override
    public String toString() {
        return "Dishes{" + "id=" + id + ", name=" + name + ", price=" + price + ", decreption=" + decreption + ", status=" + status + ", imgurl=" + imgurl + ", category=" + category + ", date=" + date + ", categoryId=" + categoryId + '}';
    }

}
