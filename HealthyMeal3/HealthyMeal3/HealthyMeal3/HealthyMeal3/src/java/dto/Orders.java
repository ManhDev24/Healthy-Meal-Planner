/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.Date;

/**
 *
 * @author NC
 */
public class Orders {

    private int id;
    private Account account;
    private Date order_date;
    private Payment paymentMethod;
    private boolean status;
    private double totalPrice;

    public Orders() {
    }

    public Orders(int id, Account account, Date order_date, Payment paymentMethod, boolean status) {
        this.id = id;
        this.account = account;
        this.order_date = order_date;
        this.paymentMethod = paymentMethod;
        this.status = status;
    }

    public Orders(int id, Account account, Date order_date, Payment paymentMethod, boolean status, double totalPrice) {
        this.id = id;
        this.account = account;
        this.order_date = order_date;
        this.paymentMethod = paymentMethod;
        this.status = status;
        this.totalPrice = totalPrice;
    }

    public Orders(int id, Date order_date, boolean status, double totalPrice) {
        this.id = id;
        this.order_date = order_date;
        this.status = status;
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public Payment getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(Payment paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Orders{" + "id=" + id + ", account=" + account + ", order_date=" + order_date + ", paymentMethod=" + paymentMethod + ", status=" + status + ", totalPrice=" + totalPrice + '}';
    }

}
