/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Dishes;
import dto.Recipe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import mylib.DBUtils;

/**
 *
 * @author NC
 */
public class RecipeDAO {

    public int getTotalCaloriesForDish(int dishId, int quantity) {
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            String sql = "SELECT d.id, d.name, SUM(i.calories) AS total_calories\n"
                    + "FROM Dishes d \n"
                    + "JOIN Recipe r  ON d.id = r.dish_id\n"
                    + "JOIN Ingredients i ON r.ingredien_id = i.id\n"
                    + "where d.id =  ? \n"
                    + "GROUP BY d.id, d.name;";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, dishId);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int totalCalories = rs.getInt("total_calories");
                return totalCalories * quantity;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
