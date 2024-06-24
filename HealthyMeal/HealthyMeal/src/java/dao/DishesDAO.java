/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Category;
import dto.Dishes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
            System.out.println(sql);
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

    public int getCountFilterDisheses(String search, String cid, String min, String max, String status) {
        ArrayList<Dishes> list = new ArrayList<>();
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

    // test filter
    public static void main(String[] args) {
        ArrayList<Dishes> list = new ArrayList<>();
        int index = 1;
        int pageSize = 5;
        int totalRows = new DishesDAO().getCountFilterDisheses("", "", "", "", "");
        int totalPage = 0;
        if (totalRows % pageSize == 0) {
            totalPage = totalRows / pageSize;
        } else {
            totalPage = totalRows / pageSize + 1;

        }
        System.out.println("Total Page : " + totalPage);
        list = new DishesDAO().getFilterDisheses("", "", "3", "10", "", "", "", index, pageSize);
        for (Dishes dishes : list) {
            System.out.println(dishes.getId() + "--" + dishes.getName());
        }

    }

}
