/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.TokenForgetPassword;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import mylib.DBUtils;

/**
 *
 * @author HP
 */
public class DAOTokenForget extends DBUtils{
    
     public String getFormatDate(LocalDateTime myDateObj) {
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        String formattedDate = myDateObj.format(myFormatObj);  
        return formattedDate;
     }
    
    public boolean insertTokenForget(TokenForgetPassword tokenForget)  {
        Connection cn = null;
        String sql = "INSERT INTO [dbo].[tokenForgetPassword]\n" +
"           ([token]\n" +
"           ,[expiryTime]\n" +
"           ,[isUsed]\n" +
"           ,[accId])\n" +
"     VALUES(?, ?, ?, ?)";
        try {
            cn = DBUtils.makeConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, tokenForget.getToken());
            System.out.println(Timestamp.valueOf(getFormatDate(tokenForget.getExpiryTime())));
            ps.setTimestamp(2, Timestamp.valueOf(getFormatDate(tokenForget.getExpiryTime())));
            ps.setBoolean(3, tokenForget.isIsUsed());
            ps.setInt(4, tokenForget.getAccId());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e);
        } catch (Exception ex) {
             Logger.getLogger(DAOTokenForget.class.getName()).log(Level.SEVERE, null, ex);
         }
        return false;
    }
    public TokenForgetPassword getTokenPassword(String token)  {
        Connection cn = null;
        String sql = "Select * from [tokenForgetPassword] where token = ?";
        try {
            cn = DBUtils.makeConnection();
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, token);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new TokenForgetPassword(
                        rs.getInt("id"),
                        rs.getInt("accId"),
                        rs.getBoolean("isUsed"),
                        rs.getString("token"),
                        rs.getTimestamp("expiryTime").toLocalDateTime()
                );
            }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (Exception ex) {
             Logger.getLogger(DAOTokenForget.class.getName()).log(Level.SEVERE, null, ex);
         }
        return null;
    }
    
    public void updateStatus(TokenForgetPassword token)  {
        Connection cn = null;
        System.out.println("token = "+token);
        String sql = "UPDATE [dbo].[tokenForgetPassword]\n"
                + "   SET [isUsed] = ?\n"
                + " WHERE token = ?";
        try {
            cn = DBUtils.makeConnection();
            PreparedStatement st = cn.prepareStatement(sql);
            st.setBoolean(1, token.isIsUsed());
            st.setString(2, token.getToken());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        } catch (Exception ex) {
             Logger.getLogger(DAOTokenForget.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
}
