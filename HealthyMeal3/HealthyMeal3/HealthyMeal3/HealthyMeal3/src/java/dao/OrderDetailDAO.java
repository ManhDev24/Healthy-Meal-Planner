package dao;

import dto.Dishes;
import dto.OrderDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import mylib.DBUtils;

public class OrderDetailDAO {

//    public boolean createOrderDetail(int oid, int did, int quantity, double price) {
//        Connection cn = null;
//        try {
//            cn = DBUtils.makeConnection();
//            String sql = "INSERT INTO [HealthyMeal].[dbo].[Order_Details] " + "([order_id], [dish_id], [quantity], [price]) " + "VALUES (?, ?, ?, ?)";
//            PreparedStatement pst = cn.prepareStatement(sql);
//            pst.setInt(1, oid);
//            pst.setInt(2, did);
//            pst.setInt(3, quantity);
//            pst.setDouble(4, price);
//            pst.executeUpdate();
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
    public boolean createOrderDetail(int orderId, int dishId, int quantity, double price) throws Exception {
        boolean success = false;
        Connection cn = null;

        try {
            cn = DBUtils.makeConnection();
            String sql = "INSERT INTO OrderDetail (order_id, dish_id, quantity, price) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = cn.prepareStatement(sql);
            pstmt.setInt(1, orderId);
            pstmt.setInt(2, dishId);
            pstmt.setInt(3, quantity);
            pstmt.setDouble(4, price);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                success = true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            // Handle any SQL exceptions appropriately
        }

        return success;
    }

    public ArrayList<OrderDetail> getOrderItemByOrderId(int id) {
        ArrayList<OrderDetail> list = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            System.out.println("Connection established.");

            String sql = "SELECT order_id, dish_id, SUM(quantity) AS quantity, price "
                    + "FROM Order_Details "
                    + "WHERE order_id = ? "
                    + "GROUP BY order_id, dish_id, price";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, id);
            System.out.println("PreparedStatement created with order_id: " + id);

            ResultSet rs = pst.executeQuery();
            System.out.println("Executing query...");

            while (rs.next()) {
                int quantity = rs.getInt("quantity");
                System.out.println("Quantity: " + quantity);

                double price = rs.getDouble("price");
                System.out.println("Price: " + price);

                int dishId = rs.getInt("dish_id");
                System.out.println("Dish ID: " + dishId);

                Dishes dish = new DishesDAO().getDishesById(dishId);
                System.out.println("Dish: " + dish);

                int orderId = rs.getInt("order_id");
                System.out.println("Order ID: " + orderId);

                OrderDetail orderD = new OrderDetail(quantity, price, dish, orderId);
                System.out.println("OrderDetail created: " + orderD);

                list.add(orderD);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
