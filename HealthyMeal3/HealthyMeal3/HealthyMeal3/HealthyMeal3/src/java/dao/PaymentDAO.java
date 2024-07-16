/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Payment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import mylib.DBUtils;

/**
 *
 * @author NC
 */
public class PaymentDAO {

    public ArrayList<Payment> getAllPayments() {
        ArrayList<Payment> list = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            String sql = "  select * from Payment";
            PreparedStatement pts = cn.prepareStatement(sql);
            ResultSet rs = pts.executeQuery();
            while (rs.next()) {
                Payment p = new Payment(rs.getInt(1), rs.getString(2));

                list.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public Payment getPaymentById(int paymentId) {
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();

            String sql = "  select * from Payment p\n"
                    + " where p.paymentid = ? ";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, paymentId);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Payment p = new Payment(rs.getInt(1), rs.getString(2));
                return p;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
