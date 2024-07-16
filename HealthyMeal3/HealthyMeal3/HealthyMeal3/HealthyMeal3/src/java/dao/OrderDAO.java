/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Account;
import dto.Cart;
import dto.CartItem;
import dto.OrderDetail;
import dto.Orders;
import dto.Payment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mylib.DBUtils;

/**
 *
 * @author NC
 */
public class OrderDAO {

    public List<Orders> listOrdersById(Account account) {
        List<Orders> listOrder = new ArrayList<>();
        Connection cn = null;
        try {
            //make connection giua backend va sqlserver
            cn = DBUtils.makeConnection();
            if (cn != null) {
                //viet sql va exec cau sql
                String sql = "  select * from[dbo].[Orders] o join[dbo].[Payment] p on o.paymentid=p.paymentid\n"
                        + "                        where account_id = ? \n"
                        + "                        order by order_date desc";
                PreparedStatement pst = cn.prepareStatement(sql);
                //lay emai,password cua input params gan vao 2 cho ?
                pst.setInt(1, account.getId());
                //run cau sql
                ResultSet rs = pst.executeQuery();
                //doc data trong table
                if (rs != null) {
                    // doc tung dong trong rs va convert no thanh object account
                    //add object nay vao arraylist
                    while (rs.next()) {
                        int id = rs.getInt("id");
                        Date order_date = rs.getDate("order_date");
                        double price = rs.getDouble("total_price");
                        boolean status = rs.getBoolean("status");
                        int paymentId = rs.getInt("paymentid");
                        String paymentMethod = rs.getString("method");
                        Payment payment = new Payment(paymentId, paymentMethod);
                        Orders o = new Orders(id, order_date, status, price);
                        listOrder.add(o);
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
        return listOrder;

    }

    public boolean createOrder(int accid, Date date, double price, int pid) {
        Connection cn = null;

        try {
            cn = DBUtils.makeConnection();
            String sql = "INSERT INTO [dbo].[Orders]\n"
                    + "           ([account_id]\n"
                    + "           ,[order_date]\n"
                    + "           ,[total_price]\n"
                    + "           ,[status]\n"
                    + "           ,[paymentid])\n"
                    + "     VALUES\n"
                    + "           (?,?,?,0,?)";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, accid);
            pst.setDate(2, (java.sql.Date) date);
            pst.setDouble(3, price);
            pst.setInt(4, pid);
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public int getLatestOrderId(int accid) {
        Connection cn = null;
        int orderId = -1;
        try {
            cn = DBUtils.makeConnection();
            String sql = "SELECT TOP 1 [order_id] FROM [dbo].[Orders] "
                    + "WHERE [account_id] = ? ORDER BY [order_date] DESC";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, accid);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                orderId = rs.getInt("order_id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderId;
    }

    public int getTotalOrder() {
        Connection cn = null;
        int result = 0;
        try {
            cn = DBUtils.makeConnection();
            String sql = "  select count(*) as Total from Orders";
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

    public ArrayList<Orders> getRecentOrders() {
        Connection cn = null;
        ArrayList<Orders> list = new ArrayList<>();
        try {
            cn = DBUtils.makeConnection();
            String sql = "SELECT TOP 10 \n"
                    + "    o.id, \n"
                    + "    a.full_name,\n"
                    + "	a.phone,\n"
                    + "	a.[address],\n"
                    + "    o.order_date, \n"
                    + "    o.[status], \n"
                    + "    o.total_price,\n"
                    + "    o.paymentid\n"
                    + "FROM Orders o \n"
                    + "JOIN Accounts a \n"
                    + "ON o.account_id = a.id \n"
                    + "ORDER BY o.order_date DESC;";
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String fullName = rs.getString("full_name");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                Date orderDate = rs.getDate("order_date");
                boolean status = rs.getBoolean("status");
                double totalPrice = rs.getDouble("total_price");
                int paymentId = rs.getInt("paymentid");

                Account account = new Account();
                account.setFullname(fullName);
                account.setPhone(phone);
                account.setAddress(address);

                Payment paymentMethod = new Payment();
                paymentMethod.setPaymentid(paymentId);

                Orders order = new Orders(id, account, orderDate, paymentMethod, status);
                order.setTotalPrice(totalPrice);

                list.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void saveOrder(Account acc, Cart cart, int paymentId) throws Exception {
        PreparedStatement pst = null;
        Connection cn = null;
        ResultSet rs = null;
        try {
            cn = DBUtils.makeConnection();
            // Inserting the order into Orders table
            String sql = "INSERT INTO [dbo].[Orders] "
                    + "([account_id], [order_date], [total_price], [status], [paymentid]) "
                    + "VALUES (?, GETDATE(), ?, 0, ?)";
            pst = cn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS); // Note the change here
            pst.setInt(1, acc.getId());
            pst.setDouble(2, cart.getTotalPrice());
            pst.setInt(3, paymentId);

            pst.executeUpdate(); // Execute the INSERT statement

            // Retrieving the generated order ID
            rs = pst.getGeneratedKeys();
            int orderId = -1;
            if (rs.next()) {
                orderId = rs.getInt(1);
            }

            // Inserting order details into Order_Details table
            String sql2 = "INSERT INTO [dbo].[Order_Details] "
                    + "([order_id], [dish_id], [quantity], [price]) "
                    + "VALUES (?, ?, ?, ?)";
            pst = cn.prepareStatement(sql2);
            for (CartItem item : cart.getItems()) {
                pst.setInt(1, orderId);
                pst.setInt(2, item.getDishes().getId());
                pst.setInt(3, item.getQuantity());
                pst.setDouble(4, item.getDishes().getPrice());
                pst.executeUpdate();
            }

            // Updating dish quantities in Dishes table
            String sql3 = "UPDATE [dbo].[Dishes] "
                    + "SET [number] = [number] - ? "
                    + "WHERE id = ?";
            pst = cn.prepareStatement(sql3);
            for (CartItem item : cart.getItems()) {
                pst.setInt(1, item.getQuantity());
                pst.setInt(2, item.getDishes().getId());
                pst.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Failed to save order."); // Handle the exception as needed
        } finally {
            // Close resources in reverse order of creation to avoid leaks
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                /* ignored */ }
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (Exception e) {
                /* ignored */ }
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                /* ignored */ }
        }
    }

    public Orders getOrdersById(int id) {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            cn = DBUtils.makeConnection();
            String sql = "SELECT * FROM Orders WHERE id = ?";
            pst = cn.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();

            if (rs.next()) {
                int orderId = rs.getInt(1);
                Date orderDate = rs.getDate(3);
                double totalPrice = rs.getDouble(4);
                int paymentId = rs.getInt(6);
                Payment payment = new PaymentDAO().getPaymentById(paymentId);
                boolean status = rs.getBoolean(5);
                int accId = rs.getInt(2);
                Account acc = new AccountDAO().getAccount(accId);

                Orders order = new Orders(orderId, acc, orderDate, payment, status, totalPrice);
                System.out.println("Order is " + order);
                return order;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                // do not close cn here, manage connection lifecycle outside this method
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public double getTotalMoneyByYear(int year) {
        double result = 0;
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cn = DBUtils.makeConnection();
            String sql = "  select sum(total_price) as TotalSale from  Orders where YEAR(order_date) = ?  and status = 0";
            pst = cn.prepareStatement(sql);
            pst.setInt(1, year);
            rs = pst.executeQuery();
            while (rs.next()) {
                result = rs.getDouble(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                // do not close cn here, manage connection lifecycle outside this method
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;

    }

    public double getTotalMoneyByMonth(int month) {
        double result = 0;
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cn = DBUtils.makeConnection();
            String sql = "select sum(total_price) as TotalSale from  Orders where month(order_date) = ?  and status = 0";
            pst = cn.prepareStatement(sql);
            pst.setInt(1, month);
            rs = pst.executeQuery();
            while (rs.next()) {
                result = rs.getDouble(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                // do not close cn here, manage connection lifecycle outside this method
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;

    }

    public double getTotalSaleToDay() {
        double result = 0;
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cn = DBUtils.makeConnection();
            String sql = "select sum(total_price) as TotalSale from Orders\n"
                    + "where cast(order_date as Date) = cast(getdate() as Date)";
            pst = cn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                result = rs.getDouble(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                // do not close cn here, manage connection lifecycle outside this method
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;

    }

    public double getTotalSale() {
        double result = 0;
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cn = DBUtils.makeConnection();
            String sql = "SELECT SUM(total_price) AS TotalSale from [Orders]";
            pst = cn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                result = rs.getDouble(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                // do not close cn here, manage connection lifecycle outside this method
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;

    }

    public int getCountOrderFilter() {
        Connection cn = null;

        try {
            cn = DBUtils.makeConnection();
            String sql = "select count(*) from Orders";
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public ArrayList<Orders> getAllOrdersFilter(String search, int index, int pageSize) {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<Orders> list = new ArrayList<>();
        try {
            cn = DBUtils.makeConnection();
            String sql = "select * from Orders o join Accounts a \n"
                    + "on o.account_id = a.id\n"
                    + "where a.full_name like ? \n"
                    + "ORDER BY order_date DESC \n"
                    + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
            pst = cn.prepareStatement(sql);
            pst.setString(1, "%" + search + "%");
            pst.setInt(2, (index - 1) * pageSize);
            pst.setInt(3, pageSize);
            rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String fullName = rs.getString("full_name");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                Date orderDate = rs.getDate("order_date");
                boolean status = rs.getBoolean("status");
                double totalPrice = rs.getDouble("total_price");
                int paymentId = rs.getInt("paymentid");

                Account account = new Account();
                account.setFullname(fullName);
                account.setPhone(phone);
                account.setAddress(address);

                Payment paymentMethod = new Payment();
                paymentMethod.setPaymentid(paymentId);

                Orders order = new Orders(id, account, orderDate, paymentMethod, status);
                order.setTotalPrice(totalPrice);
                list.add(order);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void toggleOrderStatus(int orderId) {
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            String sql = "UPDATE Orders SET status = CASE WHEN status = 0 THEN 1 ELSE 0 END WHERE id = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, orderId);
            int rowEffected = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
