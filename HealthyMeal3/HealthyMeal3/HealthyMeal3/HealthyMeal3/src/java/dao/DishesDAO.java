/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Category;
import dto.Dishes;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import mylib.DBUtils;

/**
 *
 * @author PC
 */
public class DishesDAO {

    public ArrayList<Dishes> getDishes(String findName) {
        ArrayList<Dishes> list = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select [id],[name],[price],[status],[description],[imageurl]\n"
                        + "from [dbo].[Dishes]\n"
                        + "where name like ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, "%" + findName + "%");
                ResultSet table = pst.executeQuery();
                if (table != null) {
                    while (table.next()) {
                        int itemid = table.getInt("id");
                        String itemname = table.getString("name");
                        float price = table.getFloat("price");
                        boolean status = table.getBoolean("status");
                        String desrip = table.getString("description");
                        String imageurl = table.getString("imageurl");
                        Dishes it = new Dishes(itemid, itemname, price, desrip, status, imageurl);
                        list.add(it);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

//    public Item getItem(int itemid) {
//        Item rs = null;
//        Connection cn = null;
//        try {
//            cn = DBUtil.makeConnection();
//            if (cn != null) {
//                String sql = "select ItemId,ItemName,Price,Status,Image\n"
//                        + "from dbo.Items\n"
//                        + "where ItemId = ?";
//                PreparedStatement pst = cn.prepareStatement(sql);
//                pst.setInt(1, itemid);
//                ResultSet table = pst.executeQuery();
//                if (table != null) {
//                    while (table.next()) {
//                        // int itemid=table.getInt("ItemId");
//                        String itemname = table.getString("ItemName");
//                        int price = table.getInt("Price");
//                        int status = table.getInt("Status");
//                        String imageurl = table.getString("Image");
//                        rs = new Item(itemid, itemname, price, status, imageurl);
//
//                    }
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (cn != null) {
//                    cn.close();
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return rs;
//    }
    public ArrayList<Dishes> getDishes(int id) {
        ArrayList<Dishes> list = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select [id],[name],[price],[status],[description],[imageurl]\n"
                        + "from [dbo].[Dishes]\n"
                        + "where id = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, id);
                ResultSet table = pst.executeQuery();
                if (table != null) {
                    while (table.next()) {
//                        int itemid = table.getInt("id");
                        String itemname = table.getString("name");
                        float price = table.getFloat("price");
                        boolean status = table.getBoolean("status");
                        String desrip = table.getString("description");
                        String imageurl = table.getString("imageurl");
                        Dishes it = new Dishes(id, itemname, price, desrip, status, imageurl);
                        list.add(it);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public Dishes getDishesById(int id) {
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select [id],[name],[price],[status],[description],[imageurl]\n"
                        + "from [dbo].[Dishes]\n"
                        + "where id = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, id);
                ResultSet table = pst.executeQuery();
                if (table != null) {
                    while (table.next()) {
//                        int itemid = table.getInt("id");
                        String itemname = table.getString("name");
                        float price = table.getFloat("price");
                        boolean status = table.getBoolean("status");
                        String desrip = table.getString("description");
                        String imageurl = table.getString("imageurl");
                        Dishes it = new Dishes(id, itemname, price, desrip, status, imageurl);
                        return it;

                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public Dishes getDishById2(int id) {
        Connection cn = null;
        Dishes dish = null;
        try {
            cn = DBUtils.makeConnection();
            String sql = "SELECT d.*, c.name FROM Dishes d JOIN Category c "
                    + "ON d.categoryId = c.Id "
                    + "WHERE d.id = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                Category c = new Category(rs.getInt("categoryId"), rs.getString(10));
                dish = new Dishes(rs.getInt("id"), rs.getString("name"),
                        rs.getFloat("price"), rs.getString("description"),
                        rs.getBoolean("status"), rs.getString(6),
                        c, rs.getDate("date"), rs.getInt("categoryId"),
                        rs.getInt("number"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dish;
    }

    public ArrayList<Dishes> getFilterDisheses(String search, String cid, String min, String max, String status, String sortType, String dateType, int index, int pageSize) {
        ArrayList<Dishes> list = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            String date = "";
            switch (dateType) {
                case "1":
                    date = " ,d.date asc";
                    break;
                case "2":
                    date = " ,d.date desc";
                    break;
                default:
                    date = " ,d.date asc";
                    break;
            }
            String orderBy = "";
            switch (sortType) {
                case "1":
                    orderBy = " order by d.name asc";
                    break;
                case "2":
                    orderBy = " order by d.name desc";
                    break;
                case "3":
                    orderBy = " order by d.price asc";
                    break;
                case "4":
                    orderBy = " order by d.price desc";
                    break;
                default:
                    orderBy = " order by d.id asc";
                    break;
            }
            String sql = "select d.*,c.name from Dishes d join Category c\n"
                    + "on d.categoryId = c.Id\n"
                    + "where d.name like ? ";
            if (!cid.isEmpty()) {
                sql += "and d.categoryId = " + cid;
            }
            if (!min.isEmpty()) {
                sql += " and d.price >= " + min;
            }
            if (!max.isEmpty()) {
                sql += " and d.price <= " + max;
            }
            if (!status.isEmpty()) {
                sql += " and d.[status] = " + status;
            }
            sql += orderBy + date + " OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, "%" + search + "%");
            pst.setInt(2, (index - 1) * pageSize);
            pst.setInt(3, pageSize);
//            System.out.println(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Category c = new Category(rs.getInt("id"), rs.getString("name"));
                Dishes d = new Dishes(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getString(5), rs.getBoolean(4), rs.getString(6), c, rs.getDate(7), rs.getInt(8));
                list.add(d);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Dishes> getDishesByCategory(int cid) {
        ArrayList<Dishes> list = new ArrayList<>();
        Connection cn = null;

        try {
            cn = DBUtils.makeConnection();
            String sql = "select d.*, c.name from Dishes d join Category c\n"
                    + "on d.categoryId = c.Id\n"
                    + "where c.Id = ? ";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, cid);
            ResultSet rs = pst.executeQuery();
//            System.out.println(sql);
            while (rs.next()) {
                Category c = new Category(rs.getInt(8), rs.getString(9));
                Dishes ds = new Dishes(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getString(5), rs.getBoolean(4), rs.getString(6), c, rs.getDate(7), rs.getInt(8));
                list.add(ds);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getCountFilterDisheses(String search, String cid, String min, String max, String status) {
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            String sql = "select count(*) from Dishes d join Category c\n"
                    + "on d.categoryId = c.Id\n"
                    + "where d.name like ? ";
            if (!cid.isEmpty()) {
                sql += "and d.categoryId = " + cid;
            }
            if (!min.isEmpty()) {
                sql += "and d.price >= " + min;
            }
            if (!max.isEmpty()) {
                sql += "and d.price <= " + max;
            }
            if (!status.isEmpty()) {
                sql += "and d.[staus] = " + status;
            }
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, "%" + search + "%");
            System.out.println(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int gettotalOfDishes() {
        Connection cn = null;
        int result = 0;
        try {
            cn = DBUtils.makeConnection();
            String sql = "  select count(*) as Total from Dishes where status =1";
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                result = rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int getDishLowQuantity() {
        Connection cn = null;
        int result = 0;
        try {
            cn = DBUtils.makeConnection();
            String sql = "  select count(*) as Total from Dishes where number < 10 and status = 1";
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                result = rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<Dishes> getAllDishesFilter(String search, int index, int PageSize) {
        ArrayList<Dishes> list = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            String sql = "SELECT d.id, d.name, d.price, d.description, d.status, d.imageurl, d.date, d.categoryId, d.number, c.name AS categoryName "
                    + "FROM Dishes d "
                    + "JOIN Category c ON d.categoryId = c.Id "
                    + "WHERE d.name LIKE ? "
                    + "ORDER BY d.id "
                    + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, "%" + search + "%");
            pst.setInt(2, (index - 1) * PageSize);
            pst.setInt(3, PageSize);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                float price = rs.getFloat("price");
                String description = rs.getString("description");
                boolean status = rs.getBoolean("status");
                String imageUrl = rs.getString("imageurl");
                Date date = rs.getDate("date");
                int categoryId = rs.getInt("categoryId");
                int number = rs.getInt("number");
                String categoryName = rs.getString("categoryName");

                Category category = new Category(categoryId, categoryName);
                Dishes dish = new Dishes(id, name, price, description, status, imageUrl, category, date, categoryId, number);
                list.add(dish);
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Dishes> getAllDishes() {
        ArrayList<Dishes> list = new ArrayList<>();
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cn = DBUtils.makeConnection();
            String sql = "SELECT d.*, c.name AS categoryName FROM Dishes d JOIN Category c ON d.categoryId = c.id";
            pst = cn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                float price = rs.getFloat("price");
                String description = rs.getString("description");
                boolean status = rs.getBoolean("status");
                String imgurl = rs.getString("imageurl");
                Date date = rs.getDate("date");
                int categoryId = rs.getInt("categoryId");
                int number = rs.getInt("number");
                String categoryName = rs.getString("categoryName");

                Category category = new Category(categoryId, categoryName);  // Assuming you have a Category class with this constructor

                Dishes dish = new Dishes(id, name, price, description, status, imgurl, category, date, categoryId, number);
                list.add(dish);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean updateDish(Dishes dish) throws SQLException, Exception {
        Connection cn = null;

        try {
            cn = DBUtils.makeConnection();
            String sql = "UPDATE Dishes SET name = ?, price = ?, description = ?, imageurl = ?, categoryId = ?, number = ? WHERE id = ?";
            PreparedStatement pstmt = cn.prepareStatement(sql);
            pstmt.setString(1, dish.getName());
            pstmt.setDouble(2, dish.getPrice());
            pstmt.setString(3, dish.getDecreption());
            pstmt.setString(4, dish.getImgurl());
            pstmt.setInt(5, dish.getCategoryId());
            pstmt.setInt(6, dish.getNumber());
            pstmt.setInt(7, dish.getId());

            int rowsAffected = pstmt.executeUpdate();

            return rowsAffected > 0; // Returns true if at least one row was updated

        } catch (SQLException ex) {
            throw new SQLException("Error updating dish in database", ex);
        }
    }

    public void hiddenDishes(int dishId) {
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            String sql = "UPDATE Dishes SET status = CASE WHEN status = 0 THEN 1 ELSE 0 END WHERE id = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, dishId);
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean insertDish(String name, double price, String description, String imageUrl, Date date, int categoryId, int number) throws Exception {
        Connection cn = null;
        PreparedStatement ps = null;
        boolean inserted = false;

        try {
            cn = DBUtils.makeConnection();
            // Câu truy vấn SQL để chèn một món ăn mới
            String sql = "INSERT INTO [dbo].[Dishes] ([name], [price], [status], [description], [imageurl], [date], [categoryId], [number]) "
                    + "VALUES (?, ?, 1, ?, ?, ?, ?, ?)";

            ps = cn.prepareStatement(sql);

            ps.setString(1, name);
            ps.setDouble(2, price);
            ps.setString(3, description);
            ps.setString(4, imageUrl);
            ps.setDate(5, date);
            ps.setInt(6, categoryId);
            ps.setInt(7, number);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Chèn món ăn thành công.");
                inserted = true;
            } else {
                System.out.println("Chèn món ăn thất bại.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng PreparedStatement và Connection
            try {
                if (ps != null) {
                    ps.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return inserted;
    }

    // test filter
    public static void main(String[] args) {
//        ArrayList<Dishes> list = new ArrayList<>();
//        int index = 1;
//        int pageSize = 5;
//        int totalRows = new DishesDAO().getCountFilterDisheses("", "", "", "", "");
//        int totalPage = 0;
//        if (totalRows % pageSize == 0) {
//            totalPage = totalRows / pageSize;
//        } else {
//            totalPage = totalRows / pageSize + 1;
//
//        }
//        System.out.println("Total Page : " + totalPage);
//        list = new DishesDAO().getFilterDisheses("", "", "3", "10", "", "", "", index, pageSize);
//        for (Dishes dishes : list) {
//            System.out.println(dishes.getId() + "--" + dishes.getName());
//        }

    }

}
