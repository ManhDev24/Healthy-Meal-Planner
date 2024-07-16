/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylib;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author PC
 */
public class DBUtils {

    public static Connection makeConnection() throws Exception {
        Connection cn = null;
        String IP = "localhost";
        String instanceName = "LAPTOP-2NAMG3NM\\HAOTA";
        String port = "1433";
        String uid = "sa";
        String pwd = "12345";
        String db = "HealthyMeal2";
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url = "jdbc:sqlserver://" + IP + "\\" + instanceName + ":" + port
                + ";databasename=" + db + ";user=" + uid + ";password=" + pwd;
        Class.forName(driver);
        System.out.println("connecting");
        cn = DriverManager.getConnection(url);
        return cn;
    }

    public static void main(String[] args) throws Exception {
        Connection connection = null;
        connection = DBUtils.makeConnection();

    }

}
