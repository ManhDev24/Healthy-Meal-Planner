/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import mylib.DBUtils;

/**
 *
 * @author PC
 */
public class AccountDAO {
     public Account getAccount(String email,String password){
        Account result=null;
        Connection cn=null;
        try{
            //make connection giua backend va sqlserver
            cn=DBUtils.makeConnection();
            if(cn!=null){
                //viet sql va exec cau sql
                String sql = "select [id],[password],[email],[full_name],[role],[status]\n"
                        + "from[dbo].[Accounts]\n"
                        + "where email=? and [password]= ?";
                PreparedStatement pst=cn.prepareStatement(sql);
                //lay emai,password cua input params gan vao 2 cho ?
                pst.setString(1, email);
                pst.setString(2, password);
                //run cau sql
                ResultSet table=pst.executeQuery();
                //doc data trong table
                if(table!=null && table.next()){
                    int id=table.getInt("id");
                    //String email=table.getString("email");
                    String fullname=table.getString("full_Name");
                    //String password=table.getString("password");
                    boolean role=table.getBoolean("role");
                    boolean status =table.getBoolean("status");
                    result=new Account(id, email, password, fullname, role, status);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try {
                if(cn!=null) cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }        
        return result;
    }
     
     
     public Account getAccount(String email){
        Account result=null;
        Connection cn=null;
        try{
            //make connection giua backend va sqlserver
            cn=DBUtils.makeConnection();
            if(cn!=null){
                //viet sql va exec cau sql
                String sql = "select [id],[password],[email],[full_name],[role],[status]\n"
                        + "from[dbo].[Accounts]\n"
                        + "where email like '?' and [password] like ?";
                PreparedStatement pst=cn.prepareStatement(sql);
                //lay emai,password cua input params gan vao 2 cho ?
                pst.setString(1, email);
//                pst.setString(2, password);
                //run cau sql
                ResultSet table=pst.executeQuery();
                //doc data trong table
                if(table!=null && table.next()){
                    int id=table.getInt("id");
                    //String email=table.getString("email");
                    String fullname=table.getString("full_Name");
                    String password=table.getString("password");
                    boolean role=table.getBoolean("role");
                    boolean status =table.getBoolean("status");
                    result=new Account(id, email, password, fullname, role, status);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try {
                if(cn!=null) cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }        
        return result;
    }
     public int insertAccount(String email, String fullname,String password){
        int rs=0;
        
        Connection cn=null;
        try{
            cn=DBUtils.makeConnection();//1 tao ketnoi your app voi sqlserver
            if(cn!=null){
                //2)viet query va execute
                String sql="insert dbo.Accounts(email,[full_name],[password]) values(?,?,?)";
                PreparedStatement pst=cn.prepareStatement(sql);
                pst.setString(1, email);
                pst.setString(2, fullname);
                pst.setString(3, password);
                rs=pst.executeUpdate();
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try {
                if(cn!=null) cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return rs;
    }
}
