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
public class Payment {

    private int paymentid;
    private String method;

    public Payment() {
    }

    public Payment(int paymentid, String method) {
        this.paymentid = paymentid;
        this.method = method;
    }


    public int getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(int paymentid) {
        this.paymentid = paymentid;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public String toString() {
        return "Payment{" + "paymentid=" + paymentid + ", method=" + method + '}';
    }

    
}
