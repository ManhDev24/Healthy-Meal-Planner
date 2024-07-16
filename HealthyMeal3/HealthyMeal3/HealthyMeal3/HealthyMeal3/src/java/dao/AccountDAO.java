/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Account;
import dto.Cart;
import dto.Orders;
import dto.Payment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.http.HttpSession;
import mylib.DBUtils;

/**
 *
 * @author PC
 */
public class AccountDAO {

    public Account getAccount(String email, String password) {
        Account result = null;
        Connection cn = null;
        try {
            //make connection giua backend va sqlserver
            cn = DBUtils.makeConnection();
            if (cn != null) {
                //viet sql va exec cau sql
                String sql = "  select * from Accounts where email = ? and password = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                //lay emai,password cua input params gan vao 2 cho ?
                pst.setString(1, email);
                pst.setString(2, password);
                //run cau sql
                ResultSet table = pst.executeQuery();
                //doc data trong table
                if (table != null && table.next()) {

                    result = new Account(table.getInt(1), table.getString(2),
                            table.getString(3), table.getString(4), table.getString(5),
                            table.getString(6), table.getBoolean(7), table.getBoolean(8));

                    result.setAvatar(table.getString(9));
                    return result;
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
        return result;
    }

    public Account getAccount(String email) {
        Account result = null;
        Connection cn = null;
        try {
            //make connection giua backend va sqlserver
            cn = DBUtils.makeConnection();
            if (cn != null) {
                //viet sql va exec cau sql
                String sql = "select [id],[password],[email],[full_name],[role],[status]\n"
                        + "from[dbo].[Accounts]\n"
                        + "where email like '?' and [password] like ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                //lay emai,password cua input params gan vao 2 cho ?
                pst.setString(1, email);
//                pst.setString(2, password);
                //run cau sql
                ResultSet table = pst.executeQuery();
                //doc data trong table
                if (table != null && table.next()) {
                    int id = table.getInt("id");
                    //String email=table.getString("email");
                    String fullname = table.getString("full_Name");
                    String password = table.getString("password");
                    boolean role = table.getBoolean("role");
                    boolean status = table.getBoolean("status");
                    result = new Account(id, email, password, fullname, role, status);
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
        return result;
    }

    public int insertAccount(String email, String fullname, String password) {
        int rs = 0;

        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();//1 tao ketnoi your app voi sqlserver
            if (cn != null) {
                //2)viet query va execute
                String sql = "insert dbo.Accounts(email,[full_name],[password]) values(?,?,?)";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, email);
                pst.setString(2, fullname);
                pst.setString(3, password);
                rs = pst.executeUpdate();
                rs=1;
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
        return rs;
    }

    public boolean updateAccount(String email, String fullname, String phone, String address, int id) {
        int rs;
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();//1 tao ketnoi your app voi sqlserver
            if (cn != null) {
                //2)viet query va execute
                String sql = "UPDATE Accounts SET email = ?, full_name = ?, phone = ?, address = ? WHERE id = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, email);
                pst.setString(2, fullname);

                //                pst.setString(3, password);
                pst.setString(3, phone);
                pst.setString(4, address);
                pst.setInt(5, id);
                rs = pst.executeUpdate();
                return rs > 0;
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
        return false;
    }

    public boolean updateAccountByAdmin(String email, String fullname, String phone, String address, boolean role, String avatar, int id) {
        int rs;
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "UPDATE Accounts SET email = ?, full_name = ?, phone = ?, address = ?, role = ?, avatar = ? WHERE id = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, email);
                pst.setString(2, fullname);
                pst.setString(3, phone);
                pst.setString(4, address);
                pst.setBoolean(5, role);
                pst.setString(6, avatar);
                pst.setInt(7, id);
                rs = pst.executeUpdate();
                return rs > 0;
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
        return false;
    }

    public Account getAccount(int id) {
        Connection cn = null;
        Account result = null;
        try {
            cn = DBUtils.makeConnection();//1 tao ketnoi your app voi sqlserver
            if (cn != null) {
                //2)viet query va execute
                String sql = "SELECT * FROM Accounts WHERE id = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, id);
                ResultSet table = pst.executeQuery();
                if (table != null && table.next()) {
                    result = new Account(table.getInt(1), table.getString(2),
                            table.getString(3), table.getString(4), table.getString(5),
                            table.getString(6), table.getBoolean(7), table.getBoolean(8));
                    return result;
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
        return result;

    }

    public int getTotalUsers() {
        int result = 0;
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();//1 tao ketnoi your app voi sqlserver
            String url = "  select count(*) as Total from Accounts where status = 1 and role = 1";
            PreparedStatement pst = cn.prepareStatement(url);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                result = rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<Account> getAllAccounts() {
        Connection cn = null;
        ArrayList<Account> list = new ArrayList<>();
        try {
            cn = DBUtils.makeConnection(); // Establish connection to the database
            String sql = "SELECT * FROM Accounts WHERE status = 1 ORDER BY role ASC";
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String fullname = rs.getString("full_name");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                boolean role = rs.getBoolean("role");
                boolean status = rs.getBoolean("status");
                String avatar = rs.getString("avatar");

                Account acc = new Account(id, email, password, fullname, phone, address, role, status, avatar);
                list.add(acc);
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

    public int getCountFilterAccount(String search) {
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            String sql = "select count(*) from Accounts where email like ? ";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, "%" + search + "%");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public ArrayList<Account> FilterAccount(String search, int index, int pageSize) {
        Connection cn = null;
        ArrayList<Account> list = new ArrayList<>();

        try {
            cn = DBUtils.makeConnection();
            String sql = "SELECT * FROM Accounts\n"
                    + "WHERE email LIKE ?  \n"
                    + "ORDER BY role ASC \n"
                    + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY;";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, "%" + search + "%");
            pst.setInt(2, (index - 1) * pageSize);
            pst.setInt(3, pageSize);
            System.out.println(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String fullname = rs.getString("full_name");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                boolean role = rs.getBoolean("role");
                boolean status = rs.getBoolean("status");
                String avatar = rs.getString("avatar");

                Account acc = new Account(id, email, password, fullname, phone, address, role, status, avatar);
                list.add(acc);
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void BanAccount(int accountId) {
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            String sql = "UPDATE Accounts SET status = CASE WHEN status = 0 THEN 1 ELSE 0 END WHERE id = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, accountId);
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

    public boolean checkAccountDuplicate(String email) {
        boolean isDuplicate = false;
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            String sql = "select * from Accounts where email = ? and status = 1 ";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                isDuplicate = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isDuplicate;

    }

    public void registerAccount(Account acc) throws Exception {
        Connection cn = null;
        PreparedStatement pst = null;

        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "INSERT INTO [dbo].[Accounts] "
                        + "([email], [password], [full_name], [phone], [address], [role], [status], [avatar]) "
                        + "VALUES (?, ?, ?, ?, ?, ?, 1, ?)";
                pst = cn.prepareStatement(sql);
                pst.setString(1, acc.getEmail());
                pst.setString(2, acc.getPassword());
                pst.setString(3, acc.getFullname());
                pst.setString(4, acc.getPhone());
                pst.setString(5, acc.getAddress());
                pst.setBoolean(6, acc.isRole());
                pst.setString(7, acc.getAvatar());

                pst.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
     public boolean updatePassword(String email,String password){
        int rs;
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();//1 tao ketnoi your app voi sqlserver
            if (cn != null) {
                //2)viet query va execute
                String sql = "update[dbo].[Accounts]\n"
                        + "  set[password]=?\n"
                        + "  where [email]=?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, password);
                pst.setString(2, email);
               
                rs = pst.executeUpdate();
                return rs > 0;
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
        return false;
    }
     public Account getAccountForgot(String email) {
        Account result = null;
        Connection cn = null;
        try {
            //make connection giua backend va sqlserver
            cn = DBUtils.makeConnection();
            if (cn != null) {
                //viet sql va exec cau sql
                String sql = "select [id],[password],[email],[full_name],[role],[status]\n"
                        + "from[dbo].[Accounts]\n"
                        + "where email like ? ";
                PreparedStatement pst = cn.prepareStatement(sql);
                //lay emai,password cua input params gan vao 2 cho ?
                pst.setString(1, email);
//                pst.setString(2, password);
                //run cau sql
                ResultSet table = pst.executeQuery();
                //doc data trong table
                if (table != null && table.next()) {
                    int id = table.getInt("id");
                    //String email=table.getString("email");
                    String fullname = table.getString("full_Name");
                    String password = table.getString("password");
                    boolean role = table.getBoolean("role");
                    boolean status = table.getBoolean("status");
                    result = new Account(id, email, password, fullname, role, status);
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
        return result;
    }

}
