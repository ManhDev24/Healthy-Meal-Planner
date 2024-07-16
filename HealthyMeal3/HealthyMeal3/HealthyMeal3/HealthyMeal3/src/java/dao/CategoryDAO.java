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

    public ArrayList<Category> getCategoryFilter(String search, int index, int pageSize) {
        Connection cn = null;
        ArrayList<Category> list = new ArrayList<>();
        try {
            cn = DBUtils.makeConnection();
            String sql = "SELECT * FROM Category WHERE name LIKE ? ORDER BY Id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, "%" + search + "%"); // Adding '%' for SQL LIKE wildcard
            pst.setInt(2, (index - 1) * pageSize);
            pst.setInt(3, pageSize);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("Id");
                String name = rs.getString("name");
                boolean status = rs.getBoolean("status");
                Category c = new Category(id, name, status);
                list.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateCategory(int id, String name) {
        Connection cn = null;
        PreparedStatement ps = null;

        try {
            cn = DBUtils.makeConnection();
            String sql = "UPDATE [dbo].[Category] SET [name] = ? WHERE [Id] = ?";
            ps = cn.prepareStatement(sql);
            ps.setString(1, name);
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Category updated successfully.");
            } else {
                System.out.println("Category update failed.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Category getCategoryById(int id) {
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Category category = null;

        try {
            // Establish connection
            cn = DBUtils.makeConnection();
            String sql = "SELECT * FROM [dbo].[Category] WHERE [Id] = ?";
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                int categoryId = rs.getInt(1);
                String categoryName = rs.getString(2);
                category = new Category(categoryId, categoryName);
            }
            return category;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean insertCategory(String name, boolean status) {
        Connection cn = null;
        PreparedStatement ps = null;
        boolean inserted = false;
        try {
            cn = DBUtils.makeConnection();
            String sql = "INSERT INTO [dbo].[Category] ([name], [status]) VALUES (?, ?)";
            ps = cn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setBoolean(2, status);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                inserted = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inserted;
    }

    public boolean deleteCategory(int id) {
        Connection cn = null;
        PreparedStatement ps = null;
        boolean updated = false;

        try {
            cn = DBUtils.makeConnection();
            String sql = "UPDATE [dbo].[Category] SET [status] = CASE WHEN [status] = 1 THEN 0 ELSE 1 END WHERE [Id] = ?";
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                updated = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return updated;
    }

    public int getCountFilterCategory() {
        Connection cn = null;
        PreparedStatement ps = null;
        try {
            cn = DBUtils.makeConnection();
            String sql = "select count(*) from Category";
            ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}
