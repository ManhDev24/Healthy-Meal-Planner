/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import dto.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import mylib.DBUtils;

/**
 *
 * @author NC
 */
public class CategoryDAO {

    public ArrayList<Category> getListDishCategory() {
        ArrayList<Category> list = new ArrayList<>();
        Connection cn = null;

        try {
            cn = DBUtils.makeConnection();
            String sql = "select * from Category";
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                int id = rst.getInt(1);
                String name = rst.getString(2);
                Category c = new Category(id, name);
                list.add(c);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
